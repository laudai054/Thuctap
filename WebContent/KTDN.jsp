<%@page import="bean.khachhangbean"%>
<%@page import="bo.khachhangbo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
   khachhangbo khbo=new khachhangbo();
   String un=request.getParameter("txtun");
   String pass=request.getParameter("txtpass");
   khachhangbean kh=khbo.ktdn(un, pass);
   if(kh!=null){
	   session.setAttribute("dn", kh);
	   session.setAttribute("kt", (long)1);
	   response.sendRedirect("menu.jsp?kt=0&un="+kh.getHoten());
   }else{
	   response.sendRedirect("menu.jsp?kt=1");
   		session.setAttribute("kt", (long)0);
   }
%>

<%
   //String un=request.getParameter("txtun");
   //String pass=request.getParameter("txtpass");
   //if(un.equals("haha")&&pass.equals("123")){
	  // response.sendRedirect("DangNhap.jsp?kt=0");
   //}else
	  // response.sendRedirect("DangNhap.jsp?kt=1");
%>
</body>
</html>