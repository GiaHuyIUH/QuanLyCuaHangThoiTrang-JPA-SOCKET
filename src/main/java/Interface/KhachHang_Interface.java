/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import entity.KhachHangEntity;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author HUY
 */ 
public interface KhachHang_Interface extends java.rmi.Remote {
    KhachHangEntity findOne(String id   )throws RemoteException;
    boolean update(KhachHangEntity updateKH)throws RemoteException;
    boolean insert(KhachHangEntity insertKH)throws RemoteException;
    ArrayList<KhachHangEntity> findAll()throws RemoteException;
//    int count(String id);
    
    // Nguyen Huy Hoang
    public KhachHangEntity timKiemTheoSDT(String sdt)throws RemoteException;
    // Đinh Nguyên Chung
    public KhachHangEntity getKHTheoMa(String ma)throws RemoteException;
}
