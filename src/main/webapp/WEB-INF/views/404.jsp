<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>页面不存在哦 - 赚了没</title>
<meta charset="utf-8">
<!-- 
<link href="<%=request.getContextPath()%>/assets/images/favicon.png" type="image/x-icon" rel="shortcut icon"/>
<link href="<%=request.getContextPath()%>/assets/images/favicon.png" type="image/x-icon" rel="icon"/>
 -->
<link href="<%=request.getContextPath()%>/assets/css/bootstrap.css" rel="stylesheet">
</head>
<style type="text/css">
		.container {
			margin: 150px auto auto auto;
		}
		.panel-body {
			padding: 20px;
		}
		.container {
			max-width: 300px;
		}
		.panel-body .btn:not(.btn-block) { width:120px;margin-bottom:10px; }
	</style>
<body>
	<div class="container">
	    <div class="row">
	        <div>
	            <div class="panel panel-danger">
	                <div class="panel-heading">
	                    <h3 class="panel-title">404错误提示：</h3>
	                </div>
	                <div class="panel-body">
                      	<h4 class="text-danger">您访问的页面不存在哦！</h4>
                      	<h5 class="text-info">TIP：请您不要进行非正常操作呦！</h5>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
</body>
</html>
