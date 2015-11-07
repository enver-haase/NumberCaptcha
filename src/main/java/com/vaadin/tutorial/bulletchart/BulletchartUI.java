package com.vaadin.tutorial.bulletchart;

import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import javax.servlet.annotation.WebServlet;
import java.util.Random;

@Title("Bulletchart")
public class BulletchartUI extends UI {

    BulletChart bulletChart;


    @Override
    protected void init(VaadinRequest request) {
        bulletChart = new BulletChart("bullet_chart");
        bulletChart.setValue(new Random().nextInt(100));
        setContent(bulletChart);
    }


    @WebServlet(urlPatterns = "/*")
    @VaadinServletConfiguration(ui = BulletchartUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
