package bean;

public class HoaDonbean {
	private String MaHoaDon;
    private String makh;
    private String NgayMua;
    private boolean DaMua;
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(String ngayMua) {
		NgayMua = ngayMua;
	}
	public boolean getDaMua() {
		return DaMua;
	}
	public void setDaMua(boolean daMua) {
		DaMua = daMua;
	}
	
	public String getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	
	public HoaDonbean(String maHoaDon, String makh, String ngayMua, boolean daMua) {
		super();
		MaHoaDon = maHoaDon;
		this.makh = makh;
		NgayMua = ngayMua;
		DaMua = daMua;
	}
	public HoaDonbean(String makh, String ngayMua, boolean daMua) {
		super();
		this.makh = makh;
		NgayMua = ngayMua;
		DaMua = daMua;
	}
	public HoaDonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}