package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode
@Table(name = "ChiTietHoaDon")
@Setter
@Getter
public class ChiTietHoaDonEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4070089837652376842L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaSP")
	private SanPhamEntity sanPham;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaHD")
	private HoaDonEntity hoaDon;
	@Column(name = "SoLuong")
	private int soLuong;
	    @Column(name = "GiaGoc")
        private double giaGoc;
	     @Column(name = "GiaBan")
        private double giaBan;
	    @Column(name = "ThanhTien")
        private double thanhTien;

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
