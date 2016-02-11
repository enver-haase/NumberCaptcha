package com.infraleap.client;

import com.vaadin.shared.ui.JavaScriptComponentState;

public class NumberCaptchaState extends JavaScriptComponentState {
    int numDigits = 5;
    int displayTimerMs = 500;

    String enterDigitPre = "Enter digit for '";

    String displayString0 = "ZERO";
    String displayString1 = "ONE";
    String displayString2 = "TWO";
    String displayString3 = "THREE";
    String displayString4 = "FOUR";
    String displayString5 = "FIVE";
    String displayString6 = "SIX";
    String displayString7 = "SEVEN";
    String displayString8 = "EIGHT";
    String displayString9 = "NINE";

    String enterDigitPost = "' below.";
}
