package ru.agiks.geoserver.legend.tests;

import java.io.IOException;
import org.geoserver.catalog.CatalogVisitor;
import org.geoserver.catalog.LegendInfo;
import org.geoserver.catalog.MetadataMap;
import org.geoserver.catalog.StyleInfo;
import org.geoserver.catalog.WorkspaceInfo;
import org.geotools.styling.Style;
import org.geotools.styling.StyledLayerDescriptor;
import org.geotools.util.Version;

@SuppressWarnings("serial")
class StyleInfoStub implements StyleInfo {
    Style style;

    public StyleInfoStub(Style style) {
        this.style = style;
    }

    @Override
    public void accept(CatalogVisitor visitor) {
        // TODO Auto-generated method stub
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public WorkspaceInfo getWorkspace() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setWorkspace(WorkspaceInfo workspace) {
        // TODO Auto-generated method stub
    }

    @Override
    public String getFormat() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setFormat(String format) {
        // TODO Auto-generated method stub

    }

    @Override
    public Version getFormatVersion() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setFormatVersion(Version version) {
        // TODO Auto-generated method stub

    }

    String fileName;

    @Override
    public String getFilename() {
        return this.fileName;
    }

    @Override
    public void setFilename(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Style getStyle() throws IOException {
        return this.style;
    }

    @Override
    public LegendInfo getLegend() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLegend(LegendInfo legend) {
        // TODO Auto-generated method stub

    }

    @Override
    public String prefixedName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public StyledLayerDescriptor getSLD() throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MetadataMap getMetadata() {
        // TODO Auto-generated method stub
        return null;
    }
}
