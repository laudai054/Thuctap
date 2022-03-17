package bo;

import java.util.ArrayList;

import bean.Loaibean;
import dao.Loaidao;

public class Loaibo {
	Loaidao ldao= new Loaidao();
	public ArrayList<Loaibean> getloai() throws Exception{
		return ldao.getloai();
	}
	public boolean themloai(String maloai, String tenloai) throws Exception{
		return ldao.ThemLoai(maloai, tenloai);
	}
	public boolean xoaloai(String maloai) throws Exception{
		return ldao.XoaLoai(maloai);
	}
	public boolean SuaLoai(String maloai, String tenloai) throws Exception{
		return ldao.SuaLoai(maloai, tenloai);
	}
}
