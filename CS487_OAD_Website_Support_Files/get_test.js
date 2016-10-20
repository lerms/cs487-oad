// JavaScript Document
$(document).ready(function(){
	$.get("http://localhost:8090", function(data, status){
        alert("Data: " + data + "\nStatus: " + status);
    });
});