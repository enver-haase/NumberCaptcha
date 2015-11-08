package com.vaadin.tutorial.bulletchart;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

@JavaScript({
        "http://d3js.org/d3.v3.min.js",
        "https://cdn.rawgit.com/novus/nvd3/v1.8.1/build/nv.d3.js",
        "com_vaadin_tutorial_bulletchart_BulletChart.js"
})
public class BulletChart extends AbstractJavaScriptComponent {

    public BulletChart(String domId) {
        getState().domId = domId;
    }

    public void setValue(int value) {
        getState().value = value;
    }

    @Override
    protected BulletChartState getState() {
        return (BulletChartState) super.getState();
    }
}
