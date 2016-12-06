package com.infraleap.zendesk;

import com.infraleap.zendesk.client.ZenDeskState;
import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;
import elemental.json.JsonArray;

/**
 * https://vaadin.com/blog/-/blogs/vaadin-7-loves-javascript-components
 */
@StyleSheet("com_infraleap_zendesk_ZenDesk.css")
@JavaScript({ "com_infraleap_zendesk_ZenDesk.js" })
public abstract class ZenDesk extends AbstractJavaScriptComponent {

	/**
	 * Creates a ZenDesk object.
	 *
	 * @param numDigits how many digits will the user be asked to translate?
	 * @param millisecs time to change display from one number to the next, in milliseconds.
	 * @param enterStringAndPressReturnAndDigitNames strings to be displayed for the header, the footer and the digits. Can be left away so that English standard texts are used. Otherwise exactly two or twelve strings must be given as header &amp; footer or as header &amp; footer &amp; digit-names (starting from 'zero', going to 'ten') respectively. The header string should use the placeholders %d (place of the digit to translate) and %s (name of the digit to translate).
	 */
	public ZenDesk(int numDigits, int millisecs, String... enterStringAndPressReturnAndDigitNames){

		getState().numDigits = numDigits;
		getState().displayTimerMs = millisecs;
		if (enterStringAndPressReturnAndDigitNames.length > 1) {
			getState().enterDigit = enterStringAndPressReturnAndDigitNames[0];
			getState().returnKeyWhenDone = enterStringAndPressReturnAndDigitNames[1];
		}

		if (enterStringAndPressReturnAndDigitNames.length == 12){
			for (int i=0; i<10; i++){
				getState().digitNames[i] = enterStringAndPressReturnAndDigitNames[i+2];
			}
		}
		if (enterStringAndPressReturnAndDigitNames.length != 0 && enterStringAndPressReturnAndDigitNames.length != 2 && enterStringAndPressReturnAndDigitNames.length != 12){
			throw new IllegalArgumentException("Please provide 12 strings providing headline, footer and names for exactly 10 digits, or two strings for just header and footer, or no strings at all for English standard texts.");
		}

		this.addStyleName("com_infraleap_vaadin_ZenDesk");

		this.addFunction("captchaOkay", (JavaScriptFunction) arguments -> captchaGood());

		this.addFunction("captchaWrong", new JavaScriptFunction() {
			@Override
			public void call(JsonArray arguments) {
				captchaBad();
			}
		});

	}

	@Override
	protected ZenDeskState getState(){
		return (ZenDeskState) super.getState();
	}

	public abstract void captchaGood();

	public abstract void captchaBad();

}
