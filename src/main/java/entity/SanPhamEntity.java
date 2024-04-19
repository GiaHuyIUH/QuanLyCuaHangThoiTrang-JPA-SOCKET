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
@Entity
@NamedQueries({
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
	
    private String tenSP;
    
    @Enumerated(EnumType.STRING)
    private KichThuocEnum kichThuoc;
    
    @Enumerated(EnumType.STRING)
    private MauSacEnum mauSac;
    
    private double donGia;
    private int soLuongTonKho;
    
    @Enumerated(EnumType.STRING)
    private TinhTrangSPEnum tinhTrang;
    
    private String imgUrl;
    
    
    
    
    
    @ManyToOne
    @JoinColumn(name = "maChatLieu")
    private ChatLieuEntity chatLieu;
    
    
    @ManyToOne
    @JoinColumn(name = "maThuongHieu")
    private ThuongHieuEntity thuongHieu;
    
    @ManyToOne
    @JoinColumn(name = "maDanhMuc")
    private DanhMucSanPhamEntity danhMucSanPham;
    
    @ManyToOne
    @JoinColumn(name = "maCTKM")
    private ChuongTrinhKhuyenMaiEntity chuongTrinhKhuyenMai;
    
    @OneToMany(mappedBy = "sanPham")
    private List<ChiTietHoaDonEntity> chiTietHoaDon;
    
    @OneToMany(mappedBy = "sanPham")
    private List<MatHangNhapEntity> matHangNhap ;
    
    @OneToMany(mappedBy = "sanPham")
    private List<ChiTietDoiTraEntity> chiTietDoiTra;

    public SanPhamEntity() {
        super();
    }

    public SanPhamEntity(String maSP) {
        this.maSP = maSP;
    }

 
    

	public SanPhamEntity(String maSP, String tenSP, KichThuocEnum kichThuoc, MauSacEnum mauSac, double donGia,
			int soLuongTonKho, TinhTrangSPEnum tinhTrang, String imgUrl, ChatLieuEntity chatLieu,
			ThuongHieuEntity thuongHieu, DanhMucSanPhamEntity danhMucSanPham,
			ChuongTrinhKhuyenMaiEntity chuongTrinhKhuyenMai) {
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
		this.danhMucSanPham = danhMucSanPham;
		this.chuongTrinhKhuyenMai = chuongTrinhKhuyenMai;
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
		return danhMucSanPham;
	}

	public void setDanhMucSanPham(DanhMucSanPhamEntity danhMucSanPham) {
		this.danhMucSanPham = danhMucSanPham;
	}

	public String getTenSP() {
		return tenSP;
	}

	public ChuongTrinhKhuyenMaiEntity getChuongTrinhKhuyenMai() {
        return chuongTrinhKhuyenMai;
    }

    public void setChuongTrinhKhuyenMai(ChuongTrinhKhuyenMaiEntity chuongTrinhKhuyenMai) {
        this.chuongTrinhKhuyenMai = chuongTrinhKhuyenMai;
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
        return "SanPhamEntity{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", kichThuoc=" + kichThuoc + ", mauSac=" + mauSac + ", donGia=" + donGia + ", soLuongTonKho=" + soLuongTonKho + ", tinhTrang=" + tinhTrang + ", chatLieu=" + chatLieu + ", thuongHieu=" + thuongHieu + ", danhMucSanPham=" + danhMucSanPham + ", chuongTrinhKhuyenMai=" + chuongTrinhKhuyenMai + ", imgUrl=" + imgUrl + '}';
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