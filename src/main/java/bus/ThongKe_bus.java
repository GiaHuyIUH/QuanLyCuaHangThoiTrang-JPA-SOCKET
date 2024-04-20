package bus;

import Interface.ThongKe_Interface;
import dao.ThongKe_dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ThongKe_bus extends UnicastRemoteObject implements ThongKe_Interface {

    /**
	 * 
	 */
	private static final long serialVersionUID = 769197123904899375L;
	ThongKe_dao tk_dao;

	public ThongKe_bus() throws RemoteException {
		super();
		 tk_dao = new ThongKe_dao();
	}

    @Override
    public ArrayList<Object[]> getListThongKeDoanhThu() throws RemoteException {
        return tk_dao.getListThongKeDoanhThu();
    }

    @Override
    public ArrayList<Object[]> getListThongKeDoanhSo() throws RemoteException {
        return tk_dao.getListThongKeDoanhSo();
    }

    @Override
    public ArrayList<Object[]> getListDoanhThuTheoThangvaNam(String thang, String nam)throws RemoteException  {
        return tk_dao.getListDoanhThuTheoThangvaNam(thang, nam);
    }

    @Override
    public ArrayList<Object[]> getListDoanhThuTrongNam(String nam)throws RemoteException  {
        return tk_dao.getListDoanhThuTrongNam(nam);
    }

    @Override
    public ArrayList<Object[]> getListThongKeDoanhSoTheoThangNam(String thangNam, String sort)throws RemoteException  {
        return tk_dao.getListThongKeDoanhSoTheoThangNam(thangNam, sort);
    }

    @Override
    public ArrayList<Object[]> getListTop5NhanVienDoanhThuCaoNhat(String thang, String nam)throws RemoteException  {
        return tk_dao.getListTop5NhanVienDoanhThuCaoNhat(thang, nam);
    }

    @Override
    public ArrayList<Object[]> getListTop5KhachHangMuaHangNhieuNhat(String thang, String nam)throws RemoteException  {
        return tk_dao.getListTop5KhachHangMuaHangNhieuNhat(thang, nam);
    }

    @Override
    public ArrayList<Object[]> getListThongKeDoanhSoTheoNam(String Nam, String sort) throws RemoteException {
        return tk_dao.getListThongKeDoanhSoTheoNam(Nam, sort);
    }

    @Override
    public ArrayList<Object[]> getListDoanhThuBySort(String thang, String nam)throws RemoteException  {
        return tk_dao.getListDoanhThuBySort(thang, nam);
    }
}
