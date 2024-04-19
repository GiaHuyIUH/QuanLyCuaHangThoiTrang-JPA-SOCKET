package entity;

public enum TinhTrangNCCEnum {
	DANGNHAP ("DangNhap"), NGUNGNHAP("NgungNhap");


	private String name;

	private TinhTrangNCCEnum(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
        
        
}
