package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode
@NamedQueries({
	@NamedQuery(name = "ChuongTrinhKhuyenMaiEntity.getAllCTKM", query = "SELECT ctkm FROM ChuongTrinhKhuyenMaiEntity ctkm"),
	@NamedQuery(name = "ChuongTrinhKhuyenMaiEntity.getCTKMTheoMaCTKMAndMaLoaiCTKM", query = "SELECT ctkm FROM ChuongTrinhKhuyenMaiEntity ctkm WHERE ctkm.maCTKM = :maCTKM AND ctkm.maLoaiKM.maLoaiKM = :maLoaiKM"),
//	@NamedQuery(name = "ChuongTrinhKhuyenMaiEntity.getallLoaiCTKM", query = "SELECT LoaiCTKM FROM LoaiKhuyenMaiEntity LoaiCTKM"),
//	Select top 1 * from ChuongTrinhKhuyenMai where getdate() between ngayBatDau and ngayKetThuc and soTienToiThieu <= ? and maLoaiCTKM='GGHD' order by giamGia desc
	@NamedQuery(name = "ChuongTrinhKhuyenMaiEntity.kiemTraKhuyenMai", query = "SELECT c FROM ChuongTrinhKhuyenMaiEntity c WHERE :currentDate BETWEEN c.ngayBatDau AND c.ngayKetThuc AND c.soTienToiThieu <= :soTienToiThieu AND c.maLoaiKM.maLoaiKM = 'GGHD'  ORDER BY c.giamGia DESC"),
	@NamedQuery(name = "ChuongTrinhKhuyenMaiEntity.getallCTKMtheoLoaiKM", query = "SELECT ctkm FROM ChuongTrinhKhuyenMaiEntity ctkm WHERE ctkm.maLoaiKM.maLoaiKM = :maLoaiKM"),
	@NamedQuery(name = "ChuongTrinhKhuyenMaiEntity.layTenKhuyenMaiTheoMa", query = "SELECT ctkm.tenCTKM FROM ChuongTrinhKhuyenMaiEntity ctkm WHERE ctkm.maCTKM = :maCTKM"),
	@NamedQuery(name = "ChuongTrinhKhuyenMaiEntity.layMaKhuyenMaiTheoTen", query = "SELECT ctkm.maCTKM FROM ChuongTrinhKhuyenMaiEntity ctkm WHERE ctkm.tenCTKM = :tenCTKM"),
	@NamedQuery(name = "ChuongTrinhKhuyenMaiEntity.getAllCTKMTheoLoaiKMVaTinhTrang", query = "SELECT ctkm FROM ChuongTrinhKhuyenMaiEntity ctkm WHERE ctkm.maLoaiKM.maLoaiKM = :maLoaiKM AND ctkm.tinhTrang = :tinhTrang"),
//	select * from ChuongTrinhKhuyenMai where maCTKM in(select maCTKM from HoaDon where maHD = ?)
	@NamedQuery(name = "ChuongTrinhKhuyenMaiEntity.getKMTheomaHD", query = "SELECT ctkm FROM ChuongTrinhKhuyenMaiEntity ctkm WHERE ctkm.maCTKM IN (SELECT hd.chuongTrinhKM.maCTKM FROM HoaDonEntity hd WHERE hd.maHD = :maHD)"),
})
public class ChuongTrinhKhuyenMaiEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2498963444851670544L;

	@Id
	@Column(name = "maCTKM", columnDefinition = "nvarchar(255)")
	private String maCTKM;

	@Column(name = "tenCTKM", columnDefinition = "nvarchar(255)")
	private String tenCTKM;
	@ManyToOne
	@JoinColumn(name = "maLoaiKM")
	private LoaiKhuyenMaiEntity maLoaiKM;
	
	@OneToMany(mappedBy = "chuongTrinhKM")
	private List<HoaDonEntity> hoaDon;

	private double soTienToiThieu;
	private double soTienToiDa;
	private int giamGia;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	@Column(name = "tinhTrang", columnDefinition = "nvarchar(255)")
	private String tinhTrang;

// Đinh Nguyên Chung

	public ChuongTrinhKhuyenMaiEntity(String maCTKM, String tenCTKM, LoaiKhuyenMaiEntity maLoaiKM,
			double soTienToiThieu, double soTienToiDa, int giamGia, Date ngayBatDau, Date ngayKetThuc,
			String tinhTrang) {
		this.maCTKM = maCTKM;
		this.tenCTKM = tenCTKM;
		this.maLoaiKM = maLoaiKM;
		this.soTienToiThieu = soTienToiThieu;
		this.soTienToiDa = soTienToiDa;
		this.giamGia = giamGia;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.tinhTrang = tinhTrang;
	}

	public LoaiKhuyenMaiEntity getMaLoaiKM() {
		return maLoaiKM;
	}

	public void setMaLoaiKM(LoaiKhuyenMaiEntity maLoaiKM) {
		this.maLoaiKM = maLoaiKM;
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
