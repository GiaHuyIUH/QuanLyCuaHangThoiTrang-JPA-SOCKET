
package dao;

import entity.ChiTietHoaDonEntity;
import entity.HoaDonEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Huy
 */
public interface HoaDon_Interface {
    public List<HoaDonEntity> getallHoaDon();
    public double getTotalMoney(String maHD);
    public HoaDonEntity getHoaDonTheoMaHD(String maHD);
    public ArrayList<HoaDonEntity> getHoaDonTheoNgayLap(java.sql.Date ngayLap);
    public ArrayList<HoaDonEntity> getHoaDonTheoMaHDvaNgayLap(String maHD,Date ngayLap);
    
    public boolean themHoaDon(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD);
    public boolean luuTamHoaDon(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD);
    public boolean capNhatHoaDonLuuTam(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD);
    public boolean themHoaDonLuuTam(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD);
    public HoaDonEntity timKiemHoaDonTheoMa(String maHD);
    public ArrayList<HoaDonEntity> timKiemHoaDonChuaThanhToan(String sdt);
    public int getSoLuongTonTheoMa(String maSP);
    public ArrayList<HoaDonEntity> getAllHDChuaThanhToan();
}
