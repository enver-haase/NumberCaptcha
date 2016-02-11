com_infraleap_NumberCaptcha = function() {
    var e = this.getElement(); // "our" div element

    var b = this.blubb;

    this.onStateChange = function() {
        // For "this" see:
        // https://vaadin.com/api/com/vaadin/ui/AbstractJavaScriptComponent.html
        e.innerHTML = "<h1>NumberCaptcha</h1>";

    };

    e.onclick = function() {
        alert("Dei Muddi war hier");
        b();
    };
};
