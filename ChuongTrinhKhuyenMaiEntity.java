package entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "ChuongTrinhKhuyenMai")
public class ChuongTrinhKhuyenMaiEntity {
    
    @Id
    @Column(name = "maCTKM")
    private String maCTKM;

    @Column(name = "tenCTKM")
    private String tenCTKM;

    @ManyToOne
    @JoinColumn(name = "maLoaiCTKM")
    private LoaiKhuyenMaiEntity maLoaiCTKM;

    @Column(name = "soTienToiThieu")
    private double soTienToiThieu;

    @Column(name = "soTienToiDa")
    private double soTienToiDa;

    @Column(name = "giamGia")
    private int giamGia;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngayBatDau")
    private Date ngayBatDau;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngayKetThuc")
    private Date ngayKetThuc;

    @Column(name = "tinhTrang")
    private String tinhTrang;
        
        

    public ChuongTrinhKhuyenMaiEntity(String maCTKM, String tenCTKM, LoaiKhuyenMaiEntity maLoaiCTKM, double soTienToiThieu, double soTienToiDa, int giamGia, Date ngayBatDau, Date ngayKetThuc, String tinhTrang) {
        this.maCTKM = maCTKM;
        this.tenCTKM = tenCTKM;
        this.maLoaiCTKM = maLoaiCTKM;
        this.soTienToiThieu = soTienToiThieu;
        this.soTienToiDa = soTienToiDa;
        this.giamGia = giamGia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.tinhTrang = tinhTrang;
    }


        
    public LoaiKhuyenMaiEntity getMaLoaiCTKM() {
        return maLoaiCTKM;
    }

    public void setMaLoaiCTKM(LoaiKhuyenMaiEntity maLoaiCTKM) {
        this.maLoaiCTKM = maLoaiCTKM;
    }
        

    public double getSoTienToiDa() {
        return soTienToiDa;
    }

    public void setSoTienToiDa(double soTienToiDa) {
        this.soTienToiDa = soTienToiDa;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
        
    public ChuongTrinhKhuyenMaiEntity(String maCTKM) {
        super();
        this.maCTKM = maCTKM;
    }
    public ChuongTrinhKhuyenMaiEntity() {
        super();
    }
    public String getMaCTKM() {
        return maCTKM;
    }
    public void setMaCTKM(String maCTKM) {
        this.maCTKM = maCTKM;
    }
    public String getTenCTKM() {
        return tenCTKM;
    }
    public void setTenCTKM(String tenCTKM) {
        this.tenCTKM = tenCTKM;
    }
    public double getSoTienToiThieu() {
        return soTienToiThieu;
    }
    public void setSoTienToiThieu(double soTienToiThieu) {
        this.soTienToiThieu = soTienToiThieu;
    }
    public int getGiamGia() {
        return giamGia;
    }
    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }
    public Date getNgayBatDau() {
        return ngayBatDau;
    }
    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }
    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    @Override
    public String toString() {
        return "ChuongTrinhKhuyenMaiEntity [maCTKM=" + maCTKM + ", tenCTKM=" + tenCTKM + ", soTienToiThieu="
                + soTienToiThieu + ", giamGia=" + giamGia + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc="
                + ngayKetThuc + "]";
    }
    @Override
    public int hashCode() {
        return Objects.hash(maCTKM);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ChuongTrinhKhuyenMaiEntity other = (ChuongTrinhKhuyenMaiEntity) obj;
        return Objects.equals(maCTKM, other.maCTKM);
    }
    
    
}
