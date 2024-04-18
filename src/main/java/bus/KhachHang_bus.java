/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import dao.KhachHang_dao;
import entity.KhachHangEntity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import util.GenerateID;
import Interface.KhachHang_Interface;

/**
 *
 * @author HUY
 */
public class KhachHang_bus extends UnicastRemoteObject implements KhachHang_Interface {
    KhachHang_dao khachHangDAO;
    
	public KhachHang_bus() throws RemoteException {
		khachHangDAO = new KhachHang_dao();
	}
    
    @Override
    public KhachHangEntity findOne(String id)throws RemoteException {
        return khachHangDAO.findOne(id);
    	
    }

    @Override
    public boolean update(KhachHangEntity updateKH)throws RemoteException {
        return khachHangDAO.update(updateKH);
//    	return true;
    }

    @Override
    public boolean insert(KhachHangEntity insertKH)throws RemoteException {
//        insertKH.setMaKH(generateID.sinhMa(khachHangDAO.count(GenerateID.dateFormat()), "KH"));
        return khachHangDAO.insert(insertKH);
//    	return true;
    }

    @Override
    public ArrayList<KhachHangEntity> findAll() throws RemoteException{
        return khachHangDAO.findAll();
//    	return null;
    }

//    @Override
//    public int count(String id) {
//        return khachHangDAO.count(id);
//    }
    
    // Nguyen Huy Hoang
    @Override
    public KhachHangEntity timKiemTheoSDT(String sdt)throws RemoteException {
        return khachHangDAO.timKiemTheoSDT(sdt);
//    	return null;
    }

    @Override
    public KhachHangEntity getKHTheoMa(String ma) throws RemoteException{
       return khachHangDAO.getKHTheoMa(ma);
//    	return null;
    }
    
}
