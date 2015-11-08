com_vaadin_tutorial_bulletchart_BulletChart = function() {

    var bulletchart = document.createElement('div');
    bulletchart.setAttribute('id', 'bullet_chart');
    this.getElement().appendChild(bulletchart);

    this.onStateChange = function() {

        nv.addGraph(function() {
          var chart = nv.models.bulletChart();

          d3.select('#bullet_chart')
              .datum(getData())
              .transition().duration(1000)
              .call(chart);

          return chart;
        });
    }

    function getData() {
        return {
            "title": this.getState().title,
            "subtitle": this.getState().subtitle,
            "ranges": this.getState().ranges,
            "measures": this.getState().measures,
            "markers": this.getState.markers
        }
    };

};
