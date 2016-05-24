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
    
    <script language="javascript">
        function pingjiaAll(goodsId)
        {
            var strUrl = "<%=path %>/pingjiaAll.action?goodsId="+goodsId;
            var ret = window.showModalDialog(strUrl,"","dialogWidth:800px; dialogHeight:300px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
        
            
        }
        
        
        function pingjiaAdd(goodsId)
        {
            <s:if test="#session.user==null">
                alert("请先登录");
                return false;
            </s:if>
            
            <s:if test="#session.user !=null && #session.user.userType=='普通会员'">
                alert("你是普通会员，不能评论");
                return false;
            </s:if>
            
            <s:if test="#session.user !=null && #session.user.userType=='vip会员'">
                var strUrl = "<%=path %>/qiantai/pingjia/pingjiaAdd.jsp?goodsId="+goodsId;
                var ret = window.showModalDialog(strUrl,"","dialogWidth:800px; dialogHeight:300px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
            </s:if>
        }
    </script>
    
  </head>
  
  <body>
	<jsp:include flush="true" page="/qiantai/inc/top.jsp"></jsp:include>
	
	<div id="page">
		<div id="page-bgtop">
			<div id="page-bgbtm">
				<div id="content">
				
					<div class="post">
						<!-- <h2 class="title"><a href="#">菜品详细信息</a></h2> -->
						<div class="entry">
						    <form action="<%=path %>/addToCart.action" method="post" name="buy">
								<table width="100%" border="0">
								    <tr>
								       <td align="center"><img style="border:1px solid #ccc; padding:3px;" src="<%=path %>/<s:property value="#request.goods.fujian"/>" width="280" height="230"/><hr/></td>
								    </tr>
								    <tr>
								       <td align="center">菜品名称：<s:property value="#request.goods.goodsName"/><hr/></td>
								    </tr>
								    <tr>
								       <td align="center">菜品介绍:<s:property value="#request.goods.goodsMiaoshu" escape="false"/><hr/></td>
								    </tr>
								    <tr>
								       <td align="center">单价:<s:property value="#request.goods.goodsTejia"/><hr/></td>
								    </tr>
								    <tr>
								       <td align="center">餐馆：<s:property value="#request.goods.dianpu.mingcheng"/><hr/></td>
								    </tr>
								    <tr>
								       <td align="center">
								          <input type="hidden" name="goodsId" value="<s:property value="#request.goods.goodsId"/>"/>
								          <input type="button" value="查看评价" style="width: 100px;" 
								              onclick="pingjiaAll(<s:property value="#request.goods.goodsId"/>)"/>
								          <input type="button" value="添加评价" style="width: 100px;" 
								              onclick="pingjiaAdd(<s:property value="#request.goods.goodsId"/>)"/>
								       </td>
								    </tr>
								</table>
						    </form>
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
