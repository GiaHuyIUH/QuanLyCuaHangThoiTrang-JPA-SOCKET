
package dao;

import entity.HoaDonEntity;
import java.util.ArrayList;

import entity.ChiTietHoaDonEntity;
import entity.ChuongTrinhKhuyenMaiEntity;
import entity.KhachHangEntity;
import entity.NhanVienEntity;
import entity.TinhTrangHDEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.sql.Date;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConvertStringToEnum;

/**
 *
 * @author DELL
 */
public class HoaDon_dao extends UnicastRemoteObject implements  Interface.HoaDon_Interface{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 7161894495788185035L;
	private ConvertStringToEnum toEnum = new ConvertStringToEnum();
    private EntityManager em;
    public HoaDon_dao() throws RemoteException{
		em = jakarta.persistence.Persistence.createEntityManagerFactory("JPA MSSQL").createEntityManager();
	
}
    
    @Override
    public ArrayList<HoaDonEntity> getallHoaDon() throws RemoteException {
    	 return (ArrayList<HoaDonEntity>) em.createNamedQuery("HoaDon.getAllHoaDon", HoaDonEntity.class).getResultList();
       
    }

    @Override
    public double getTotalMoney(String maHD) throws RemoteException{
    	return em.createNamedQuery("HoaDon.getTotalMoney", Double.class).setParameter("maHD", maHD).getSingleResult();
    }
    
    // Nguyen Huy Hoang
    @Override
    public boolean themHoaDon(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD) throws RemoteException{
    	hoaDon.setTinhTrang(TinhTrangHDEnum.DATHANHTOAN);
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(hoaDon);
            
            for (ChiTietHoaDonEntity cthd : danhSachCTHD) {
                // Liên kết chi tiết hoá đơn với hoá đơn trước khi lưu
                cthd.setHoaDon(hoaDon);
                em.persist(cthd);
            }
            
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean luuTamHoaDon(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD) throws RemoteException{
    	hoaDon.setTinhTrang(TinhTrangHDEnum.CHUATHANHTOAN);
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(hoaDon);
			tx.commit();
			for (ChiTietHoaDonEntity cthd : danhSachCTHD) {
				tx.begin();
				em.persist(cthd);
				tx.commit();
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
    public boolean capNhatHoaDonLuuTam(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD)throws RemoteException {
    	hoaDon.setTinhTrang(TinhTrangHDEnum.CHUATHANHTOAN);
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.createNamedQuery("HoaDon.capNhatHoaDonLuuTam", HoaDonEntity.class);
			for (ChiTietHoaDonEntity cthd : danhSachCTHD) {
				em.persist(cthd);
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
    public boolean themHoaDonLuuTam(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD)throws RemoteException {
    	hoaDon.setTinhTrang(TinhTrangHDEnum.DATHANHTOAN);
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(hoaDon);
			for (ChiTietHoaDonEntity cthd : danhSachCTHD) {
				em.persist(cthd);
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
    public ArrayList<HoaDonEntity> timKiemHoaDonChuaThanhToan(String sdt) throws RemoteException{
    	return (ArrayList<HoaDonEntity>) em.createNamedQuery("HoaDon.timKiemHoaDonChuaThanhToan", HoaDonEntity.class).setParameter("sdt", sdt).getResultList();
    }
    
    @Override
    public HoaDonEntity timKiemHoaDonTheoMa(String maHD) throws RemoteException{
    	return em.find(HoaDonEntity.class, maHD);
    }
    
    @Override
    public int getSoLuongTonTheoMa(String maSP)throws RemoteException {
    	return em.createNamedQuery("SanPham.getSoLuongTonTheoMa", Integer.class).setParameter("maSP", maSP).getSingleResult();
    }
    
    @Override
    public ArrayList<HoaDonEntity> getAllHDChuaThanhToan() throws RemoteException{
    	return (ArrayList<HoaDonEntity>) em.createNamedQuery("HoaDon.getAllHDChuaThanhToan", HoaDonEntity.class).getResultList();
    }


    @Override
    public HoaDonEntity getHoaDonTheoMaHD(String maHD)throws RemoteException {
    	return em.find(HoaDonEntity.class, maHD);
    }

    @Override
    public ArrayList<HoaDonEntity> getHoaDonTheoNgayLap(Date ngayLap)throws RemoteException {
    	return (ArrayList<HoaDonEntity>) em.createNamedQuery("HoaDon.getHoaDonTheoNgayLap", HoaDonEntity.class).setParameter("ngayLap", ngayLap).getResultList();
	
    }

    @Override
    public ArrayList<HoaDonEntity> getHoaDonTheoMaHDvaNgayLap(String maHD, java.util.Date ngayLap)throws RemoteException {
    	return (ArrayList<HoaDonEntity>) em.createNamedQuery("HoaDon.getHoaDonTheoMaHDvaNgayLap", HoaDonEntity.class).setParameter("maHD", maHD).setParameter("ngayLap", ngayLap).getResultList();
    }
    	
}
