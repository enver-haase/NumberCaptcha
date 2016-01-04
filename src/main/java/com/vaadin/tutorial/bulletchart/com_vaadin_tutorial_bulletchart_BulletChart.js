com_vaadin_tutorial_bulletchart_BulletChart = function() {
	var bulletchart = document.createElement('div');
    bulletchart.setAttribute('id', 'bullet_chart');
    bulletchart.style.width = "100%"
    bulletchart.style.height = "100%"
    this.getElement().appendChild(bulletchart);
    var svg = d3.select("#bullet_chart").append("svg")
    	.attr("width", '100%')
    	.attr("height", '100%')

    this.onStateChange = function() {
    	var that = this;
        nv.addGraph(function() {
          var chart = nv.models.bulletChart();
          
          d3.select('#bullet_chart svg')
              .datum(stateData(that))
              .transition().duration(1000)
              .call(chart);
          
          return chart;
        });
    }

	function stateData(that) {
		return {
			"title":that.getState().title,
			"subtitle":that.getState().subtitle,
			"ranges":that.getState().ranges,
			"measures":that.getState().measures,
			"markers":that.getState().markers
		}; 	
	}
	
	
}