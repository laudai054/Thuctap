package bo;

import bean.Adminbean;
import dao.Admindao;

public class Adminbo {
	Admindao addao= new Admindao();
//	public ArrayList<Adminbean> getkh(){
//		return addao.getkh();
//	}
	
	 public Adminbean ktdn(String makh,String password) throws Exception {
		return addao.getAdmin(makh, password);
	}
	
	 public Adminbean dangky(String hoten, String diachi, String sdt, String email, String tendn, String matkhau) throws Exception {
			return addao.DangKy(hoten, diachi, sdt, email, tendn, matkhau);
	}
}