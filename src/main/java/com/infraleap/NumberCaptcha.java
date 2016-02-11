package com.infraleap;

import com.infraleap.client.NumberCaptchaState;
import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;
import elemental.json.JsonArray;

/**
 * https://vaadin.com/blog/-/blogs/vaadin-7-loves-javascript-components
 */
@StyleSheet("com_infraleap_NumberCaptcha.css")
@JavaScript({ "com_infraleap_NumberCaptcha.js", "com_infraleap_NumberCaptcha_blubb.js" })
public class NumberCaptcha extends AbstractJavaScriptComponent {

    public NumberCaptcha(){
        this.addStyleName("com_infraleap_vaadin_NumberCaptcha");
        this.setWidth("400px");
        this.setHeight("200px");

        this.addFunction("blubb", new JavaScriptFunction() {
            @Override
            public void call(JsonArray arguments) {
                System.out.println("ll");
            }
        });
    }

    @Override
    protected NumberCaptchaState getState(){
        return (NumberCaptchaState) super.getState();
    }

}
