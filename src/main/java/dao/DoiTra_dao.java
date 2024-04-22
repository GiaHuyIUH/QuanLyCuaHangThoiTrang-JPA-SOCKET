/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Interface.DoiTra_Interface;
import entity.ChiTietDoiTraEntity;
import entity.DoiTraEntity;
import entity.HinhThucDoiTraEnum;
import entity.HoaDonEntity;
import entity.KhachHangEntity;
import entity.NhanVienEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import util.ConvertStringToEnum;

/**
 *
 * @author Admin
 */
public class DoiTra_dao extends UnicastRemoteObject implements DoiTra_Interface{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3791296870487186517L;
	private ChiTietDoiTra_dao ctdt_dao;
    
    private EntityManager em;
    public DoiTra_dao() throws RemoteException{
    	ctdt_dao = new ChiTietDoiTra_dao();
    	em = jakarta.persistence.Persistence.createEntityManagerFactory("JPA MSSQL").createEntityManager();
    }
    
    @Override
    public boolean taoDoiTra(DoiTraEntity dt, ArrayList<ChiTietDoiTraEntity> ctdtList) {
       EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(dt);
			for (ChiTietDoiTraEntity ctdt : ctdtList) {
				em.persist(ctdt);
			}
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
    	
    }

    @Override
    public ArrayList<DoiTraEntity> getAllDoiTra() {
    	return (ArrayList<DoiTraEntity>) em.createNamedQuery("DoiTra.getAllDoiTra", DoiTraEntity.class).getResultList();
    }
    
    @Override
    public DoiTraEntity getDoiTraTheoMa(String ma) {
    	return em.find(DoiTraEntity.class, ma);
    }
    
    @Override
    public ArrayList<DoiTraEntity> getDoiTraTheoNgayLap(Date ngayLap) {
    	return (ArrayList<DoiTraEntity>) em.createNamedQuery("DoiTra.getDoiTraTheoNgayLap", DoiTraEntity.class)
				.setParameter("ngayLap", ngayLap).getResultList();
    }
    
    @Override
    public DoiTraEntity getDoiTraTheoDieuKien(String ma, Date ngayLap) {
    	return em.createNamedQuery("DoiTra.getDoiTraTheoDieuKien", DoiTraEntity.class).setParameter("ma", ma)
				.setParameter("ngayLap", ngayLap).getSingleResult();
    }

//    @Override
//    public Long getTongSoLuongSPDoiTra(String maHD, String maSP) {
//    	return em.createNamedQuery("DoiTra.getTongSoLuongSPDoiTra", Long.class).setParameter("maHD", maHD)
//				.setParameter("maSP", maSP).setParameter("hinhThucDoiTra", HinhThucDoiTraEnum.HOANTRA)
//				.getSingleResult();
//    }
    @Override
    public Long getTongSoLuongSPDoiTra(String maHD, String maSP) {
        try {
            TypedQuery<Long> query = em.createNamedQuery("DoiTra.getTongSoLuongSPDoiTra", Long.class)
                    .setParameter("maHD", maHD)
                    .setParameter("maSP", maSP)
                    .setParameter("hinhThucDoiTra", HinhThucDoiTraEnum.HOANTRA);
            Long tongSoLuong = query.getSingleResult();
            return tongSoLuong != null ? tongSoLuong : 0L;
        } catch (NoResultException e) {
            // Xử lý trường hợp không tìm thấy kết quả
            return 0L;
        }
    }

    @Override
    public boolean kiemTraThoiHanDoiTra(String maHD) {
            
    	Long count = em.createNamedQuery("DoiTra.kiemTraThoiHanDoiTra", Long.class).setParameter("maHD", maHD)
				.getSingleResult();
		if (count == 1) {
			return true;
		}
		return false;
    }
}
