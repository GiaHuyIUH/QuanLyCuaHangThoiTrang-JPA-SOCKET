/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import Interface.TaiKhoanInterface;
import dao.TaiKhoan_dao;
import entity.TaiKhoanEntity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author HUY
 */
public class TaiKhoan_bus extends UnicastRemoteObject implements TaiKhoanInterface{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8927312745547418480L;
	private  TaiKhoan_dao dao;
    
    public TaiKhoan_bus() throws RemoteException {
        dao = new TaiKhoan_dao();
    }
    
    @Override
    public boolean insert(TaiKhoanEntity tk) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(TaiKhoanEntity tk)throws RemoteException {
        return dao.update(tk);
    }

    @Override
    public boolean delete(TaiKhoanEntity tk)throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TaiKhoanEntity findOne(String tenTK)throws RemoteException {
        return dao.findOne(tenTK);
    }

    @Override
    public ArrayList<TaiKhoanEntity> findAll()throws RemoteException {
        return dao.findAll();
    }

    @Override
    public boolean thoiGianDNGN(TaiKhoanEntity tk)throws RemoteException {
        return dao.thoiGianDNGN(tk);// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

	@Override
	public TaiKhoanEntity getTaiKhoan(String taiKhoan, String matKhau) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.getTaiKhoan(taiKhoan, matKhau);
	}

	@Override
	public boolean lamMoiMatKhau(TaiKhoanEntity tk) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.lamMoiMatKhau(tk);
	}
    
    
    
}
