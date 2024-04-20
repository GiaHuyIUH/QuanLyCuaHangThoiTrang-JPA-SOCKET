package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQueries({
//	@NamedQuery(name = "HoaDon.getTotalMoney", query = "SELECT SUM(hd.tongTien) FROM HoaDonEntity hd WHERE maHD = :maHD"),
		@NamedQuery(name = "HoaDon.getAllHoaDon", query = "SELECT hd FROM HoaDonEntity hd"), 
		@NamedQuery(name = "HoaDon.getTotalMoney", query = "SELECT SUM(hd.tongTien) FROM HoaDonEntity hd WHERE maHD = :maHD"),
		@NamedQuery(name = "HoaDon.getHoaDonTheoNgayLap", query = "SELECT hd FROM HoaDonEntity hd WHERE hd.ngayLapHD = :ngayLap"),
		@NamedQuery(name = "HoaDon.getHoaDonTheoMaHDvaNgayLap", query = "SELECT hd FROM HoaDonEntity hd WHERE hd.maHD = :maHD AND hd.ngayLapHD = :ngayLap"),
		@NamedQuery(name = "HoaDon.getAllHDChuaThanhToan", query = "SELECT hd FROM HoaDonEntity hd WHERE hd.tinhTrang = 'CHUATHANHTOAN'"),
		@NamedQuery(name = "HoaDon.getSoLuongTonTheoMa", query = "SELECT COUNT(hd) FROM HoaDonEntity hd WHERE hd.maHD = :maHD"),
		@NamedQuery(name = "HoaDon.timKiemHoaDonChuaThanhToan", query = "SELECT hd FROM HoaDonEntity hd WHERE hd.khachHang.soDienThoai = :sdt AND hd.tinhTrang = 'CHUATHANHTOAN'"),
		@NamedQuery(name = "HoaDon.capNhatHoaDonLuuTam", query = "UPDATE HoaDonEntity h SET h.nhanVien = :nhanVien, h.chuongTrinhKM = :chuongTrinhKM, " +
	              "h.ngayLapHD = :ngayLapHD, h.tienKhuyenMai = :tienKhuyenMai, h.tongTien = :tongTien, " +
	              "h.tienThanhToan = :tienThanhToan, h.tinhTrang = :tinhTrang " +
	              "WHERE h.maHD = :maHD AND h.khachHang.maKH = :maKH"),
		//		@NamedQuery(name = "HoaDon.luuTamHoaDon", query = "INSERT INTO HoaDon(hd.maHD, hd.khachHang.maKH, hd.nhanVien.maNV, hd.chuongTrinhKM.maCTKM, hd.ngayLapHD, hd.tienKhuyenMai, hd.tongTien, hd.tienThanhToan, hd.tinhTrang) "
//				+ "VALUES (:maHD, :maKH, :maNV, :maCTKM, :ngayLapHD, :tienKhuyenMai, :tongTien, :tienThanhToan, :tinhTrang)"),
//		
})
public class HoaDonEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3387812072003627356L;
	@Id
	@Column(name = "MaHD")
	private String maHD;
	@Column(name = "NgayLapHD")
	private Date ngayLapHD;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaKH")
	private KhachHangEntity khachHang;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaNV")
	private NhanVienEntity nhanVien;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maCTKM")
	private ChuongTrinhKhuyenMaiEntity chuongTrinhKM;
	@Column(name = "TienKhuyenMai")
	private double tienKhuyenMai;
	@Column(name = "TongTien")
	private double tongTien;
	@Column(name = "TienThanhToan")
	private double tienThanhToan;
	@Enumerated(EnumType.STRING)
	private TinhTrangHDEnum tinhTrang;
	
	@OneToMany(mappedBy = "hoaDon")
	private List<ChiTietHoaDonEntity> chiTietHoaDon;

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
		return "HoaDonEntity [maHD=" + maHD + ", ngayLapHD=" + ngayLapHD + ", khachHang=" + khachHang + ", nhanVien="
				+ nhanVien + ", chuongTrinhKM=" + chuongTrinhKM + ", tienKhuyenMai=" + tienKhuyenMai + ", tongTien="
				+ tongTien + ", tienThanhToan=" + tienThanhToan + ", tinhTrang=" + tinhTrang + "]";
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