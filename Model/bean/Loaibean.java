package bean;

public class Loaibean {
	private String maloai;
    private String tenloai;
	public Loaibean(String maloai, String tenloai) {
		super();
		this.maloai = maloai;
		this.tenloai = tenloai;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public String getTenloai() {
		return tenloai;
	}
	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}
	public Loaibean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
