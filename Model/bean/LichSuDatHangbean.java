package bean;

public class LichSuDatHangbean {
	private String makh;
    private String TenSach;
    private Long SoluongMua;
    private Long gia;
    private Long ThanhTien;
    private boolean damua;
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getTenSach() {
		return TenSach;
	}
	public void setTenSach(String tenSach) {
		TenSach = tenSach;
	}
	public Long getSoluongMua() {
		return SoluongMua;
	}
	public void setSoluongMua(Long soluongMua) {
		SoluongMua = soluongMua;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public Long getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(Long thanhTien) {
		ThanhTien = thanhTien;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	public LichSuDatHangbean(String makh, String tenSach, Long soluongMua, Long gia, Long thanhTien, boolean damua) {
		super();
		this.makh = makh;
		TenSach = tenSach;
		SoluongMua = soluongMua;
		this.gia = gia;
		ThanhTien = thanhTien;
		this.damua = damua;
	}
	public LichSuDatHangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}