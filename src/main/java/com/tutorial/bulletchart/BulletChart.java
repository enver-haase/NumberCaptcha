package com.tutorial.bulletchart;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;

@StyleSheet("https://cdn.rawgit.com/novus/nvd3/v1.8.1/build/nv.d3.css")
@JavaScript({
        "http://d3js.org/d3.v3.min.js",
        "https://cdn.rawgit.com/novus/nvd3/v1.8.1/build/nv.d3.js",
        "com_tutorial_bulletchart_BulletChart.js"
})
public class BulletChart extends AbstractJavaScriptComponent {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1213833898353675122L;

	public BulletChart(String title) {
		getState().title = title;
	}

    public void setTitle(String title) {
        getState().title = title;
    }
    public void setSubtitle(String subtitle) {
        getState().subtitle = subtitle;
    }
    public void setRanges(int[] ranges) {
        getState().ranges = ranges;
    }
    public void setMeasures(int[] measures) {
        getState().measures = measures;
    }
    public void setMarkers(int[] markers) {
        getState().markers = markers;
    }

    @Override
    protected BulletChartState getState() {
        return (BulletChartState) super.getState();
    }
}
