package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.khachhangbean;
import bean.Loaibean;

public class khachhangdao {
	public khachhangbean getkh(String un, String pass) throws Exception{
		 //b1: ket noi
    	DungChung dc= new DungChung();
    	dc.KetNoi();
    	//B2: Lay du lieu ve
    	String sql="select * from KhachHang where tendn=? and pass=?";
    	PreparedStatement cmd= dc.cn.prepareStatement(sql);
    	cmd.setString(1, un);
    	cmd.setString(2, pass);
    	//Truyen 01 tham so:un, pass  vao cmdƯ
    	ResultSet rs= cmd.executeQuery();
    	
    	if(rs.next()==false)
    		return null;
    	else {
    		String makh=rs.getString("makh");
    		String hoten=rs.getString("hoten");
    		String diachi=rs.getString("diachi");
    		String sdt=rs.getString("sodt");
    		String email=rs.getString("email");
    		String tendn=rs.getString("tendn");
    		String matkhau=rs.getString("pass");
    		khachhangbean kh=new khachhangbean(makh, hoten, diachi, sdt, email, tendn, matkhau);
    		return kh;
    	}
	}
	public khachhangbean DangKy(String hoten, String diachi, String sdt, String email, String tendn,
			String matkhau) throws Exception{
		 //b1: ket noi
		DungChung dc= new DungChung();
    	dc.KetNoi();
    	//B2: Lay du lieu ve
    	String sql="select * from KhachHang where tendn=?";
    	PreparedStatement cmd= dc.cn.prepareStatement(sql);
    	cmd.setString(1, tendn);
    	ResultSet rs= cmd.executeQuery();
    	
    	if(rs.next()==true) {
    		return null;}
	   	else {
	   		
	   		PreparedStatement pst = dc.cn.prepareStatement("insert into "
	   			   + "KhachHang(hoten,diachi,sodt,email,tendn,pass) values(?,?,?,?,?,?)");	   					
	   					pst.setString(1, hoten);
	   					pst.setString(2, diachi);
	   					pst.setString(3, sdt);
	   					pst.setString(4, email);
	   					pst.setString(5, tendn);
	   					pst.setString(6, matkhau); 			          
	   					pst.executeUpdate();
	   			      khachhangbean kh=new khachhangbean(hoten, diachi, sdt, email, tendn, matkhau);
	   	    		return kh;
	   	}
	}
	
}