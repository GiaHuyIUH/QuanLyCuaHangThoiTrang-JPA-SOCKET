package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity

@Table(name = "ChiTietHoaDon")
@EqualsAndHashCode
@NamedQueries({
	@NamedQuery(name = "ChiTietHoaDonEntity.getAllCTHD", query = "SELECT cthd FROM ChiTietHoaDonEntity cthd"),
    @NamedQuery(name = "ChiTietHoaDonEntity.getCTHDByMaHD", query = "SELECT cthd FROM ChiTietHoaDonEntity cthd WHERE cthd.hoaDon.maHD = :maHD"),
    @NamedQuery(name = "ChiTietHoaDonEntity.getCTHDByMaSP", query = "SELECT cthd FROM ChiTietHoaDonEntity cthd WHERE cthd.sanPham.maSP = :maSP"),
    @NamedQuery(name = "ChiTietHoaDonEntity.getCTHDByMaHDAndMaSP", query = "SELECT cthd FROM ChiTietHoaDonEntity cthd WHERE cthd.hoaDon.maHD = :maHD AND cthd.sanPham.maSP = :maSP"),
//	"Select cthd.*, sp.tenSP, sp.kichThuoc, sp.mauSac from ChiTietHoaDon as cthd inner join SanPham as sp on cthd.maSP=sp.maSP where maHD=?"
	@NamedQuery(name = "ChiTietHoaDonEntity.getAllCTHDTheoMaHD", query = "SELECT cthd FROM ChiTietHoaDonEntity cthd WHERE cthd.hoaDon.maHD = :maHD"),
//	"Select tongSoLuong=sum(cthd.soLuong) from ChiTietHoaDon as cthd inner join HoaDon as hd on cthd.maHD=hd.maHD where cthd.maSP=? and hd.tinhTrang=N'Chưa thanh toán' "
	@NamedQuery(name = "ChiTietHoaDonEntity.getSoLuongCTHD", query = "SELECT SUM(cthd.soLuong) FROM ChiTietHoaDonEntity cthd WHERE cthd.sanPham.maSP = :maSP AND cthd.hoaDon.tinhTrang = 'CHUATHANHTOAN' "),
	@NamedQuery(name = "ChiTietHoaDonEntity.soluongSPByMaSPAndMaHD", query = "SELECT cthd.soLuong FROM ChiTietHoaDonEntity cthd WHERE cthd.sanPham.maSP = :maSP AND cthd.hoaDon.maHD = :maHD"),
})

public class ChiTietHoaDonEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4070089837652376842L;
	
	
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maSP")
	private SanPhamEntity sanPham;
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maHD")
	private HoaDonEntity hoaDon;
	
	
	private int soLuong;
	    
    private double giaGoc;
	     
    private double giaBan;
	    
    private double thanhTien;
    
//    @OneToMany(mappedBy = "chiTietHoaDon")
//    private List<ChiTietDoiTraEntity> chiTietDoiTra;

        public ChiTietHoaDonEntity(SanPhamEntity sanPham, HoaDonEntity hoaDon, int soLuong, double giaGoc, double giaBan, double thanhTien) {
            this.sanPham = sanPham;
            this.hoaDon = hoaDon;
            this.soLuong = soLuong;
            this.giaGoc = giaGoc;
            this.giaBan = giaBan;
            this.thanhTien = thanhTien;
        }

	public ChiTietHoaDonEntity() {
	}

	public SanPhamEntity getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPhamEntity sanPham) {
		this.sanPham = sanPham;
	}
	public HoaDonEntity getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDonEntity hoaDon) {
		this.hoaDon = hoaDon;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
        
        public double getGiaGoc() {
            return giaGoc;
        }

        public void setGiaGoc() {
            this.giaGoc = sanPham.getDonGia() * 1.4;
        }

        public double getGiaBan() {
            return giaBan;
        }

        public void setGiaBan() {
            if(sanPham.getChuongTrinhKhuyenMai() != null) {
                this.giaBan = this.giaGoc * (1 - (sanPham.getChuongTrinhKhuyenMai().getGiamGia() * 0.01));
            } else {
                this.giaBan = this.giaGoc;
            }
        }

        public double getThanhTien() {
            return thanhTien;
        }

        public void setThanhTien() {
            this.thanhTien = giaBan * soLuong;
        }

        @Override
        public String toString() {
            return "ChiTietHoaDonEntity{" + "sanPham=" + sanPham + ", hoaDon=" + hoaDon + ", soLuong=" + soLuong + ", giaGoc=" + giaGoc + ", giaBan=" + giaBan + ", thanhTien=" + thanhTien + '}';
        }
 
}
