/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import Interface.ChuongTrinhKhuyenMai_Interface;
import dao.ChuongTrinhKhuyenMai_dao;
import entity.ChuongTrinhKhuyenMaiEntity;
import entity.LoaiKhuyenMaiEntity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ChuongTrinhKhuyenMai_bus extends UnicastRemoteObject implements ChuongTrinhKhuyenMai_Interface{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8076479216446107287L;
	ChuongTrinhKhuyenMai_dao ctkm_dao;

	public ChuongTrinhKhuyenMai_bus() throws RemoteException {
		ctkm_dao = new ChuongTrinhKhuyenMai_dao();
	}
    @Override
    public ArrayList<ChuongTrinhKhuyenMaiEntity> getallCTKM()throws RemoteException {
       return ctkm_dao.getallCTKM();
    }

    @Override
    public ArrayList<ChuongTrinhKhuyenMaiEntity> getCTKMTheoMaCTKM(String maCTKM, String maLoai)throws RemoteException {
       return ctkm_dao.getCTKMTheoMaCTKM(maCTKM,maLoai);
    }

    @Override
    public boolean create(ChuongTrinhKhuyenMaiEntity ctkm)throws RemoteException {
        return ctkm_dao.create(ctkm);
    }

    @Override
    public boolean delete(ChuongTrinhKhuyenMaiEntity ctkm) throws RemoteException{
       return ctkm_dao.delete(ctkm);
    }

    @Override
    public boolean update(ChuongTrinhKhuyenMaiEntity ctkm)throws RemoteException {
       return ctkm_dao.update(ctkm);
    }

    @Override
    public ChuongTrinhKhuyenMaiEntity kiemTraKhuyenMai(double tongTien)throws RemoteException {
       return ctkm_dao.kiemTraKhuyenMai(tongTien);
    }

    @Override
    public ArrayList<LoaiKhuyenMaiEntity> getallLoaiCTKM()throws RemoteException {
        return ctkm_dao.getallLoaiCTKM();

 
    }

    @Override
    public ArrayList<ChuongTrinhKhuyenMaiEntity> getallCTKMtheoLoaiKM(String ma)throws RemoteException {
       return ctkm_dao.getallCTKMtheoLoaiKM(ma);
    }

    @Override
    public String layTenKhuyenMaiTheoMa(String maKhuyenMai)throws RemoteException {
        return ctkm_dao.layTenKhuyenMaiTheoMa(maKhuyenMai);
    }

    @Override
    public String layMaKhuyenMaiTheoTen(String tenKhuyenMai)throws RemoteException {
        return ctkm_dao.layMaKhuyenMaiTheoTen(tenKhuyenMai);
    }

    @Override
    public ChuongTrinhKhuyenMaiEntity getKMTheoma(String ma) throws RemoteException{
        return ctkm_dao.getKMTheoma(ma);
    }

    @Override
    public ArrayList<ChuongTrinhKhuyenMaiEntity> getAllCTKMTheoLoaiKMVaTinhTrang(String loaiKM, String tinhTrang)throws RemoteException {
        return ctkm_dao.getAllCTKMTheoLoaiKMVaTinhTrang(loaiKM, tinhTrang);
    }

    @Override
    public ChuongTrinhKhuyenMaiEntity getKMTheomaHD(String maHD) throws RemoteException{
       return ctkm_dao.getKMTheomaHD(maHD);
    }
}
