<%@page import="bo.GioHangbo"%>
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
String so=request.getParameter("slmua");
String masach=(String)request.getParameter("MaSach");
String CapNhat=request.getParameter("sub0");
String Xoa=request.getParameter("sub1");
GioHangbo gh1 = new GioHangbo();
gh1=(GioHangbo)session.getAttribute("gh");                      //Lấy arraylist gh
 
                                                                                                        //Cập nhật sách
if(CapNhat!=null){
        long so2=Long.parseLong(so);   
        gh1.SetSL(masach,so2);
        session.setAttribute("gh", gh1);
        response.sendRedirect("htgio.jsp");    
}else{                                                                                          //Xóa sách
        gh1.xoa(masach);
        session.setAttribute("gh", gh1);
        response.sendRedirect("htgio.jsp");            
}
%>
</body>
</html>