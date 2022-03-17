package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ChiTietHoaDonbean;
import bean.HoaDonbean;

public class ChiTietHoaDondao {
	public ArrayList<ChiTietHoaDonbean> getCTHD(String maHoaDon) throws Exception{
		ArrayList<ChiTietHoaDonbean>  ds= new ArrayList<ChiTietHoaDonbean>();
		//b1: ket noi
    	DungChung dc= new DungChung();
    	dc.KetNoi();
    	//B2: Lay du lieu ve
    	String sql="select * from ChiTietHoaDon";
    	PreparedStatement cmd= dc.cn.prepareStatement(sql);
    	//cmd.setString(1, maHoaDon);
    	ResultSet rs= cmd.executeQuery();
    	
    	//b3: Duyet qua cac du lieu lay ve de luu vao 1 mang
    	while(rs.next()) {
    		String MaChiTietHD=rs.getString("MaChiTietHD");
    		String MaSach=rs.getString("MaSach");
    		Long SoLuongMua=rs.getLong("SoLuongMua");
       		String MaHoaDon=rs.getString("MaHoaDon");
       		boolean damua=rs.getBoolean("damua");
    		ds.add(new ChiTietHoaDonbean(MaChiTietHD,MaSach, SoLuongMua, MaHoaDon, damua));
    	}
    	//Dong ket noi
    	rs.close();
    	dc.cn.close();
    	return ds;
	}
	public ChiTietHoaDonbean ThemCTHD(String MaSach, Long SoLuongMua) throws Exception{
		 //b1: ket noi
		System.out.println("CTHD dao");
		DungChung dc= new DungChung();
		dc.KetNoi();
		String sql="select max(MaHoaDon) as MaHoaDon from hoadon";
    	PreparedStatement cmd= dc.cn.prepareStatement(sql);
    	ResultSet rs= cmd.executeQuery();
    	String MaHoaDon = null;
    	while(rs.next()) {
    	
    		MaHoaDon=rs.getString("MaHoaDon");
    		System.out.println(MaHoaDon);
    	}
	
  		PreparedStatement pst = dc.cn.prepareStatement("insert into "
  			   + "ChiTietHoaDon(MaSach, SoLuongMua, MaHoaDon, damua) values(?,?,?,?)"); 	   					
		pst.setString(1, MaSach);
		pst.setLong(2, SoLuongMua);
		pst.setString(3, MaHoaDon);
		pst.setBoolean(4, false);
		pst.executeUpdate();
		ChiTietHoaDonbean cthd=new ChiTietHoaDonbean(MaSach, SoLuongMua,MaHoaDon,false);
		return cthd;  	
	}
	
	public ArrayList<ChiTietHoaDonbean> getallCTHD() throws Exception{
		ArrayList<ChiTietHoaDonbean>  ds= new ArrayList<ChiTietHoaDonbean>();
		//b1: ket noi
    	DungChung dc= new DungChung();
    	dc.KetNoi();
    	//B2: Lay du lieu ve
    	String sql="select * from ChiTietHoaDon";
    	PreparedStatement cmd= dc.cn.prepareStatement(sql);
    	//cmd.setString(1, maHoaDon);
    	ResultSet rs= cmd.executeQuery();
    	
    	//b3: Duyet qua cac du lieu lay ve de luu vao 1 mang
    	while(rs.next()) {
    		String MaChiTietHD=rs.getString("MaChiTietHD");
    		String MaSach=rs.getString("MaSach");
    		Long SoLuongMua=rs.getLong("SoLuongMua");
       		String MaHoaDon=rs.getString("MaHoaDon");
       		boolean damua=rs.getBoolean("damua");
    		ds.add(new ChiTietHoaDonbean(MaChiTietHD,MaSach, SoLuongMua, MaHoaDon, damua));
    	}
    	//Dong ket noi
    	rs.close();
    	dc.cn.close();
    	return ds;
	}
	public boolean xacnhan(String MaCTHD) throws Exception{
		ArrayList<ChiTietHoaDonbean>  ds= new ArrayList<ChiTietHoaDonbean>();
		//b1: ket noi
    	DungChung dc= new DungChung();
    	dc.KetNoi();
    	//B2: Lay du lieu ve
    	String sql="UPDATE ChiTietHoaDon SET damua = 'True' WHERE MaChiTietHD=?;";
    	PreparedStatement cmd= dc.cn.prepareStatement(sql);
    	cmd.setString(1, MaCTHD);
    	cmd.executeUpdate();   	
    	dc.cn.close();
    	return true;
	}
}