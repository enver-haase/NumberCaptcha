package com.tutorial.playground;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

@JavaScript({ "com_tutorial_playground_JsLabel.js" })
public class JsLabel extends AbstractJavaScriptComponent {

    public JsLabel(String xhtml) {
        getState().xhtml = xhtml;
    }

    @Override
    protected JsLabelState getState() {
        return (JsLabelState) super.getState();
    }
}
