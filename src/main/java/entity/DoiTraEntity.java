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
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode
public class DoiTraEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6170787916186295208L;
	@Id
	private String maDT;

	@ManyToOne
	@JoinColumn(name = "maHD")
	private HoaDonEntity hoaDon;

	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVienEntity nhanVien;

	@Enumerated(EnumType.STRING)
	private HinhThucDoiTraEnum hinhThucDoiTra;

	private Date thoiGianDoiTra;

	private double tongTien;

	public DoiTraEntity() {
	}

	public DoiTraEntity(String maDT) {
		this.maDT = maDT;
	}

	public DoiTraEntity(String maDT, HoaDonEntity hoaDon, NhanVienEntity nhanVien, HinhThucDoiTraEnum hinhThucDoiTra,
			Date thoiGianDoiTra, double tongTien) {
		this.maDT = maDT;
		this.hoaDon = hoaDon;
		this.nhanVien = nhanVien;
		this.hinhThucDoiTra = hinhThucDoiTra;
		this.thoiGianDoiTra = thoiGianDoiTra;
		this.tongTien = tongTien;
	}

	public String getMaDT() {
		return maDT;
	}

	public void setMaDT(String maDT) {
		this.maDT = maDT;
	}

	public HoaDonEntity getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDonEntity hoaDon) {
		this.hoaDon = hoaDon;
	}

	public NhanVienEntity getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVienEntity nhanVien) {
		this.nhanVien = nhanVien;
	}

	public HinhThucDoiTraEnum getHinhThucDoiTra() {
		return hinhThucDoiTra;
	}

	public void setHinhThucDoiTra(HinhThucDoiTraEnum hinhThucDoiTra) {
		this.hinhThucDoiTra = hinhThucDoiTra;
	}

	public Date getThoiGianDoiTra() {
		return thoiGianDoiTra;
	}

	public void setThoiGianDoiTra(Date thoiGianDoiTra) {
		this.thoiGianDoiTra = thoiGianDoiTra;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	@Override
	public String toString() {
		return "DoiTraEntity{" + "maDT=" + maDT + ", hoaDon=" + hoaDon + ", nhanVien=" + nhanVien + ", hinhThucDoiTra="
				+ hinhThucDoiTra + ", thoiGianDoiTra=" + thoiGianDoiTra + ", tongTien=" + tongTien + '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDT);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoiTraEntity other = (DoiTraEntity) obj;
		return Objects.equals(maDT, other.maDT);
	}

}
