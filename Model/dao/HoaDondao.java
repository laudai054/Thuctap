package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.HoaDonbean;

public class HoaDondao {
	
	public ArrayList<HoaDonbean> gethd(String maHoaDon) throws Exception{
		ArrayList<HoaDonbean>  ds= new ArrayList<HoaDonbean>();
		//b1: ket noi
    	DungChung dc= new DungChung();
    	dc.KetNoi();
    	//B2: Lay du lieu ve
    	String sql="select * from hoadon where makh=?";
    	PreparedStatement cmd= dc.cn.prepareStatement(sql);
    	cmd.setString(1, maHoaDon);
    	ResultSet rs= cmd.executeQuery();
    	
    	//b3: Duyet qua cac du lieu lay ve de luu vao 1 mang
    	while(rs.next()) {
    		System.out.println(rs.getString("MaHoaDon")+"/HDD");
    		String MaHoaDon=rs.getString("MaHoaDon");
    		String makh=rs.getString("makh");
       		String NgayMua=rs.getString("NgayMua");
       		boolean damua=rs.getBoolean("damua");
    		ds.add(new HoaDonbean(MaHoaDon,makh, NgayMua, damua));
    	}
    	//Dong ket noi
    	rs.close();
    	dc.cn.close();
    	return ds;
	}
	public HoaDonbean ThemHD(String makh, boolean damua) throws Exception{
		 //b1: ket noi
		DungChung dc= new DungChung();
    	dc.KetNoi();
   		PreparedStatement pst = dc.cn.prepareStatement("insert into "
   			   + "HoaDon(makh, NgayMua, damua) values(?,?,?)"); 	   					
		pst.setString(1, makh);
		pst.setString(2, java.time.LocalDate.now().toString());
		pst.setBoolean(3, damua);
      
		pst.executeUpdate();
		HoaDonbean hd=new HoaDonbean(makh, java.time.LocalDate.now().toString(), damua);
		return hd;
	   	
	}
	public ArrayList<HoaDonbean> getallhd() throws Exception{
		ArrayList<HoaDonbean>  ds= new ArrayList<HoaDonbean>();
		//b1: ket noi
    	DungChung dc= new DungChung();
    	dc.KetNoi();
    	//B2: Lay du lieu ve
    	String sql="select * from hoadon";
    	PreparedStatement cmd= dc.cn.prepareStatement(sql);
    	ResultSet rs= cmd.executeQuery();
    	
    	//b3: Duyet qua cac du lieu lay ve de luu vao 1 mang
    	while(rs.next()) {
    		System.out.println(rs.getString("MaHoaDon")+"/HDD");
    		String MaHoaDon=rs.getString("MaHoaDon");
    		String makh=rs.getString("makh");
       		String NgayMua=rs.getString("NgayMua");
       		boolean damua=rs.getBoolean("damua");
    		ds.add(new HoaDonbean(MaHoaDon,makh, NgayMua, damua));
    	}
    	//Dong ket noi
    	rs.close();
    	dc.cn.close();
    	return ds;
	}
}