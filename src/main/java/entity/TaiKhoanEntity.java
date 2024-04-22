package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode
@NamedQueries({
	@NamedQuery(name = "TaiKhoanEntity.getTKByNameAndPass", query = "SELECT tk FROM TaiKhoanEntity tk WHERE tk.tenTaiKhoan = :tenTaiKhoan AND tk.matKhau = :matKhau"),
	@NamedQuery(name = "TaiKhoanEntity.updateThoiGianDNGN", query = "UPDATE TaiKhoanEntity tk SET tk.thoiGianDNGN = :thoiGianDNGN WHERE tk.tenTaiKhoan = :tenTaiKhoan"),
	@NamedQuery(name = "TaiKhoanEntity.lamMoiMatKha", query = "UPDATE TaiKhoanEntity tk SET tk.matKhau = :matKhau WHERE tk.tenTaiKhoan = :tenTaiKhoan"),
//	@NamedQuery(name = "TaiKhoanEntity.insert", query = "insert into TaiKhoanEntity(tk.tenTaiKhoan, tk.matKhau, tk.thoiGianDNGN, tk.tinhTrang, tk.maNV) values(:tenTaiKhoan, :matKhau, :thoiGianDNGN, :tinhTrang, :maNV)"),
	@NamedQuery(name = "TaiKhoanEntity.updateTinhTrang", query = "UPDATE TaiKhoanEntity tk SET tk.tinhTrang = :tinhTrang WHERE tk.tenTaiKhoan = :tenTaiKhoan"),
	@NamedQuery(name = "TaiKhoanEntity.getAllTK", query = "SELECT tk FROM TaiKhoanEntity tk"),
	@NamedQuery(name = "TaiKhoanEntity.getTKByTenTK", query = "SELECT tk FROM TaiKhoanEntity tk WHERE tk.tenTaiKhoan = :tenTaiKhoan")
})
public class TaiKhoanEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7617207203593199672L;
	@Id
	private String tenTaiKhoan;
	
	private String matKhau;
	private LocalDateTime thoiGianDNGN;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "nvarchar(255)")
	private TinhTrangTKEnum tinhTrang;
	
	
	@OneToOne
	@JoinColumn(name = "maNV")
	private NhanVienEntity nhanVien;

	public LocalDateTime getThoiGianDNGN() {
		return thoiGianDNGN;
	}

	public void setThoiGianDNGN(LocalDateTime thoiGianDNGN) {
		this.thoiGianDNGN = thoiGianDNGN;
	}

	public TinhTrangTKEnum getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(TinhTrangTKEnum tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public TaiKhoanEntity(String tenTaiKhoan, String matKhau, LocalDateTime thoiGianDNGN, TinhTrangTKEnum tinhTrang) {
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.thoiGianDNGN = thoiGianDNGN;
		this.tinhTrang = tinhTrang;
	}

	public TaiKhoanEntity(String tenTaiKhoan, String matKhau) {
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
	}

	public TaiKhoanEntity() {
		super();
	}

	public TaiKhoanEntity(String tenTaiKhoan, String matKhau, LocalDateTime thoiGianDNGN, TinhTrangTKEnum tinhTrang,
			NhanVienEntity nhanVien) {
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.thoiGianDNGN = thoiGianDNGN;
		this.tinhTrang = tinhTrang;
		this.nhanVien = nhanVien;
	}

	public NhanVienEntity getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVienEntity nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	@Override
	public String toString() {
		return "TaiKhoanEntity [tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + "]";
	}

	@Override
	public int hashCode() {
		int hash = 7;
		return hash;
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
		final TaiKhoanEntity other = (TaiKhoanEntity) obj;
		return Objects.equals(this.tenTaiKhoan, other.tenTaiKhoan);
	}

}
