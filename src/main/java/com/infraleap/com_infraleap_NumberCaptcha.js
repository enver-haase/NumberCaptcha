com_infraleap_NumberCaptcha = function() {
    var e = this.getElement(); // "our" div element

    var okayCaptchaFunc = this.captchaOkay;
    var badCaptchaFunc = this.captchaBad;

    var currentDigit = 0;

    this.onStateChange = function() {
        // For "this" see:
        // https://vaadin.com/api/com/vaadin/ui/AbstractJavaScriptComponent.html

        var s = this.getState().enterDigit;

        s = s.replace("%d", currentDigit);
        s = s.replace("%s", this.getState().digitNames[2]);

        e.innerHTML = "<h1>"+s+"</h1>";



    };

    e.onclick = function() {

        var okay = true; // TODO

        if (okay){
            okayCaptchaFunc();
        }
        else{
            badCaptchaFunc();
        }
    };
};
