package ru.agiks.geoserver.legend.tests;

import java.io.IOException;
import java.io.InputStream;
import org.geoserver.catalog.StyleInfo;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.styling.NamedLayer;
import org.geotools.styling.Style;
import org.geotools.styling.StyleFactory;
import org.geotools.styling.StyledLayer;
import org.geotools.styling.StyledLayerDescriptor;
import org.geotools.styling.UserLayer;
import org.geotools.xml.styling.SLDParser;

class StyleInfoLoader {
    static StyleInfo Load(String sldFileName) throws Exception {
        Style style = loadStyle(sldFileName);
        if (style == null) throw new Exception("Unexpected SLD structure.");

        StyleInfoStub stub = new StyleInfoStub(style);
        stub.setFilename(sldFileName);
        return stub;
    }

    private static Style loadStyle(String sldFileName) throws IOException {
        StyledLayerDescriptor descriptor = null;

        try (InputStream inputStream = CLASS_LOADER.getResourceAsStream(sldFileName)) {
            SLDParser parser = new SLDParser(STYLE_FACTORY, inputStream);
            descriptor = parser.parseSLD();
        } catch (IOException e) {

        }

        if (descriptor != null) {
            StyledLayer[] styledLayers = descriptor.getStyledLayers();
            if (styledLayers.length == 1) {
                if (styledLayers[0] instanceof NamedLayer) {
                    NamedLayer namedLayer = (NamedLayer) styledLayers[0];
                    Style[] styles = namedLayer.getStyles();
                    if (styles.length == 1) return styles[0];
                } else if (styledLayers[0] instanceof UserLayer) {
                    UserLayer userLayer = (UserLayer) styledLayers[0];
                    Style[] styles = userLayer.getUserStyles();
                    if (styles.length == 1) return styles[0];
                }
            }
        }
        return null;
    }

    private static final ClassLoader CLASS_LOADER = StyleInfo.class.getClassLoader();
    private static final StyleFactory STYLE_FACTORY = CommonFactoryFinder.getStyleFactory();
}
