<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<STYLE type=text/css> 
		{
			FONT-SIZE: 12px
		}
		#menuTree A {
			COLOR: #566984; TEXT-DECORATION: none
		}
		</STYLE>

		<SCRIPT src="<%=path%>/js/TreeNode.js" type=text/javascript></SCRIPT>
		<SCRIPT src="<%=path%>/js/Tree.js" type=text/javascript></SCRIPT>
	</head>

	<BODY topmargin="7" rightmargin="0" leftmargin="0">
		<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%">
				<TR>
					<TD width=10 height=29>
						<IMG src="<%=path %>/img/bg_left_tl.gif">
					</TD>
					<TD
						style="FONT-SIZE: 18px; BACKGROUND-IMAGE: url(<%=path %>/img/bg_left_tc.gif); COLOR: white; FONT-FAMILY: system">
						Main Menu
					</TD>
					<TD width=10>
						<IMG src="<%=path %>/img/bg_left_tr.gif">
					</TD>
				</TR>
				<TR>
					<TD style="BACKGROUND-IMAGE: url(<%=path %>/img/bg_left_ls.gif)"></TD>
					<TD id=menuTree style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; PADDING-TOP: 10px; HEIGHT: 100%; BACKGROUND-COLOR: white" vAlign=top></TD>
					<TD style="BACKGROUND-IMAGE: url(<%=path %>/img/bg_left_rs.gif)"></TD>
				</TR>
		</TABLE>
		<SCRIPT type=text/javascript>
                var tree = null;
	            var root = new TreeNode('系统菜单');
	           
	            
	            <c:if test="${sessionScope.userType==0}"> 
	            var fun2 = new TreeNode('修改登陆密码');
	            var fun21 = new TreeNode('修改登陆密码', '<%=path %>/admin/userinfo/userPw.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
	            fun2.add(fun21);
	            root.add(fun2);
	            
	            
	            
	            
	            var fun2 = new TreeNode('餐馆信息管理');
	            var fun21 = new TreeNode('餐馆信息管理', '<%=path %>/dianpuMana.action', 'tree_node.gif', null, 'tree_node.gif', null);
	            fun2.add(fun21);
	            root.add(fun2);
	            
	            
	            var fun2 = new TreeNode('用户信息管理');
	            var fun21 = new TreeNode('用户信息管理', '<%=path %>/userMana.action', 'tree_node.gif', null, 'tree_node.gif', null);
	            fun2.add(fun21);
	            root.add(fun2);
	           
	            
	            
	            var fun2 = new TreeNode('菜品展示管理');
	            var fun21 = new TreeNode('菜品展示管理', '<%=path %>/goodsMana.action', 'tree_node.gif', null, 'tree_node.gif', null);
	            fun2.add(fun21);
	            root.add(fun2);
	            
	            
	            </c:if>
	            
	            
	            
	            
	            
	            <c:if test="${sessionScope.userType==1}"> 
	            
	            var fun2 = new TreeNode('我的菜品管理');
	            var fun21 = new TreeNode('发布新的菜品', '<%=path %>/admin/goods/goodsAdd.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
	            var fun22 = new TreeNode('我的菜品展示', '<%=path %>/goodsMine.action', 'tree_node.gif', null, 'tree_node.gif', null);
	            fun2.add(fun21);
	            fun2.add(fun22);
	            root.add(fun2);
	            
	            
	            
	            var fun2 = new TreeNode('预约信息管理');
	            var fun21 = new TreeNode('预约信息管理', '<%=path %>/yudingMana.action', 'tree_node.gif', null, 'tree_node.gif', null);
	            fun2.add(fun21);
	            root.add(fun2);
	            
	            
	            
	            
	            </c:if>
	            tree = new Tree(root);
	            tree.show('menuTree')
        </SCRIPT>
	</BODY>
</html>
