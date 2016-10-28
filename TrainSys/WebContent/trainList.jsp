<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
				<table width="553" border="1" align="center" cellpadding="0"
						cellspacing="1" bordercolor="#dadada" bgcolor="#FFFFFF">
						<tr align="center">
							<td width="44" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">删除</td>
							<td width="98" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">姓名</td>
							<td width="80" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">性别</td>
							<td width="132" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">证件类型</td>
							<td width="247" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">证件号码</td>
							<td width="82" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">旅客类型</td>
						
						</tr>
						<tr align="center">
							<td height="15" colspan="7" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1"><img
								src="../img/line1.jpg" width="790" height="6"></td>
						</tr>
						<c:forEach items="${list }" var="e" varStatus="status">
							<tr align="center"
								bgcolor="${status.index%2==0?'#FFFFFF':'#cccccc' }">
								<td bordercolor="#FFFFFF" class="text_cray1"><input
									type="checkbox" name="checkbox" value="${e.train_no }"
									></td>
								<td width="98" bordercolor="#FFFFFF" class="text_cray1">${e.start_station }</td>
								<td width="80" bordercolor="#FFFFFF" class="text_cray1">${e.arrival_station }</td>
								<td width="132" bordercolor="#FFFFFF" class="text_cray1">${e.start_time }</td>
								<td width="247" bordercolor="#FFFFFF" class="text_cray1">${e.arrival_time }</td>
								<td width="82" bordercolor="#FFFFFF" class="text_cray1">${e.type }</td>
								
							</tr>
						</c:forEach>


					</table> 
</body>
</html>