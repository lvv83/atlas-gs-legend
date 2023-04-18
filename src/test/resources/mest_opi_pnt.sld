<?xml version="1.0" encoding="UTF-8"?>
<StyledLayerDescriptor version="1.0.0"
                       xsi:schemaLocation="http://www.opengis.net/sld http://schemas.opengis.net/sld/1.0.0/StyledLayerDescriptor.xsd"
                       xmlns="http://www.opengis.net/sld" xmlns:ogc="http://www.opengis.net/ogc"
                       xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <NamedLayer>
    <Name>Месторождения ОПИ РК (точ.)</Name>
    <UserStyle>
      <Name>Месторождения ОПИ РК (точ.)</Name>
      <FeatureTypeStyle>
        <Rule>
          <Name>Базальт</Name>
          
            <Title>Базальт</Title>
          
          <ogc:Filter xmlns:ogc="http://www.opengis.net/ogc">
            <ogc:PropertyIsEqualTo>
              <ogc:PropertyName>osn_pi</ogc:PropertyName>
              <ogc:Literal>базальт</ogc:Literal>
            </ogc:PropertyIsEqualTo>
          </ogc:Filter>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x79</WellKnownName>
                <Fill>
                  <CssParameter name="fill">#e9ffbe</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x63</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>99</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#894444</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
        </Rule>
        <Rule>
          <Name>Известняк</Name>
          
            <Title>Известняк</Title>
          
          <ogc:Filter xmlns:ogc="http://www.opengis.net/ogc">
            <ogc:PropertyIsEqualTo>
              <ogc:PropertyName>osn_pi</ogc:PropertyName>
              <ogc:Literal>известняк</ogc:Literal>
            </ogc:PropertyIsEqualTo>
          </ogc:Filter>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x79</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>121</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#e9ffbe</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x67</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>103</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#894444</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
        </Rule>
        <Rule>
          <Name>Известняк, карбонатные породы</Name>
          
            <Title>Известняк, карбонатные породы</Title>
          
          <ogc:Filter xmlns:ogc="http://www.opengis.net/ogc">
            <ogc:PropertyIsEqualTo>
              <ogc:PropertyName>osn_pi</ogc:PropertyName>
              <ogc:Literal>известняк, карбонатные породы</ogc:Literal>
            </ogc:PropertyIsEqualTo>
          </ogc:Filter>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x79</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>121</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#e9ffbe</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x67</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>103</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#894444</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
        </Rule>
        <Rule>
          <Name>Доломит</Name>
          
            <Title>Доломит</Title>
          
          <ogc:Filter xmlns:ogc="http://www.opengis.net/ogc">
            <ogc:PropertyIsEqualTo>
              <ogc:PropertyName>osn_pi</ogc:PropertyName>
              <ogc:Literal>доломит</ogc:Literal>
            </ogc:PropertyIsEqualTo>
          </ogc:Filter>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x79</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>121</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#e9ffbe</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x68</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>104</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#894444</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
        </Rule>
        <Rule>
          <Name>Мука доломитовая</Name>
          
            <Title>Мука доломитовая</Title>
          
          <ogc:Filter xmlns:ogc="http://www.opengis.net/ogc">
            <ogc:PropertyIsEqualTo>
              <ogc:PropertyName>osn_pi</ogc:PropertyName>
              <ogc:Literal>мука доломитовая</ogc:Literal>
            </ogc:PropertyIsEqualTo>
          </ogc:Filter>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x79</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>121</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#e9ffbe</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x68</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>104</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#894444</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
        </Rule>
        <Rule>
          <Name>Кварцито-песчаник</Name>
          
            <Title>Кварцито-песчаник</Title>
          
          <ogc:Filter xmlns:ogc="http://www.opengis.net/ogc">
            <ogc:PropertyIsEqualTo>
              <ogc:PropertyName>osn_pi</ogc:PropertyName>
              <ogc:Literal>кварцито-песчаник</ogc:Literal>
            </ogc:PropertyIsEqualTo>
          </ogc:Filter>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x79</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>121</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#e9ffbe</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x7c</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>124</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#894444</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
        </Rule>
        <Rule>
          <Name>Песчаник</Name>
          
            <Title>Песчаник</Title>
          
          <ogc:Filter xmlns:ogc="http://www.opengis.net/ogc">
            <ogc:PropertyIsEqualTo>
              <ogc:PropertyName>osn_pi</ogc:PropertyName>
              <ogc:Literal>песчаник</ogc:Literal>
            </ogc:PropertyIsEqualTo>
          </ogc:Filter>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x79</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>121</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#e9ffbe</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x78</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>120</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#894444</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
        </Rule>
        <Rule>
          <Name>Песчаник, кварцито-песчаник</Name>
          
            <Title>Песчаник, кварцито-песчаник</Title>
          
          <ogc:Filter xmlns:ogc="http://www.opengis.net/ogc">
            <ogc:PropertyIsEqualTo>
              <ogc:PropertyName>osn_pi</ogc:PropertyName>
              <ogc:Literal>песчаник, кварцито-песчаник</ogc:Literal>
            </ogc:PropertyIsEqualTo>
          </ogc:Filter>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x79</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>121</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#e9ffbe</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x78</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>120</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#894444</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
        </Rule>
        <Rule>
          <Name>Глина</Name>
          
            <Title>Глина</Title>
          
          <ogc:Filter xmlns:ogc="http://www.opengis.net/ogc">
            <ogc:PropertyIsEqualTo>
              <ogc:PropertyName>osn_pi</ogc:PropertyName>
              <ogc:Literal>глина</ogc:Literal>
            </ogc:PropertyIsEqualTo>
          </ogc:Filter>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x79</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>121</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#e9ffbe</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x6e</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>110</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#894444</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
        </Rule>
        <Rule>
          <Name>Глина, аргиллит</Name>
          
            <Title>Глина, аргиллит</Title>
          
          <ogc:Filter xmlns:ogc="http://www.opengis.net/ogc">
            <ogc:PropertyIsEqualTo>
              <ogc:PropertyName>osn_pi</ogc:PropertyName>
              <ogc:Literal>глина, аргиллит</ogc:Literal>
            </ogc:PropertyIsEqualTo>
          </ogc:Filter>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x78</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>121</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#e9ffbe</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x6e</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>110</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#894444</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
        </Rule>
        <Rule>
          <Name>Глина, породы глинистые</Name>
          
            <Title>Глина, породы глинистые</Title>
          
          <ogc:Filter xmlns:ogc="http://www.opengis.net/ogc">
            <ogc:PropertyIsEqualTo>
              <ogc:PropertyName>osn_pi</ogc:PropertyName>
              <ogc:Literal>глина, породы глинистые</ogc:Literal>
            </ogc:PropertyIsEqualTo>
          </ogc:Filter>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x79</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>121</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#e9ffbe</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x6e</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>110</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#894444</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
        </Rule>
        <Rule>
          <Name>Глина, суглинок</Name>
          
            <Title>Глина, суглинок</Title>
          
          <ogc:Filter xmlns:ogc="http://www.opengis.net/ogc">
            <ogc:PropertyIsEqualTo>
              <ogc:PropertyName>osn_pi</ogc:PropertyName>
              <ogc:Literal>глина, суглинок</ogc:Literal>
            </ogc:PropertyIsEqualTo>
          </ogc:Filter>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x79</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>121</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#e9ffbe</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x6e</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>110</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#894444</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
        </Rule>
        <Rule>
          <Name>Песок строительный</Name>
          
            <Title>Песок строительный</Title>
          
          <ogc:Filter xmlns:ogc="http://www.opengis.net/ogc">
            <ogc:PropertyIsEqualTo>
              <ogc:PropertyName>osn_pi</ogc:PropertyName>
              <ogc:Literal>песок</ogc:Literal>
            </ogc:PropertyIsEqualTo>
          </ogc:Filter>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x79</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>121</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#e9ffbe</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x77</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>119</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#894444</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
        </Rule>
        <Rule>
          <Name>Песчано-гравийные отложения</Name>
          
            <Title>Песчано-гравийные отложения</Title>
          
          <ogc:Filter xmlns:ogc="http://www.opengis.net/ogc">
            <ogc:PropertyIsEqualTo>
              <ogc:PropertyName>osn_pi</ogc:PropertyName>
              <ogc:Literal>песчано-гравийные отложения</ogc:Literal>
            </ogc:PropertyIsEqualTo>
          </ogc:Filter>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x79</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>121</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#e9ffbe</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x75</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>117</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#894444</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
        </Rule>
        <Rule>
          <Name>Песчано-гравийные отложения, песок</Name>
          
            <Title>Песчано-гравийные отложения, песок</Title>
          
          <ogc:Filter xmlns:ogc="http://www.opengis.net/ogc">
            <ogc:PropertyIsEqualTo>
              <ogc:PropertyName>osn_pi</ogc:PropertyName>
              <ogc:Literal>песчано-гравийные отложения, песок</ogc:Literal>
            </ogc:PropertyIsEqualTo>
          </ogc:Filter>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x79</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>121</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#e9ffbe</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x75</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>117</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#894444</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
        </Rule>
        <Rule>
          <Name>Гипс</Name>
          
            <Title>Гипс</Title>
          
          <ogc:Filter xmlns:ogc="http://www.opengis.net/ogc">
            <ogc:PropertyIsEqualTo>
              <ogc:PropertyName>osn_pi</ogc:PropertyName>
              <ogc:Literal>гипс</ogc:Literal>
            </ogc:PropertyIsEqualTo>
          </ogc:Filter>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x79</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>121</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#e9ffbe</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x7a</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>122</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#894444</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
        </Rule>
        <Rule>
          <Name>Сланец</Name>
          
            <Title>Сланец</Title>
          
          <ogc:Filter xmlns:ogc="http://www.opengis.net/ogc">
            <ogc:PropertyIsEqualTo>
              <ogc:PropertyName>osn_pi</ogc:PropertyName>
              <ogc:Literal>сланец</ogc:Literal>
            </ogc:PropertyIsEqualTo>
          </ogc:Filter>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x79</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>121</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#e9ffbe</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
          <PointSymbolizer>
            <Graphic>
              <Mark>
                <WellKnownName>ttf://PI_DEMO#0x73</WellKnownName>
                <Format>ttf</Format>
                <MarkIndex>115</MarkIndex>
                <Fill>
                  <CssParameter name="fill">#894444</CssParameter>
                </Fill>
              </Mark>
              <Size>12</Size>
            </Graphic>
          </PointSymbolizer>
        </Rule>
      </FeatureTypeStyle>
    </UserStyle>
  </NamedLayer>
</StyledLayerDescriptor>