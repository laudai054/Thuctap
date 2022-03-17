package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ChiTietHoaDonbean;
import bean.LichSuDatHangbean;

public class LichSuDatHangdao {
	public ArrayList<LichSuDatHangbean> getLSDH(String makh1) throws Exception{
		ArrayList<LichSuDatHangbean>  ds= new ArrayList<LichSuDatHangbean>();
		//b1: ket noi
    	DungChung dc= new DungChung();
    	dc.KetNoi();
    	//B2: Lay du lieu ve
    	String sql="select * from VLichSu where makh=?";
    	PreparedStatement cmd= dc.cn.prepareStatement(sql);
    	cmd.setString(1, makh1);
    	ResultSet rs= cmd.executeQuery();
    	
    	//b3: Duyet qua cac du lieu lay ve de luu vao 1 mang
    	while(rs.next()) {
    		String makh=rs.getString("makh");
    	    String TenSach=rs.getString("tensach");
    	    Long SoluongMua=rs.getLong("SoLuongMua");
    	    Long gia=rs.getLong("gia");
    	    Long ThanhTien=rs.getLong("ThanhTien");
    	    boolean damua=rs.getBoolean("Damua");
    	    
    		ds.add(new LichSuDatHangbean(makh, TenSach, SoluongMua, gia, ThanhTien, damua));
    	}
    	//Dong ket noi
    	rs.close();
    	dc.cn.close();
    	return ds;
	}
}