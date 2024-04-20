
package bus;

import Interface.ChiTietHoaDon_Interface;
import dao.ChiTietHoaDon_dao;
import entity.ChiTietHoaDonEntity;
import entity.SanPhamEntity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ChiTietHoaDon_bus extends UnicastRemoteObject implements ChiTietHoaDon_Interface{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1110775337632763364L;
	ChiTietHoaDon_dao cthd_dao;
	public ChiTietHoaDon_bus() throws RemoteException{
        cthd_dao = new ChiTietHoaDon_dao();
    }
//    ChiTietHoaDon_dao cthd_dao = new ChiTietHoaDon_dao() throws RemoteException;
    @Override
    public ArrayList<ChiTietHoaDonEntity> getallCTHD() throws RemoteException{
        return cthd_dao.getallCTHD();
    }

    @Override
    public ArrayList<SanPhamEntity> getSanPhamTheoMaSP(String maSP) throws RemoteException{
        return cthd_dao.getSanPhamTheoMaSP(maSP);
    }

    @Override
    public ArrayList<SanPhamEntity> getSanPhamTheoMaHD(String maHD)throws RemoteException {
        return cthd_dao.getSanPhamTheoMaHD(maHD);
    }
    
    
    // Nguyen Huy Hoang
    @Override
    public boolean themChiTietHoaDon(ChiTietHoaDonEntity cthd)throws RemoteException {
        return cthd_dao.themChiTietHoaDon(cthd);
    }
    
    @Override
    public boolean xoaCTHDTheoMaHoaDon(String maHD) throws RemoteException{
        return cthd_dao.xoaCTHDTheoMaHoaDon(maHD);
    }

    @Override
    public int soluongSP(String maHD, String maSP) throws RemoteException{
        return cthd_dao.soluongSP(maHD, maSP);
    }

    @Override
    public ArrayList<ChiTietHoaDonEntity> getCTHDTheoMaHDvaMaSP(String maHD, String maSP) throws RemoteException{
        return cthd_dao.getCTHDTheoMaHDvaMaSP(maHD, maSP);
    }

    @Override
    public ArrayList<ChiTietHoaDonEntity> getAllCTHDTheoMaHD(String maHD)throws RemoteException {
        return cthd_dao.getAllCTHDTheoMaHD(maHD);
    }

    @Override
    public int getSoLuongCTHD(String maSP)throws RemoteException {
        return cthd_dao.getSoLuongCTHD(maSP);
    }
}
