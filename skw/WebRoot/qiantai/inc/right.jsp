<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 

<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
  </head>
  
  <body>
	  <div id="sidebar">
			<ul>
				<li>
					<h2>餐馆列表</h2>
					<ul>
					    <c:forEach items="${sessionScope.dianpuList}" var="dianpu" varStatus="s">
						<li><a href="<%=path %>/dianpuDetailQian.action?id=${dianpu.id }">${dianpu.mingcheng }</a></li>
						</c:forEach>
					</ul>
				</li>
				<li>
					<h2>系统公告</h2>
					<p>
					   <MARQUEE onmouseover=this.stop() onmouseout=this.start() direction=up height=90 width=160 scrollAmount=3 scrollDelay=166 border="0">本站于2014年06月28日正式开通,欢迎大家访问本网站,餐馆的菜无公害，新鲜的哦。</MARQUEE>
					</p>
				</li>
				<li>
					<h2>联系我们</h2>
					<ul>
						<li><a href="#">电话：010-78956524</a></li>
						<li><a href="#">地主：北京东环大厦305</a></li>
					</ul>
				</li>
			</ul>
	  </div>
  </body>
</html>
