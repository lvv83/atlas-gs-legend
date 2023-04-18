package ru.agiks.geoserver.legend;

import java.io.IOException;
import java.io.OutputStream;
import org.geoserver.ows.Response;
import org.geoserver.platform.Operation;
import org.geoserver.platform.ServiceException;

public class GetLegendResponseWriter extends Response {

    public GetLegendResponseWriter() {
        super(GetLegendResponse.class, GetLegendResponse.MIME_TYPE);
    }

    @Override
    public String getMimeType(Object value, Operation operation) throws ServiceException {
        return GetLegendResponse.MIME_TYPE;
    }

    @Override
    public void write(Object value, OutputStream output, Operation operation)
            throws IOException, ServiceException {
        GetLegendResponse response = (GetLegendResponse) value;
        output.write(response.getContent());
    }

    @Override
    public String getAttachmentFileName(Object value, Operation operation) {
        return "getLegend.json";
    }

    @Override
    public String getCharset(Operation operation) {
        return GetLegendResponse.CHARSET;
    }
}
