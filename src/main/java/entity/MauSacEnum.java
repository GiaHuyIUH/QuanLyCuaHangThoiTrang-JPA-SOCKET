package entity;

public enum MauSacEnum {
	
	 BLACK("Đen"), GREY("Xám"),WHITE("Trắng");
	
	private String mauSac;

	private MauSacEnum(String mauSac) {
		this.mauSac = mauSac;
	}
	@Override
	public String toString() {
		return mauSac;
	}
	
}
