package com.tutorial.bulletchart;

import com.vaadin.shared.ui.JavaScriptComponentState;

public class BulletChartState extends JavaScriptComponentState {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7421689875171064265L;

    public String title = "xRevenue";
    public String subtitle = "xUS$, in thousands";
    public int[] ranges = new int [] {150, 225, 300};
    public int[] measures = new int[]{220};
    public int[] markers = new int[]{250};

}
