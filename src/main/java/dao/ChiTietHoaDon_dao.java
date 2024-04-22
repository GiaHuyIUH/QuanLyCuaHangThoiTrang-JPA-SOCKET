package dao;

import Interface.ChiTietHoaDon_Interface;
//import connectDB.ConnectDB;
import entity.ChatLieuEntity;
import entity.ChiTietHoaDonEntity;
import entity.ChuongTrinhKhuyenMaiEntity;
import entity.DanhMucSanPhamEntity;
import entity.HoaDonEntity;
import entity.KichThuocEnum;
import entity.MauSacEnum;
import entity.SanPhamEntity;
import entity.ThuongHieuEntity;
import entity.TinhTrangSPEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConvertStringToEnum;
import util.GenerateID;

/**
 *
 * @author DELL
 */
public class ChiTietHoaDon_dao extends UnicastRemoteObject implements ChiTietHoaDon_Interface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -795006082930773290L;
	private EntityManager em;
//	private ChiTietHoaDon_dao chiTietHoaDon_dao;
    public ChiTietHoaDon_dao() throws RemoteException{
//    	chiTietHoaDon_dao = new ChiTietHoaDon_dao();
    	em = Persistence.createEntityManagerFactory("JPA MSSQL").createEntityManager();
    }

    @Override
    public ArrayList<ChiTietHoaDonEntity> getallCTHD() throws RemoteException {
        ArrayList<ChiTietHoaDonEntity> dscthd = new ArrayList<ChiTietHoaDonEntity>();
//        Connection con = null; // Khởi tạo biến kết nối
//        try {
////            ConnectDB.getInstance().connect();
////            con = ConnectDB.getConnection(); // Gán kết nối từ ConnectDB
//            String sql = "Select * from ChiTietHoaDon";
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                String masp = rs.getString("maSP");
//                SanPhamEntity sp = new SanPhamEntity(masp);
//                String mahd = rs.getString("maHD");
//                HoaDonEntity hd = new HoaDonEntity(mahd);
//                int sl = rs.getInt("soLuong");
//                double giaban = rs.getDouble("giaBan");
//                double thanhtien = rs.getDouble("thanhTien");
//                double giaGoc = rs.getDouble("giaGoc");
//                
//                ChiTietHoaDonEntity cthd = new ChiTietHoaDonEntity(sp, hd, sl, giaGoc,giaban, thanhtien);
//                dscthd.add(cthd);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }
        dscthd = (ArrayList<ChiTietHoaDonEntity>) em.createNamedQuery("ChiTietHoaDonEntity.getAllCTHD", ChiTietHoaDonEntity.class).getResultList();
        return dscthd;

    }

    @Override
    public ArrayList<SanPhamEntity> getSanPhamTheoMaSP(String maSP) throws RemoteException{
        ArrayList<SanPhamEntity> dsSP = new ArrayList<SanPhamEntity>();
//        Connection con = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        try {
////            con = ConnectDB.getConnection();
//            String sql = "select * from SanPham where maSP = ?";
//            stmt = con.prepareStatement(sql);
//            stmt.setString(1, maSP);
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                // Xử lý dữ liệu ở đây
//                String ma = rs.getString("maSP");
//                String ten = rs.getString("tenSP");
//                KichThuocEnum kichthuoc = KichThuocEnum.valueOf(rs.getString("kichThuoc"));
//                MauSacEnum mausac = MauSacEnum.valueOf(rs.getString("mauSac"));
//                double dongia = rs.getDouble("donGia");
//                int sl = rs.getInt("soLuong");
//                TinhTrangSPEnum tinhtrang = TinhTrangSPEnum.valueOf(rs.getString("tinhTrang"));
//                ChatLieuEntity chatlieu = new ChatLieuEntity(rs.getString("maChatLieu"));
//                ThuongHieuEntity thuonghieu = new ThuongHieuEntity(rs.getString("maThuongHieu"));
//                DanhMucSanPhamEntity danhmuc = new DanhMucSanPhamEntity(rs.getString("maDanhMuc"));
//                ChuongTrinhKhuyenMaiEntity ctkm = new ChuongTrinhKhuyenMaiEntity(rs.getString("maCTKM"));
////                SanPhamEntity sp = new SanPhamEntity(maSP, ten, kichthuoc, mausac, dongia, sl, tinhtrang, chatlieu, thuonghieu, danhmuc, ctkm, null);
//                SanPhamEntity sp = new SanPhamEntity(maSP, ten, kichthuoc, mausac, dongia, sl, tinhtrang, ten, chatlieu, thuonghieu, danhmuc, ctkm);
//                dsSP.add(sp);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (stmt != null) {
//                    stmt.close();
//                }
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
        dsSP = (ArrayList<SanPhamEntity>) em.createNamedQuery("SanPhamEntity.getSanPhamTheoMaSP", SanPhamEntity.class).setParameter("maSP", maSP).getResultList();
        return dsSP;
    }

    @Override
    public ArrayList<SanPhamEntity> getSanPhamTheoMaHD(String maHD) throws RemoteException{
        
        ArrayList<SanPhamEntity> dsSP = new ArrayList<SanPhamEntity>();
//        Connection con = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        try {
////            ConnectDB.getInstance();
////            con = ConnectDB.getConnection();
//            String sql = "select * from SanPham where maSP in (select maSP from ChiTietHoaDon where maHD = ?)";
//            stmt = con.prepareStatement(sql);
//            stmt.setString(1, maHD);
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                String maSP = rs.getString("maSP");
//                String tenSP = rs.getString("tenSP");
//                String kichThuoc = rs.getString("kichThuoc");
//                String mauSac = rs.getString("mauSac");
//                int donGia = rs.getInt("donGia");
//                String tinhTrang = rs.getString("tinhTrang");
//                String chatLieu = rs.getString("maChatLieu");
//                String thuongHieu = rs.getString("maThuongHieu");
//                String danhMuc = rs.getString("maDanhMuc");
//                String ctkm = rs.getString("maCTKM");
//                String imgUrl = rs.getString("imgUrl");
//                KichThuocEnum kichThuocEnum = null;
//                if (kichThuoc.equals("XS")) {
//                    kichThuocEnum = KichThuocEnum.XS;
//                } else if (kichThuoc.equals("S")) {
//                    kichThuocEnum = KichThuocEnum.S;
//                } else if (kichThuoc.equals("M")) {
//                    kichThuocEnum = KichThuocEnum.M;
//                } else if (kichThuoc.equals("L")) {
//                    kichThuocEnum = KichThuocEnum.L;
//                } else if (kichThuoc.equals("XL")) {
//                    kichThuocEnum = KichThuocEnum.XL;
//                } else if (kichThuoc.equals("XXL")) {
//                    kichThuocEnum = KichThuocEnum.XXL;
//                }
//                MauSacEnum mauSacEnum = null;
//                if (mauSac.equals("Trắng")) {
//                    mauSacEnum = MauSacEnum.Trang;
//                } else if (mauSac.equals("Đen")) {
//                    mauSacEnum = MauSacEnum.Đen;
//                } else if (mauSac.equals("Xám")) {
//                    mauSacEnum = MauSacEnum.Xám;
//                }
//                TinhTrangSPEnum tinhTrangSPEnum = null;
//                if (tinhTrang.equals("Đang bán")) {
//                    tinhTrangSPEnum = TinhTrangSPEnum.DANGBAN;
//                } else if (tinhTrang.equals("Ngừng bán")) {
//                    tinhTrangSPEnum = TinhTrangSPEnum.NGUNGBAN;
//                }
//                ChatLieuEntity maChatLieu = new ChatLieuEntity(chatLieu);
//                ThuongHieuEntity maThuongHieu = new ThuongHieuEntity(thuongHieu);
//                DanhMucSanPhamEntity maDanhMuc = new DanhMucSanPhamEntity(danhMuc);
//                ChuongTrinhKhuyenMaiEntity maCTKM = new ChuongTrinhKhuyenMaiEntity(ctkm);
////                SanPhamEntity sp = new SanPhamEntity(maSP, tenSP, kichThuocEnum, mauSacEnum, donGia, donGia, tinhTrangSPEnum, maChatLieu, maThuongHieu, maDanhMuc, maCTKM, imgUrl);
//                SanPhamEntity sp = new SanPhamEntity(maSP, tenSP, kichThuocEnum, mauSacEnum, donGia, donGia, tinhTrangSPEnum, imgUrl, maChatLieu, maThuongHieu, maDanhMuc, maCTKM);
//                dsSP.add(sp);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (stmt != null) {
//                    stmt.close();
//                }
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
        dsSP = (ArrayList<SanPhamEntity>) em.createNamedQuery("SanPhamEntity.getSanPhamTheoMaHD", SanPhamEntity.class).setParameter("maHD", maHD).getResultList();
        return dsSP;
    }

    // Nguyen Huy Hoang
//    @Override
//    public boolean themChiTietHoaDon(ChiTietHoaDonEntity cthd) throws RemoteException{
////        PreparedStatement statement = null;
////        try {
//////            ConnectDB.getInstance().connect();
//////            Connection con = ConnectDB.getConnection();
////
////            String sql = "Insert into ChiTietHoaDon(maSP, maHD, soLuong, giaGoc, giaBan, thanhTien) values (?, ?, ?, ?, ?, ?)";
//////            statement = con.prepareStatement(sql);
////            statement.setString(1, cthd.getSanPham().getMaSP());
////            statement.setString(2, cthd.getHoaDon().getMaHD());
////            statement.setInt(3, cthd.getSoLuong());
////            statement.setDouble(4, cthd.getGiaGoc());
////            statement.setDouble(5, cthd.getGiaBan());
////            statement.setDouble(6, cthd.getThanhTien());
////
////            int ketQua = statement.executeUpdate();
////
////            if (ketQua < 1) {
////                return false;
////            }
////
////            return true;
////        } catch (SQLException e) {
////            e.printStackTrace();
////            return false;
////        } finally {
////            try {
////                statement.close();
//////                ConnectDB.getInstance().disconnect();
////            } catch (SQLException e) {
////                e.printStackTrace();
////            }
////        }
//    	   String maHD = cthd.getHoaDon().getMaHD();
//    	    
//    	    // Kiểm tra xem giá trị maHD có tồn tại trong bảng HoaDonEntity hay không
//    	    HoaDonEntity hoaDon = em.find(HoaDonEntity.class, maHD);
//    	    if (hoaDon == null) {
//    	        // Nếu maHD không tồn tại, có thể xử lý tùy theo yêu cầu của ứng dụng,
//    	        // ví dụ: trả về thông báo lỗi hoặc rollback giao dịch
//    	    	System.out.println("HoaDonEntity không tồn tại");
//    	        return false;
//    	    }
//    	EntityTransaction tx = em.getTransaction();
//    	try {
//			tx.begin();
//			em.persist(cthd);
//			tx.commit();
//			return true;
//		} catch (Exception e) {
//			tx.rollback();
//			e.printStackTrace();
//		}
//    	return false;
//    }
    @Override
	public boolean themChiTietHoaDon(ChiTietHoaDonEntity cthd) throws RemoteException {
		try {
			em.getTransaction().begin();
			int result = em.createNativeQuery(
					"INSERT INTO ChiTietHoaDon(maSP, maHD, soLuong, giaGoc, giaBan, thanhTien) VALUES (?, ?, ?, ?, ?, ?)")
					.setParameter(1, cthd.getSanPham().getMaSP()).setParameter(2, cthd.getHoaDon().getMaHD())
					.setParameter(3, cthd.getSoLuong()).setParameter(4, cthd.getGiaGoc())
					.setParameter(5, cthd.getGiaBan()).setParameter(6, cthd.getThanhTien()).executeUpdate();
			
			if (result < 1) {
				return false;
			}
			
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}
    
    @Override
    public boolean xoaCTHDTheoMaHoaDon(String maHD)throws RemoteException {
      em.getTransaction().begin();
		try {
			em.createNativeQuery("DELETE FROM ChiTietHoaDon WHERE maHD = ?").setParameter(1, maHD).executeUpdate();
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
    }

    @Override
    public ArrayList<ChiTietHoaDonEntity> getAllCTHDTheoMaHD(String maHD)throws RemoteException {

////        Connection con = ConnectDB.getConnection();
//        PreparedStatement statement = null;
//
//        try {
//            String sql = "Select cthd.*, sp.tenSP, sp.kichThuoc, sp.mauSac from ChiTietHoaDon as cthd inner join SanPham as sp on cthd.maSP=sp.maSP where maHD=?";
////            statement = con.prepareStatement(sql);
//            statement.setString(1, maHD);
//
//            ResultSet rs = statement.executeQuery();
//            ArrayList<ChiTietHoaDonEntity> cthdList = new ArrayList<ChiTietHoaDonEntity>();
//            while (rs.next()) {
//                String mahd = rs.getString("maHD");
//                HoaDonEntity hd = new HoaDonEntity(mahd);
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
//                double giaGoc = rs.getDouble("giaGoc");
//                
//                ChiTietHoaDonEntity cthd = new ChiTietHoaDonEntity(sp, hd, soLuong, giaGoc, giaBan, thanhTien);
//
//                cthdList.add(cthd);
//            }
//            return cthdList;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//           
//        }
	
		ArrayList<ChiTietHoaDonEntity> dscthd = new ArrayList<ChiTietHoaDonEntity>();
		dscthd = (ArrayList<ChiTietHoaDonEntity>) em.createNamedQuery("ChiTietHoaDonEntity.getAllCTHDTheoMaHD", ChiTietHoaDonEntity.class).setParameter("maHD", maHD).getResultList();
//		dscthd.add(cthd);
		return dscthd;
    }
    
    @Override
    public int getSoLuongCTHD(String maSP)throws RemoteException {
//        try {
////            ConnectDB.getInstance().connect();
//        } catch (SQLException ex) {
//            Logger.getLogger(HoaDon_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
////        Connection con = ConnectDB.getConnection();
//        PreparedStatement statement = null;
//
//        try {
//            String sql = "Select tongSoLuong=sum(cthd.soLuong) from ChiTietHoaDon as cthd inner join HoaDon as hd on cthd.maHD=hd.maHD where cthd.maSP=? and hd.tinhTrang=N'Chưa thanh toán' ";
////            statement = con.prepareStatement(sql);
//            statement.setString(1, maSP);
//
//            ResultSet rs = statement.executeQuery();
//            if (rs.next()) {
//                int tongSL = rs.getInt("tongSoLuong");
//                
//                return tongSL;
//            }
//            return 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        } finally {
//            
//        }
    	int tongSL = 0;
    	tongSL = (int) em.createNamedQuery("ChiTietHoaDonEntity.getSoLuongCTHD", Integer.class).setParameter("maSP", maSP).getResultList().get(0);
    	return tongSL;
    }

//chung
    @Override
    public int soluongSP(String maHD, String maSP)throws RemoteException {
        int sl = 0;
//        Connection con = null;
//        PreparedStatement stmt = null;
//        try {
////            ConnectDB.getInstance().connect();
////            con = ConnectDB.getConnection();
//            String sql = "select soLuong from ChiTietHoaDon where maHD = ? and maSP = ?";
//            stmt = con.prepareStatement(sql);
//            stmt.setString(1, maHD);
//            stmt.setString(2, maSP);
//
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                int soluong = rs.getInt("soLuong");
//                sl = soluong;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        sl = (int) em.createNamedQuery("ChiTietHoaDonEntity.soluongSPByMaSPAndMaHD", Integer.class).setParameter("maSP", maSP).setParameter("maHD", maHD).getResultList().get(0);
        return sl;
    }

    @Override
    public ArrayList<ChiTietHoaDonEntity> getCTHDTheoMaHDvaMaSP(String maHD, String maSP)throws RemoteException {
        ArrayList<ChiTietHoaDonEntity> dscthd = new ArrayList<ChiTietHoaDonEntity>();
//        try {
////            ConnectDB.getInstance().connect();
////            Connection con = ConnectDB.getConnection();
////            PreparedStatement stmt = con.prepareStatement("select * from [dbo].[ChiTietHoaDon] where maHD = ? and maSP = ?");
////            stmt.setString(1, maHD);
////            stmt.setString(2, maSP);
////            ResultSet rs = stmt.executeQuery();
////            while (rs.next()) {
////                String masp = rs.getString("maSP");
////                SanPhamEntity sp = new SanPhamEntity(masp);
////                String mahd = rs.getString("maHD");
////                HoaDonEntity hd = new HoaDonEntity(mahd);
////                int sl = rs.getInt("soLuong");
////                double giaban = rs.getDouble("giaBan");
////                double thanhtien = rs.getDouble("thanhTien");
////                double giagoc = rs.getDouble("giaGoc");
////                
////                ChiTietHoaDonEntity cthd = new ChiTietHoaDonEntity(sp, hd, sl, giagoc, giaban, thanhtien);
////                dscthd.add(cthd);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        dscthd = (ArrayList<ChiTietHoaDonEntity>) em.createNamedQuery("ChiTietHoaDonEntity.getCTHDByMaHDAndMaSP", ChiTietHoaDonEntity.class).setParameter("maHD", maHD).setParameter("maSP", maSP).getResultList();
        return dscthd;
    }

}
