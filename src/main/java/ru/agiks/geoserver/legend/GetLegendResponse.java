package ru.agiks.geoserver.legend;

import java.io.UnsupportedEncodingException;
import java.util.List;
import net.sf.json.JSONArray;

public class GetLegendResponse {

    static final String MIME_TYPE = "application/json";
    static final String CHARSET = "UTF-8";

    private List<LayerItem> items;

    public GetLegendResponse(List<LayerItem> list) {
        this.items = list;
    }

    public byte[] getContent() {
        JSONArray json = JSONArray.fromObject(this.items);
        try {
            return json.toString().getBytes(CHARSET);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
