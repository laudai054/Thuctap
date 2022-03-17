package bo;

import java.util.ArrayList;

import bean.ChiTietHoaDonbean;
import bean.GioHangbean;
import dao.ChiTietHoaDondao;

public class ChiTietHoaDonbo {
	ChiTietHoaDondao ctd= new ChiTietHoaDondao();
	public ArrayList<ChiTietHoaDonbean> getCT(String maHoaDon) throws Exception{
		return ctd.getCTHD(maHoaDon);
	}
	public void ThemCthd(String MaSach, Long SoLuongMua) throws Exception {
		ctd.ThemCTHD(MaSach, SoLuongMua);
	}
	public ArrayList<ChiTietHoaDonbean> getallCT() throws Exception{
		return ctd.getallCTHD();
	}
	public boolean xacnhan(String MaCTHD) throws Exception{
		return ctd.xacnhan(MaCTHD);
	}
}