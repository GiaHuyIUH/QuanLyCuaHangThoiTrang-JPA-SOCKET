/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import entity.ChiTietDoiTraEntity;
import entity.DoiTraEntity;
import java.util.ArrayList;
import java.rmi.RemoteException;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public interface DoiTra_Interface extends java.rmi.Remote{
    public boolean taoDoiTra(DoiTraEntity dt, ArrayList<ChiTietDoiTraEntity> ctdtList) throws java.rmi.RemoteException;
    public ArrayList<DoiTraEntity> getAllDoiTra() throws RemoteException;
    public DoiTraEntity getDoiTraTheoMa(String ma)throws RemoteException;
    public ArrayList<DoiTraEntity> getDoiTraTheoNgayLap(Date ngayLap)throws RemoteException;
    public DoiTraEntity getDoiTraTheoDieuKien(String ma, Date ngayLap)throws RemoteException;
    public Long getTongSoLuongSPDoiTra(String maHD, String maSP)throws RemoteException;
    public boolean kiemTraThoiHanDoiTra(String maHD)throws RemoteException;
}
