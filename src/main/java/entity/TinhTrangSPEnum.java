package entity;

public enum TinhTrangSPEnum {
	DANGBAN("Đang bán"), HETHANG("Hết hàng"), NGUNGBAN("Ngừng bán");
	
	private String tinhTrang;

	private TinhTrangSPEnum(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	@Override
	public String toString() {
		return tinhTrang;
	}
	
}
