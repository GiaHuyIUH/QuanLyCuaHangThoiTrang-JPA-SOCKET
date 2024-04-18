
package entity;


public enum TinhTrangHDEnum {
    DATHANHTOAN("Đã thanh toán"), CHUATHANHTOAN("Chưa thanh toán");
	
    private String name;
    private TinhTrangHDEnum(String name) {
        this.name = name;
    }
    @Override
	public String toString() {
		return name;
	}
}
