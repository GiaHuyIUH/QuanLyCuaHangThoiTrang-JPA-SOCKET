/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Interface.NhaCungCap_Interface;
import entity.NhaCungCapEntity;
import entity.TinhTrangNCCEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;



public class NhaCungCap_dao extends UnicastRemoteObject implements NhaCungCap_Interface {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -4602343847237255983L;
		private EntityManager em;
	
	    public NhaCungCap_dao() throws RemoteException{
	        super();
	        em = Persistence.createEntityManagerFactory("JPA MSSQL").createEntityManager();
	    }

	    @Override
	    public ArrayList<NhaCungCapEntity> getAllNhaCungCap()throws RemoteException {
	        Query query = em.createQuery("SELECT n FROM NhaCungCapEntity n");
	        return (ArrayList<NhaCungCapEntity>) query.getResultList();
	    }
//    @Override
//    public ArrayList<NhaCungCapEntity> getAllNhaCungCap() {
//        ArrayList<NhaCungCapEntity> dsNCC = new ArrayList<NhaCungCapEntity>();
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement ps = null;
//            String sql = "select * from NhaCungCap";
//            ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                String maNCC = rs.getString("maNCC");
//                String tenNCC = rs.getString("tenNCC");
//                String soDienThoai = rs.getString("soDienThoai");
//                String diaChi = rs.getString("diaChi");
//                String tinhTrang = rs.getString("tinhTrang");
//                TinhTrangNCCEnum tinhTrangEnum = null;
//                if (tinhTrang.equals("Đang nhập")) {
//                    tinhTrangEnum = TinhTrangNCCEnum.DANGNHAP;
//                } else if (tinhTrang.equals("Ngừng nhập")) {
//                    tinhTrangEnum = TinhTrangNCCEnum.NGUNGNHAP;
//                }
//                NhaCungCapEntity ncc = new NhaCungCapEntity(maNCC, tenNCC, diaChi, soDienThoai, tinhTrangEnum);
//                dsNCC.add(ncc);
//            }
//            ps.close();
//            rs.close();
//            ConnectDB.getInstance().disconnect();
//        } catch (SQLException ex) {
//            Logger.getLogger(NhaCungCap_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return dsNCC;
//    }

	    @Override
	    public boolean themNCC(NhaCungCapEntity ncc) throws RemoteException{
	        EntityTransaction tx = em.getTransaction();
	        try {
	            tx.begin();
	            em.persist(ncc);
	            tx.commit();
	            return true;
	        } catch (Exception e) {
	            tx.rollback();
	            e.printStackTrace();
	            return false;
	        }
	    }
//    @Override
//    public boolean themNCC(NhaCungCapEntity ncc) {
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement ps = null;
//            String sql = "Insert into NhaCungCap(maNCC,tenNCC,soDienThoai,diaChi,tinhTrang) values(?,?,?,?,?)";
//            ps = con.prepareStatement(sql);
//            ps.setString(1, ncc.getMaNCC());
//            ps.setString(2, ncc.getTenNCC());
//            ps.setString(3, ncc.getSoDienThoai());
//            ps.setString(4, ncc.getDiaChi());
//            ps.setString(5, ncc.getTinhTrang().toString());
//            int check = ps.executeUpdate();
//            ps.close();
//            ConnectDB.getInstance().disconnect();
//            return check > 0;
//        } catch (SQLException ex) {
//            Logger.getLogger(NhaCungCap_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return false;
//    }
	    @Override
	    public ArrayList<NhaCungCapEntity> timKiemNCC(String ma)throws RemoteException {
	        Query query = em.createQuery("SELECT n FROM NhaCungCapEntity n WHERE n.maNCC = :maNCC");
	        query.setParameter("maNCC", ma);
	        return (ArrayList<NhaCungCapEntity>) query.getResultList();
	    }
//    @Override
//    public ArrayList<NhaCungCapEntity> timKiemNCC(String ma) {
//        ArrayList<NhaCungCapEntity> dsNCC = new ArrayList<NhaCungCapEntity>();
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement ps = null;
//            String sql = "select * from NhaCungCap where maNCC=?";
//            try {
//                ps = con.prepareStatement(sql);
//                ps.setString(1, ma);
//                ResultSet rs = ps.executeQuery();
//                while (rs.next()) {
//                    String maNCC = rs.getString(1);
//                    String tenNCC = rs.getString(2);
//                    String soDienThoai = rs.getString(3);
//                    String diaChi = rs.getString(4);
//                    String tinhTrang = rs.getString(5);
//                    TinhTrangNCCEnum tinhTrangEnum = null;
//                    if (rs.getString("tinhTrang").equals("Đang nhập")) {
//                        tinhTrangEnum = TinhTrangNCCEnum.DANGNHAP;
//                    } else if (rs.getString("tinhTrang").equals("Ngừng nhập")) {
//                        tinhTrangEnum = TinhTrangNCCEnum.NGUNGNHAP;
//                    }
//                    NhaCungCapEntity ncc = new NhaCungCapEntity(maNCC, tenNCC, diaChi, soDienThoai, tinhTrangEnum);
//                    dsNCC.add(ncc);
//                }
//                ps.close();
//                rs.close();
//                ConnectDB.getInstance().disconnect();
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(NhaCungCap_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return dsNCC;
//    }
	    @Override
	    public boolean capNhatNhaCungCap(NhaCungCapEntity ncc) throws RemoteException{
	        EntityTransaction tx = em.getTransaction();
	        try {
	            tx.begin();
	            em.merge(ncc);
	            tx.commit();
	            return true;
	        } catch (Exception e) {
	            tx.rollback();
	            e.printStackTrace();
	            return false;
	        }
	    }
//    @Override
//    public boolean capNhatNhaCungCap(NhaCungCapEntity ncc) {
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement ps = null;
//            String sql = "update NhaCungCap set tenNCC=?, soDienThoai=?, diaChi=?, tinhTrang=? where maNCC=?";
//            ps = con.prepareStatement(sql);
//            ps.setString(1, ncc.getTenNCC());
//            ps.setString(2, ncc.getSoDienThoai());
//            ps.setString(3, ncc.getDiaChi());
//            ps.setString(4, ncc.getTinhTrang().toString());
//            ps.setString(5, ncc.getMaNCC());
//            ps.executeUpdate();
//            ps.close();
//            ConnectDB.getInstance().disconnect();
//            return true;
//        } catch (SQLException ex) {
//            Logger.getLogger(NhaCungCap_dao.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//    }
	    @Override
	    public ArrayList<NhaCungCapEntity> layDSNCCDangNhap()throws RemoteException {
	        Query query = em.createQuery("SELECT n FROM NhaCungCapEntity n WHERE n.tinhTrang = :tinhTrang");
	        query.setParameter("tinhTrang", TinhTrangNCCEnum.DANGNHAP);
	        return (ArrayList<NhaCungCapEntity>) query.getResultList();
	    }
//    @Override
//    public ArrayList<NhaCungCapEntity> layDSNCCDangNhap() {
//        ArrayList<NhaCungCapEntity> dsNCC = new ArrayList<NhaCungCapEntity>();
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement ps = null;
//            String sql = "SELECT * FROM NhaCungCap WHERE tinhTrang =N'Đang nhập'";
//            ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                String maNCC = rs.getString("maNCC");
//                String tenNCC = rs.getString("tenNCC");
//                String soDienThoai = rs.getString("soDienThoai");
//                String diaChi = rs.getString("diaChi");
//                NhaCungCapEntity ncc = new NhaCungCapEntity(maNCC, tenNCC, diaChi, soDienThoai, TinhTrangNCCEnum.DANGNHAP);
//                dsNCC.add(ncc);
//            }
//            ps.close();
//            rs.close();
//            ConnectDB.getInstance().disconnect();
//        } catch (SQLException ex) {
//            Logger.getLogger(NhaCungCap_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return dsNCC;
//    }
	    @Override
	    public String layTenNhaCungCapTheoMa(String maNhaCungCap) throws RemoteException{
	        Query query = em.createQuery("SELECT n.tenNCC FROM NhaCungCapEntity n WHERE n.maNCC = :maNCC");
	        query.setParameter("maNCC", maNhaCungCap);
	        return (String) query.getSingleResult();
	    }
//    @Override
//    public String layTenNhaCungCapTheoMa(String maNhaCungCap) {
//        String tenNCC = null;
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement ps = null;
//
//            String sql = "SELECT tenNCC FROM NhaCungCap WHERE maNCC = ?";
//            ps = con.prepareStatement(sql);
//            ps.setString(1, maNhaCungCap);
//
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                tenNCC = rs.getString("tenNCC");
//            }
//
//            ps.close();
//            rs.close();
//            ConnectDB.getInstance().disconnect();
//        } catch (SQLException ex) {
//            Logger.getLogger(NhaCungCap_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return tenNCC;
//    }
	    @Override
	    public String layMaNhaCungCapTheoTen(String tenNhaCungCap)throws RemoteException {
	        Query query = em.createQuery("SELECT n.maNCC FROM NhaCungCapEntity n WHERE n.tenNCC = :tenNCC");
	        query.setParameter("tenNCC", tenNhaCungCap);
	        return (String) query.getSingleResult();
	    }
//    @Override
//    public String layMaNhaCungCapTheoTen(String tenNhaCungCap) {
//        String maNCC = null;
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement ps = null;
//            String sql = "SELECT maNCC FROM NhaCungCap WHERE tenNCC = ?";
//            ps = con.prepareStatement(sql);
//            ps.setString(1, tenNhaCungCap);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                maNCC = rs.getString("maNCC");
//            }
//
//            ps.close();
//            rs.close();
//            ConnectDB.getInstance().disconnect();
//        } catch (SQLException ex) {
//            Logger.getLogger(NhaCungCap_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return maNCC;
//    }
}