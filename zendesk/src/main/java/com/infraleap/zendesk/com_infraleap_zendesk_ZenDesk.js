com_infraleap_zendesk_ZenDesk = function() {

    // "globals"

    // For "this" see:
    // https://vaadin.com/api/com/vaadin/ui/AbstractJavaScriptComponent.html
    var self = this;

    // see reset() for init'ing.
    var timerIntervalId;    // int
    var currentDigit;       // int
    var currentCaptcha;     // int[]

    var inputField = document.createElement("INPUT");
    inputField.setAttribute("type", "text");
    inputField.onkeyup = function(event){
        if(event.keyCode == 13) {
            var okay = true; // TODO

            var nd = self.getState().numDigits;
            var txt = inputField.value;
            if (txt.length != nd) {
                okay = false;
            }
            else {
                for (var i = 0; i < nd; i++) {
                    if (parseInt(txt[i]) != currentCaptcha[i]) {
                        okay = false;
                        break;
                    }
                }
            }
            if (okay){
                self.captchaOkay();
            }
            else{
                self.captchaWrong();
            }
        }
    };

    self.onStateChange = function() {
        reset();
    };

    /**
     * Sets up the view, basically a re-usable init(). Use this function when state changes, for example.
     */
    function reset(){
        currentDigit = 0;
        currentCaptcha = generateNumberCaptcha(self.getState().numDigits);
        refreshDisplay();
        window.clearTimeout(timerIntervalId); // assuming it doesn't hurt should timerInvervalId not be init'ed.
        timerIntervalId = window.setInterval(timerCB, self.getState().displayTimerMs);
    }

    function timerCB(){
        currentDigit = ((currentDigit+1) % self.getState().numDigits);
        refreshDisplay();
    }

    function refreshDisplay() {
        var displayString = self.getState().enterDigit;
        var displayPostfix = self.getState().returnKeyWhenDone;
        displayString = displayString.replace("%d", currentDigit+1); // humans count from 1, not from 0
        displayString = displayString.replace("%s", self.getState().digitNames[currentCaptcha[currentDigit]]);
        self.getElement().innerHTML = "<h1>" + displayString + "</h1>";
        self.getElement().appendChild(inputField);
        var h3 = document.createElement("h3");
        h3.textContent = displayPostfix;
        self.getElement().appendChild(h3);
        inputField.focus();
    }

    /**
     *
     * @param numDigits number of digits to be keyed in by a human
     * @returns array of int representing the digits a human must key in, of length numDigits
     */
    function generateNumberCaptcha(numDigits){
        // Returns a random integer between min (included) and max (excluded)
        // Using Math.round() will give you a non-uniform distribution!
        function getRandomInt(min, max) {
            return Math.floor(Math.random() * (max - min)) + min;
        }

        var retVal = [];
        for (var i=0; i<numDigits; i++){
            retVal.push(getRandomInt(0, 10));
        }

        return retVal;
    }
};
