<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="bean.khachhangbean"%>
<%@page import="bo.khachhangbo"%>
<%@page import="bean.Loaibean"%>
<%@page import="bean.Giaybean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.Giaybo"%>
<%@page import="bo.Loaibo"%>
<%@page import="java.util.Calendar"%>
<%@page import="bean.GioHangbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.GioHangbo"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Quản lý giày</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand">NikeShop</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">

				<ul class="nav navbar-nav">
					<li class="active"><a href="AdminQLGiay">Quản lý giày</a></li>
					<li><a href="AdminQLDonHang">Quản lý đơn hàng</a></li>
					<li><a href="AdminQLNguoiDung">Quản lý người dùng</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
							Đăng xuất</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<p>
					<a class="btn btn-primary" style="width: 200px" href="AdminQLGiay">Quản lý giày</a>
				</p>
				<p>
					<a class="btn btn-primary" style="width: 200px" href="AdminQLLoaiGiay">Quản lý loại
						giày</a>
				</p>
				<a href="#" data-toggle="modal" data-target="#ThemSach"
					class="btn btn-success"> <span class="glyphicon glyphicon-plus"></span>
					Thêm giày
				</a>
			</div>
			<!-- -------body------- -->
			<div class="col-sm-10 text-left">

				<table class="table table-bordered">
					<colgroup>
						<col width="80" span="2">
					</colgroup>
					<thead valign="top">
						<tr class="info" align="center">
							<th width="70px">Mã giày</th>
							<th width="100px">Tên giày</th>
							<th width="100px">Chi tiết</th>
							<th width="50px">Giá</th>
							<th width="250px">Ảnh</th>
							<th width="50px">Mã loại</th>
							<th width="50px">Chỉnh sửa</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${dssachad}" var="s">
							<tr>
								<th>${s.getMasach()}</th>
								<th>${s.getTensach()}</th>
								<th>${s.getTacgia()}</th>
								<th>${s.getGia()}</th>
								<th><img width="250px" height="300px" src="${s.getAnh()}"></th>
								<th>${s.getMaloai()}</th>
								<th><a class="btn btn-warning"
									href="AdminXoaGiay?ms=${s.getMasach()}" style="width: 50px">Xóa</a>
								</th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<!-- Modal dang nhap-->
	<div class="modal fade" id="ThemSach" role="dialog">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Bạn đang thêm giày thành công</h4>
				</div>
				<div class="modal-body">
					<form method="post" action="AdminThemSach">
						<label> Mã giày: </label> <input name="maloai" type="text"
							class="form-control"> <label> Tên loại giày: </label> <input
							name="tenloai" type="text" class="form-control"> <label>
							Chi tiết: </label> <input name="tacgia" type="text" class="form-control">
						<label> Giá: </label> <input name="gia" type="text"
							class="form-control"> <label> Ảnh: </label> <input
							name="anh" type="text" class="form-control"> <label>
							Mã loại giày: </label> <input name="maloai" type="text"
							class="form-control"> <br> <input name="themloai"
							type="submit" value="Thêm" class="btn-primary">
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>