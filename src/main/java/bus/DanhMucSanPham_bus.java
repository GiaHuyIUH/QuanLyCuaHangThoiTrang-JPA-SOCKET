/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import Interface.DanhMucSanPham_Interface;
import dao.DanhMucSanPham_dao;
import entity.DanhMucSanPhamEntity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public class DanhMucSanPham_bus extends UnicastRemoteObject implements DanhMucSanPham_Interface{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3306035117812713001L;
	DanhMucSanPham_dao dmsp_dao;
	public DanhMucSanPham_bus() throws RemoteException {
		dmsp_dao=new DanhMucSanPham_dao();
	}
    @Override
    public ArrayList<DanhMucSanPhamEntity> getAllDMSP()throws RemoteException {
        return dmsp_dao.getAllDMSP();
    }

    @Override
    public String layTenDanhMucTheoMa(String maDanhMuc) throws RemoteException{
        return dmsp_dao.layTenDanhMucTheoMa(maDanhMuc);
    }

    @Override
    public String layMaDanhMucTheoTen(String tenDanhMuc)throws RemoteException {
        return dmsp_dao.layMaDanhMucTheoTen(tenDanhMuc);
    }
    
}
