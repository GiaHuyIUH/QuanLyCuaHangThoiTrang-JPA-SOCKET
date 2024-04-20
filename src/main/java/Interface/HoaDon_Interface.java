
package Interface;

import entity.ChiTietHoaDonEntity;
import entity.HoaDonEntity;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author DELL
 */
public interface HoaDon_Interface extends java.rmi.Remote {
    //Đinh Nguyên Chung
    public ArrayList<HoaDonEntity> getallHoaDon()throws RemoteException;
    public double getTotalMoney(String maHD)throws RemoteException;
    public HoaDonEntity getHoaDonTheoMaHD(String maHD)throws RemoteException;
    public ArrayList<HoaDonEntity> getHoaDonTheoNgayLap(java.sql.Date ngayLap)throws RemoteException;
    public ArrayList<HoaDonEntity> getHoaDonTheoMaHDvaNgayLap(String maHD,Date ngayLap)throws RemoteException;
    
    // Nguyen Huy Hoang
    public boolean themHoaDon(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD)throws RemoteException;
    public boolean luuTamHoaDon(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD)throws RemoteException;
    public boolean capNhatHoaDonLuuTam(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD)throws RemoteException;
    public boolean themHoaDonLuuTam(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD)throws RemoteException;
    public HoaDonEntity timKiemHoaDonTheoMa(String maHD)throws RemoteException;
    public ArrayList<HoaDonEntity> timKiemHoaDonChuaThanhToan(String sdt)throws RemoteException;
    public int getSoLuongTonTheoMa(String maSP)throws RemoteException;
    public ArrayList<HoaDonEntity> getAllHDChuaThanhToan()throws RemoteException;
}
