<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
           function dianpuDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/dianpuDel.action?id="+id;
               }
           }
           function dianpuShenhe(id)
           {
               if(confirm('您确定审核吗？'))
               {
                   window.location.href="<%=path %>/dianpuShenhe.action?id="+id;
               }
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="14" background="<%=path %>/images/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="5%">序号</td>
					<td width="10%">账号</td>
					<td width="10%">密码</td>
					<td width="10%">餐馆名称</td>
					
					<td width="10%">联系人</td>
					<td width="10%">联系电话</td>
					<td width="10%">地址</td>
					<td width="10%">状态</td>
					
					<td width="10%">操作</td>
		        </tr>	
				<s:iterator value="#request.dianpuList" id="dianpu" status="sta">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#sta.index+1"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#dianpu.loginname"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#dianpu.loginpw"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#dianpu.mingcheng"/>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#dianpu.lianxiren"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#dianpu.dianhua"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#dianpu.dizhi"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#dianpu.zt"/>
					</td>
					
					
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="dianpuDel(<s:property value="#dianpu.id"/>)"/>
						<input type="button" value="审核" onclick="dianpuShenhe(<s:property value="#dianpu.id"/>)"/>
					</td>
				</tr>
				</s:iterator>
			</table>
	</body>
</html>
