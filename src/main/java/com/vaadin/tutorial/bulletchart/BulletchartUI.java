package com.vaadin.tutorial.bulletchart;

import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.tutorial.playground.JsLabel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;

@Title("Bulletchart")
public class BulletchartUI extends UI {

    BulletChart bulletChart = new BulletChart("bullet_chart");

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout content = new VerticalLayout();
        setContent(content);

        content.addComponent(bulletChart);
        //content.addComponent(new JsLabel("Hello!"));
    }

    @WebServlet(urlPatterns = "/*")
    @VaadinServletConfiguration(ui = BulletchartUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
