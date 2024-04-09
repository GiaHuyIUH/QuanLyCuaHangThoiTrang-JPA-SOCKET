package entity;

public enum ChucVuEnum {
	NHAN_VIEN("Nhân viên"), QUAN_LY("Quản lý");

	private String name;

	private ChucVuEnum(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
