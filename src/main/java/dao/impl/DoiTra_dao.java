package dao.impl;

import java.sql.Date;
import java.util.ArrayList;

import entity.ChiTietDoiTraEntity;
import entity.DoiTraEntity;
import entity.HinhThucDoiTraEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 *
 * @author Huy
 */
public class DoiTra_dao implements dao.DoiTra_Interface {

	private EntityManager em;

	public DoiTra_dao() {
		this.em = Persistence.createEntityManagerFactory("CoLenServer").createEntityManager();
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

	@Override
	public Long getTongSoLuongSPDoiTra(String maHD, String maSP) {
		return em.createNamedQuery("DoiTra.getTongSoLuongSPDoiTra", Long.class).setParameter("maHD", maHD)
				.setParameter("maSP", maSP).setParameter("hinhThucDoiTra", HinhThucDoiTraEnum.HOANTRA)
				.getSingleResult();
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

//    @Override
//    public boolean taoDoiTra(DoiTraEntity dt, ArrayList<ChiTietDoiTraEntity> ctdtList) {
//        try {
//            ConnectDB.getInstance().connect();
//        } catch (SQLException ex) {
//            Logger.getLogger(DoiTra_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement statement = null;
//        try {
//
//            String sql = "Insert into DoiTra(maDT, maHD, maNV, thoiGianDoiTra, hinhThucDoiTra, tongTien) values (?, ?, ?, ?, ?, ?)";
//            statement = con.prepareStatement(sql);
//
//            statement.setString(1, dt.getMaDT());
//            statement.setString(2, dt.getHoaDon().getMaHD());
//            statement.setString(3, dt.getNhanVien().getMaNV());
//            statement.setDate(4, dt.getThoiGianDoiTra());
//            statement.setString(5, dt.getHinhThucDoiTra().toString());
//            statement.setDouble(6, dt.getTongTien());
//
//            int ketQua = statement.executeUpdate();
//            if(ketQua < 1) {
//                return false;
//            }
//            
//            ChiTietHoaDon_dao cthd_dao = new ChiTietHoaDon_dao();
//            for (ChiTietDoiTraEntity ctdt : ctdtList) {
//                if(!ctdt_dao.themChiTietDoiTra(ctdt)) {
//                    return false;
//                }
//            }
//
//            return true;
//        } catch (SQLException e) {
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
//    public ArrayList<DoiTraEntity> getAllDoiTra() {
//        try {
//            ConnectDB.getInstance().connect();
//        } catch (SQLException ex) {
//            Logger.getLogger(DoiTra_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement statement = null;
//        try {
//
//            String sql = "Select * from DoiTra";
//            statement = con.prepareStatement(sql);
//
//            ResultSet rs = statement.executeQuery();
//            
//            ArrayList<DoiTraEntity> dtList = new ArrayList<>();
//            while(rs.next()) {
//                String maDT = rs.getString("maDT");
//                String maHD = rs.getString("maHD");
//                HoaDonEntity hd = new HoaDonEntity(maHD);
//                String maNV = rs.getString("maNV");
//                NhanVienEntity nv = new NhanVienEntity(maNV);
//                Date thoiGian = rs.getDate("thoiGianDoiTra");
//                String hinhThuc = rs.getString("hinhThucDoiTra");
//                double tongTien = rs.getDouble("tongTien");
//                
//                ConvertStringToEnum toEnum = new ConvertStringToEnum();
//                
//                DoiTraEntity dt = new DoiTraEntity(maDT, hd, nv, toEnum.HinhThucDTToEnum(hinhThuc), thoiGian, tongTien);
//                dtList.add(dt);
//            }
//
//            return dtList;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
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
//    public DoiTraEntity getDoiTraTheoMa(String ma) {
//        try {
//            ConnectDB.getInstance().connect();
//        } catch (SQLException ex) {
//            Logger.getLogger(DoiTra_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement statement = null;
//        try {
//
//            String sql = "Select dt.*, hd.maKH from DoiTra as dt inner join HoaDon as hd on dt.maHD=hd.maHD where maDT=?";
//            statement = con.prepareStatement(sql);
//            statement.setString(1, ma);
//
//            ResultSet rs = statement.executeQuery();
//            
//            DoiTraEntity dt = null;
//            if(rs.next()) {
//                String maDT = rs.getString("maDT");
//                String maHD = rs.getString("maHD");
//                HoaDonEntity hd = new HoaDonEntity(maHD);
//                
//                String maKH = rs.getString("maKH");
//                KhachHangEntity kh = new KhachHangEntity();
//                
//                String maNV = rs.getString("maNV");
//                NhanVienEntity nv = new NhanVienEntity(maNV);
//                Date thoiGian = rs.getDate("thoiGianDoiTra");
//                String hinhThuc = rs.getString("hinhThucDoiTra");
//                double tongTien = rs.getDouble("tongTien");
//                if(maKH != null) {
//                    kh.setMaKH(maKH);
//                    String sql_kh = "Select hoTen, soDienThoai from KhachHang where maKH=?";
//                    statement = con.prepareStatement(sql_kh);
//                    statement.setString(1, maKH);
//                    
//                    rs = statement.executeQuery();
//                    if(rs.next()) {
//                        
//                        kh.setHoTen(rs.getString("hoTen"));
//                        kh.setSoDienThoai(rs.getString("soDienThoai"));
//                    }
//                    
//                }
//                hd.setKhachHang(kh);
//                
//                ConvertStringToEnum toEnum = new ConvertStringToEnum();
//                
//                dt = new DoiTraEntity(maDT, hd, nv, toEnum.HinhThucDTToEnum(hinhThuc), thoiGian, tongTien);
//            }
//
//            return dt;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
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
//    public ArrayList<DoiTraEntity> getDoiTraTheoNgayLap(Date ngayLap) {
//        try {
//            ConnectDB.getInstance().connect();
//        } catch (SQLException ex) {
//            Logger.getLogger(DoiTra_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement statement = null;
//        try {
//
//            String sql = "Select * from DoiTra where thoiGianDoiTra=?";
//            statement = con.prepareStatement(sql);
//            statement.setDate(1, ngayLap);
//
//            ResultSet rs = statement.executeQuery();
//            
//            ArrayList<DoiTraEntity> dtList = new ArrayList<DoiTraEntity>();
//            while(rs.next()) {
//                String maDT = rs.getString("maDT");
//                String maHD = rs.getString("maHD");
//                HoaDonEntity hd = new HoaDonEntity(maHD);
//                String maNV = rs.getString("maNV");
//                NhanVienEntity nv = new NhanVienEntity(maNV);
//                Date thoiGian = rs.getDate("thoiGianDoiTra");
//                String hinhThuc = rs.getString("hinhThucDoiTra");
//                double tongTien = rs.getDouble("tongTien");
//                
//                ConvertStringToEnum toEnum = new ConvertStringToEnum();
//                
//                DoiTraEntity dt = new DoiTraEntity(maDT, hd, nv, toEnum.HinhThucDTToEnum(hinhThuc), thoiGian, tongTien);
//                
//                dtList.add(dt);
//            }
//
//            return dtList;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
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
//    public DoiTraEntity getDoiTraTheoDieuKien(String ma, Date ngayLap) {
//        try {
//            ConnectDB.getInstance().connect();
//        } catch (SQLException ex) {
//            Logger.getLogger(DoiTra_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement statement = null;
//        try {
//
//            String sql = "Select * from DoiTra where thoiGianDoiTra=? and maDT=?";
//            statement = con.prepareStatement(sql);
//            statement.setDate(1, ngayLap);
//            statement.setString(2, ma);
//
//            ResultSet rs = statement.executeQuery();
//            
//            DoiTraEntity dt = null;
//            if(rs.next()) {
//                String maDT = rs.getString("maDT");
//                String maHD = rs.getString("maHD");
//                HoaDonEntity hd = new HoaDonEntity(maHD);
//                String maNV = rs.getString("maNV");
//                NhanVienEntity nv = new NhanVienEntity(maNV);
//                Date thoiGian = rs.getDate("thoiGianDoiTra");
//                String hinhThuc = rs.getString("hinhThucDoiTra");
//                double tongTien = rs.getDouble("tongTien");
//                
//                ConvertStringToEnum toEnum = new ConvertStringToEnum();
//                
//                dt = new DoiTraEntity(maDT, hd, nv, toEnum.HinhThucDTToEnum(hinhThuc), thoiGian, tongTien);
//            }
//
//            return dt;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
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
//    public int getTongSoLuongSPDoiTra(String maHD, String maSP) {
//         try {
//            ConnectDB.getInstance().connect();
//        } catch (SQLException ex) {
//            Logger.getLogger(DoiTra_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement statement = null;
//        try {
//
//            String sql = "select tongSoLuong=sum(ctdt.soLuong) from DoiTra as dt inner join ChiTietDoiTra as ctdt on dt.maDT=ctdt.maDT " +
//            "where dt.maHD=? and dt.hinhThucDoiTra=N'Hoàn trả' and ctdt.maSP=? " +
//            "group by ctdt.maSP";
//            statement = con.prepareStatement(sql);
//            statement.setString(1, maHD);
//            statement.setString(2, maSP);
//
//            ResultSet rs = statement.executeQuery();
//            
//            int tongSoLuong = 0;
//            if(rs.next()) {
//                tongSoLuong = rs.getInt("tongSoLuong");
//            }
//
//            return tongSoLuong;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return 0;
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
//    public boolean kiemTraThoiHanDoiTra(String maHD) {
//         try {
//            ConnectDB.getInstance().connect();
//        } catch (SQLException ex) {
//            Logger.getLogger(DoiTra_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement statement = null;
//        try {
//
//            String sql = "Select thoiHan=count(*) from HoaDon where year(ngayLapHD) = year(getdate()) and month(ngayLapHD) = month(getdate()) "
//                    + "and day(ngayLapHD)+7 >= day(getdate()) and maHD=?";
//            statement = con.prepareStatement(sql);
//            statement.setString(1, maHD);
//
//            ResultSet rs = statement.executeQuery();
//            
//            boolean flag = false;
//            if(rs.next()) {
//                if(rs.getInt("thoiHan") == 1) {
//                    flag = true;
//                }
//            }
//
//            return flag;
//        } catch (SQLException e) {
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
}
