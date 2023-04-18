package ru.agiks.geoserver.legend;

import java.util.List;
import org.geoserver.catalog.LayerInfo;

public class GetLegendRequest {

    private List<LayerInfo> layers;
    private int width = 24;
    private int height = 24;

    public List<LayerInfo> getLayers() {
        return layers;
    }

    public void setLayers(List<LayerInfo> layers) {
        this.layers = layers;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
