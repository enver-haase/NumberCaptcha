package com.vaadin.tutorial.bulletchart;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.tutorial.playground.JsLabel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Title("Bulletchart")
public class BulletchartUI extends UI {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2820914028993369752L;

	@Override
    protected void init(VaadinRequest request) {
        VerticalLayout content = new VerticalLayout();
        setContent(content);

        BulletChart chart = new BulletChart("bullet_chart");
        chart.setWidth("400px");
        chart.setHeight("200px");
        content.addComponent(chart);
        content.addComponent(new JsLabel("Hello!"));
    }

    @WebServlet(urlPatterns = "/*")
    @VaadinServletConfiguration(ui = BulletchartUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = -55324411331112701L;
    }
}
