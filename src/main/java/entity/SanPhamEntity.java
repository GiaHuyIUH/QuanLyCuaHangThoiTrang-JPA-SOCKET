package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
@Entity
@EqualsAndHashCode
//@AllArgsConstructor
@NamedQueries({
	@NamedQuery(name = "SanPhamEntity.getSanPhamTheoMaSP", query = "SELECT sp FROM SanPhamEntity sp WHERE sp.maSP = :maSP"),
//	select * from SanPham where maSP in (select maSP from ChiTietHoaDon where maHD = ?)
	@NamedQuery(name = "SanPhamEntity.getSanPhamTheoMaHD", query = "SELECT sp FROM SanPhamEntity sp WHERE sp.maSP IN (SELECT cthd.sanPham.maSP FROM ChiTietHoaDonEntity cthd WHERE cthd.hoaDon.maHD = :maHD)"),
//	UPDATE SanPham SET maCTKM = NULL WHERE maCTKM IN (SELECT maCTKM FROM ChuongTrinhKhuyenMai WHERE ngayKetThuc < SYSDATETIME() AND ngayKetThuc <> CONVERT(DATE, SYSDATETIME()))
	@NamedQuery(name = "SanPhamEntity.capNhatKhuyenMai", query = "UPDATE SanPhamEntity sp SET sp.chuongTrinhKM.maCTKM = NULL WHERE sp.chuongTrinhKM.maCTKM IN (SELECT ctkm.maCTKM FROM ChuongTrinhKhuyenMaiEntity ctkm WHERE ctkm.ngayKetThuc < CURRENT_DATE AND ctkm.ngayKetThuc <> CURRENT_DATE)"),
	@NamedQuery(name = "SanPham.getSoLuongTonTheoMa", query = "SELECT sp.soLuongTonKho FROM SanPhamEntity sp WHERE sp.maSP = :maSP"),
	
})
public class SanPhamEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8890485992814533408L;
	@Id
	@Column(name = "maSP")
    private String maSP;
	
	@Column(name = "tenSP", columnDefinition = "nvarchar(255)")
    private String tenSP;
    
    @Enumerated(EnumType.STRING)
    private KichThuocEnum kichThuoc;
    
    @Enumerated(EnumType.STRING )
    @Column(columnDefinition = "nvarchar(255)")
    private MauSacEnum mauSac;
    
    private double donGia;
    private int soLuongTonKho;
    
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "nvarchar(255)")
    private TinhTrangSPEnum tinhTrang;

    @Column(name = "imgUrl", columnDefinition = "nvarchar(255)")
    private String imgUrl;
    
    
    
    @ManyToOne
    @JoinColumn(name = "maChatLieu")
    private ChatLieuEntity chatLieu;
    
    
    @ManyToOne
    @JoinColumn(name = "maThuongHieu")
    private ThuongHieuEntity thuongHieu;
    
    @ManyToOne
    @JoinColumn(name = "maDanhMuc")
    private DanhMucSanPhamEntity danhMuc;
    
    @ManyToOne
    @JoinColumn(name = "maCTKM")
    private ChuongTrinhKhuyenMaiEntity chuongTrinhKM;
    
    @OneToMany(mappedBy = "sanPham")
    private List<ChiTietDoiTraEntity> chiTietDoiTra;
    
    @OneToMany(mappedBy = "sanPham")
    private List<ChiTietHoaDonEntity> chiTietHoaDon;
    
    @OneToMany(mappedBy = "sanPham")
    private List<MatHangNhapEntity> matHangNhap ;

    public SanPhamEntity() {
        super();
    }

    public SanPhamEntity(String maSP) {
        this.maSP = maSP;
    }

 
    

	public SanPhamEntity(String maSP, String tenSP, KichThuocEnum kichThuoc, MauSacEnum mauSac, double donGia,
			int soLuongTonKho, TinhTrangSPEnum tinhTrang, String imgUrl, ChatLieuEntity chatLieu,
			ThuongHieuEntity thuongHieu, DanhMucSanPhamEntity danhMuc,
			ChuongTrinhKhuyenMaiEntity chuongTrinhKM) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.kichThuoc = kichThuoc;
		this.mauSac = mauSac;
		this.donGia = donGia;
		this.soLuongTonKho = soLuongTonKho;
		this.tinhTrang = tinhTrang;
		this.imgUrl = imgUrl;
		this.chatLieu = chatLieu;
		this.thuongHieu = thuongHieu;
		this.danhMuc = danhMuc;
		this.chuongTrinhKM = chuongTrinhKM;
	}

	public void setMaSP(String maSP) {
        this.maSP = maSP;
    }
	

    public String getMaSP() {
		return maSP;
	}

	public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public KichThuocEnum getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(KichThuocEnum kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public MauSacEnum getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSacEnum mauSac) {
        this.mauSac = mauSac;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public void setSoLuongTonKho(int soLuongTonKho) {
        this.soLuongTonKho = soLuongTonKho;
    }

    public TinhTrangSPEnum getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TinhTrangSPEnum tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public ChatLieuEntity getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(ChatLieuEntity chatLieu) {
        this.chatLieu = chatLieu;
    }

    public ThuongHieuEntity getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(ThuongHieuEntity thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

   

  

	public DanhMucSanPhamEntity getDanhMucSanPham() {
		return danhMuc;
	}

	public void setDanhMucSanPham(DanhMucSanPhamEntity danhMuc) {
		this.danhMuc = danhMuc;
	}

	public String getTenSP() {
		return tenSP;
	}

	public ChuongTrinhKhuyenMaiEntity getChuongTrinhKhuyenMai() {
        return chuongTrinhKM;
    }

    public void setChuongTrinhKhuyenMai(ChuongTrinhKhuyenMaiEntity chuongTrinhKM) {
        this.chuongTrinhKM = chuongTrinhKM;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public double tinhGiaBan() {
        return this.donGia * 1.4;
    }

    @Override
    public String toString() {
        return "SanPhamEntity{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", kichThuoc=" + kichThuoc + ", mauSac=" + mauSac + ", donGia=" + donGia + ", soLuongTonKho=" + soLuongTonKho + ", tinhTrang=" + tinhTrang + ", chatLieu=" + chatLieu + ", thuongHieu=" + thuongHieu + ", danhMucSanPham=" + danhMuc + ", chuongTrinhKhuyenMai=" + chuongTrinhKM + ", imgUrl=" + imgUrl + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSP);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SanPhamEntity other = (SanPhamEntity) obj;
        return Objects.equals(maSP, other.maSP);
    }
}
