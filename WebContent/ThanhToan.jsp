<%@page import="bean.ChiTietHoaDonbean"%>
<%@page import="bean.HoaDonbean"%>
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
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Thanh toán</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Css Styles -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/plyr.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<style>
.dropbtn {
	background-color: #070720;
	color: white;
	border: none;
}

.dropdown {
	position: relative;
	left: 103%;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	text-align: left;
	font-size: 15px;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}

table tr:nth-child(odd) {
	background-color: #eee;
}

table tr:nth-child(even) {
	background-color: white;
}
</style>
</head>
<body>
	<%
	response.setCharacterEncoding("utf-8"); //respon về tiếng Việt
	request.setCharacterEncoding("utf-8"); //request về tiếng Việt
	%>
	<%
	ArrayList<Loaibean> dsloai = (ArrayList<Loaibean>) session.getAttribute("dsloai");
	ArrayList<Giaybean> ds = (ArrayList<Giaybean>) session.getAttribute("dssach");
	%>
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header Section Begin -->
	<header class="header">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="header__nav">
						<nav class="header__menu mobile-menu">
							<ul>
								<li class="active"><a href="HTGiay">Trang chủ</a></li>
								<li><a>Thể loại</a>
									<ul class="dropdown">
										<li>
											<%
											if (dsloai != null) {
											%> <%
 for (Loaibean loai : dsloai) {
 %><a href="HTGiay?ml=<%=loai.getMaloai()%> " style="width: 200px">
												<%
												//link :ml được request ở dòng 69 sau đó chạy ở dòng 72
												%> <%=loai.getTenloai()%> <%
 //tên loại 
 %>
										</a> <%
 }
 }
 %>
										</li>
									</ul></li>
								<li><a href="giohang">Giỏ hàng<span class="badge"><%=session.getAttribute("dem") == null ? 0 : session.getAttribute("dem")%></span></a></li>
								<li><a href="HTThanhToan">Thanh toán</a></li>
								<li><a href="LichSu">Lịch sử mua hàng</a></li>
							</ul>

						</nav>
					</div>
				</div>
				<div class="col-lg-2">
					<div class="header__right">
						<div class="dropdown">
							<button class="dropbtn">
								<i class="far fa-user" style="color: white; font-size: 20px;"></i>
							</button>
							<div class="dropdown-content">
								<%
								// tạo kh = biến session dn (đăng nhập) - đã tạo ở 1KiemTraDN.jsp

								if (session.getAttribute("ktdky") != null && session.getAttribute("ktdky").toString().equals("0")) { //check null truoc
								%>
								<script>
									alert('đăng ký thành công');
								</script>
								<%
								session.removeAttribute("dky");
								%>
								<%
								session.removeAttribute("ktdky");
								}
								%>
								<%
								if (session.getAttribute("ktdky") != null && session.getAttribute("ktdky").toString().equals("1")) { //check null truoc
								%>
								<script>
									alert('Đăng ký không thành công! \nTên đăng nhập đã được sử dụng, hãy chọn tên khác');
								</script>
								<%
								session.removeAttribute("ktdky");
								%>
								<%
								session.removeAttribute("dky");
								%>
								<%
								}
								%>
								<!-- Dang nhap -->
								<%
								khachhangbean kh = (khachhangbean) session.getAttribute("dn"); // tạo kh = biến session dn (đăng nhập) - đã tạo ở 1KiemTraDN.jsp
								if (kh != null) {
								%>
								<a href="#">Xin chao: <%=kh.getHoten()%></a> <a href="#"
									data-toggle="modal" data-target="#myModal1"> <span
									class="glyphicon glyphicon-log-in"></span> Đăng xuất
								</a>
								<%
								} else {
								%>
								<a href="#" data-toggle="modal" data-target="#myModal2"> <span
									class="glyphicon glyphicon-log-in"></span> Đăng ký
								</a> <a href="#" data-toggle="modal" data-target="#myModal"> <span
									class="glyphicon glyphicon-log-in"></span> Đăng nhập
								</a>
								<%
								if (session.getAttribute("kt") != null && session.getAttribute("kt").toString().equals("0")) { //check null truoc
								%>
								<script>
									alert('Đăng nhập sai! Vui lòng đăng nhập lại');
								</script>
								<%
								session.removeAttribute("kt");
								%>
								<%
								}
								%>
								<%
								//1bug sau khi dn sai, vi da chuyen sang trang 1KiemTraDN va tao bien dn nen khi load trang lai se hien len thong bao nay
								%>
								<%
								}
								%>
							</div>
						</div>
					</div>
					<div id="mobile-menu-wrap"></div>
				</div>
			</div>
		</div>
	</header>


	<!-- Modal dang nhap-->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Đăng nhập hệ thống</h4>
				</div>
				<div class="modal-body">
					<form method="post" action="KiemTraDN">
						<label> Tên đăng nhập: </label> <input name="txtun" type="text"
							class="form-control"> <label> Mật khẩu: </label> <input
							name="txtpass" type="password" class="form-control"> <input
							name="but1" type="submit" value="Đăng nhập" class="btn-primary">
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal1 dang xuat -->
	<div class="modal fade" id="myModal1" role="dialog">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Nhấn nút đồng ý để đăng xuất.</h4>
				</div>
				<div class="modal-body">
					<form method="post" action="DangXuat">
						<input name="but12" type="submit" value="Đồng ý"
							class="btn-primary">
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal2 dang ky-->
	<div class="modal fade" id="myModal2" role="dialog">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Đăng ký tài khoản</h4>
				</div>
				<div class="modal-body">
					<form method="post" action="DangKy">
						<label> Tên đăng nhập: </label> <input name="tendn" type="text"
							class="form-control"> <label> Mật khẩu: </label> <input
							name="matkhau" type="password" class="form-control"> <label>
							Họ tên: </label> <input name="hoten" type="text" class="form-control">
						<label> Địa chỉ: </label> <input name="diachi" type="text"
							class="form-control"> <label> Số điện thoại: </label> <input
							name="sdt" type="text" class="form-control"> <label>
							Email: </label> <input name="email" type="text" class="form-control">
						<br> <input name="but13" type="submit" value="Đăng ký"
							class="btn-primary">
					</form>
				</div>
			</div>
		</div>
	</div>
	<%
	ArrayList<HoaDonbean> dshoadon = (ArrayList<HoaDonbean>) session.getAttribute("dsHoaDonLS");
	ArrayList<ChiTietHoaDonbean> dsCTHD = (ArrayList<ChiTietHoaDonbean>) session.getAttribute("dsCTHD");
	System.out.print("ls.jsp");
	%>
	
	
	<!-- Bang -->
	<div class="container">
		<br>
		<h3 align="center" style="color: white"><b>ĐƠN ĐẶT HÀNG</b></h3>
		<br>
		

		<table align="center">
			<tr style="padding: 5px" class="table table-hover">
				<td style="padding: 5px" class="table table-hover" valign="top"
					style="width: 1000px">
					<table class="table table-bordered" style="width: 1000px">
						<%
						if (dshoadon != null && dsCTHD != null) { //checknull
						%>
						<%
						for (HoaDonbean hd : dshoadon) {
							if (!hd.getDaMua()) {
						%>
						<tr>
							<td>
								<p>
									<span style="color: red; font-weight: bold;	">Mã hóa đơn: </span><%=hd.getMaHoaDon()%></p>
								<p>
									<span style="color: red; font-weight: bold;	">Ngày đặt: </span><%=hd.getNgayMua()%></p> <% boolean s = hd.getDaMua();%>
								<p>
									<span style="color: red; font-weight: bold;	"> Trạng thái: </span><%=hd.getDaMua() ? "Đã mua" : "Chưa mua"%></p>
								<table style="background-color: white;">
									<p>Danh sách giày đã đặt:
									<p>
										<%
										System.out.println("11");
										%>
										<%
										for (ChiTietHoaDonbean ct : dsCTHD) {
											System.out.print("loop1");
											if (ct.getMaHoaDon().equals(hd.getMaHoaDon())) {
										%>
									
									<tr>
										<td><span>Mã giày </span><%=ct.getMaSach()%><span>
												- Số lượng mua: </span><%=ct.getSoluongMua()%></td>
									</tr>
									<%
									}
									%>
									<%
									}
									%>
								</table>
							</td>
						</tr>
						<%
						}
						%>
						<%
						}
						}
						%>
					</table>
				</td>
		</table>
		</div>
	
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/player.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/mixitup.min.js"></script>
	<script src="js/jquery.slicknav.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>
