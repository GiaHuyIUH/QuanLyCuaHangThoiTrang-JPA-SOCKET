
package Interface;

import entity.ChuongTrinhKhuyenMaiEntity;
import entity.LoaiKhuyenMaiEntity;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface ChuongTrinhKhuyenMai_Interface {
    public ArrayList<ChuongTrinhKhuyenMaiEntity > getallCTKM()throws RemoteException;
    public ArrayList<ChuongTrinhKhuyenMaiEntity> getCTKMTheoMaCTKM(String maCTKM, String maLoai)throws RemoteException;
    public boolean create (ChuongTrinhKhuyenMaiEntity ctkm)throws RemoteException;
    public boolean delete (ChuongTrinhKhuyenMaiEntity ctkm)throws RemoteException;
    public boolean update (ChuongTrinhKhuyenMaiEntity ctkm)throws RemoteException;
    public ArrayList<LoaiKhuyenMaiEntity> getallLoaiCTKM()throws RemoteException ;
    public ArrayList<ChuongTrinhKhuyenMaiEntity> getallCTKMtheoLoaiKM(String ma)throws RemoteException;
    public ChuongTrinhKhuyenMaiEntity getKMTheoma(String ma)throws RemoteException;
    public ChuongTrinhKhuyenMaiEntity getKMTheomaHD(String maHD)throws RemoteException;
    
    // Nguyen Huy Hoang
    public ChuongTrinhKhuyenMaiEntity kiemTraKhuyenMai(double tongTien)throws RemoteException;
    public String layTenKhuyenMaiTheoMa(String maKhuyenMai)throws RemoteException;
    public String layMaKhuyenMaiTheoTen(String tenKhuyenMai)throws RemoteException;
    public ArrayList<ChuongTrinhKhuyenMaiEntity> getAllCTKMTheoLoaiKMVaTinhTrang(String loaiKM, String tinhTrang)throws RemoteException;
}
