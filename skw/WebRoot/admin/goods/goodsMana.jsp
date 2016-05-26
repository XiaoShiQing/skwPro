<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/include.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <title>管理员菜品展示</title>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#win").hide();
				$("#gid").hide();
			});
		</script>
		<script type="text/javascript">
			function xiugai(){
				$.post(
					"<%=path %>/modify.action",
					{
						"goodsId":$("#gid").text(),
						"fujian":$("#goodsimg").val(),
						"goodsName":$("#goodsname").val(),
						"goodsShichangjia":$("#goodsprice").val(),
						"goodsMiaoshu":$("#goodsremark").val(),
					},
					function(msg){
						$("#win").window('close');
						$.messager.show({
							title:'提示',
							msg:msg
						});
					}
				);
			};
			
			/*返回操作*/
			function back(){
				$("#win").window('close');
			}
			
		</script>
        <script language="javascript">
           function goodsDetailHou(goodsId)
           {
                 var url="<%=path %>/goodsDetailHou.action?goodsId="+goodsId;
                 var n="";
                 var w="480px";
                 var h="500px";
                 var s="resizable:no;help:no;status:no;scroll:yes";
				 openWin(url,n,w,h,s);
           }
           
           function goodsDel(goodsId)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/goodsDel.action?goodsId="+goodsId;
               }
           }

           function goodsModify(goodsId){
           		// alert("修改商品");
           		$("#gid").text(goodsId);
           		$.post("<%=path %>/toModify.action?",{"goodsId":goodsId},
           				function(msg){
           					//  alert(msg.tomodifyGood);
           					var json = JSON.parse(msg);
           					// alert(json.tomodifyGood.goodsShichangjia);
           					var g = json.tomodifyGood;
           					$("#goodsname").val(g.goodsName);
           					$("#goodsremark").val(g.goodsMiaoshu);
           					$("#goodsimg").val(g.fujian);
           					$("#goodsprice").val(g.goodsShichangjia);
           				}
           			);
           		$('#win').window({    
           			title:'修改商品(gid: '+goodsId+')',
				    width:600,    
				    height:400,    
				    modal:true   
				}); 
           }
           
           function over(picPath)
	       {
			  if (picPath=="")picPath="/images/default.jpg";
			  x = event.clientX;
			  y = event.clientY;      
			  document.all.tip.style.display = "block";
			  document.all.tip.style.top = y;
			  document.all.tip.style.left = x+10;
			  document.all.photo.src = ".."+picPath; 
		   }
		   function out()
	       {
			  document.all.tip.style.display = "none";
		   }		
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="9" background="<%=path %>/images/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
				    <td>序号</td>
				    <td>餐馆</td>
					<td>名称</td>
					<td>介绍</td>
					<td>价格</td>
					<td>操作</td>
		        </tr>	
				<s:iterator value="#request.goodsList" id="goods" status="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#ss.index+1"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#goods.dianpu.mingcheng"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#goods.goodsName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <a href="#" onclick="goodsDetailHou(<s:property value="#goods.goodsId"/>)" class="pn-loperator">介绍</a>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
					     <s:property value="#goods.goodsShichangjia"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="goodsDel(<s:property value="#goods.goodsId"/>)"/>
						<input type="button" value="修改" onclick="goodsModify(<s:property value="#goods.goodsId"/>)"/>
					</td>
				</tr>
				</s:iterator>
			</table>
			<div id="win">
			<span id="gid"></span>
				<table>
					<tr>
						<td>商品名:</td>
						<td><input id="goodsname"></td>
					</tr>
					<tr>
						<td>介绍:</td>
						<td><input id="goodsremark"></td>
					</tr>
					<tr>
						<td>图片:</td>
						<td><input id="goodsimg"></td>
					</tr>
					<tr>
						<td>价格:</td>
						<td><input id="goodsprice"></td>
					</tr>
				</table>
				<br />
				<a id="btn_xiugai" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onClick="xiugai();">修改</a>  &nbsp
				<a id="btn_xiugai" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onClick="back();">返回</a>
			</div>
		    <div id="tip" style="position:absolute;display:none;border:0px;width:80px; height:80px;">
			<TABLE id="tipTable" border="0" bgcolor="#ffffee">
				<TR align="center">
					<TD><img id="photo" src="" height="80" width="80"></TD>
				</TR>
			</TABLE>
		</div>
	</body>
</html>
