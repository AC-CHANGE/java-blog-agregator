<%--
  Created by IntelliJ IDEA.
  User: Andrew
  Date: 22.03.2016
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html; charset=UTF-8">
    <title><tiles:getAsString name="title"/></title>
</head>
<body>

    <tiles:insertAttribute name="body"/>

    <br>
    <br>
    <center>
        <tiles:insertAttribute name="footer"/>
    </center>

</body>
</html>
