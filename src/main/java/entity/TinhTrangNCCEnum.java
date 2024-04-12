package entity;

public enum TinhTrangNCCEnum {
	DANGNHAP ("DangNhap"), NGUNGNHAP("NgungNhap");

//    @Override
//    public String toString() {
//        switch (this) {
//            case DANGNHAP:
//                return "Đang nhập";
//            case NGUNGNHAP:
//                return "Ngừng nhập";
//            default:
//                return null;
//        }
//    }

	private String name;

	private TinhTrangNCCEnum(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
        
        
}
