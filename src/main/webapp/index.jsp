<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>赚了没？</title>
<meta property="qc:admins" content="7644371667620516455516375" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimal-ui" />
<meta name="apple-mobile-web-app-status-bar-style" content="yes" />

<link href="<%=request.getContextPath()%>/assets/img/favicon.ico" type="image/x-icon" rel="icon" />
<link href="<%=request.getContextPath()%>/assets/img/favicon.ico" type="image/x-icon" rel="shortcut icon" />
<link href="<%=request.getContextPath()%>/assets/css/mobile.css" rel="stylesheet">
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/bootstrap.css" type="text/css"></link>

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
        <a href="<%=request.getContextPath()%>/fund/ask" target="_blank">
          <button class="btn btn-mkm-answer btn-lg btn-block" style="font-size: 16px; font-weight: normal;">我也要赚</button>
        </a>
      </div>
    </div>
  </div>
  
  <div class="container">
    <div style="max-width: 300px; margin-top: 20px; margin-left: auto; margin-right: auto; border: 1px solid #EBEBEB; padding: 20px;">
      <form class="form">
        <div class="form-group">
          <input type="text" class="form-control" id="exampleInputName2" placeholder="请输入账号">
        </div>
        <div class="form-group">
          <input type="password" class="form-control" id="exampleInputEmail2" placeholder="请输入密码">
        </div>
        <button type="submit" class="btn btn-primary btn-block">登录</button>
      </form>
      <h5>你还可以使用第三方账号登录：</h5>
      <a href="/top/oauth/qq/login"><img src="${root}/assets/images/Connect_logo_4.png"></a>
    </div>
  </div>
  
  <div class="container" style="text-align: center;"><img style="width: 100%;" alt="" src="<%=request.getContextPath()%>/assets/images/aboutus2.png"></div>
  
  <hr>
  
  <div class="footer" style="text-align: center; margin-bottom: 20px;">
    <div class="container">
      <span>赚了没</span>&nbsp;&nbsp;<span class="text-danger">投资有风险，入市需谨慎！</span><br>
      <span>Copyright ©1996-2015 TRIGER Corporation, All Rights Reserved</span>
    </div>
  </div>

</body>
<script src="<%=request.getContextPath()%>/assets/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/bootstrap.js"></script>
</html>
