<?xml version="1.0" encoding="UTF-8"?>
<sld:StyledLayerDescriptor xmlns="http://www.opengis.net/sld" xmlns:sld="http://www.opengis.net/sld" 
    xmlns:ogc="http://www.opengis.net/ogc" xmlns:gml="http://www.opengis.net/gml" version="1.0.0">
    <sld:UserLayer>
        <sld:LayerFeatureConstraints>
            <sld:FeatureTypeConstraint/>
        </sld:LayerFeatureConstraints>
        <sld:UserStyle>
            <FeatureTypeStyle>
                <Rule>
                    <sld:MinScaleDenominator>1.0</sld:MinScaleDenominator>
                    <sld:MaxScaleDenominator>4622320.0</sld:MaxScaleDenominator>
                    <RasterSymbolizer>
                        <Opacity>0.8</Opacity>
                        <ColorMap>
                            <ColorMapEntry color="#1072b4" quantity="1" label="Высокая"/>
                            <ColorMapEntry color="#4e8bba" quantity="2" label="Средняя"/>
                            <ColorMapEntry color="#85b0cd" quantity="3" label="Низкая"/>
                            <ColorMapEntry color="#ffffff" quantity="4" label="Отсутствует"/>
                        </ColorMap>
                    </RasterSymbolizer>
                </Rule>
            </FeatureTypeStyle>
        </sld:UserStyle>
    </sld:UserLayer>
</sld:StyledLayerDescriptor>