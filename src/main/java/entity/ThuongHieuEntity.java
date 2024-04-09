package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ThuongHieuEntity {

	@Id
    private String maThuongHieu;
	
    private String  tenThuongHieu;

    public ThuongHieuEntity(String maThuongHieu, String tenThuongHieu) {
        super();
        this.maThuongHieu = maThuongHieu;
        this.tenThuongHieu = tenThuongHieu;
    }

    public ThuongHieuEntity(String maThuongHieu) {
        super();
        this.maThuongHieu = maThuongHieu;
    }

    public String getMaThuongHieu() {
        return maThuongHieu;
    }

    public void setMaThuongHieu(String maThuongHieu) {
        this.maThuongHieu = maThuongHieu;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }

    public ThuongHieuEntity() {
        super();
    }

    @Override
    public String toString() {
        return "ThuongHieuEntity [maThuongHieu=" + maThuongHieu + ", tenThuongHieu=" + tenThuongHieu + "]";
    }

}
