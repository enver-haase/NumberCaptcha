com_vaadin_tutorial_playground_JsLabel = function() {
  var e = this.getElement();

  this.onStateChange = function() {
    e.innerHTML = this.getState().xhtml;
  }
}