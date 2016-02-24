package com.infraleap.application;

import javax.servlet.annotation.WebServlet;

import com.infraleap.NumberCaptcha;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Title("NoRobots")
public class NoRobotsUI extends UI {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2820914028993369752L;

	@Override
    protected void init(VaadinRequest request) {
        VerticalLayout content = new VerticalLayout();
        setContent(content);

        content.addComponent(new NumberCaptcha(4, 3000, "Pos %d, enter %s as a digit", "Hit RETURN to continue when finished.") {
            @Override
            public void captchaGood() {
                Notification.show("Good, you are a human being. Thanks.");
            }

            @Override
            public void captchaBad() {
                Notification.show("Please try again.");
            }
        });
    }

    @WebServlet(urlPatterns = "/*")
    @VaadinServletConfiguration(ui = NoRobotsUI.class, productionMode = false, widgetset = "com.infraleap.NumberCaptchaWidgetSet")
    public static class MyUIServlet extends VaadinServlet {
    }
}
