package ru.agiks.geoserver.legend;

public class LegendService {
    private GetLegendOperation getLegendOperation;

    public void setGetLegendOperation(GetLegendOperation operation) {
        this.getLegendOperation = operation;
    }

    public GetLegendResponse getLegend(GetLegendRequest request) throws Exception {
        if (getLegendOperation == null)
            throw new UnsupportedOperationException(
                    "Operation not properly configured, make sure the operation bean has been set");

        return getLegendOperation.run(request);
    }
}
