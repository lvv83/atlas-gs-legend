package ru.agiks.geoserver.legend;

import java.util.ArrayList;
import java.util.List;
import org.geoserver.catalog.LayerInfo;

public class GetLegendOperation {
    public GetLegendResponse run(GetLegendRequest request) throws Exception {

        List<LayerInfo> layerInfos = request.getLayers();
        List<LayerItem> result = new ArrayList<LayerItem>();

        LegendItemBuilder builder = new LegendItemBuilder(request.getWidth(), request.getHeight());

        for (LayerInfo layerInfo : layerInfos) {
            LayerItem layerItem = new LayerItem(layerInfo.prefixedName(), layerInfo.getTitle());
            layerItem.setItems(builder.build(layerInfo.getDefaultStyle()));
            result.add(layerItem);
        }

        return new GetLegendResponse(result);
    }
}
