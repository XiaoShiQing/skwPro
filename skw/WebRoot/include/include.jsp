<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- easyui -->
<link rel="stylesheet" type="text/css" href="<%=path%>/plugins/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/plugins/easyui/themes/icon.css">
<script type="text/javascript" src="<%=path%>/plugins/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/plugins/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/plugins/easyui/locale/easyui-lang-zh_CN.js"></script>
<!-- echarts -->
<script type="text/javascript" src="<%=path%>/plugins/echarts/echarts.min.js"></script>