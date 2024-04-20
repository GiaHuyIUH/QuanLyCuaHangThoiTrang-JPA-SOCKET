/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import Interface.MatHangNhap_Interface;
import dao.MatHangNhap_dao;
import entity.MatHangNhapEntity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public class MatHangNhap_bus extends UnicastRemoteObject implements MatHangNhap_Interface{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1167898117083455639L;
	MatHangNhap_dao mhn_dao;

	public MatHangNhap_bus() throws RemoteException {
		mhn_dao=new MatHangNhap_dao() ;
	}
    @Override
    public ArrayList<MatHangNhapEntity> getAllMatHangNhap() throws RemoteException{
        return mhn_dao.getAllMatHangNhap();
    }

    @Override
    public boolean nhapHang(MatHangNhapEntity mhn)throws RemoteException {
        return mhn_dao.nhapHang(mhn);
    }

    @Override
    public ArrayList<MatHangNhapEntity> timKiemMHN(LocalDate ngayNhap) throws RemoteException{
        return mhn_dao.timKiemMHN(ngayNhap);
    }

    @Override
    public boolean capNhapMatHangNhap(MatHangNhapEntity mhm) throws RemoteException{
        return mhn_dao.capNhapMatHangNhap(mhm);
    }  

    @Override
    public boolean kiemTraMaMatHangNhapTonTai(String maMHN)throws RemoteException {
        return mhn_dao.kiemTraMaMatHangNhapTonTai(maMHN);
    }
    
}
