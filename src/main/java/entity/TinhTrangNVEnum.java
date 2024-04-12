package entity;

public enum TinhTrangNVEnum {
	DANG_LAM_VIEC("Đang làm việc"), NGHI_VIEC("Nghỉ việc"), NGHI_PHEP("Nghỉ phép");

	private String name;

	private TinhTrangNVEnum(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
