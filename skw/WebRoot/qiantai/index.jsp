<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
	
    <link href="<%=path %>/css/qiantai.css" rel="stylesheet" type="text/css" media="screen" />
    
  </head>
  
  <body>
	<jsp:include flush="true" page="/qiantai/inc/top.jsp"></jsp:include>
	
	<div id="page">
		<div id="page-bgtop">
			<div id="page-bgbtm">
				<div id="content">
					<!-- <div class="post">
						<h2 class="title"><a href="#">企业介绍</a></h2>
						<p class="meta">我们企业在青岛市</p>
						<div class="entry">
							<p>订单嘎嘎嘎嘎嘎嘎嘎嘎嘎个te designed by FreeCssTemplree template is rse, so you’re prd you keep the links in the footer intact. Aside from that, have fun wi</p>
							<p>Sibus semper urna. Pellentesque ornare, orci in felis. Donec ut ante. In id eros. Suspendisse lacus turpis, cursus egestas at sem.</p>
						</div>
					</div> -->
					<div class="post">
						<!-- <h2 class="title"><a href="#">菜品展示</a></h2> -->
						<div class="entry">
						    <table cellspacing="3" cellpadding="3" align="left">
						          <tr>
						               <c:forEach items="${requestScope.goodsNoTejiaList}" var="goods" varStatus="sta">
						                  <c:if test="${sta.index%4==0}">
						                     </tr><tr>
						                  </c:if>
						                  <td align="center">
											   <a href="<%=path %>/goodsDetailQian.action?goodsId=${goods.goodsId }">  
											      <img width="135" height="130" src="<%=path %>/${goods.fujian }" style="border:1px solid #ccc; padding:3px;"/>
											   </a>
											   <br/>
						                       ${goods.goodsName }
						                  </td>
						               </c:forEach>
						          </tr>
							</table>
						</div>
					</div>
				    <div style="clear: both;">&nbsp;</div>
		        </div>
				<jsp:include flush="true" page="/qiantai/inc/right.jsp"></jsp:include>
				<div style="clear: both;">&nbsp;</div>	
		    </div>
		</div>
	</div>
	
	
	
	<div id="footer-wrapper">
		<div id="footer">
			<p>Copyright (c) 2008 Sitename.com. All rights reserved. Design by <a href="<%=path %>/login.jsp">系统后台登陆</a>.</p>
		</div>
	</div>
  </body>
</html>