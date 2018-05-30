<%@page import="Mindeft.CFMS.bean.police_station_map"%>
<%@page import="Mindeft.CFMS.bean.police_station_Bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <style>
       #map {
        height: 800px;
        width: 100%;
       }
    </style>
  </head>
  <body>
<%
police_station_map police_station_BeanObj=(police_station_map)request.getAttribute("police_station_mapObj");


%>

    <div id="map"></div>
    <script>
      function initMap() {
        var uluru = {lat: <%= police_station_BeanObj.getLatitude() %>, lng: <%= police_station_BeanObj.getLongitude() %>};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 4,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
        });
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDn9KmNR0pYGY3beftht5naUV5M7XiYcQ0&callback=initMap">
    </script>
  </body>
</html>