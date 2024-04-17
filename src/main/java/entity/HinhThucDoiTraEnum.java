package entity;

public enum HinhThucDoiTraEnum {
	HOANTRA("Hoan Tra"), DOIMOI("Doi Moi");
        
	private String name;
	private HinhThucDoiTraEnum(String name) {
		            this.name = name;
	}
//        @Override
//	public String toString() {
//		switch(this) {
//			case HOANTRA: return "Hoàn trả";
//			case DOIMOI: return "Đổi mới";
//                        default: return "Hoàn trả";
//		}
//	}
	@Override
	public String toString() {
		return name;
	}	
}
