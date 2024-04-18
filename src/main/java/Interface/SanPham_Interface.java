/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import entity.SanPhamEntity;
import entity.TinhTrangSPEnum;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public interface SanPham_Interface {

    public ArrayList<SanPhamEntity> getAllSanPham()throws RemoteException;

    public boolean themSP(SanPhamEntity sp)throws RemoteException;

    public ArrayList<SanPhamEntity> timSanPham(String ma)throws RemoteException;

    public boolean capNhatSanPham(SanPhamEntity sp)throws RemoteException;

    public ArrayList<SanPhamEntity> kiemTraTonKho()throws RemoteException;

    public int laySoLuongTonKhoTheoMaSP(String maSP)throws RemoteException;

    public boolean capNhatSoLuong(String maSP, int soLuongNhap)throws RemoteException;
    
    public boolean kiemTraMaSanPhamTonTai(String maSP)throws RemoteException;
    
    public void capNhatKhuyenMai()throws RemoteException;
    
    public void capNhatTinhTrang(String maSP, TinhTrangSPEnum tinhTrangDangBan)throws RemoteException;
    
    // Nguyen Huy Hoang
    public SanPhamEntity timKiemSanPham(String ma)throws RemoteException;
    public boolean capNhatSoLuongTonSauKhiTaoHD(String maSP, int soLuong)throws RemoteException;
}
