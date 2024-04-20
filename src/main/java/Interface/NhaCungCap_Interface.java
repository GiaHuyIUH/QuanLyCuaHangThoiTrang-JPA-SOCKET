/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import entity.NhaCungCapEntity;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public interface NhaCungCap_Interface extends java.rmi.Remote {
    public ArrayList<NhaCungCapEntity> getAllNhaCungCap()throws RemoteException;
    public boolean themNCC(NhaCungCapEntity ncc)throws RemoteException;
    public ArrayList<NhaCungCapEntity> timKiemNCC(String ma)throws RemoteException;
    public boolean capNhatNhaCungCap(NhaCungCapEntity maNCC)throws RemoteException;
    public ArrayList<NhaCungCapEntity> layDSNCCDangNhap()throws RemoteException;
    public String layTenNhaCungCapTheoMa(String maNhaCungCap)throws RemoteException;
    public String layMaNhaCungCapTheoTen(String tenNhaCungCap)throws RemoteException;
}
