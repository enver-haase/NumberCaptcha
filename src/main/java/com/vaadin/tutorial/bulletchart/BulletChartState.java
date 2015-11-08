package com.vaadin.tutorial.bulletchart;

import com.vaadin.shared.ui.JavaScriptComponentState;

public class BulletChartState extends JavaScriptComponentState {
    public String domId;

    public String title = "xRevenue";
    public String subtitle = "xUS$, in thousands";
    public int[] ranges = new int [] {150, 225, 300};
    public int[] measures = new int[]{220};
    public int[] markers = new int[]{250};

}
