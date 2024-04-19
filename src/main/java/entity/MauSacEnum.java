package entity;

public enum MauSacEnum {
	
	WHITE("Trắng"), BLACK("Đen"), GREY("Xám");
	
	private String mauSac;

	private MauSacEnum(String mauSac) {
		this.mauSac = mauSac;
	}
	@Override
	public String toString() {
		return mauSac;
	}
	
}
