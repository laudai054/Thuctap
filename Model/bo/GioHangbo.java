package bo;
 
import java.util.ArrayList;
 
import bean.GioHangbean;
import bean.Giaybean;
 
public class GioHangbo {
        public ArrayList<GioHangbean> ds= new ArrayList<GioHangbean>();
        public void Them(String masach, String tensach, String tacgia, String anh, Long gia, Long slmua) {
                //Kiem tra xem sach nay da co chua, neu co thi tang soluong
                for(GioHangbean g: ds)
                          if(g.getMasach().equals(masach)) {
                                  g.setSlmua(g.getSlmua()+slmua);
                                  g.setThanhtien(g.getSlmua()*g.getGia());
                                  return;
                          }
                ds.add(new GioHangbean(masach, tensach, tacgia, anh, gia, slmua));
        }
        public void xoa(String masach) {
                for(GioHangbean g: ds)
                          if(g.getMasach().equals(masach)) {
                                  ds.remove(g);
                                  break;
                          }
        }
       
       
        public void SetSL(String masach,Long slmua) {
            //Kiem tra xem sach nay da co chua, neu co thi tang soluong
            for(GioHangbean g: ds)
                      if(g.getMasach().equals(masach)) {
                              g.setSlmua(slmua);
                              g.setThanhtien(g.getSlmua()*g.getGia());
                              return;
                      }
        }        
       
        public Long TongTien() {
                long s=(long)0;
                for(GioHangbean g: ds)
                        s+=g.getThanhtien();
                return s;
        }
        
		 public int dem() {
			return ds.size();
		}
       
} 