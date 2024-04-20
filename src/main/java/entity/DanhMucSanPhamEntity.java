package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode
@NamedQueries({
	@NamedQuery(name = "DanhMucSanPhamEntity.getAllDanhMucSanPham", query = "SELECT dm FROM DanhMucSanPhamEntity dm"),
    @NamedQuery(name = "DanhMucSanPhamEntity.getTenDanhMucTheoMa", query = "SELECT dm.tenDanhMuc FROM DanhMucSanPhamEntity dm WHERE dm.maDanhMuc = :maDanhMuc"),
    @NamedQuery(name = "DanhMucSanPhamEntity.getMaDanhMucTheoTen", query = "SELECT dm.maDanhMuc FROM DanhMucSanPhamEntity dm WHERE dm.tenDanhMuc = :tenDanhMuc")

})
public class DanhMucSanPhamEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8000915183043346637L;
	@Id
	private String maDanhMuc;
	
	@Column(name = "tenDanhMuc", columnDefinition = "nvarchar(255)")
	private String tenDanhMuc;

	public DanhMucSanPhamEntity(String maDanhMuc, String tenDanhMuc) {
		super();
		this.maDanhMuc = maDanhMuc;
		this.tenDanhMuc = tenDanhMuc;
	}

	public DanhMucSanPhamEntity(String maDanhMuc) {
		super();
		this.maDanhMuc = maDanhMuc;
	}

	public DanhMucSanPhamEntity() {
		super();
	}

	public String getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDanhMuc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DanhMucSanPhamEntity other = (DanhMucSanPhamEntity) obj;
		return Objects.equals(maDanhMuc, other.maDanhMuc);
	}

	@Override
	public String toString() {
		return "DanhMucSanPhamEntity [maDanhMuc=" + maDanhMuc + ", tenDanhMuc=" + tenDanhMuc + "]";
	}
	
	
}	
