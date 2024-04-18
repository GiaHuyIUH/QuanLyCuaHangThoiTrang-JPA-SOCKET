package entity;

public enum HinhThucDoiTraEnum {
	HOANTRA("Hoàn trả"), DOIMOI("Đổi mới");
        
	private String name;
	private HinhThucDoiTraEnum(String name) {
		            this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}	
}
