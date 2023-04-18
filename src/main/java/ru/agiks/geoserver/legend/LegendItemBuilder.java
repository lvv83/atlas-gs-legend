package ru.agiks.geoserver.legend;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import org.geoserver.catalog.StyleInfo;
import org.geotools.data.DataUtilities;
import org.geotools.feature.SchemaException;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.geometry.jts.LiteShape2;
import org.geotools.renderer.lite.StyledShapePainter;
import org.geotools.renderer.style.SLDStyleFactory;
import org.geotools.renderer.style.Style2D;
import org.geotools.styling.ColorMap;
import org.geotools.styling.ColorMapEntry;
import org.geotools.styling.Description;
import org.geotools.styling.FeatureTypeStyle;
import org.geotools.styling.LineSymbolizer;
import org.geotools.styling.PointSymbolizer;
import org.geotools.styling.PolygonSymbolizer;
import org.geotools.styling.RasterSymbolizer;
import org.geotools.styling.Rule;
import org.geotools.styling.Style;
import org.geotools.styling.Symbolizer;
import org.geotools.styling.TextSymbolizer;
import org.geotools.util.NumberRange;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Polygon;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.util.InternationalString;

public class LegendItemBuilder {
    private final int imageWidth;
    private final int imageHeight;

    private LiteShape2 sampleRect;
    private LiteShape2 sampleLine;
    private LiteShape2 samplePoint;

    private final SLDStyleFactory sldStyleFactory = new SLDStyleFactory();

    public LegendItemBuilder(int imageWidth, int imageHeight) {
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
    }

    public List<LegendItem> build(StyleInfo styleInfo) throws Exception {
        ArrayList<LegendItem> result = new ArrayList<LegendItem>();
        Style style = styleInfo.getStyle();
        List<FeatureTypeStyle> fts = style.featureTypeStyles();

        if (fts.size() != 1)
            throw new Exception(
                    styleInfo.getFilename()
                            + " should contain single FeatureTypeStyle, but actual count is "
                            + fts.size());

        List<Rule> rules = fts.get(0).rules();

        boolean hasVector = false;
        int dim = 0, maxDim = 0;
        RasterSymbolizer rsmb = null;
        Rule rsmbRule = null;

        for (Rule rule : rules) {
            Symbolizer[] symbolizers = rule.getSymbolizers();

            for (Symbolizer smb : symbolizers) {
                if (smb instanceof PolygonSymbolizer) {
                    dim = 3;
                    hasVector = true;
                } else if (smb instanceof LineSymbolizer) {
                    dim = 2;
                    hasVector = true;
                } else if (smb instanceof PointSymbolizer || smb instanceof TextSymbolizer) {
                    dim = 1;
                    hasVector = true;
                } else if (smb instanceof RasterSymbolizer) {
                    if (rsmb != null)
                        throw new Exception(
                                styleInfo.getFilename()
                                        + " - more than one raster symbolizers in the style");
                    dim = 3;
                    rsmb = (RasterSymbolizer) smb;
                    rsmbRule = rule;
                }

                if (maxDim < dim) {
                    maxDim = dim;
                }
            }
        }

        if (maxDim == 0)
            throw new Exception(styleInfo.getFilename() + " - can't recognize dimensionality");

        if (hasVector && rsmb != null)
            throw new Exception(
                    styleInfo.getFilename() + " - both vector and raster symbolizers in the style");

        SimpleFeature feature = SIMPLE_FEATURES[maxDim - 1];

        if (rsmb != null) {
            ColorMap colorMap = rsmb.getColorMap();
            if (colorMap == null)
                throw new Exception(
                        styleInfo.getFilename() + " - colorMap for raster symbolizer not found");

            ColorMapEntry[] colorMapEntries = colorMap.getColorMapEntries();
            LiteShape2 shape = getShape(rsmb);

            for (ColorMapEntry cme : colorMapEntries) {
                BufferedImage image = prepareImage(USE_TRANSPARENT);
                Graphics2D graphics =
                        prepareGraphics(image, USE_TRANSPARENT, DEFAULT_BACKGROUND_COLOR);

                Symbolizer smb = SymbolizerHelper.createPolygonSymbolizer(cme);
                Style2D style2d = sldStyleFactory.createStyle(feature, smb, NO_SCALE_RANGE);

                if (style2d != null) {
                    SHAPE_PAINTER.paint(graphics, shape, style2d, NO_SCALE);
                }

                graphics.dispose();
                result.add(createLegendItem(cme.getLabel(), rsmbRule, image));
            }
        } else {
            for (Rule rule : rules) {
                BufferedImage image = prepareImage(USE_TRANSPARENT);
                Graphics2D graphics =
                        prepareGraphics(image, USE_TRANSPARENT, DEFAULT_BACKGROUND_COLOR);

                Symbolizer[] symbolizers = rule.getSymbolizers();

                for (Symbolizer smb : symbolizers) {
                    // РЎСЋРґР° RasterSymbolizer РїРѕРїР°РґР°С‚СЊ РЅРµ РґРѕР»Р¶РµРЅ
                    Style2D style2d = sldStyleFactory.createStyle(feature, smb, NO_SCALE_RANGE);
                    LiteShape2 shape = getShape(smb);
                    if (style2d != null) {
                        SHAPE_PAINTER.paint(graphics, shape, style2d, NO_SCALE);
                    }
                }

                graphics.dispose();
                result.add(createLegendItem(null, rule, image));
            }
        }
        return result;
    }

    private BufferedImage prepareImage(boolean useTransparent) {
        int imageType =
                useTransparent ? BufferedImage.TYPE_4BYTE_ABGR : BufferedImage.TYPE_3BYTE_BGR;
        return new BufferedImage(imageWidth, imageHeight, imageType);
    }

    private LiteShape2 getShape(Symbolizer symbolizer) {
        if (symbolizer instanceof PointSymbolizer || symbolizer instanceof TextSymbolizer) {
            if (this.samplePoint == null) {
                Coordinate coord = new Coordinate(imageWidth / 2, imageHeight / 2);

                // РѕР±РѕСЂР°С‡РёРІР°РµРј РІС‹Р·РѕРІ РєРѕРЅСЃС‚СЂСѓРєС‚РѕСЂР° РІ try/catch,
                // СЃР»РµРґСѓСЏ РїСЂРёРЅС†РёРїСѓ "catch or specify"
                try {
                    this.samplePoint =
                            new LiteShape2(GEOMETRY_FACTORY.createPoint(coord), null, null, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return this.samplePoint;
        } else if (symbolizer instanceof LineSymbolizer) {
            if (this.sampleLine == null) {
                // РІ РѕС‚Р»РёС‡РёРё РѕС‚ СЂРµР°Р»РёР·Р°С†РёРё РІ GeoServer (РґРёР°РіРѕРЅР°Р»СЊ),
                // Р·Р°РґР°РµРј РіРѕСЂРёР·РѕРЅС‚Р°Р»СЊРЅСѓСЋ Р»РёРЅРёСЋ РїРѕ СЃРµСЂРµРґРёРЅРµ
                // С…РѕР»СЃС‚Р°
                Coordinate[] coords = {
                    new Coordinate(0, imageHeight / 2),
                    new Coordinate(imageWidth - 1, imageHeight / 2)
                };
                LineString geom = GEOMETRY_FACTORY.createLineString(coords);
                try {
                    this.sampleLine = new LiteShape2(geom, null, null, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return this.sampleLine;
        } else if (symbolizer instanceof PolygonSymbolizer
                || symbolizer instanceof RasterSymbolizer) {
            if (this.sampleRect == null) {
                Coordinate[] coords = {
                    new Coordinate(0, 0),
                    new Coordinate(0, imageHeight - 1),
                    new Coordinate(imageWidth - 1, imageHeight - 1),
                    new Coordinate(imageWidth - 1, 0),
                    new Coordinate(0, 0)
                };
                LinearRing shell = GEOMETRY_FACTORY.createLinearRing(coords);
                Polygon geom = GEOMETRY_FACTORY.createPolygon(shell, null);
                try {
                    this.sampleRect = new LiteShape2(geom, null, null, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return this.sampleRect;
        } else throw new IllegalArgumentException("Unknown symbolizer: " + symbolizer);
    }

    // ==========================================================================================
    // РЎРўРђРўР�Р§Р•РЎРљР�Р• РњР•РўРћР”Р« Р� РџРћР›РЇ
    // ==========================================================================================

    private static Graphics2D prepareGraphics(
            BufferedImage image, boolean useTransparent, Color bgColor) {
        Graphics2D graphic = image.createGraphics();
        HashMap<RenderingHints.Key, Object> hintsMap = new HashMap<RenderingHints.Key, Object>();

        // РџСЂРё VALUE_ANTIALIAS_OFF РёР·РѕР±СЂР°Р¶РµРЅРёРµ РѕР±СЂРµР·Р°РµС‚СЃСЏ
        hintsMap.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphic.setRenderingHints(hintsMap);

        if (useTransparent) {
            graphic.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC));

            Color c = new Color(bgColor.getRed(), bgColor.getGreen(), bgColor.getBlue(), 0);
            graphic.setBackground(bgColor);
            graphic.setColor(c);
            graphic.fillRect(0, 0, image.getWidth(), image.getHeight());

            graphic.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        } else {
            graphic.setColor(bgColor);
            graphic.fillRect(0, 0, image.getWidth(), image.getHeight());
        }
        return graphic;
    }

    @SuppressWarnings("deprecation")
    private static LegendItem createLegendItem(String label, Rule rule, BufferedImage image)
            throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, IMAGE_FORMAT, baos);
        String encodedImage = Base64.getEncoder().encodeToString(baos.toByteArray());

        double minScale = rule.getMinScaleDenominator();
        double maxScale = rule.getMaxScaleDenominator();

        // РџР°СЂР°РјРµС‚СЂС‹ РјР°СЃС€С‚Р°Р±Р° РѕС‚СЃСѓС‚СЃС‚РІСѓСЋС‚
        if (maxScale == Double.POSITIVE_INFINITY) {
            minScale = maxScale = NO_SCALE;
        }

        if (label == null) {
            Description desc = rule.getDescription();
            label = rule.getName();
            if (desc != null) {
                InternationalString title = desc.getTitle();
                if (title != null) {
                    label = title.toString();
                }
            }

            if (label == null) label = UNTITLED_RULE_LABEL;
        }

        return new LegendItem(
                label,
                image.getWidth(),
                image.getHeight(),
                MIME_TYPE,
                encodedImage,
                minScale,
                maxScale);
    }

    private static final String IMAGE_FORMAT = "png";
    private static final String MIME_TYPE = "image/png";
    private static final String UNTITLED_RULE_LABEL = "";
    private static final double NO_SCALE = -1d;
    private static final NumberRange<Double> NO_SCALE_RANGE =
            NumberRange.create(NO_SCALE, NO_SCALE);
    private static final boolean USE_TRANSPARENT = true;
    private static final Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;

    private static final SimpleFeature[] SIMPLE_FEATURES;
    private static final StyledShapePainter SHAPE_PAINTER = new StyledShapePainter();
    private static final GeometryFactory GEOMETRY_FACTORY = new GeometryFactory();

    static {
        try {
            SimpleFeatureType pointType =
                    DataUtilities.createType("myPointType", "geom:Point,name:String");
            SimpleFeatureType lineType =
                    DataUtilities.createType("myLineType", "geom:LineString,name:String");
            SimpleFeatureType polygonType =
                    DataUtilities.createType("myPolygonType", "geom:Polygon,name:String");

            SimpleFeature pointFeature = SimpleFeatureBuilder.template(pointType, null);
            SimpleFeature lineFeature = SimpleFeatureBuilder.template(lineType, null);
            SimpleFeature polygonFeature = SimpleFeatureBuilder.template(polygonType, null);

            SIMPLE_FEATURES = new SimpleFeature[] {pointFeature, lineFeature, polygonFeature};

        } catch (final SchemaException ex) {
            throw new RuntimeException("Failed to create feature types!", ex);
        }
    }
}
