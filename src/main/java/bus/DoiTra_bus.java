/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import Interface.DoiTra_Interface;
import dao.DoiTra_dao;
import entity.ChiTietDoiTraEntity;
import entity.DoiTraEntity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DoiTra_bus extends UnicastRemoteObject implements DoiTra_Interface{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8621739996868258611L;
	private DoiTra_dao dt_dao;

	public DoiTra_bus() throws RemoteException {
		super();
		dt_dao = new DoiTra_dao();
	}
    
    @Override
    public boolean taoDoiTra(DoiTraEntity dt, ArrayList<ChiTietDoiTraEntity> ctdtList)throws RemoteException {
        return dt_dao.taoDoiTra(dt, ctdtList);
    }

    @Override
    public ArrayList<DoiTraEntity> getAllDoiTra()throws RemoteException {
        return dt_dao.getAllDoiTra();
    }

    @Override
    public DoiTraEntity getDoiTraTheoMa(String ma)throws RemoteException {
        return dt_dao.getDoiTraTheoMa(ma);
    }

    @Override
    public ArrayList<DoiTraEntity> getDoiTraTheoNgayLap(Date ngayLap)throws RemoteException {
        return dt_dao.getDoiTraTheoNgayLap(ngayLap);
    }

    @Override
    public DoiTraEntity getDoiTraTheoDieuKien(String ma, Date ngayLap)throws RemoteException {
        return dt_dao.getDoiTraTheoDieuKien(ma, ngayLap);
    }

    @Override
    public Long getTongSoLuongSPDoiTra(String maHD, String maSP)throws RemoteException {
        return (Long) dt_dao.getTongSoLuongSPDoiTra(maHD, maSP);
    }

    @Override
    public boolean kiemTraThoiHanDoiTra(String maHD) throws RemoteException{
        return dt_dao.kiemTraThoiHanDoiTra(maHD);
    }
    
}
