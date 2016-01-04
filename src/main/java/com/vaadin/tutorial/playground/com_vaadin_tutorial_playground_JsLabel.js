com_vaadin_tutorial_playground_JsLabel = function() {
  var e = this.getElement();

  this.onStateChange = function() {
    e.innerHTML = "<h1>JSLabel-"+this.getState().xhtml+"</h1>";
  }
}