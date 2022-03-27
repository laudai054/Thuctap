package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Loaibean;

public class Loaidao {
	public ArrayList<Loaibean> getloai() throws Exception{
    	ArrayList<Loaibean> ds= new ArrayList<Loaibean>();
    	//b1: ket noi
    	DungChung dc= new DungChung();
    	dc.KetNoi();
    	//B2: Lay du lieu ve
    	String sql="Select * from Loai";
    	PreparedStatement cmd= dc.cn.prepareStatement(sql);
    	ResultSet rs= cmd.executeQuery();
    	//b3: Duyet qua cac du lieu lay ve de luu vao 1 mang
    	while(rs.next()) {
    		String maloai=rs.getString("maloai");
    		String tenloai=rs.getString("tenloai");
    		ds.add(new Loaibean(maloai, tenloai));
    	}
    	//Dong ket noi
    	rs.close();
    	dc.cn.close();
    	return ds;
	}
	
	public boolean XoaLoai(String maloai) throws Exception{
		ArrayList<Loaibean> ds = new ArrayList<Loaibean>();
		//b1: ket noi
    	DungChung dc= new DungChung();
    	dc.KetNoi();
    	//B2: Lay du lieu ve
    	String sql="DELETE  FROM loai"
    			+ "  WHERE maloai='"+maloai+"';";
    	PreparedStatement cmd= dc.cn.prepareStatement(sql);
    	ResultSet rs = cmd.executeQuery();
    	//b3: Duyet qua cac du lieu lay ve de luu vao 1 mang
    	//Dong ket noi
    	rs.close();
    	dc.cn.close();
    	System.out.println("maloai"+ maloai);
		return true;
	}
	
	public boolean ThemLoai(String maloai,String tenloai) throws Exception{
		//b1: ket noi
    	DungChung dc= new DungChung();
    	dc.KetNoi();
    	//B2: Lay du lieu ve
    	String sql="select *  FROM loai"
    			+ "  WHERE maloai='"+maloai+"';";
    	PreparedStatement cmd= dc.cn.prepareStatement(sql);
    	ResultSet rs= cmd.executeQuery();
    	
    	if(rs.next()==true) {
    		rs.close();
        	dc.cn.close();
    		return false;}
	   	else {
	   		
	   		PreparedStatement pst = dc.cn.prepareStatement("insert into "
	   			   + "loai(maloai,tenloai) values(?,?)");	   					
	   					pst.setString(1, maloai);
	   					pst.setString(2, tenloai);		          
	   					pst.executeUpdate();
	   	}
    	
    	//Dong ket noi
    	rs.close();
    	dc.cn.close();
		return true;
	}
	
	public boolean SuaLoai(String maloai,String tenloai) throws Exception{
		//b1: ket noi
    	DungChung dc= new DungChung();
    	dc.KetNoi();
    	//B2: Lay du lieu ve
    	String sql= "UPDATE loai SET tenloai = ? WHERE maloai = ? ";
    	
    	
    	PreparedStatement cmd= dc.cn.prepareStatement(sql);
    	cmd.setString(1, tenloai);
    	cmd.setString(2, maloai);
    	
    	cmd.executeUpdate();
    	
    	//Dong ket noi

    	dc.cn.close();
		return true;
	}
}
