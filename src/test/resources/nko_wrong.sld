<?xml version="1.0" encoding="UTF-8"?>
<StyledLayerDescriptor version="1.0.0"
                       xsi:schemaLocation="http://www.opengis.net/sld http://schemas.opengis.net/sld/1.0.0/StyledLayerDescriptor.xsd"
                       xmlns="http://www.opengis.net/sld" xmlns:ogc="http://www.opengis.net/ogc"
                       xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <NamedLayer>
    <Name>Некоммерческая организация</Name>
    <UserStyle>
      <Name>Некоммерческая организация</Name>
      <FeatureTypeStyle>
     <Rule>
       <PointSymbolizer>
         <Graphic>
           <Mark>
             <WellKnownName>circle</WellKnownName>
             <Fill>
               <CssParameter name="fill">#00eafe</CssParameter>
             </Fill>
           </Mark>
           <Size>20</Size>
         </Graphic>
       </PointSymbolizer>
     </Rule>
   </FeatureTypeStyle>
      <FeatureTypeStyle>
     <Rule>
       <PointSymbolizer>
         <Graphic>
           <Mark>
             <WellKnownName>circle</WellKnownName>
             <Fill>
               <CssParameter name="fill">#ffffff</CssParameter>
               <CssParameter name="fill-opacity">0</CssParameter>
             </Fill>
           </Mark>
           <Size>6</Size>
         </Graphic>
       </PointSymbolizer>
       <TextSymbolizer>
         <label><Literal>НКО</Literal> </label>
          <Font>
           <CssParameter name="font-family">Arial</CssParameter>
           <CssParameter name="font-size">7</CssParameter>
           <CssParameter name="font-style">normal</CssParameter>
         </Font>
           <LabelPlacement>
           <PointPlacement>
             <AnchorPoint>
               <AnchorPointX>0.5</AnchorPointX>
               <AnchorPointY>0.5</AnchorPointY>
             </AnchorPoint>
           </PointPlacement>
         </LabelPlacement>
         <Fill>
           <CssParameter name="fill">#000000</CssParameter>
         </Fill>
       </TextSymbolizer>
     </Rule>
   </FeatureTypeStyle>
    </UserStyle>
  </NamedLayer>
</StyledLayerDescriptor>