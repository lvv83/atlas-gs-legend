package ru.agiks.geoserver.legend;

import java.util.ArrayList;
import java.util.List;

public class LayerItem {
    private String name;
    private String title;
    private List<LegendItem> items;

    public LayerItem(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return this.name;
    }

    public String getTitle() {
        return this.title;
    }

    public List<LegendItem> getItems() {
        if (this.items == null) return new ArrayList<LegendItem>();
        return this.items;
    }

    public void setItems(List<LegendItem> items) {
        this.items = items;
    }
}
