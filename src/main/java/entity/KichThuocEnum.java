package entity;

public enum KichThuocEnum {
	XS("XS"), S("S"), M("M"), L("L"), XL("XL"), XXL("XXL"), FREESIZE("FREESIZE");
	
	
	
	private String kichThuoc;

	private KichThuocEnum(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}
	
	@Override
	public String toString() {
		return kichThuoc;
	}
	


}
