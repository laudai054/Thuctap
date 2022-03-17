package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.khachhangbean;
import bean.Loaibean;
import bean.Giaybean;

public class Giaydao {
	public ArrayList<Giaybean> getsach() throws Exception{
		ArrayList<Giaybean>  ds= new ArrayList<Giaybean>();
		//b1: ket noi
    	DungChung dc= new DungChung();
    	dc.KetNoi();
    	//B2: Lay du lieu ve
    	String sql="Select * from sach";
    	PreparedStatement cmd= dc.cn.prepareStatement(sql);
    	ResultSet rs= cmd.executeQuery();
    	//b3: Duyet qua cac du lieu lay ve de luu vao 1 mang
    	while(rs.next()) {
    		String masach=rs.getString("masach");
    		String tenloai=rs.getString("tensach");
    		String tacgia=rs.getString("tacgia");
    		long gia=rs.getLong("gia");
    		String anh=rs.getString("anh");
    		String maloai=rs.getString("maloai");
    		ds.add(new Giaybean(masach,tenloai,tacgia,gia,anh,maloai));
    	}
    	//Dong ket noi
    	rs.close();
    	dc.cn.close();
    	return ds;
	}
	
	public boolean XoaSach(String masach) throws Exception{
		ArrayList<Giaybean>  ds= new ArrayList<Giaybean>();
		//b1: ket noi
    	DungChung dc= new DungChung();
    	dc.KetNoi();
    	//B2: Lay du lieu ve
    	String sql="DELETE  FROM sach"
    			+ "  WHERE masach='"+masach+"';";
    	PreparedStatement cmd= dc.cn.prepareStatement(sql);
    	ResultSet rs= cmd.executeQuery();
    	//b3: Duyet qua cac du lieu lay ve de luu vao 1 mang
    	//Dong ket noi
    	rs.close();
    	dc.cn.close();
		return true;
	}
	
	public boolean ThemSach(String masach, String tensach, String tacgia, Long gia, String anh, String maloai) throws Exception{
		ArrayList<Giaybean>  ds= new ArrayList<Giaybean>();
		//b1: ket noi
    	DungChung dc= new DungChung();
    	dc.KetNoi();
    	//B2: Lay du lieu ve
    	String sql="INSERT INTO sach (masach, tensach, soluong, gia, maloai, sotap, anh, NgayNhap, tacgia)"
    			+ "VALUES (?, ?, '10', ?, ?, '10', ?, '2021/10/10', ?);";
    	PreparedStatement cmd= dc.cn.prepareStatement(sql);
    	cmd.setString(1, masach);
    	cmd.setString(2, tensach);
    	cmd.setString(3, tacgia);
    	cmd.setLong(4, gia);
    	cmd.setString(5, anh);
    	cmd.setString(6, maloai);
    	cmd.executeUpdate();
    	
    	//b3: Duyet qua cac du lieu lay ve de luu vao 1 mang
    	//Dong ket noi
    	dc.cn.close();
		return true;
	}
}
