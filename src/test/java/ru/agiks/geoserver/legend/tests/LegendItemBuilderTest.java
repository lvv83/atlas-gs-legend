package ru.agiks.geoserver.legend.tests;

import static org.junit.Assert.*;

import java.awt.FontFormatException;
import java.io.IOException;
import java.util.List;
import org.geoserver.catalog.StyleInfo;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.agiks.geoserver.legend.LegendItem;
import ru.agiks.geoserver.legend.LegendItemBuilder;

public class LegendItemBuilderTest {
    @Test
    public void mest_opi_pnt() {
        LegendItemBuilder builder = createBuilder();
        try {
            StyleInfo styleInfo = StyleInfoLoader.Load("mest_opi_pnt.sld");
            List<LegendItem> items = builder.build(styleInfo);
            assertEquals(17, items.size());
            System.out.println(getImageDataUrl(items.get(0)));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void density_class() {
        LegendItemBuilder builder = createBuilder();
        try {
            StyleInfo styleInfo = StyleInfoLoader.Load("density_class.sld");
            List<LegendItem> items = builder.build(styleInfo);
            assertEquals(4, items.size());
            assertEquals("Высокая", items.get(0).getLabel());
            System.out.println(getImageDataUrl(items.get(0)));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void nko_wrong() {
        LegendItemBuilder builder = createBuilder();
        try {
            StyleInfo styleInfo = StyleInfoLoader.Load("nko_wrong.sld");
            builder.build(styleInfo);
            fail();
        } catch (Exception e) {
            // should be here
            System.out.println(e.getMessage());
        }
    }

    private static LegendItemBuilder createBuilder() {
        return new LegendItemBuilder(24, 24);
    }

    private static String getImageDataUrl(LegendItem legendItem) {
        return String.format(
                "data:%s;base64,%s", legendItem.getContentType(), legendItem.getContent());
    }

    @BeforeClass
    public static void registerFonts() {
        try {
            FontLoader.loadTTF("pi_demo.ttf");
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
