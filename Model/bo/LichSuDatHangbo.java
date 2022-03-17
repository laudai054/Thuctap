package bo;

import java.util.ArrayList;

import bean.LichSuDatHangbean;
import dao.LichSuDatHangdao;


public class LichSuDatHangbo {
	LichSuDatHangdao ctd= new LichSuDatHangdao();
	public ArrayList<LichSuDatHangbean> getLSDH(String makh) throws Exception{
		return ctd.getLSDH(makh);
	}
}