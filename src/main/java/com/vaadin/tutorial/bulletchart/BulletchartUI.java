package com.vaadin.tutorial.bulletchart;

import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;

import javax.servlet.annotation.WebServlet;

@Title("Bulletchart")
public class BulletchartUI extends UI {

    BulletChart bulletChart;

    @Override
    protected void init(VaadinRequest request) {
        bulletChart = new BulletChart("bullet_chart");

        bulletChart.setTitle("Revenue");
        bulletChart.setSubtitle("US$, in thousands");
        bulletChart.setRanges(new int [] {150, 225, 300});
        bulletChart.setMeasures(new int[]{220});
        bulletChart.setMarkers(new int[]{250});

        bulletChart.setSizeFull();

        HorizontalLayout mainLayout = new HorizontalLayout(bulletChart);
        mainLayout.setWidth("100%");
        bulletChart.setWidth("100%");
        mainLayout.setExpandRatio(bulletChart, 1);

        mainLayout.setSizeFull();

        setContent(bulletChart);
        bulletChart.setVisible(true);
    }


    @WebServlet(urlPatterns = "/*")
    @VaadinServletConfiguration(ui = BulletchartUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
