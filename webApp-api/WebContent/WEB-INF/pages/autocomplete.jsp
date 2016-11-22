<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="eng">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>ElasticSearch Autocomplete</title>
</head>
<body>
	<div class="jumbotron">
		<img src="http://www.techstricks.com/wp-content/uploads/2016/05/elasticsearch.jpg" width="230" height="120" style="position:absolute;left:320px;top:50px;">
		<h1 align="center">AutoComplete</h1><br><br>
		<p align="center"> Search-as-you-type using <b><em>ELASTICSEARCH</em></b> and <b><em> JAVA SPRING</em><b> </p>
	</div>
	

	<div class="col-xs-4" style="float:none;margin:0 auto">
		<span class="label label-danger" style="display:none">Found 0 suggestions</span>
	  <span class="label label-success" style="display:none">Found x suggestions</span>
	  <span class="label label-info" >Type something in the box!</span>
	  <br>
	  <input type="text" class="form-control input-lg" id="keyword" onkeyup="showSearchResults(this.value)">
	  <div class="suggestions well" ></div>
	  <br>
	</div>

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>

function showSearchResults(keyword){
	
	//Load results from Elasticsearch via Ajax call
	
	if(keyword.length==0)
		{
			document.getElementsByClassName("suggestions")[0].innerHTML="";
		    document.getElementsByClassName("label-info")[0].style.display="initial";
		    document.getElementsByClassName("label-success")[0].style.display="none";
			document.getElementsByClassName("label-danger")[0].style.display="none";
		    return;
		}
	var url = "http://localhost:8080/webapp-api/getSuggestions?keyword="+keyword;
	
	$.ajax({
		type : "GET",
		url : url,
		success : function(data) {
			
			document.getElementsByClassName("suggestions")[0].innerHTML=data;
			if(data.length){
			document.getElementsByClassName("label-success")[0].innerHTML="Found 9 suggestions";
			document.getElementsByClassName("label-success")[0].style.display="initial";
			document.getElementsByClassName("label-danger")[0].style.display="none";
			document.getElementsByClassName("label-info")[0].style.display="none";
			}
			
			else{
				document.getElementsByClassName("label-success")[0].style.display="none";
				document.getElementsByClassName("label-danger")[0].style.display="initial";
				document.getElementsByClassName("label-info")[0].style.display="none";
			}
				
		  //  document.getElementsByClassName("suggestions")[0].style.border="1px solid #A5ACB2";
		},
		error : function(e) {
			console.log("ERROR: ", e);
			display(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
	
}


</script>
	
</body>
</html>