package entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NhaCungCapEntity {
    @Id
    private String maNCC;

    @Column
    private String tenNCC;

    @Column
    private String diaChi;

    @Column
    private String soDienThoai;

    @Column
    private TinhTrangNCCEnum tinhTrang;

    public NhaCungCapEntity(String maNCC, String tenNCC, String diaChi, String soDienThoai, TinhTrangNCCEnum tinhTrang) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.tinhTrang = tinhTrang;
    }

    public NhaCungCapEntity(String maNCC) {
        this.maNCC = maNCC;
    }

    public NhaCungCapEntity() {
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public TinhTrangNCCEnum getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TinhTrangNCCEnum tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "NhaCungCapEntity{" +
                "maNCC='" + maNCC + '\'' +
                ", tenNCC='" + tenNCC + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", tinhTrang=" + tinhTrang +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNCC);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NhaCungCapEntity that = (NhaCungCapEntity) obj;
        return Objects.equals(maNCC, that.maNCC);
    }

    // Kiểm tra xem nhà cung cấp có chứa tiêu chí tìm kiếm không
    public boolean matchesSearchTerm(String search) {
        return maNCC.contains(search) || tenNCC.contains(search) || soDienThoai.contains(search) || diaChi.contains(search) || tinhTrang.toString().contains(search);
    }
}
