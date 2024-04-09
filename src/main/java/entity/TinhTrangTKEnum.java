package entity;

/**
 *
 * @author HUY
 */
public enum TinhTrangTKEnum {
    DANG_HOAT_DONG("Đang hoạt động"), NGUNG_HOAT_DONG("Ngưng hoạt động");
	
	private String name;
	
	private TinhTrangTKEnum(String name) { 
		this.name = name;
	}
	

    @Override
    public String toString() {
        return name;
    }
    
    
}
