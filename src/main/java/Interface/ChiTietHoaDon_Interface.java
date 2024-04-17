
package Interface;

import entity.ChiTietHoaDonEntity;
import entity.SanPhamEntity;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface ChiTietHoaDon_Interface {
    public ArrayList<ChiTietHoaDonEntity> getallCTHD() throws RemoteException;
    public ArrayList<SanPhamEntity> getSanPhamTheoMaSP(String maSP)throws RemoteException; 
    public ArrayList<SanPhamEntity> getSanPhamTheoMaHD(String maHD)throws RemoteException;
    public int soluongSP(String maHD,String maSP)throws RemoteException;
    public ArrayList<ChiTietHoaDonEntity> getCTHDTheoMaHDvaMaSP(String maHD,String maSP)throws RemoteException;
    
    // Nguyen Huy Hoang
    public boolean themChiTietHoaDon(ChiTietHoaDonEntity cthd)throws RemoteException;
    public ArrayList<ChiTietHoaDonEntity> getAllCTHDTheoMaHD(String maHD)throws RemoteException;
    public boolean xoaCTHDTheoMaHoaDon(String maHD)throws RemoteException;
    public int getSoLuongCTHD(String maSP)throws RemoteException;
}
