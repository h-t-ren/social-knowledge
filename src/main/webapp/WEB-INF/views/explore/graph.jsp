
   <canvas id='neoviz'></canvas>
    <header>
      <section id='title'>
      </section>
      <br style='clear: both;'>
    </header>
    <section id='content'>
      <script>
        //<![CDATA[
          var canvas = document.getElementById("neoviz");
          
          var myGraph; // a reference to the graph to make it available to the outside world
          
          var p = Processing(canvas); 
          
          function loadvisualization() {
            var vizid = document.getElementById("vizid").value 
            if ( vizid != "") {
              p.resourceId = vizid; 
            } else {
              p.resourceId = window.location.search.substring(1).split("=")[1];
            }
            p.resourceId = vizid;
            p.setup();
          
            $("#path li").remove();
          
          };
          
          $(function() {
            function canvasSupported() {
              var canvas_compatible = false;
              try {
               canvas_compatible = !!(document.createElement('canvas').getContext('2d')); // S60
              } catch(e) {
               canvas_compatible = !!(document.createElement('canvas').getContext); // IE
              }
              return canvas_compatible;
            }
          
            if (canvasSupported()) {
          
              var initialized = false;
                
              // init
              var vizid =  window.location.search.substring(1).split("=")[1];
              if (vizid) {
                p.resourceId = vizid;
              } else {
                p.resourceId = "0";
              }
          
              p.init(p.ajax("resources/neo/js/pjs/physics.pjs")+p.ajax("resources/neo/js/pjs/value.pjs")+p.ajax("resources/neo/js/pjs/donut.pjs")+p.ajax("resources/neo/js/pjs/resource.pjs")+p.ajax("resources/neo/js/pjs/node.pjs")+p.ajax("resources/neo/js/pjs/edge.pjs")+p.ajax("resources/neo/js/pjs/graph.pjs")+p.ajax("resources/neo/js/pjs/network.pjs"));
              initialized = true;
              
              $(window).resize(function(){
                p.resize();
                Attributes.adjustHeight();
              });
            } else {
              $('#browser_not_supported').show();
              $('#explanation').hide();
            }
          });
        //]]>
      </script>
    </section>
    <aside>
      <div id="browser_not_supported">
      Your Browser is currently not supported.<br/><br/>Try one of these:<br/>
      <a href="http://www.mozilla.com/en-US/firefox/firefox.html">Firefox 3.6</a><br/>
      <a href="http://www.apple.com/safari/">Safari 4.0</a><br/>
      <a href="http://www.google.com/chrome/">Chrome</a><br/>
      </div>
    </aside>
      
      
      
      
      
      
      
      
      
      
      
   