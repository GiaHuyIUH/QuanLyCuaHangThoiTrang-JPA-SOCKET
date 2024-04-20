
package bus;

import Interface.HoaDon_Interface;
import dao.HoaDon_dao;
import entity.ChiTietHoaDonEntity;
import entity.HoaDonEntity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class HoaDon_bus extends UnicastRemoteObject implements HoaDon_Interface{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 3118615656942451625L;
	private HoaDon_dao hd_dao ;

	public HoaDon_bus() throws RemoteException {
		super();
		hd_dao = new HoaDon_dao();
	}
    @Override
    public ArrayList<HoaDonEntity> getallHoaDon()throws RemoteException {
       return hd_dao.getallHoaDon();
    }

    @Override
    public double getTotalMoney(String maHD) throws RemoteException{
        return hd_dao.getTotalMoney(maHD);
    }

    @Override
    public boolean themHoaDon(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD)throws RemoteException {
        return hd_dao.themHoaDon(hoaDon, danhSachCTHD);
    }

    @Override
    public HoaDonEntity getHoaDonTheoMaHD(String maHD)throws RemoteException {
        return hd_dao.getHoaDonTheoMaHD(maHD);
    }

    @Override
    public ArrayList<HoaDonEntity> getHoaDonTheoNgayLap(java.sql.Date ngayLap) throws RemoteException{
       return hd_dao.getHoaDonTheoNgayLap(ngayLap);
    }

    @Override
    public HoaDonEntity timKiemHoaDonTheoMa(String maHD)throws RemoteException {
        return hd_dao.timKiemHoaDonTheoMa(maHD);
    }

    @Override
    public boolean luuTamHoaDon(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD) throws RemoteException{
        return hd_dao.luuTamHoaDon(hoaDon, danhSachCTHD);
    }

    @Override
    public ArrayList<HoaDonEntity> timKiemHoaDonChuaThanhToan(String sdt) throws RemoteException{
        return hd_dao.timKiemHoaDonChuaThanhToan(sdt);
    }

    @Override
    public int getSoLuongTonTheoMa(String maSP) throws RemoteException{
        return hd_dao.getSoLuongTonTheoMa(maSP);
    }

    @Override
    public boolean themHoaDonLuuTam(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD) throws RemoteException{
        return hd_dao.themHoaDonLuuTam(hoaDon, danhSachCTHD);
    }

    @Override
    public ArrayList<HoaDonEntity> getAllHDChuaThanhToan()throws RemoteException {
        return hd_dao.getAllHDChuaThanhToan();
    }

    @Override
    public boolean capNhatHoaDonLuuTam(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD) throws RemoteException{
        return hd_dao.capNhatHoaDonLuuTam(hoaDon, danhSachCTHD);
    }

    @Override
    public ArrayList<HoaDonEntity> getHoaDonTheoMaHDvaNgayLap(String maHD, Date ngayLap)throws RemoteException {
        return hd_dao.getHoaDonTheoMaHDvaNgayLap(maHD, ngayLap);
    }
    
}
