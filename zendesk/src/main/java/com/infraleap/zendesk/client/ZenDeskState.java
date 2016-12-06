package com.infraleap.zendesk.client;

import com.vaadin.shared.ui.JavaScriptComponentState;

public class ZenDeskState extends JavaScriptComponentState {
    public int numDigits = 5;
    public int displayTimerMs = 2000;

    public String enterDigit = "On position %d, please enter the digit for '%s' below.";

    public String[] digitNames = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};

    public String returnKeyWhenDone = "Press enter when done.";
}
