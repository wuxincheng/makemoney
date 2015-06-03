<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
<!-- 引入微信JS-SDK -->
<script src="<%=request.getContextPath()%>/assets/js/jweixin-1.0.0.js"></script>
<script type="text/javascript">
wx.config({
    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
    appId: '', // 必填，公众号的唯一标识
    timestamp: '', // 必填，生成签名的时间戳
    nonceStr: '', // 必填，生成签名的随机串
    signature: '',// 必填，签名，见附录1
    jsApiList: [] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
});
</script>
</head>
<body style="background-color: #F8F8F8;">
  <jsp:include page="top.jsp" />
  
  <div class="container">
    <!-- Comment start -->
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
  </div>
  
  <div class="container">
    <input type="button" class="btn btn-mkm-answer btn-block" value="向好友提问" />
  </div>
</body>
</html>
