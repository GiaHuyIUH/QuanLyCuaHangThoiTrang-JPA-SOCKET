package entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity

public class MatHangNhapEntity implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 8307944599547507934L;
	@Id
    @Column(name = "maMHN")
    private String maMHN;
    @ManyToOne
    @JoinColumn(name = "maNCC")
    private NhaCungCapEntity nhaCungCap;
    @ManyToOne
    @JoinColumn(name = "maSP")
    private SanPhamEntity sanPham;
    private int soLuongNhap;
    private LocalDate ngayNhap;

    public MatHangNhapEntity() {
    }

    public MatHangNhapEntity(String maMHN, NhaCungCapEntity nhaCungCap, SanPhamEntity sanPham, int soLuongNhap, LocalDate ngayNhap) {
        this.maMHN = maMHN;
        this.nhaCungCap = nhaCungCap;
        this.sanPham = sanPham;
        this.soLuongNhap = soLuongNhap;
        this.ngayNhap = ngayNhap;
    }

    public String getMaMHN() {
        return maMHN;
    }

    public void setMaMHN(String maMHN) {
        this.maMHN = maMHN;
    }

    public NhaCungCapEntity getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCapEntity nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public SanPhamEntity getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPhamEntity sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    @Override
    public String toString() {
        return "MatHangNhapEntity{" + "maMHN=" + maMHN + ", nhaCungCap=" + nhaCungCap + ", sanPham=" + sanPham + ", soLuongNhap=" + soLuongNhap + ", ngayNhap=" + ngayNhap + '}';
    }

}
