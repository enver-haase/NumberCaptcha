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
@JavaScript({ "com_infraleap_NumberCaptcha.js" })
public abstract class NumberCaptcha extends AbstractJavaScriptComponent {

    public NumberCaptcha(int numDigits, int millisecs, String... enterStringAndDigitNames){

        getState().numDigits = numDigits;
        getState().displayTimerMs = millisecs;
        if (enterStringAndDigitNames.length > 0) {
            getState().enterDigit = enterStringAndDigitNames[0];
        }
        if (enterStringAndDigitNames.length == 11){
            for (int i=0; i<10; i++){
                getState().digitNames[i] = enterStringAndDigitNames[i+1];
            }
        }
        if (enterStringAndDigitNames.length != 0 && enterStringAndDigitNames.length != 1 && enterStringAndDigitNames.length != 11){
            throw new IllegalArgumentException("Please provide names for exactly 10 digits, or none at all for English standard names.");
        }

        this.addStyleName("com_infraleap_vaadin_NumberCaptcha");

        this.setWidth("400px");
        this.setHeight("200px");

        this.addFunction("captchaOkay", new JavaScriptFunction() {
            @Override
            public void call(JsonArray arguments) {
                captchaGood();
            }
        });

        this.addFunction("captchaWrong", new JavaScriptFunction() {
            @Override
            public void call(JsonArray arguments) {
                captchaBad();
            }
        });

    }

    @Override
    protected NumberCaptchaState getState(){
        return (NumberCaptchaState) super.getState();
    }

    public abstract void captchaGood();

    public abstract void captchaBad();

}
