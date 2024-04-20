/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import entity.ChiTietDoiTraEntity;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Huy Hoang
 */
public interface ChiTietDoiTra_Interface extends Remote {
    public boolean themChiTietDoiTra(ChiTietDoiTraEntity ctdt) throws RemoteException;
    public ArrayList<ChiTietDoiTraEntity> getAllCTDTTheoMaDT(String ma)throws RemoteException;
}
