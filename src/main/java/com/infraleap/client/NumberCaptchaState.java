package com.infraleap.client;

import com.vaadin.shared.ui.JavaScriptComponentState;

public class NumberCaptchaState extends JavaScriptComponentState {
    public int numDigits = 5;
    public int displayTimerMs = 500;

    public String enterDigit = "Please enter digit number %d for '%s' below.";

    public String[] digitNames = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
}
