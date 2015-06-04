<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
<style type="text/css">
td{
  height: 50px;
}
</style>
</head>
<body style="background-color: #F8F8F8;">
  <jsp:include page="top.jsp" />
  
  <div class="container">
    <!-- Comment start -->
    <form>
    <div class="tab-content">
      <ul class="media-list">
        <li class="media">
          <a class="pull-left" href="#">
            <img class="media-object img-circle" src="<%=request.getContextPath()%>/assets/images/profit.jpeg" />
          </a>
          <div class="media-body">
            <textarea class="form-control" rows="5" placeholder="行情这么好，赚了不少吧，给推荐个好产品呗！"></textarea>
          </div>
         </li>
      </ul>
    </div>
    <!-- Comment end -->
    <p>&nbsp;</p>
    <table style="width: 100%;">
      <tr>
        <td style="width: 35%;"><div class="input-tip">基金名称：</div></td>
        <td style="width: 65%;"><input type="text" class="form-control" style="border-left: 0px solid #e7e7e7; border-radius: 0px;" id="inputEmail3" placeholder="基金名称" value="嘉实海外（070012）" /></td>
      </tr>
      <tr>
        <td style="width: 35%;"><div class="input-tip">近期收益：</div></td>
        <td style="width: 65%;"><input type="text" class="form-control" style="border-left: 0px solid #e7e7e7; border-radius: 0px;" id="inputEmail3" placeholder="近期收益" value="10%" /></td>
      </tr>
      <tr>
        <td style="width: 35%;"><div class="input-tip">留&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;言：</div></td>
        <td style="width: 65%;"><input type="text" class="form-control" style="border-left: 0px solid #e7e7e7; border-radius: 0px;" id="inputEmail3" placeholder="这个嘛" /></td>
      </tr>
      <tr>
        <td colspan="2"><input type="button" class="btn btn-mkm-answer btn-block" value="匿名回复" /></td>
      </tr>
      <tr>
        <td colspan="2"><input type="button" class="btn btn-mkm-answer btn-block" value="转问好友" /></td>
      </tr>
    </table>
    </form>
  </div>
</body>
</html>
