package ru.agiks.geoserver.legend.tests;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

class FontLoader {
    static void loadTTF(String ttfFileName) throws FontFormatException, IOException {
        loadFont(Font.TRUETYPE_FONT, ttfFileName);
    }

    private static void loadFont(int fontFormat, String fileName)
            throws FontFormatException, IOException {
        try (InputStream inputStream = CLASS_LOADER.getResourceAsStream(fileName)) {
            GRAPHICS_ENVIRONMENT.registerFont(Font.createFont(Font.TRUETYPE_FONT, inputStream));
        }
    }

    private static final ClassLoader CLASS_LOADER = FontLoader.class.getClassLoader();
    private static final GraphicsEnvironment GRAPHICS_ENVIRONMENT =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
}
