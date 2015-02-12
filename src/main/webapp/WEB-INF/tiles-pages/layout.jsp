<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=utf-8" language="java" %>

<!DOCTYPE html "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ua">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title><tiles:insertAttribute name="title" ignore="true" /></title>
  <%--<link rel="icon" type="image/ico" href="favicon.ico">--%>

  <link href="<s:url value="/public/css/" />bootstrap.min.css" rel="stylesheet"type="text/css" />
  <link href="<s:url value="/public/css/" />main.css" rel="stylesheet"type="text/css" />
  
  <!--[if lt IE 9]>
  <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>
<body>
  <div id="wrap">
    <header class="masthead">
      <div id="nav" class="navbar navbar-custom navbar-inverse navbar-static-top" >
        <div class="container">
          <div class="navbar-header">
            <%--<a class="navbar-brand" id="brand" href="/" title=""><img src="/public/img/logo.png" alt="logo" class="logoIc"/></a>--%>
          </div><!--/.nav-collapse -->
          <tiles:insertAttribute name="header" />
        </div><!--/.container -->
      </div><!--/.navbar -->
    </header>
    <div class="bg-5">
      <div class="container">
        <tiles:insertAttribute name="body" />
      </div><!--/container-->
    </div><!--/row-->
  </div>
  <div id="footer">
    <tiles:insertAttribute name="footer" />
  </div>
  <ul class="nav pull-right scroll-top">
    <li><a href="#" title="Scroll to top"><i class="glyphicon glyphicon-chevron-up"></i></a></li>
  </ul>
  <div id="mask"></div>

  <script src="<s:url value="/public/js/" />jquery.min.js"></script>
  <script src="<s:url value="/public/js/" />jquery.form.min.js"></script>
  <script src="<s:url value="/public/js/" />bootstrap.min.js"></script>
  <script src="<s:url value="/public/js/" />functions.js"></script>
  <script src="<s:url value="/public/js/" />app.js"></script>
</body>
</html>
