package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode
public class HoaDonEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3387812072003627356L;

	@Id
	private String maHD;

	private Date ngayLapHD;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maKH")
	private KhachHangEntity khachHang;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNV")
	private NhanVienEntity nhanVien;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maCTKM")
	private ChuongTrinhKhuyenMaiEntity chuongTrinhKM;

	private double tienKhuyenMai;

	private double tongTien;

	private double tienThanhToan;
	@Enumerated(EnumType.STRING)
	private TinhTrangHDEnum tinhTrang;

	public HoaDonEntity(String maHD, Date ngayLapHD, KhachHangEntity khachHang, NhanVienEntity nhanVien,
			ChuongTrinhKhuyenMaiEntity chuongTrinhKM) {
		super();
		this.maHD = maHD;
		this.ngayLapHD = ngayLapHD;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.chuongTrinhKM = chuongTrinhKM;
	}

	public HoaDonEntity(String maHD) {
		this.maHD = maHD;
	}

	public HoaDonEntity(String maHD, Date ngayLapHD, KhachHangEntity khachHang, NhanVienEntity nhanVien,
			ChuongTrinhKhuyenMaiEntity chuongTrinhKM, double tienKhuyenMai, double tongTien, double tienThanhToan,
			TinhTrangHDEnum tinhTrang) {
		this.maHD = maHD;
		this.ngayLapHD = ngayLapHD;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.chuongTrinhKM = chuongTrinhKM;
		this.tienKhuyenMai = tienKhuyenMai;
		this.tongTien = tongTien;
		this.tienThanhToan = tienThanhToan;
		this.tinhTrang = tinhTrang;
	}

	public HoaDonEntity() {
		super();

	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public Date getNgayLapHD() {
		return ngayLapHD;
	}

	public void setNgayLapHD(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}

	public KhachHangEntity getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHangEntity khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVienEntity getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVienEntity nhanVien) {
		this.nhanVien = nhanVien;
	}

	public ChuongTrinhKhuyenMaiEntity getChuongTrinhKM() {
		return chuongTrinhKM;
	}

	public void setChuongTrinhKM(ChuongTrinhKhuyenMaiEntity chuongTrinhKM) {
		this.chuongTrinhKM = chuongTrinhKM;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTienKhuyenMai() {
		if (this.getChuongTrinhKM() != null) {
			double tienKM = tongTien * (chuongTrinhKM.getGiamGia() * 0.01);
			if (tienKM > chuongTrinhKM.getSoTienToiDa()) {
				this.tienKhuyenMai = chuongTrinhKM.getSoTienToiDa();
			} else {
				this.tienKhuyenMai = tienKM;
			}
		} else {
			this.tienKhuyenMai = 0;
		}
	}

	public void setTienThanhToan() {
		this.tienThanhToan = tongTien - tienKhuyenMai;
	}

	public double getTienKhuyenMai() {
		return tienKhuyenMai;
	}

	public double getTienThanhToan() {
		return tienThanhToan;
	}

	public TinhTrangHDEnum getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(TinhTrangHDEnum tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public String toString() {
		return "HoaDonEntity{" + "maHD=" + maHD + ", ngayLapHD=" + ngayLapHD + ", khachHang=" + khachHang
				+ ", nhanVien=" + nhanVien + ", chuongTrinhKM=" + chuongTrinhKM + ", tienKhuyenMai=" + tienKhuyenMai
				+ ", tongTien=" + tongTien + ", tienThanhToan=" + tienThanhToan + ", tinhTrang=" + tinhTrang + '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHD);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDonEntity other = (HoaDonEntity) obj;
		return Objects.equals(maHD, other.maHD);
	}

}
