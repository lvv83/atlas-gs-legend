package ru.agiks.geoserver.legend;

public class LegendItem {
    String label;
    int width;
    int height;
    String contentType;
    String content;
    double minScale;
    double maxScale;

    public LegendItem(
            String label,
            int width,
            int height,
            String contentType,
            String content,
            double minScale,
            double maxScale) {
        this.label = label;
        this.width = width;
        this.height = height;
        this.contentType = contentType;
        this.content = content;
        this.minScale = minScale;
        this.maxScale = maxScale;
    }

    public String getLabel() {
        return this.label;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getContent() {
        return this.content;
    }

    public double getMinScale() {
        return this.minScale;
    }

    public double getMaxScale() {
        return this.maxScale;
    }
}
