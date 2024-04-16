/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Interface.ThuongHieu_Interface;
import entity.ThuongHieuEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ThuongHieu_dao implements ThuongHieu_Interface {
		private EntityManager em;
	
	    public ThuongHieu_dao() {
	        super();
	        em = Persistence.createEntityManagerFactory("JPA MSSQL").createEntityManager();
	    }
	    
	    @Override
	    public ArrayList<ThuongHieuEntity> getAllTH() {
	        Query query = em.createQuery("SELECT t FROM ThuongHieuEntity t");
	        return (ArrayList<ThuongHieuEntity>) query.getResultList();
	    }
//    @Override
//    public ArrayList<ThuongHieuEntity> getAllTH() {
//        ArrayList<ThuongHieuEntity> dsTH = new ArrayList<ThuongHieuEntity>();
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement ps = null;
//            String sql = "select * from ThuongHieu";
//            ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                String maThuongHieu = rs.getString("maThuongHieu");
//                String tenThuongHieu = rs.getString("tenThuongHieu");
//                ThuongHieuEntity th = new ThuongHieuEntity(maThuongHieu, tenThuongHieu);
//                dsTH.add(th);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ThuongHieu_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return dsTH;
//    }
	    @Override
	    public String layTenThuongHieuTheoMa(String maThuongHieu) {
	        Query query = em.createQuery("SELECT t.tenThuongHieu FROM ThuongHieuEntity t WHERE t.maThuongHieu = :maTH");
	        query.setParameter("maTH", maThuongHieu);
	        return (String) query.getSingleResult();
	    }
//    @Override
//    public String layTenThuongHieuTheoMa(String maThuongHieu) {
//        String tenThuongHieu = null;
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement ps = null;
//
//            String sql = "SELECT tenThuongHieu FROM ThuongHieu WHERE maThuongHieu = ?";
//            ps = con.prepareStatement(sql);
//            ps.setString(1, maThuongHieu);
//
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                tenThuongHieu = rs.getString("tenThuongHieu");
//            }
//
//            ps.close();
//            rs.close();
//            ConnectDB.getInstance().disconnect();
//        } catch (SQLException ex) {
//            Logger.getLogger(ThuongHieu_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return tenThuongHieu;
//    }
	    @Override
	    public String layMaThuongHieuTheoTen(String tenThuongHieu) {
	        Query query = em.createQuery("SELECT t.maThuongHieu FROM ThuongHieuEntity t WHERE t.tenThuongHieu = :tenTH");
	        query.setParameter("tenTH", tenThuongHieu);
	        return (String) query.getSingleResult();
	    }

//    @Override
//    public String layMaThuongHieuTheoTen(String tenThuongHieu) {
//        String maThuongHieu = null;
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement ps = null;
//            String sql = "SELECT maThuongHieu FROM ThuongHieu WHERE tenThuongHieu = ?";
//            ps = con.prepareStatement(sql);
//            ps.setString(1, tenThuongHieu);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                maThuongHieu = rs.getString("maThuongHieu");
//            }
//
//            ps.close();
//            rs.close();
//            ConnectDB.getInstance().disconnect();
//        } catch (SQLException ex) {
//            Logger.getLogger(ThuongHieu_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return maThuongHieu;
//    }

}
