/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import Interface.ChiTietDoiTra_Interface;
import dao.ChiTietDoiTra_dao;
import entity.ChiTietDoiTraEntity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Huy Hoang
 */
public class ChiTietDoiTra_bus extends UnicastRemoteObject implements ChiTietDoiTra_Interface{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2726851117561816316L;
	private ChiTietDoiTra_dao ctdt_dao ;

	public ChiTietDoiTra_bus() throws RemoteException {
		super();
		ctdt_dao = new ChiTietDoiTra_dao();
	}

    @Override
    public boolean themChiTietDoiTra(ChiTietDoiTraEntity ctdt) throws RemoteException{
        return ctdt_dao.themChiTietDoiTra(ctdt);
    }

    @Override
    public ArrayList<ChiTietDoiTraEntity> getAllCTDTTheoMaDT(String ma) throws RemoteException{
        return ctdt_dao.getAllCTDTTheoMaDT(ma);
    }
}
