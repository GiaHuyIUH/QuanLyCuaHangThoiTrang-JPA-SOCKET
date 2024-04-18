/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import Interface.SanPham_Interface;
import dao.SanPham_dao;
import entity.SanPhamEntity;
import entity.TinhTrangSPEnum;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public class SanPham_bus extends UnicastRemoteObject implements SanPham_Interface{
    SanPham_dao sp_dao;
    
	public SanPham_bus() throws RemoteException{
		sp_dao =new SanPham_dao();
		
	}
	
    @Override
    public ArrayList<SanPhamEntity> getAllSanPham() throws RemoteException{
        return sp_dao.getAllSanPham();
    }

    @Override
    public boolean themSP(SanPhamEntity sp) throws RemoteException{
        return sp_dao.themSP(sp);
    }

    @Override
    public ArrayList<SanPhamEntity> timSanPham(String ma) throws RemoteException{
        return sp_dao.timSanPham(ma);
    }

    @Override
    public boolean capNhatSanPham(SanPhamEntity sp) throws RemoteException{
        return sp_dao.capNhatSanPham(sp);
    }

    @Override
    public ArrayList<SanPhamEntity> kiemTraTonKho() throws RemoteException{
        return sp_dao.kiemTraTonKho();
    }

    @Override
    public SanPhamEntity timKiemSanPham(String ma) throws RemoteException{
        return sp_dao.timKiemSanPham(ma);
    }
    @Override
    public int laySoLuongTonKhoTheoMaSP(String maSP)throws RemoteException {
        return sp_dao.laySoLuongTonKhoTheoMaSP(maSP);
    }

    @Override
    public boolean capNhatSoLuong(String maSP, int soLuongNhap)throws RemoteException {
        return sp_dao.capNhatSoLuong(maSP, soLuongNhap);
    }

    @Override
    public boolean kiemTraMaSanPhamTonTai(String maSP)throws RemoteException {
        return sp_dao.kiemTraMaSanPhamTonTai(maSP);
    }

    @Override
    public boolean capNhatSoLuongTonSauKhiTaoHD(String maSP, int soLuong)throws RemoteException {
        return sp_dao.capNhatSoLuongTonSauKhiTaoHD(maSP, soLuong);
    }

    @Override
    public void capNhatKhuyenMai() throws RemoteException{
        sp_dao.capNhatKhuyenMai();
    }

    @Override
    public void capNhatTinhTrang(String maSP, TinhTrangSPEnum tinhTrangDangBan)throws RemoteException {
        sp_dao.capNhatTinhTrang(maSP, tinhTrangDangBan);
    }
    
}
