
package Interface;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ThongKe_Interface extends java.rmi.Remote {
    //Đinh Nguyên Chung
    public ArrayList<Object[]> getListThongKeDoanhThu()throws RemoteException;
    public ArrayList<Object[]> getListThongKeDoanhSo()throws RemoteException;
    public ArrayList<Object[]> getListDoanhThuTheoThangvaNam(String thang,String nam)throws RemoteException;
    public ArrayList<Object[]> getListDoanhThuTrongNam(String nam)throws RemoteException;
    public ArrayList<Object[]> getListThongKeDoanhSoTheoThangNam(String thangNam,String sort)throws RemoteException;
    public ArrayList<Object[]> getListTop5NhanVienDoanhThuCaoNhat(String thang, String nam)throws RemoteException;
    public ArrayList<Object[]> getListTop5KhachHangMuaHangNhieuNhat(String thang, String nam)throws RemoteException;
    public ArrayList<Object[]> getListThongKeDoanhSoTheoNam(String Nam,String sort) throws RemoteException;
    // Đinh Nguyên Chung
    public ArrayList<Object[]> getListDoanhThuBySort(String  thang, String nam)throws RemoteException;
}
