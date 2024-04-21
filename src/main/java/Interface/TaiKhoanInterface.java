/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import entity.TaiKhoanEntity;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author HUY
 */
public interface TaiKhoanInterface extends Remote {
    public boolean insert(TaiKhoanEntity tk)throws RemoteException;
    public boolean update(TaiKhoanEntity tk)throws RemoteException;
    public boolean delete(TaiKhoanEntity tk)throws RemoteException;
    public TaiKhoanEntity findOne(String tenTK)throws RemoteException;
    public ArrayList<TaiKhoanEntity> findAll()throws RemoteException;
    public boolean thoiGianDNGN(TaiKhoanEntity tk)throws RemoteException;
    public TaiKhoanEntity getTaiKhoan(String taiKhoan, String matKhau) throws RemoteException ;
}
