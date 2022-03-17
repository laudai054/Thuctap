package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Adminbean;

public class Admindao {
	public Adminbean getAdmin(String un, String pass) throws Exception{
		 //b1: ket noi
   	DungChung dc= new DungChung();
   	dc.KetNoi();
   	//B2: Lay du lieu ve
   	String sql="select * from QuanTri where tendn=? and pass=?";
   	PreparedStatement cmd= dc.cn.prepareStatement(sql);
   	cmd.setString(1, un);
   	cmd.setString(2, pass);
   	//Truyen 01 tham so:un, pass  vao cmdƯ
   	ResultSet rs= cmd.executeQuery();
   	
   	if(rs.next()==false)
   		return null;
   	else {
   		String makh=rs.getString("maqt");
   		String hoten=rs.getString("hoten");
   		String diachi=rs.getString("diachi");
   		String sdt=rs.getString("sodt");
   		String email=rs.getString("email");
   		String tendn=rs.getString("tendn");
   		String matkhau=rs.getString("pass");
   		Adminbean kh=new Adminbean(makh, hoten, diachi, sdt, email, tendn, matkhau);
   		return kh;
   	}
	}
	public Adminbean DangKy(String hoten, String diachi, String sdt, String email, String tendn,
			String matkhau) throws Exception{
		 //b1: ket noi
		DungChung dc= new DungChung();
   	dc.KetNoi();
   	//B2: Lay du lieu ve
   	String sql="select * from QuanTri where tendn=?";
   	PreparedStatement cmd= dc.cn.prepareStatement(sql);
   	cmd.setString(1, tendn);
   	ResultSet rs= cmd.executeQuery();
   	
   	if(rs.next()==true) {
   		return null;}
	   	else {
	   		
	   		PreparedStatement pst = dc.cn.prepareStatement("insert into "
	   			   + "QuanTri(hoten,diachi,sodt,email,tendn,pass) values(?,?,?,?,?,?)");	   					
	   					pst.setString(1, hoten);
	   					pst.setString(2, diachi);
	   					pst.setString(3, sdt);
	   					pst.setString(4, email);
	   					pst.setString(5, tendn);
	   					pst.setString(6, matkhau); 			          
	   					pst.executeUpdate();
	   			      Adminbean kh=new Adminbean(hoten, diachi, sdt, email, tendn, matkhau);
	   	    		return kh;
	   	}
	}
}