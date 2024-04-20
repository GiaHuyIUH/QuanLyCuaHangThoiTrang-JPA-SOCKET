/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import Interface.ThuongHieu_Interface;
import dao.ThuongHieu_dao;
import entity.ThuongHieuEntity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public class ThuongHieu_bus extends UnicastRemoteObject implements ThuongHieu_Interface{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3858007281177248790L;
	ThuongHieu_dao th_dao;

	public ThuongHieu_bus() throws RemoteException {
		super();
		th_dao = new ThuongHieu_dao();
	}
    @Override
    public ArrayList<ThuongHieuEntity> getAllTH()throws RemoteException {
        return th_dao.getAllTH();
    }

    @Override
    public String layTenThuongHieuTheoMa(String maThuongHieu)throws RemoteException {
        return th_dao.layTenThuongHieuTheoMa(maThuongHieu);
    }

    @Override
    public String layMaThuongHieuTheoTen(String tenThuongHieu)throws RemoteException {
        return th_dao.layMaThuongHieuTheoTen(tenThuongHieu);
    }
    
}
