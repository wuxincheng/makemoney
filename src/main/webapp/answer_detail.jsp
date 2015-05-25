<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>赚了没 - V1.0</title>
<link href="<%=request.getContextPath()%>/assets/images/logo.png" type="image/x-icon" rel="shortcut icon" />
<link href="<%=request.getContextPath()%>/assets/images/logo.png" type="image/x-icon" rel="icon" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/bootstrap.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/makemoney.css" type="text/css"></link>

</head>
<body style="background-color: #F8F8F8;">
  <div class="mkm-answer-top-box">
  </div>
  
  <div class="container">
    <!-- Comment start -->
    <div class="tab-content">
      <ul class="media-list">
        <li class="media">
          <a class="pull-left" href="#">
            <img class="media-object img-circle" src="<%=request.getContextPath()%>/assets/images/profit.jpeg" />
          </a>
          <div class="media-body">
            <textarea class="form-control" rows="5"></textarea>
          </div>
         </li>
      </ul>
    </div>
    <!-- Comment end -->
    <p>&nbsp;</p>
    
    <div class="form-group">
      <input type="text" class="form-control input-lg" id="inputEmail3" placeholder="基金名称" />
    </div>
    
    <div class="form-group">
      <input type="text" class="form-control input-lg" id="inputEmail3" placeholder="近期收益" />
    </div>
    
    <div class="form-group">
      <input type="text" class="form-control input-lg" id="inputEmail3" placeholder="留言" />
    </div>
    
    <div class="form-group">
      <input type="button" class="btn btn-mkm-answer btn-lg btn-block" value="向好友提问" />
    </div>
  </div>
</body>
</html>
