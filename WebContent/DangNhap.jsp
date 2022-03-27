<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Form</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">  
   	<ul class="nav navbar-nav">
     	<li class="active"><a href="tc.jsp">Trang chủ</a></li>
      	<li><a href="giohang.jsp">Giỏ hàng</a></li>
      	<li><a href="tt.jsp">Thanh toán</a></li>
      	<li><a href="lichsu.jsp">Lịch sử mua hàng</a></li>
   	</ul>
	<ul class="nav navbar-nav navbar-right">
   	<li><a href="#"><span class="glyphicon glyphicon-user"></span> Đăng ký</a></li>
		
		<%String kq=request.getParameter("kt"); 
			if(kq!=null&& kq.equals("0")){%>
		<li><a href="#">Xin chao: <%=request.getParameter("un") %> </a></li>
			<%}else{ %>
		<li><a href="#" data-toggle="modal" data-target="#myModal">
			<span class="glyphicon glyphicon-log-in"></span> Đăng nhập</a></li>
			<%} %>
			<%if(kq!=null&&kq.equals("1")){%>
				<script>alert('Dang nhap sai');</script>
			<%}%>      
    </ul>
</div>
</nav>
  
 <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
		 <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Đăng nhập hệ thống</h4>
        </div>
        <div class="modal-body">
          <form method="post" action="KTDN.jsp">
             <label> Tên đăng nhập: </label>
 			 <input name="txtun" type="text" class="form-control">
             <label> Mật khẩu: </label>
             <input name="txtpass" type="password" class="form-control">
             <input name="but1" type="submit" value="Đăng nhập" class="btn-primary">
         </form>
        </div>     
      </div>
    </div>
  </div>
</body>
</html>