
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

import javax.swing.JOptionPane;

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
    private ChiTietHoaDon_dao cthd_dao;
    public HoaDon_dao() throws RemoteException{
		em = jakarta.persistence.Persistence.createEntityManagerFactory("JPA MSSQL").createEntityManager();
		cthd_dao = new ChiTietHoaDon_dao();
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
//    @Override
//    public boolean themHoaDon(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD) throws RemoteException{
//    	 hoaDon.setTinhTrang(TinhTrangHDEnum.DATHANHTOAN);
//    	    EntityTransaction tx = em.getTransaction();
//    	    try {
//    	        tx.begin();
//    	        em.persist(hoaDon);
//    	        tx.commit(); // Thêm hoá đơn thành công, commit giao dịch
//
//    	        // Nếu hoá đơn đã được thêm thành công, thêm chi tiết hoá đơn
//    	        tx.begin();
//    	        for (ChiTietHoaDonEntity cthd : danhSachCTHD) {
//    	            if (!cthd_dao.themChiTietHoaDon(cthd)) {
//    	                // Nếu thêm chi tiết hóa đơn thất bại, rollback giao dịch và trả về false
//    	                tx.rollback();
//    	                return false;
//    	            }
//    	        }
//    	        // Nếu mọi thứ đều thành công, commit giao dịch
//    	        tx.commit();
//    	        return true;
//    	    } catch (Exception e) {
//    	        // Nếu có lỗi, rollback giao dịch và trả về false
//    	        if (tx != null && tx.isActive()) {
//    	            tx.rollback();
//    	        }
//    	        e.printStackTrace();
//    	        return false;
//    	    }
//    }
    @Override
	public boolean themHoaDon(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD) throws RemoteException{
		try {
			em.getTransaction().begin();
			int result = em.createNativeQuery("Insert into HoaDonEntity(maHD, maKH, maNV, maCTKM, ngayLapHD, tienKhuyenMai, tongTien, tienThanhToan, tinhTrang) values (?, ?, ?, ?, ?, ?, ?, ?, ?)")
					.setParameter(1, hoaDon.getMaHD()).setParameter(2, hoaDon.getKhachHang().getMaKH())
					.setParameter(3, hoaDon.getNhanVien().getMaNV()).setParameter(4, hoaDon.getChuongTrinhKM().getMaCTKM())
					.setParameter(5, hoaDon.getNgayLapHD()).setParameter(6, hoaDon.getTienKhuyenMai()).setParameter(7, hoaDon.getTongTien())
					.setParameter(8, hoaDon.getTienThanhToan()).setParameter(9, TinhTrangHDEnum.DATHANHTOAN.name()).executeUpdate();
			
			if (result < 1) {
				return false;
			}
			
			em.getTransaction().commit();
			
			ChiTietHoaDon_dao cthd_dao = new ChiTietHoaDon_dao();
			for (ChiTietHoaDonEntity cthd : danhSachCTHD) {
				if (!cthd_dao.themChiTietHoaDon(cthd)) {
					return false;
				}
			}

			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}
    
    @Override
    public boolean luuTamHoaDon(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD) throws RemoteException{
//    	hoaDon.setTinhTrang(TinhTrangHDEnum.CHUATHANHTOAN);
//		EntityTransaction tx = em.getTransaction();
//		try {
//			tx.begin();
//			em.persist(hoaDon);
//			tx.commit();
//			for (ChiTietHoaDonEntity cthd : danhSachCTHD) {
//				tx.begin();
//				em.persist(cthd);
//				tx.commit();
//			}
//			tx.commit();
//			return true;
//		} catch (Exception e) {
//			tx.rollback();
//			e.printStackTrace();
//		}
//		return false;
    	try {
			em.getTransaction().begin();
			int result = em.createNativeQuery("Insert into HoaDonEntity(maHD, maKH, maNV, maCTKM, ngayLapHD, tienKhuyenMai, tongTien, tienThanhToan, tinhTrang) values (?, ?, ?, ?, ?, ?, ?, ?, ?)")
					.setParameter(1, hoaDon.getMaHD()).setParameter(2, hoaDon.getKhachHang().getMaKH()).setParameter(3, hoaDon.getNhanVien().getMaNV())
					.setParameter(4, hoaDon.getChuongTrinhKM().getMaCTKM()).setParameter(5, hoaDon.getNgayLapHD()).setParameter(6, hoaDon.getTienKhuyenMai())
					.setParameter(7, hoaDon.getTongTien()).setParameter(8, hoaDon.getTienThanhToan()).setParameter(9,TinhTrangHDEnum.CHUATHANHTOAN.name()).executeUpdate();
			if (result < 1) {
				return false;
			}
			em.getTransaction().commit();
			
			ChiTietHoaDon_dao cthd_dao = new ChiTietHoaDon_dao();
			for (ChiTietHoaDonEntity cthd : danhSachCTHD) {
				if (!cthd_dao.themChiTietHoaDon(cthd)) {
					return false;
				}
			}

			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
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
//    	try {
//			em.getTransaction().begin();
//			hoaDon.setTinhTrang(TinhTrangHDEnum.DATHANHTOAN);
////			em.merge(hoaDon);
//			int rs = em.createNativeQuery(
//					"Update HoaDonEntity set maNV=?, maCTKM=?, ngayLapHD=?, tienKhuyenMai=?, tongTien=?, tienThanhToan=?, tinhTrang=? where maHD=? and maKH=?")
//					.setParameter(1, hoaDon.getNhanVien().getMaNV())
//					.setParameter(2, hoaDon.getChuongTrinhKM().getMaCTKM()).setParameter(3, hoaDon.getNgayLapHD())
//					.setParameter(4, hoaDon.getTienKhuyenMai()).setParameter(5, hoaDon.getTongTien())
//					.setParameter(6, hoaDon.getTienThanhToan()).setParameter(7, TinhTrangHDEnum.DATHANHTOAN.name())
//					.setParameter(8, hoaDon.getMaHD()).setParameter(9, hoaDon.getKhachHang().getMaKH()).executeUpdate();
//			if (rs < 1) {
//				return false;
//			}
//			em.getTransaction().commit();
//
//			ChiTietHoaDon_dao cthd_dao = new ChiTietHoaDon_dao();
//			boolean kq = cthd_dao.xoaCTHDTheoMaHoaDon(hoaDon.getMaHD());
//
//			if (kq) {
//				for (ChiTietHoaDonEntity cthd : danhSachCTHD) {
//					if (!cthd_dao.themChiTietHoaDon(cthd)) {
//						return false;
//					}
//				}
//			} else {
//				return false;
//			}
//
//			return true;
//		} catch (Exception e) {
//			em.getTransaction().rollback();
//			e.printStackTrace();
//			return false;
//		}
//    	try {
//            em.getTransaction().begin();
//
//            // Lấy đối tượng ChuongTrinhKhuyenMaiEntity từ cơ sở dữ liệu
//            ChuongTrinhKhuyenMaiEntity chuongTrinhKM = em.find(ChuongTrinhKhuyenMaiEntity.class, hoaDon.getChuongTrinhKM().getMaCTKM());
//
//            // Gán đối tượng ChuongTrinhKhuyenMaiEntity cho trường chuongTrinhKM của HoaDonEntity
//            hoaDon.setChuongTrinhKM(chuongTrinhKM);
//
//            // Cập nhật tình trạng hoá đơn thành Đã thanh toán
//            hoaDon.setTinhTrang(TinhTrangHDEnum.DATHANHTOAN);
//
//            // Thực hiện cập nhật hoá đơn
//            em.merge(hoaDon);
//
//            // Xóa các chi tiết hoá đơn liên quan
//            em.createQuery("DELETE FROM ChiTietHoaDonEntity cthd WHERE cthd.hoaDon.maHD = :maHD")
//            .setParameter("maHD", hoaDon.getMaHD())
//            .executeUpdate();
//
//            // Thêm lại các chi tiết hoá đơn mới
//            ChiTietHoaDon_dao cthd_dao = new ChiTietHoaDon_dao();
//            for (ChiTietHoaDonEntity cthd : danhSachCTHD) {
//                if (!cthd_dao.themChiTietHoaDon(cthd)) {
//                    em.getTransaction().rollback();
//                    return false;
//                }
//            }
//
//            em.getTransaction().commit();
//
//            return true;
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//            e.printStackTrace();
//            return false;
//        }
    	try {
    	    em.getTransaction().begin();
    	    
    	    // Tìm đối tượng ChuongTrinhKhuyenMaiEntity từ cơ sở dữ liệu bằng mã
    	    ChuongTrinhKhuyenMaiEntity chuongTrinhKM = em.find(ChuongTrinhKhuyenMaiEntity.class, hoaDon.getChuongTrinhKM().getMaCTKM());
    	    
    	    // Gán đối tượng đã tìm được cho hoá đơn
    	    hoaDon.setChuongTrinhKM(chuongTrinhKM);
    	    
    	    // Cập nhật trạng thái của hoá đơn
    	    hoaDon.setTinhTrang(TinhTrangHDEnum.DATHANHTOAN);
    	    
    	    // Merge hoá đơn vào cơ sở dữ liệu
    	    em.merge(hoaDon);
    	    
    	    // Nếu không có lỗi, tiếp tục với việc xóa và thêm các chi tiết hoá đơn
    	    
    	    // Commit giao dịch
    	    em.getTransaction().commit();

    	    // Thực hiện xóa các chi tiết hoá đơn cũ
    	    ChiTietHoaDon_dao cthd_dao = new ChiTietHoaDon_dao();
    	    boolean kqXoaCTHD = cthd_dao.xoaCTHDTheoMaHoaDon(hoaDon.getMaHD());

    	    // Nếu xóa thành công, thêm các chi tiết hoá đơn mới
    	    if (kqXoaCTHD) {
    	        for (ChiTietHoaDonEntity cthd : danhSachCTHD) {
    	            if (!cthd_dao.themChiTietHoaDon(cthd)) {
    	                // Nếu có lỗi khi thêm chi tiết hoá đơn mới, rollback giao dịch
    	                JOptionPane.showMessageDialog(null, "Thêm chi tiết hóa đơn mới thất bại");
    	                em.getTransaction().rollback();
    	                return false;
    	            }
    	        }
    	    } else {
    	        // Nếu có lỗi khi xóa các chi tiết hoá đơn cũ, rollback giao dịch
    	        JOptionPane.showMessageDialog(null, "Xóa chi tiết hóa đơn cũ thất bại");
    	        em.getTransaction().rollback();
    	        return false;
    	    }

    	    return true;
    	} catch (Exception e) {
    	    // Nếu có bất kỳ lỗi nào, rollback giao dịch và hiển thị thông báo lỗi
//    	    JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
    	    if (em.getTransaction().isActive()) {
    	        em.getTransaction().rollback();
    	    }
    	    e.printStackTrace();
    	    return false;
    	}


        
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
//    	return em.find(HoaDonEntity.class, maHD);
    	return em.createQuery("SELECT hd FROM HoaDonEntity hd WHERE hd.maHD = :maHD", HoaDonEntity.class).setParameter("maHD", maHD).getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public ArrayList<HoaDonEntity> getHoaDonTheoNgayLap(Date ngayLap)throws RemoteException {
    	return (ArrayList<HoaDonEntity>) em.createNamedQuery("HoaDon.getHoaDonTheoNgayLap", HoaDonEntity.class).setParameter("ngayLap", ngayLap).getResultList();
	
    }

    @Override
    public ArrayList<HoaDonEntity> getHoaDonTheoMaHDvaNgayLap(String maHD, java.util.Date ngayLap)throws RemoteException {
    	return (ArrayList<HoaDonEntity>) em.createNamedQuery("HoaDon.getHoaDonTheoMaHDvaNgayLap", HoaDonEntity.class).setParameter("maHD", maHD).setParameter("ngayLap", ngayLap).getResultList();
    }

	@Override
	public boolean CapNhatTTDoiTraHoaDon(HoaDonEntity hd) throws RemoteException {
		// TODO Auto-generated method stub
		
		try {
			em.getTransaction().begin();
			em.merge(hd);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return false;
	}
    	
}
