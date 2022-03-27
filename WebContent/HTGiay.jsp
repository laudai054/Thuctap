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
<title>Game</title>
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
								<li><a>Loại giày</a>
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
 //tên loại game
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
								<!-- ---------------------Dang nhap----------------------- -->
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
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Đăng nhập hệ
						thống</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form method="post" action="KiemTraDN">
						<label> Tên đăng nhập: </label> <input name="txtun" type="text"
							class="form-control"> <label> Mật khẩu: </label> <input
							name="txtpass" type="password" class="form-control">
						<div class="modal-footer">
							<input name="but1" type="submit" value="Đăng nhập"
								class="btn btn-primary">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<section class="hero" style="padding-top: 6%;">
		<div class="container">
			<h3 align="center" style="color: white">
				<b>NIKE SHOP</b>
			</h3>
		</div>
	</section>
	<!-- Hero Section Begin -->
	<!-- <section class="hero" style="padding-top: 6%;">
		<div class="container">
			<div class="hero__slider owl-carousel">
				<div class="hero__items set-bg" data-setbg="image_sach/cl01.jpg">
					<div class="row">
						<div class="col-lg-6">
							<div class="hero__text">
								<div class="label">Adventure</div>
								<h2>Fate / Stay Night: Unlimited Blade Works</h2>
								<p>After 30 days of travel across the world...</p>
								<i class="fas fa-chevron-right"></i>
							</div>
						</div>
					</div>
				</div>
				<div class="hero__items set-bg" data-setbg="img/hero/hero-1.jpg">
					<div class="row">
						<div class="col-lg-6">
							<div class="hero__text">
								<div class="label">Adventure</div>
								<h2>Fate / Stay Night: Unlimited Blade Works</h2>
								<p>After 30 days of travel across the world...</p>
								<i class="fas fa-chevron-right"></i>
							</div>
						</div>
					</div>
				</div>
				<div class="hero__items set-bg" data-setbg="img/hero/hero-1.jpg">
					<div class="row">
						<div class="col-lg-6">
							<div class="hero__text">
								<div class="label">Adventure</div>
								<h2>Fate / Stay Night: Unlimited Blade Works</h2>
								<p>After 30 days of travel across the world...</p>
								><i class="fas fa-chevron-right"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section> -->

	<!-- Hero Section End -->
	<!-- Modal1 dang xuat -->
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Nhấn nút đồng ý
						để đăng xuất!</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form method="post" action="DangXuat">
						<input name="but12" type="submit" value="Đồng ý"
							class="btn btn-primary">
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal2 dang ky-->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Đăng ký tài
						khoản</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form method="post" action="DangKy">
						<label class="text-info"> Tên đăng nhập: </label> <input
							class="form-control" placeholder="Tên đăng nhập" name="tendn"
							type="text" class="form-control"> <label
							class="text-info"> Mật khẩu: </label> <input class="form-control"
							placeholder="Mật khẩu" name="matkhau" type="password"
							class="form-control"> <label class="text-info">
							Họ tên: </label> <input class="form-control" placeholder="Họ tên"
							name="hoten" type="text" class="form-control"> <label
							class="text-info"> Địa chỉ: </label> <input class="form-control"
							placeholder="Địa chỉ" name="diachi" type="text"
							class="form-control"> <label class="text-info">
							Số điện thoại: </label> <input class="form-control"
							placeholder="Số điện thoại" name="sdt" type="text"
							class="form-control"> <label class="text-info">
							Email: </label> <input class="form-control" placeholder="Email"
							name="email" type="text" class="form-control"> <br>
						<div class="model-footer">
							<input name="but13" type="submit" value="Đăng ký"
								class="btn btn-primary btn-block">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<section class="product spad">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="trending__product">
						<div class="row">
							<div class="col-lg-8 col-md-8 col-sm-8">
								<div class="section-title">
									<h4>LIST GIÀY</h4>
								</div>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4">
								<div class="btn__all">
									<div>
										<%
										String a1 = request.getParameter("txta");
										if (a1 == null) {
											a1 = "";
										}
										%>
										<form class="pager" align="right">
											<input name="key" value="" placeholder="Tìm kiếm...">
											<button type="submit"
												style="background-color: #0b0c2a; border-color: #0b0c2a; border: none;">
												<i class="fas fa-search"
													style="color: white; font-size: 20px;"></i>
											</button>
										</form>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<%
							if (ds != null) {
								int n = ds.size();
								for (int i = 0; i < n; i++) { //duyệt mảng theo size của arraylist
									Giaybean s = ds.get(i); // get(i) lấy phần tử thứ i trong list
							%>
							<div class="col-lg-4 col-md-6 col-sm-6">
								<div class="product__item">
									<div style="width: 100%; height: 476px; object-fit: cover;"
										class="product__item__pic set-bg" data-setbg=<%=s.getAnh()%>>
										<div class="comment">
											<a
												href="giohang?ms=<%=s.getMasach()%>&ts=<%=s.getTensach()%>&gia=<%=s.getGia()%>&tg=<%=s.getTacgia()%>&a=<%=s.getAnh()%>">
												<i class="fas fa-shopping-cart"
												style="color: white; font-size: 20px;"></i> <b
												style="font-size: 1px; color: white;">Buy now</b>
											</a>
										</div>
										<div class="view">
											<%=s.getGia()%>đ
										</div>
									</div>
									<div class="product__item__text">
										<h5>
											<a href="#"> <%=s.getTensach()%>
											</a>
										</h5>
									</div>
								</div>
							</div>
							<%
							}
							}
							%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ---------------------------Check đăng nhập------------------------------- -->
	<%
	if (session.getAttribute("khxn") != null && session.getAttribute("khxn").toString().equals("1")) {
	%>
	<%
	session.removeAttribute("khxn");
	%>
	<script>
		alert('Bạn cần đăng nhập trước khi sử dụng tính năng này!');
	</script>
	<%
	}
	%>
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
