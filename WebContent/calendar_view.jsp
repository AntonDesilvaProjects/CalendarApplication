<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="/WebContent/stylesheets/calendar_style.css">
	<title>{},{}</title>
</head>
<body>
<style>
table {
  table-layout: fixed;
  width: 1250px;
  height: 800px;
}

table td {
  height: 125px;
  position: relative;
}

table td:before {
  content: attr(data-day);
  display: block;
  position: absolute;
  top: 0;
  left: 0;
  background: yellow;
}

</style>

${html}

</body>
</html>