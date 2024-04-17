package entity;

public enum MauSacEnum {
	
	 Đen("Đen"), Xám("Xám"),Trang("Trắng");
	
	private String mauSac;

	private MauSacEnum(String mauSac) {
		this.mauSac = mauSac;
	}
	@Override
	public String toString() {
		return mauSac;
	}
	
}
