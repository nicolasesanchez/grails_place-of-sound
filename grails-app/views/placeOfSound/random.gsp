<%--
  Created by IntelliJ IDEA.
  User: nicsanchez
  Date: 03/11/2019
  Time: 19:38
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<h3>This is a homeish</h3>

<img src="${createLink(controller: "PlaceOfSound", action: "getInstrumentPicture", id: 11)}" />

</body>
</html>