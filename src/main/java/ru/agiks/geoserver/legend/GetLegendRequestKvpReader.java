package ru.agiks.geoserver.legend;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.geoserver.catalog.LayerInfo;
import org.geoserver.config.GeoServer;
import org.geoserver.ows.KvpRequestReader;
import org.geoserver.ows.util.KvpUtils;
import org.geoserver.platform.ServiceException;

public class GetLegendRequestKvpReader extends KvpRequestReader {

    private final GeoServer geoserver;

    public GetLegendRequestKvpReader(final GeoServer geoserver) {
        super(GetLegendRequest.class);
        this.geoserver = geoserver;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public GetLegendRequest read(Object request, Map kvp, Map rawKvp) throws Exception {
        GetLegendRequest req = (GetLegendRequest) super.read(request, kvp, rawKvp);

        String layersParam = (String) rawKvp.get("LAYERS");
        if (layersParam != null) {
            @SuppressWarnings("unchecked")
            List<String> layerNames = KvpUtils.readFlat(layersParam);
            List<LayerInfo> layers = new ArrayList<LayerInfo>();

            for (String layerName : layerNames) {
                LayerInfo layerInfo = this.geoserver.getCatalog().getLayerByName(layerName);
                if (layerInfo == null)
                    throw new ServiceException(
                            "Could not find layer " + layerName, "LayerNotDefined", "layers");

                layers.add(layerInfo);
            }

            req.setLayers(layers);
        }

        String widthParam = (String) rawKvp.get("WIDTH");
        String heightParam = (String) rawKvp.get("HEIGHT");
        if (widthParam != null && heightParam != null) {
            try {
                req.setWidth(validateSizeParam(widthParam, "WIDTH"));
                req.setHeight(validateSizeParam(heightParam, "HEIGHT"));
            } catch (Exception e) {
                throw new ServiceException(
                        "Wrong values for WIDTH and/or HEIGHT. Use defaults instead.", e);
            }
        }

        return req;
    }

    private static int validateSizeParam(String size, String name) {
        int result = Integer.parseInt(size);
        if (result < 8 || result > 256)
            throw new IllegalArgumentException(name + " should have value between 8 and 256");

        return result;
    }
}
