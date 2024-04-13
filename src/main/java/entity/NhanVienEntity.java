package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class NhanVienEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7564071463227667131L;
	@Id
	private String maNV;
	
	private String hoTen;
	@Enumerated(EnumType.STRING)
	private GioiTinhEnum gioiTinh;
	private LocalDate ngaySinh;
	private String email;
	private String soDienThoai;
	private String diaChi;
	@Enumerated(EnumType.STRING)
	private ChucVuEnum chucVu;
	@Enumerated(EnumType.STRING)
	private TinhTrangNVEnum tinhTrang;
	@Enumerated(EnumType.STRING)
	private CaLamViecEnum caLamViec;
	
        
	public NhanVienEntity(String maNV, String hoTen, GioiTinhEnum gioiTinh, LocalDate ngaySinh, String email,
			String soDienThoai, String diaChi, ChucVuEnum chucVu, TinhTrangNVEnum tinhTrang, CaLamViecEnum caLamViec) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
		this.tinhTrang = tinhTrang;
		this.caLamViec = caLamViec;
	}
	public NhanVienEntity(String maNV) {
		super();
		this.maNV = maNV;
	}
	public NhanVienEntity() {
		super();
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public GioiTinhEnum getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(GioiTinhEnum gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public ChucVuEnum getChucVu() {
		return chucVu;
	}
	public void setChucVu(ChucVuEnum chucVu) {
		this.chucVu = chucVu;
	}
	public TinhTrangNVEnum getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(TinhTrangNVEnum tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public CaLamViecEnum getCaLamViec() {
		return caLamViec;
	}
	public void setCaLamViec(CaLamViecEnum caLamViec) {
		this.caLamViec = caLamViec;
	}

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 79 * hash + Objects.hashCode(this.maNV);
            hash = 79 * hash + Objects.hashCode(this.soDienThoai);
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
            final NhanVienEntity other = (NhanVienEntity) obj;
            
            return Objects.equals(this.soDienThoai, other.soDienThoai);
        }
	
        public static int getAge(Date currentDate, Date birthDate) {
            Calendar calendarCurrent = Calendar.getInstance();
            calendarCurrent.setTime(currentDate);

            Calendar calendarBirth = Calendar.getInstance();
            calendarBirth.setTime(birthDate);

            int years = calendarCurrent.get(Calendar.YEAR) - calendarBirth.get(Calendar.YEAR);

            // Check if the birthdate has occurred this year
            if (calendarBirth.get(Calendar.MONTH) > calendarCurrent.get(Calendar.MONTH)
                    || (calendarBirth.get(Calendar.MONTH) == calendarCurrent.get(Calendar.MONTH)
                    && calendarBirth.get(Calendar.DAY_OF_MONTH) > calendarCurrent.get(Calendar.DAY_OF_MONTH))) {
                years--;
            }

            return years;
    }
}
