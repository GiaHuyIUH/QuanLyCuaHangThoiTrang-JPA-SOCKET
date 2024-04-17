package dao;

import Interface.NhanVienInterface;

import entity.CaLamViecEnum;
import entity.ChucVuEnum;
import entity.GioiTinhEnum;
import entity.NhanVienEntity;
import entity.TaiKhoanEntity;
import entity.TinhTrangNVEnum;
import entity.TinhTrangTKEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HUY
 */
public class NhanVien_dao extends UnicastRemoteObject implements NhanVienInterface{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -2628481656822445170L;
	private EntityManager em;
	
	public NhanVien_dao() throws RemoteException{
		em = Persistence.createEntityManagerFactory("JPA MSSQL")
				.createEntityManager();
	}
	@Override
    public boolean checkNV(String email, String sdt) throws RemoteException {
//        ConnectDB.getInstance();
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement statement = null;
//        try {
//
//            String sql = "SELECT * FROM NhanVien WHERE email = ? AND soDienThoai = ?";
//            statement = con.prepareStatement(sql);
//            statement.setString(1, email);
//            statement.setString(2, sdt);
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//               return true;
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
        return em.createNamedQuery("NhanVienEntity.checkNV", NhanVienEntity.class).setParameter("email", email).setParameter("soDienThoai", sdt).getResultList().size() > 0;
      
    }
    @Override
    public NhanVienEntity getNV( String sdt) throws RemoteException {
        NhanVienEntity nv = new NhanVienEntity();
     nv = em.createNamedQuery("NhanVienEntity.getNV", NhanVienEntity.class).setParameter("soDienThoai", sdt).getResultList()
        .stream().findFirst().orElse(null);
        return nv;
    }
    @Override
    public NhanVienEntity findOne(String id)throws RemoteException {
        NhanVienEntity nhanVien = null;
//        ResultSet rs = null;
//        try {
//            connect.connect();
//            PreparedStatement statement = connect.getConnection().prepareStatement("SELECT * FROM NhanVien WHERE soDienThoai = ?");
//            statement.setString(1, id);
//            rs = statement.executeQuery();
//            while (rs.next()) {
//                GioiTinhEnum gt = null;
//                gt = switch (rs.getString("gioiTinh")) {
//                    case "Nam" -> GioiTinhEnum.NAM;
//                    case "Nữ" -> GioiTinhEnum.NU;
//                    default -> GioiTinhEnum.KHAC;
//                };
//                TinhTrangNVEnum tt = null;
//                tt = switch (rs.getString("tinhTrang")) {
//                    case "Đang làm việc" -> TinhTrangNVEnum.DANG_LAM_VIEC;
//                    case "Nghỉ việc" -> TinhTrangNVEnum.NGHI_VIEC;
//                    default -> TinhTrangNVEnum.NGHI_PHEP;
//                };
//                nhanVien = new NhanVienEntity(rs.getString("maNV"), 
//                        rs.getString("hoTen"), 
//                        gt, LocalDate.parse(rs.getString("ngaySinh")), 
//                        rs.getString("email"), 
//                        rs.getString("soDienThoai"), 
//                        rs.getString("diaChi"), 
//                        rs.getString("chucVu").equals(ChucVuEnum.NHAN_VIEN.name()) == true ? ChucVuEnum.NHAN_VIEN : ChucVuEnum.QUAN_LY, 
//                        tt, 
//                        rs.getString("caLamViec").equals(CaLamViecEnum.CA_1.name()) == true ? CaLamViecEnum.CA_1 : CaLamViecEnum.CA_2);
//            }
//            
//            connect.disconnect();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(KhachHang_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
		nhanVien = em.createNamedQuery("NhanVienEntity.getNV", NhanVienEntity.class).setParameter("soDienThoai", id)
				.getResultList().stream().findFirst().orElse(null);
        return nhanVien;
    }

    @Override
    public boolean update(NhanVienEntity NewNV) throws RemoteException{
//        StringBuilder sql = new StringBuilder("UPDATE NhanVien SET hoTen = ?, gioiTinh = ?,");
//        sql.append(" ngaySinh = ?, email = ?, soDienThoai = ?, diaChi = ?, chucVu = ?, tinhTrang = ?, caLamViec = ? WHERE maNV = ?");
//        int n = 0;
//        try {
//            connect.connect();
//            PreparedStatement statement = connect.getConnection().prepareStatement(sql.toString());
//            statement.setString(1, NewNV.getHoTen());
//            statement.setString(2, NewNV.getGioiTinh().toString());
//            statement.setString(3, NewNV.getNgaySinh().toString());
//            statement.setString(4, NewNV.getEmail());
//            statement.setString(5, NewNV.getSoDienThoai());
//            statement.setString(6, NewNV.getDiaChi());
//            statement.setString(7, NewNV.getChucVu().toString());
//            statement.setString(8, NewNV.getTinhTrang().toString());
//            statement.setString(9, NewNV.getCaLamViec().toString());
//            statement.setString(10, NewNV.getMaNV());
//            n = statement.executeUpdate();
//            connect.disconnect();
//        } catch (SQLException ex) {
//            Logger.getLogger(KhachHang_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
    	EntityTransaction tx = em.getTransaction();
    	try {
			tx.begin();
			em.merge(NewNV);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
    	}
        return false;
    }

    @Override
    public boolean insert(NhanVienEntity NV )throws RemoteException {
//        TaiKhoan_dao tkDao = new TaiKhoan_dao();
//        int n = 0;
//        if(tkDao.insert(new TaiKhoanEntity(NV.getSoDienThoai(), "1111", null, TinhTrangTKEnum.DANG_HOAT_DONG))) {
//            StringBuilder sql = new StringBuilder("INSERT INTO NhanVien(maNV, hoTen, gioiTinh, ngaySinh, email, soDienThoai, diaChi, chucVu, tinhTrang, caLamViec)");
//            sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//        try {
//            connect.connect();
//            PreparedStatement statement = connect.getConnection().prepareStatement(sql.toString());
//            statement.setString(1, NV.getMaNV());
//            statement.setString(2, NV.getHoTen());
//            statement.setString(3, NV.getGioiTinh().toString());
//            statement.setString(4, NV.getNgaySinh().toString());
//            statement.setString(5, NV.getEmail());
//            statement.setString(6, NV.getSoDienThoai());
//            statement.setString(7, NV.getDiaChi());
//            statement.setString(8, NV.getChucVu().toString());
//            statement.setString(9, NV.getTinhTrang().toString());
//            statement.setString(10, NV.getCaLamViec().toString());
//            n = statement.executeUpdate();
//            
//            connect.disconnect();
//            } catch (SQLException ex) {
//                Logger.getLogger(KhachHang_dao.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(NV);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
        return  false;
    }

    @Override
    public ArrayList<NhanVienEntity> findAll()throws RemoteException {
        ArrayList<NhanVienEntity> listKH = new ArrayList<>();
//        try {
//            connect.connect();
//            PreparedStatement statement = ConnectDB.getConnection().prepareStatement("SELECT * FROM NhanVien");
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                NhanVienEntity nhanVien = null;
//                GioiTinhEnum gt = null;
//                gt = switch (rs.getString("gioiTinh")) {
//                    case "Nam" -> GioiTinhEnum.NAM;
//                    case "Nữ" -> GioiTinhEnum.NU;
//                    default -> GioiTinhEnum.KHAC;
//                };
//                TinhTrangNVEnum tt = null;
//                tt = switch (rs.getString("tinhTrang")) {
//                    case "Đang làm việc" -> TinhTrangNVEnum.DANG_LAM_VIEC;
//                    case "Nghỉ việc" -> TinhTrangNVEnum.NGHI_VIEC;
//                    default -> TinhTrangNVEnum.NGHI_PHEP;
//                };
//                nhanVien = new NhanVienEntity(rs.getString("maNV"), 
//                        rs.getString("hoTen"), 
//                        gt, LocalDate.parse(rs.getString("ngaySinh")), 
//                        rs.getString("email"), 
//                        rs.getString("soDienThoai"), 
//                        rs.getString("diaChi"), 
//                        rs.getString("chucVu").equals(ChucVuEnum.NHAN_VIEN.toString()) == true ? ChucVuEnum.NHAN_VIEN : ChucVuEnum.QUAN_LY, 
//                        tt, 
//                        rs.getString("caLamViec").equals(CaLamViecEnum.CA_1.toString()) == true ? CaLamViecEnum.CA_1 : CaLamViecEnum.CA_2);
//                if (!listKH.contains(nhanVien)) listKH.add(nhanVien);
//            }
//            connect.disconnect();
//        }
//        catch (SQLException ex) {
//            Logger.getLogger(KhachHang_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
        listKH = (ArrayList<NhanVienEntity>) em.createNamedQuery("NhanVienEntity.getAllNV", NhanVienEntity.class).getResultList();
        return listKH;
    }
}
