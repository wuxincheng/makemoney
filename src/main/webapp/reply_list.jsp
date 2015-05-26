<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
<style type="text/css">
.table {
  margin-bottom: 5px;
}
</style>
</head>
<body style="background-color: #F8F8F8;">
  <jsp:include page="top.jsp" />
  
  <div class="container">
    <div class="tab-content">
      <ul class="media-list">
        <li class="media">
          <a class="pull-left" href="#">
            <img class="media-object img-circle" src="<%=request.getContextPath()%>/assets/images/profit.jpeg" />
          </a>
          <div class="media-body" style="padding-top: 25px;">
            <span style="font-size: 14px; color: #222;">其收到20个回复，15个推荐产品！</span>
          </div>
         </li>
      </ul>
    </div>
  </div>
  <div class="mkm-tab-box">
    <div class="container">
      <table class="table">
        <tr>
          <td>20150505</td>
          <td>朋友</td>
          <td><span class="text-success">汇添富移动互联</span></td>
          <td><span class="text-danger">20%</span></td>
        </tr>
        <tr>
          <td>20150505</td>
          <td>同事</td>
          <td><span class="text-success">嘉实绝对收益策略定期混合</span></td>
          <td><span class="text-danger">15%</span></td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>
