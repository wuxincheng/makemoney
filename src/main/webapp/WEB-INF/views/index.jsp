<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>赚了没？</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport"
  content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimal-ui" />
<meta name="apple-mobile-web-app-status-bar-style" content="yes" />

<link href="<%=request.getContextPath()%>/assets/img/favicon.ico"
  type="image/x-icon" rel="icon" />
<link href="<%=request.getContextPath()%>/assets/img/favicon.ico"
  type="image/x-icon" rel="shortcut icon" />
<link href="<%=request.getContextPath()%>/assets/css/mobile.css"
  rel="stylesheet">

<link rel="stylesheet"
  href="<%=request.getContextPath()%>/assets/css/bootstrap.css"
  type="text/css"></link>

</head>

<body>
  <jsp:include page="top.jsp" />
  
  <div style="background-color: #CA4E4E; margin-top: 0px;">
    <div class="container">
      <div style="color: #FFFFFF; font-size: 28px; padding: 30px;">
        <span>我2014年入的市，3W本金的小小散，现在小赚7000元。算赚的很少的了！！ 再说说一个朋友，本金8W，才三个月时间竟然赚了7W了。</span>
      </div>
    </div>
  </div>
  
  <div style="background-color: #CA4E4E; margin-top: 0px; color: #FFFFFF;">  
    <div class="container" style="width: 100%; text-align: center; padding: 20px;">
      <div style="background-color: #FFFFFF; border-radius: 6px; border: 2px solid #FFFFFF; margin: 0 auto; width: 100px;">
        <button type="submit" class="btn btn-mkm-answer btn-lg btn-block">我也要赚</button>
      </div>
    </div>
  </div>
  
  <div class="container" style="text-align: center;"><img style="width: 100%;" alt="" src="<%=request.getContextPath()%>/assets/images/aboutus2.png"></div>
  
  <hr>
  
  <div class="footer" style="text-align: center;">
    <div class="container">
      <span>赚了没</span>&nbsp;&nbsp;<span class="text-danger">投资有风险，入市需谨慎！</span><br>
      <span>Copyright ©1996-2015 TRIGER Corporation, All Rights Reserved</span>
    </div>
  </div>

</body>
<script src="<%=request.getContextPath()%>/assets/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/bootstrap.js"></script>
</html>
