/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Interface.TaiKhoanInterface;

import entity.TaiKhoanEntity;
import entity.TinhTrangTKEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author HUY
 */
public class TaiKhoan_dao extends UnicastRemoteObject implements TaiKhoanInterface{
     
     /**
	 * 
	 */
	private static final long serialVersionUID = 1687824401253710884L;
	private NhanVien_dao nhanVienDAO;
	private EntityManager em;

	public TaiKhoan_dao() throws RemoteException {
		nhanVienDAO = new NhanVien_dao();
		em = Persistence.createEntityManagerFactory("JPA MSSQL").createEntityManager();
	}

    public TaiKhoanEntity getTaiKhoan(String taiKhoan, String matKhau) throws RemoteException {

       TaiKhoanEntity tk = new TaiKhoanEntity();
       tk = em.createNamedQuery("TaiKhoanEntity.getTKByNameAndPass", TaiKhoanEntity.class)
    		   .setParameter("tenTaiKhoan", taiKhoan)
    		   .setParameter("matKhau", matKhau)
    		   .getResultList()
    		   .stream()
    		   .findFirst()
    		   .orElse(null);
//        PreparedStatement statement = null;
//        try {
//
//            String sql = "SELECT * FROM taikhoan WHERE tenTaiKhoan = ? AND matKhau = ?";
////            statement = con.prepareStatement(sql);
//            statement.setString(1, taiKhoan);
//            statement.setString(2, matKhau);
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                String tk = rs.getString("tenTaiKhoan");
//                String mk = rs.getString("matKhau");
//               
//                entity.TaiKhoanEntity taikhoan = new TaiKhoanEntity(tk, mk, null, rs.getString("tinhTrang").equals("Đang hoạt động") == true ? TinhTrangTKEnum.DANG_HOAT_DONG : TinhTrangTKEnum.NGUNG_HOAT_DONG);
//                return taikhoan;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                statement.close();
//            } catch (Exception e2) {
//                // TODO: handle exception
//                e2.printStackTrace();
//            }
//        }
        return tk;
      
    }
    public boolean thoiGianDNGN(TaiKhoanEntity tk)throws RemoteException {
        LocalDateTime currentTime = LocalDateTime.now();
//        try {
//            ConnectDB.getInstance().connect();
//        } catch (SQLException ex) {
//            Logger.getLogger(TaiKhoan_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement statement = null;
//        int n = 0;
//        try {
//
//            statement = con.prepareStatement("update TaiKhoan set thoiGianDNGN = ? where tenTaiKhoan= ?");
//            statement.setTimestamp(1, Timestamp.valueOf(currentTime));
//            statement.setString(2, tk.getTenTaiKhoan());
//            n = statement.executeUpdate();
//
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//           
//        
//
//        } finally {
//            try {
//                statement.close();
//            } catch (Exception e2) {
//                // TODO: handle exception
//                e2.printStackTrace();
//            }
//        }
    EntityTransaction tx = em.getTransaction();
    try {
    	tx.begin();
    	em.createNamedQuery("TaiKhoanEntity.updateThoiGianDNGN").setParameter("thoiGianDNGN", currentTime).setParameter("tenTaiKhoan", tk.getTenTaiKhoan()).executeUpdate();
    	tx.commit();
    	return true;
    }catch (Exception e) {
		tx.rollback();// TODO: handle exception
		e.printStackTrace();
	}
        return false;
    }
    
     public boolean lamMoiMatKhau(TaiKhoanEntity tk)throws RemoteException {

//        try {
//            ConnectDB.getInstance().connect();
//        } catch (SQLException ex) {
//            Logger.getLogger(TaiKhoan_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement statement = null;
//        int n = 0;
//        try {
//
//            statement = con.prepareStatement("update TaiKhoan set matKhau = ? where tenTaiKhoan= ?");
//            statement.setString(1, tk.getMatKhau());
//            statement.setString(2, tk.getTenTaiKhoan());
//            n = statement.executeUpdate();
//
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//           
//        
//
//        } finally {
//            try {
//                statement.close();
//            } catch (Exception e2) {
//                // TODO: handle exception
//                e2.printStackTrace();
//            }
//        }
    	 EntityTransaction tx = em.getTransaction();
    	 try {
				tx.begin();
				em.createNamedQuery("TaiKhoanEntity.updateMatKhau").setParameter("matKhau", tk.getMatKhau())
						.setParameter("tenTaiKhoan", tk.getTenTaiKhoan()).executeUpdate();
				tx.commit();
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		}

        return false;
    }

    @Override
    public boolean insert(TaiKhoanEntity tk)throws RemoteException {
        

//        try {
//            ConnectDB.getInstance().connect();
//        } catch (SQLException ex) {
//            Logger.getLogger(TaiKhoan_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement statement = null;
//        Timestamp timestamp = new Timestamp(new Date().getTime());
//        try {
//            statement = con.prepareStatement("INSERT INTO TaiKhoan(tenTaiKhoan, matKhau, thoiGianDNGN, tinhTrang) "
//                    + " values(?,?,?,?)");
//            statement.setString(1, tk.getTenTaiKhoan());
//            statement.setString(2, tk.getMatKhau());
//            statement.setTimestamp(3, timestamp);
//            statement.setString(4, tk.getTinhTrang().toString());
//            n = statement.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        EntityTransaction tx = em.getTransaction();
        try {
        	tx.begin();
        	em.persist(tk);
        	tx.commit();
        	return true;
        	}catch (Exception e) {
        		tx.rollback();
        		e.printStackTrace();
        	}
        return false;
    }

    @Override
    public boolean update(TaiKhoanEntity tk) throws RemoteException{
//        int n = 0;
//        try {
//                 ConnectDB.getInstance().connect();
//             } catch (SQLException ex) {
//                 Logger.getLogger(TaiKhoan_dao.class.getName()).log(Level.SEVERE, null, ex);
//             }
//         try {
//             Connection connection = ConnectDB.getConnection();
//             PreparedStatement statement = null;
//             statement = connection.prepareStatement("UPDATE TaiKhoan SET tinhTrang = ? WHERE tenTaiKhoan = ?");
//             statement.setString(1, tk.getTinhTrang().toString());
//             statement.setString(2, tk.getTenTaiKhoan());
//             n = statement.executeUpdate();
//         } catch (SQLException ex) {
//             Logger.getLogger(TaiKhoan_dao.class.getName()).log(Level.SEVERE, null, ex);
//         }
        EntityTransaction tx = em.getTransaction();
        try {
        	tx.begin();
//        	em.merge(tk);
        	em.createNamedQuery("TaiKhoanEntity.updateTinhTrang").setParameter("tinhTrang", tk.getTinhTrang()).setParameter("tenTaiKhoan", tk.getTenTaiKhoan()).executeUpdate();
        	tx.commit();
        	return true;
        }
        catch (Exception e) {
        	            tx.rollback();
        	            e.printStackTrace();
        }
         return false;
        
    }

    @Override
    public boolean delete(TaiKhoanEntity tk) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TaiKhoanEntity findOne(String tenTK) {
        TaiKhoanEntity taiKhoan = null;
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement statement = null;
//            try {
//                
//                String sql = "SELECT * FROM taikhoan WHERE tenTaiKhoan = ?";
//                statement = con.prepareStatement(sql);
//                statement.setString(1, tenTK);
//                ResultSet rs = statement.executeQuery();
//                while (rs.next()) {
//                    String tk = rs.getString("tenTaiKhoan");
//                    String mk = rs.getString("matKhau");
//                    
//                    taiKhoan = new TaiKhoanEntity();
//                    taiKhoan.setMatKhau(mk);
//                    taiKhoan.setTenTaiKhoan(tenTK);
//                    taiKhoan.setThoiGianDNGN(rs.getTimestamp("thoiGianDNGN").toLocalDateTime());
//                    taiKhoan.setTinhTrang(rs.getString("tinhTrang").equals("Đang hoạt động") == true ? TinhTrangTKEnum.DANG_HOAT_DONG : TinhTrangTKEnum.NGUNG_HOAT_DONG);
//                    taiKhoan.setNhanVien(nhanVienDAO.findOne(tk));
//                }
//                
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    statement.close();
//                } catch (Exception e2) {
//                    // TODO: handle exception
//                    e2.printStackTrace();
//                }
//            }
//            
//            
//        } catch (SQLException ex) {
//             Logger.getLogger(TaiKhoan_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
			taiKhoan = em.createNamedQuery("TaiKhoanEntity.getTKByTenTK", TaiKhoanEntity.class)
				.setParameter("tenTaiKhoan", tenTK).getResultList().stream().findFirst().orElse(null);
         return taiKhoan;
    }

    @Override
    public ArrayList<TaiKhoanEntity> findAll()throws RemoteException {
        ArrayList<TaiKhoanEntity> listTK = new ArrayList<>();
//        try {
//            connect.connect();
//            PreparedStatement statement = connect.getConnection().prepareStatement("SELECT * FROM TaiKhoan");
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                TaiKhoanEntity taiKhoan = null;
//                String tenTaiKhoan = rs.getString("tenTaiKhoan");
//                taiKhoan = new TaiKhoanEntity(tenTaiKhoan, rs.getString("matKhau"), rs.getTimestamp("thoiGianDNGN").toLocalDateTime(), rs.getString("tinhTrang").equals("Đang hoạt động") == true ? TinhTrangTKEnum.DANG_HOAT_DONG : TinhTrangTKEnum.NGUNG_HOAT_DONG);
//                taiKhoan.setNhanVien(nhanVienDAO.findOne(tenTaiKhoan));
//                if (!listTK.contains(taiKhoan)) listTK.add(taiKhoan);
//            }
//            connect.disconnect();
//        }
//        catch (SQLException ex) {
//            Logger.getLogger(KhachHang_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
        listTK = (ArrayList<TaiKhoanEntity>) em.createNamedQuery("TaiKhoanEntity.getAllTK", TaiKhoanEntity.class).getResultList();
        return listTK;
    }
    
}
