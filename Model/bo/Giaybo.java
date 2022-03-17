package bo;

import java.util.ArrayList;

import bean.Giaybean;
import dao.Giaydao;

public class Giaybo {
	Giaydao sdao= new Giaydao();
	public ArrayList<Giaybean> getsach() throws Exception{
		return sdao.getsach();
	}
	
	 public ArrayList<Giaybean> TimLoai(ArrayList<Giaybean> ds,String maloai) throws Exception{
    	 ArrayList<Giaybean> tam= new ArrayList<Giaybean>();
    	 for(Giaybean s: ds)
    		 if(s.getMaloai().equals(maloai))
    			   tam.add(s);
    	 return tam;
     }
	
	public ArrayList<Giaybean> Tim(ArrayList<Giaybean> ds,String key) throws Exception{
   	 ArrayList<Giaybean> tam= new ArrayList<Giaybean>();
   	 for(Giaybean s: ds)
   		 if(s.getTensach().toLowerCase().contains(key.toLowerCase()) ||
   				 s.getTacgia().toLowerCase().contains(key.toLowerCase()))
   			   tam.add(s);
   	 return tam;
    }	
	
	public int DemLoai(ArrayList<Giaybean> ds,String maloai) throws Exception{
    	int d=0;
    	 for(Giaybean s: ds)
    		 if(s.getMaloai().equals(maloai))
    			d++;
    	 return d;
     }
	public String TimAnh(ArrayList<Giaybean> ds,String masach) throws Exception{
    	String m="haha";
    	 for(Giaybean s: ds)
    		 if(s.getMasach().equals(masach))
    			m=s.getAnh();
    	 return m;
     }
	public boolean Xoa(String masach) throws Exception{
    	return sdao.XoaSach(masach);
     }	
}
