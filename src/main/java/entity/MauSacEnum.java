package entity;

public enum MauSacEnum {
	
	TRANG("Trắng"), DEN("Đen"), XAM("Xám");
	
	private String mauSac;

	private MauSacEnum(String mauSac) {
		this.mauSac = mauSac;
	}
	@Override
	public String toString() {
		return mauSac;
	}
	
}
