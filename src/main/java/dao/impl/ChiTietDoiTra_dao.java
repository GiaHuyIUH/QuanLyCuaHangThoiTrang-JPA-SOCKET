package dao.impl;

import java.util.ArrayList;

import entity.ChiTietDoiTraEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 *
 * @author Huy
 */
public class ChiTietDoiTra_dao implements dao.ChiTietDoiTra_Interface{
	
	private EntityManager em;
    
    public ChiTietDoiTra_dao() {
        em = Persistence.createEntityManagerFactory("CoLenServer").createEntityManager();
    }

	@Override
	public boolean themChiTietDoiTra(ChiTietDoiTraEntity ctdt) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(ctdt);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<ChiTietDoiTraEntity> getAllCTDTTheoMaDT(String ma) {
		return (ArrayList<ChiTietDoiTraEntity>) em
				.createNamedQuery("ChiTietDoiTra.getAllCTDTTheoMaDT", ChiTietDoiTraEntity.class)
				.setParameter("ma", ma).getResultList();
	}
    
//    @Override
//    public boolean themChiTietDoiTra(ChiTietDoiTraEntity ctdt) {
//        PreparedStatement statement = null;
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            
//            String sql = "Insert into ChiTietDoiTra(maSP, maDT, soLuong, giaBan, thanhTien) values (?, ?, ?, ?, ?)";
//            statement = con.prepareStatement(sql);
//            statement.setString(1, ctdt.getSanPham().getMaSP());
//            statement.setString(2, ctdt.getDoiTra().getMaDT());
//            statement.setInt(3, ctdt.getSoLuong());
//            statement.setDouble(4, ctdt.getGiaBan());
//            statement.setDouble(5, ctdt.getThanhTien());
//            
//            int ketQua = statement.executeUpdate();
//
//            if(ketQua < 1) {
//                return false;
//            }
//            
//            return true;
//        } catch(SQLException e) {
//            e.printStackTrace();
//            return false;
//        } finally {
//            try {
//                statement.close();
//                ConnectDB.getInstance().disconnect();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public ArrayList<ChiTietDoiTraEntity> getAllCTDTTheoMaDT(String ma) {
//        try {
//            ConnectDB.getInstance().connect();
//        } catch (SQLException ex) {
//            Logger.getLogger(HoaDon_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement statement = null;
//        
//        try {
//            String sql = "Select ctdt.*, sp.tenSP, sp.kichThuoc, sp.mauSac from ChiTietDoiTra as ctdt inner join SanPham as sp on ctdt.maSP=sp.maSP where maDT=?";
//            statement = con.prepareStatement(sql);
//            statement.setString(1, ma);
//            
//            ResultSet rs = statement.executeQuery();
//            ArrayList<ChiTietDoiTraEntity> ctdtList = new ArrayList<ChiTietDoiTraEntity>();
//            while(rs.next()) {
//                String madt = rs.getString("maDT");
//                DoiTraEntity dt = new DoiTraEntity(madt);
//                String masp = rs.getString("maSP");
//                String tensp = rs.getString("tenSP");
//                String kichThuoc = rs.getString("kichThuoc");
//                String mauSac = rs.getString("mauSac");
//                SanPhamEntity sp = new SanPhamEntity(masp);
//                sp.setTenSP(tensp);
//                ConvertStringToEnum toEnum = new ConvertStringToEnum();
//                sp.setKichThuoc(toEnum.KichThuoctoEnum(kichThuoc));
//                sp.setMauSac(toEnum.MauSactoEnum(mauSac));
//                int soLuong = rs.getInt("soLuong");
//                double giaBan = rs.getDouble("giaBan");
//                double thanhTien = rs.getDouble("thanhTien");
//                
//                ChiTietDoiTraEntity cthd = new ChiTietDoiTraEntity(sp, dt, soLuong, giaBan, thanhTien);
//                
//                ctdtList.add(cthd);
//            }
//            return ctdtList;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            if(con != null) {
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(HoaDon_dao.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//    }
}
