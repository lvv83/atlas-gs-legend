package ru.agiks.geoserver.legend;

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.styling.ColorMapEntry;
import org.geotools.styling.PolygonSymbolizer;
import org.geotools.styling.StyleFactory;
import org.geotools.styling.Symbolizer;
import org.opengis.filter.FilterFactory;
import org.opengis.filter.expression.Expression;

class SymbolizerHelper {
    private static final StyleFactory STYLE_FACTORY = CommonFactoryFinder.getStyleFactory();
    private static final FilterFactory FILTER_FACTORY = CommonFactoryFinder.getFilterFactory();

    static Symbolizer createPolygonSymbolizer(ColorMapEntry colorMapEntry) {
        PolygonSymbolizer smb = STYLE_FACTORY.createPolygonSymbolizer();
        Expression colorExpression = colorMapEntry.getColor();

        smb.setFill(STYLE_FACTORY.createFill(colorExpression));
        smb.setStroke(STYLE_FACTORY.createStroke(colorExpression, FILTER_FACTORY.literal(1)));

        return smb;
    }
}
