/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import Interface.NhaCungCap_Interface;
import dao.NhaCungCap_dao;
import entity.NhaCungCapEntity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public class NhaCungCap_bus extends UnicastRemoteObject implements NhaCungCap_Interface{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5423547276059170908L;
	NhaCungCap_dao ncc_dao;

	public NhaCungCap_bus() throws RemoteException {
		super();
		ncc_dao=new NhaCungCap_dao();
	}
    @Override
    public ArrayList<NhaCungCapEntity> getAllNhaCungCap() throws RemoteException{
        return ncc_dao.getAllNhaCungCap();
    }

    @Override
    public boolean themNCC(NhaCungCapEntity ncc) throws RemoteException{
        return ncc_dao.themNCC(ncc);
    }

    @Override
    public ArrayList<NhaCungCapEntity> timKiemNCC(String ma)throws RemoteException {
        return ncc_dao.timKiemNCC(ma);
    }

    @Override
    public boolean capNhatNhaCungCap(NhaCungCapEntity maNCC) throws RemoteException{
        return ncc_dao.capNhatNhaCungCap(maNCC);
    }

    @Override
    public ArrayList<NhaCungCapEntity> layDSNCCDangNhap()throws RemoteException {
        return ncc_dao.layDSNCCDangNhap();
    }

    @Override
    public String layTenNhaCungCapTheoMa(String maNhaCungCap)throws RemoteException {
        return ncc_dao.layTenNhaCungCapTheoMa(maNhaCungCap);
    }

    @Override
    public String layMaNhaCungCapTheoTen(String tenNhaCungCap)throws RemoteException {
        return ncc_dao.layMaNhaCungCapTheoTen(tenNhaCungCap);
    }
    
}
