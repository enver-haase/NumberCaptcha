com_vaadin_tutorial_bulletchart_BulletChart = function() {

        var e = this.getElement();

        e.innerHTML = getState().title;

        this.onStateChange = function() {
          e.innerHTML = "state changed";
        }

/*
        nv.addGraph(function() {
          var chart = nv.models.bulletChart();

          d3.select(this.getState().domId)
              .datum(getData())
              .transition().duration(1000)
              .call(chart);

          return chart;
        });


        function getData() {
            return {
                "title": this.getState().title,
                "subtitle": this.getState().subtitle,
                "ranges": this.getState().ranges,
                "measures": this.getState().measures,
                "markers": this.getState.markers
            }
        };
*/
};