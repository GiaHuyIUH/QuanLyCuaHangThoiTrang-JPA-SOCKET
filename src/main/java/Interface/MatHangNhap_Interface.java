/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import entity.MatHangNhapEntity;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public interface MatHangNhap_Interface extends java.rmi.Remote {

    public ArrayList<MatHangNhapEntity> getAllMatHangNhap() throws RemoteException;

    public boolean nhapHang(MatHangNhapEntity mhn)throws RemoteException;

    public ArrayList<MatHangNhapEntity> timKiemMHN(LocalDate ngayNhap)throws RemoteException;

    public boolean capNhapMatHangNhap(MatHangNhapEntity mhn)throws RemoteException;

    public boolean kiemTraMaMatHangNhapTonTai(String maMHN)throws RemoteException;
}
