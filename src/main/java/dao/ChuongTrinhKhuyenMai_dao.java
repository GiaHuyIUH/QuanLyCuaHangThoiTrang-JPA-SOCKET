
package dao;

import Interface.ChuongTrinhKhuyenMai_Interface;
//import connectDB.ConnectDB;
import entity.ChuongTrinhKhuyenMaiEntity;
import entity.LoaiKhuyenMaiEntity;
import gui.KhuyenMai_JPanel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DELL
 */
public class ChuongTrinhKhuyenMai_dao extends UnicastRemoteObject implements ChuongTrinhKhuyenMai_Interface {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6564856768160309775L;
	private EntityManager em;
	public ChuongTrinhKhuyenMai_dao() throws RemoteException {
		em = Persistence.createEntityManagerFactory("JPA MSSQL").createEntityManager();
    }

    public ArrayList<ChuongTrinhKhuyenMaiEntity> getallCTKM()throws RemoteException {
        ArrayList<ChuongTrinhKhuyenMaiEntity> dsctkm = new ArrayList<ChuongTrinhKhuyenMaiEntity>();
//        try {
           
            String sql = "Select * from ChuongTrinhKhuyenMai";
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                String ma = rs.getString("maCTKM");
//                String ten = rs.getString("tenCTKM");
//                String maLoaiKM = rs.getString("maLoaiCTKM");
//                LoaiKhuyenMaiEntity lkm = new LoaiKhuyenMaiEntity(maLoaiKM);
//                double sotienTT = rs.getDouble("soTienToiThieu");
//                double sotienTD = rs.getDouble("soTienToiDa");
//                int giamgia = rs.getInt("giamGia");
//                Date ngaybatdau = rs.getDate("ngayBatDau");
//                Date ngayketthuc = rs.getDate("ngayKetThuc");
//                String tinhTrang = rs.getString("tinhTrang");
////                ChuongTrinhKhuyenMaiEntity ctkm = new ChuongTrinhKhuyenMaiEntity(ma, ten, sotienTT, giamgia, ngaybatdau, ngayketthuc);
//                ChuongTrinhKhuyenMaiEntity ctkm = new ChuongTrinhKhuyenMaiEntity(ma, ten, lkm, sotienTT, sotienTD, giamgia, ngaybatdau, ngayketthuc, tinhTrang);
//                dsctkm.add(ctkm);
//            }
//
////            ResultSet rs = statement.executeQuery(sql);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
            dsctkm = (ArrayList<ChuongTrinhKhuyenMaiEntity>) em.createNamedQuery("ChuongTrinhKhuyenMaiEntity.getAllCTKM",ChuongTrinhKhuyenMaiEntity.class).getResultList();
        return dsctkm;
    }

    @Override
    public ArrayList<ChuongTrinhKhuyenMaiEntity> getCTKMTheoMaCTKM(String maCTKM,String maLoai)throws RemoteException {
        ArrayList<ChuongTrinhKhuyenMaiEntity> dsctkm = new ArrayList<ChuongTrinhKhuyenMaiEntity>();
//        
////        Connection con = ConnectDB.getConnection();
//        PreparedStatement stmt = null;
//        try {
//            String sql = "SELECT * FROM ChuongTrinhKhuyenMai WHERE maCTKM = ? and maLoaiCTKM = ?";
////            stmt = con.prepareStatement(sql);
//            stmt.setString(1, maCTKM);
//            stmt.setString(2, maLoai);
//            ResultSet  rs = stmt.executeQuery();
//            while (rs.next()){
//                 String maKM = rs.getString("maCTKM");
//                String ten = rs.getString("tenCTKM");
//                String maLoaiKM = rs.getString("maLoaiCTKM");
//                LoaiKhuyenMaiEntity lkm = new LoaiKhuyenMaiEntity(maLoaiKM);
//                double sotienTT = rs.getDouble("soTienToiThieu");
//                double sotienTD = rs.getDouble("soTienToiDa");
//                int giamgia = rs.getInt("giamGia");
//                Date ngaybatdau = rs.getDate("ngayBatDau");
//                Date ngayketthuc = rs.getDate("ngayKetThuc");
//                String tinhTrang = rs.getString("tinhTrang");
////                ChuongTrinhKhuyenMaiEntity ctkm = new ChuongTrinhKhuyenMaiEntity(ma, ten, sotienTT, giamgia, ngaybatdau, ngayketthuc);
//                ChuongTrinhKhuyenMaiEntity ctkm = new ChuongTrinhKhuyenMaiEntity(maKM, ten, lkm, sotienTT, sotienTD, giamgia, ngaybatdau, ngayketthuc, tinhTrang);
//                dsctkm.add(ctkm);
//                
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
		dsctkm = (ArrayList<ChuongTrinhKhuyenMaiEntity>) em
				.createNamedQuery("ChuongTrinhKhuyenMaiEntity.getCTKMTheoMaCTKMAndMaLoaiCTKM",
						ChuongTrinhKhuyenMaiEntity.class)
				.setParameter("maCTKM", maCTKM).setParameter("maLoaiKM", maLoai).getResultList();
        return dsctkm;
    }

    @Override
    public boolean create(ChuongTrinhKhuyenMaiEntity ctkm) throws RemoteException{
       
//       Connection con = ConnectDB.getConnection();
//       PreparedStatement stmt = null;
//       int n =0;
//        try {
////            stmt = con.prepareStatement("INSERT INTO ChuongTrinhKhuyenMai values(?,?,?,?,?,?,?,?,?)");
//            stmt.setString(1, ctkm.getMaCTKM());
//            
//            stmt.setString(2, ctkm.getTenCTKM());
//            stmt.setDouble(3, ctkm.getSoTienToiDa());
//            stmt.setDouble(4, ctkm.getSoTienToiThieu());
//            stmt.setInt(5, ctkm.getGiamGia());
//            stmt.setDate(6, (Date) ctkm.getNgayBatDau());
//            stmt.setDate(7, (Date) ctkm.getNgayKetThuc());
//            stmt.setString(8, ctkm.getTinhTrang());
//            stmt.setString(9, ctkm.getMaLoaiKM().getMaLoaiKM());
//            n = stmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally{
//            try {
//                stmt.close();
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
//        }
    	EntityTransaction tx = em.getTransaction();
    	try {
			tx.begin();
			em.persist(ctkm);
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
    public boolean delete(ChuongTrinhKhuyenMaiEntity ctkm)throws RemoteException {
//        try {
//            ConnectDB.getInstance().connect();
//        } catch (SQLException ex) {
//            Logger.getLogger(ChuongTrinhKhuyenMai_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//       Connection con = ConnectDB.getConnection();
//       PreparedStatement stmt = null;
//       int n =0;
//        try {
//            String sql = "DELETE FROM ChuongTrinhKhuyenMai WHERE maCTKM = ?";
//            stmt = con.prepareStatement(sql);
//            stmt.setString(1, ctkm.getMaCTKM());
////            stmt.executeQuery();
//            n = stmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                stmt.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return n >0;
		return false;
    }

    @Override
    public boolean update(ChuongTrinhKhuyenMaiEntity ctkm)throws RemoteException {
//        try {
//            ConnectDB.getInstance().connect();
//        } catch (SQLException ex) {
//            Logger.getLogger(ChuongTrinhKhuyenMai_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//       Connection con = ConnectDB.getConnection();
//       PreparedStatement stmt = null;
//       int n =0;
//        try {
//            if(ctkm.getMaLoaiKM().getMaLoaiKM().equals("GGHD")){
//                stmt = con.prepareStatement("update ChuongTrinhKhuyenMai set tenCTKM = ?,maLoaiCTKM = ?,soTienToiDa = ?,soTienToiThieu = ?,giamGia = ?,ngayBatDau = ?,ngayKetThuc = ?,tinhTrang =? where maCTKM = ? ");
//                stmt.setString(1, ctkm.getTenCTKM());
//                stmt.setString(2,ctkm.getMaLoaiKM().getMaLoaiKM());
//                 stmt.setDouble(3, ctkm.getSoTienToiDa());
//                stmt.setDouble(4, ctkm.getSoTienToiThieu());
//                stmt.setInt(5, ctkm.getGiamGia());
//                stmt.setDate(6, (Date) ctkm.getNgayBatDau());
//                stmt.setDate(7,(Date)ctkm.getNgayKetThuc());
//                 stmt.setString(8, ctkm.getTinhTrang());
//                stmt.setString(9, ctkm.getMaCTKM());
//            }
//            else {
//                stmt = con.prepareStatement("update ChuongTrinhKhuyenMai set tenCTKM = ?,maLoaiCTKM = ?,giamGia = ?,ngayBatDau = ?,ngayKetThuc = ?,tinhTrang =? where maCTKM = ? ");
//                stmt.setString(1, ctkm.getTenCTKM());
//                stmt.setString(2,ctkm.getMaLoaiKM().getMaLoaiKM());
////                stmt.setDouble(3, ctkm.getSoTienToiDa());
////                stmt.setDouble(4, ctkm.getSoTienToiThieu());
//                stmt.setInt(3, ctkm.getGiamGia());
//                stmt.setDate(4, (Date) ctkm.getNgayBatDau());
//                stmt.setDate(5,(Date)ctkm.getNgayKetThuc());
//                 stmt.setString(6, ctkm.getTinhTrang());
//                stmt.setString(7, ctkm.getMaCTKM());
//            }
//            
//
//            n = stmt.executeUpdate();
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    	EntityTransaction tx = em.getTransaction();
    	try {
    		tx.begin();
    		em.merge(ctkm);
    		tx.commit();
    		return true;
    	}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
    	}
        return false;
        
    }
       @Override
    public ArrayList<LoaiKhuyenMaiEntity> getallLoaiCTKM()throws RemoteException {
        ArrayList<LoaiKhuyenMaiEntity> dsLoaiKM = new ArrayList<>();
        
//       try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            Statement stmt = null;
//            
//            String sql = "select * from LoaiChuongTrinhKhuyenMai";
//            stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()){
//                String ma = rs.getString("maLoaiCTKM");
//                String mota = rs.getString("moTa");
//                LoaiKhuyenMaiEntity lkm = new  LoaiKhuyenMaiEntity(ma, mota);
//                dsLoaiKM.add(lkm);
//            } 
//        } catch (Exception e) {
//        
//            e.printStackTrace();
//    }
        dsLoaiKM = (ArrayList<LoaiKhuyenMaiEntity>) em.createNamedQuery("LoaiKhuyenMaiEntity.getAllLoaiKhuyenMai",LoaiKhuyenMaiEntity.class).getResultList();
        return dsLoaiKM;
}
    
    // Nguyen Huy Hoang
    @Override
    public ChuongTrinhKhuyenMaiEntity kiemTraKhuyenMai(double tongTien)throws RemoteException {
       
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement statement = null;
//        
//        try {
//            String sql = "Select top 1 * from ChuongTrinhKhuyenMai where getdate() between ngayBatDau and ngayKetThuc and soTienToiThieu <= ? and maLoaiCTKM='GGHD' order by giamGia desc";
//            statement = con.prepareStatement(sql);
//            statement.setDouble(1, tongTien);
//            
//            ResultSet rs = statement.executeQuery();
//            ChuongTrinhKhuyenMaiEntity ctkm = null;
//            if(rs.next()) {
//                String maCTKM = rs.getString("maCTKM");
//                String tenCTKM = rs.getString("tenCTKM");
//                double soTienToiThieu = rs.getDouble("soTienToiThieu");
//                double soTienToiDa = rs.getDouble("soTienToiDa");
//                int giamGia = rs.getInt("giamGia");
//                Date ngayBatDau = rs.getDate("ngayBatDau");
//                Date ngayKetThuc = rs.getDate("ngayKetThuc");
//                String tinhTrang = rs.getString("tinhTrang");
//                LoaiKhuyenMaiEntity loaiKM = new LoaiKhuyenMaiEntity(rs.getString("maLoaiCTKM"));
//                
//                ctkm = new ChuongTrinhKhuyenMaiEntity(maCTKM, tenCTKM, loaiKM, soTienToiThieu, soTienToiDa, giamGia, ngayBatDau, ngayKetThuc, tinhTrang);
//            }
//            
//            return ctkm;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            if(con != null) {
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ChuongTrinhKhuyenMai_dao.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
    	ChuongTrinhKhuyenMaiEntity ctkm = em.createNamedQuery("ChuongTrinhKhuyenMaiEntity.kiemTraKhuyenMai", ChuongTrinhKhuyenMaiEntity.class).setParameter("currentDate", new Date(System.currentTimeMillis())).setParameter("soTienToiThieu", tongTien).setMaxResults(1).getResultList().stream().findFirst().orElse(null);
    	        return ctkm;
    }

    @Override
    public ArrayList<ChuongTrinhKhuyenMaiEntity> getallCTKMtheoLoaiKM(String ma)throws RemoteException {
        ArrayList<ChuongTrinhKhuyenMaiEntity> dsctkm = new ArrayList<>();
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement stmt = null;
//            String sql = "select * from ChuongTrinhKhuyenMai where maLoaiCTKM = ?";
////            String sql = "select * from ChuongTrinhKhuyenMai where maLoaiCTKM = ? and tinhTrang=N'Còn'";
//            stmt =con.prepareStatement(sql);
//            stmt.setString(1, ma);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()){
//                 String maKM = rs.getString("maCTKM");
//                String ten = rs.getString("tenCTKM");
//                String maLoaiKM = rs.getString("maLoaiCTKM");
//                LoaiKhuyenMaiEntity lkm = new LoaiKhuyenMaiEntity(maLoaiKM);
//                double sotienTT = rs.getDouble("soTienToiThieu");
//                double sotienTD = rs.getDouble("soTienToiDa");
//                int giamgia = rs.getInt("giamGia");
//                Date ngaybatdau = rs.getDate("ngayBatDau");
//                Date ngayketthuc = rs.getDate("ngayKetThuc");
//                String tinhTrang = rs.getString("tinhTrang");
////                ChuongTrinhKhuyenMaiEntity ctkm = new ChuongTrinhKhuyenMaiEntity(ma, ten, sotienTT, giamgia, ngaybatdau, ngayketthuc);
//                ChuongTrinhKhuyenMaiEntity ctkm = new ChuongTrinhKhuyenMaiEntity(maKM, ten, lkm, sotienTT, sotienTD, giamgia, ngaybatdau, ngayketthuc, tinhTrang);
//                dsctkm.add(ctkm);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        dsctkm = (ArrayList<ChuongTrinhKhuyenMaiEntity>) em.createNamedQuery("ChuongTrinhKhuyenMaiEntity.getallCTKMtheoLoaiKM",ChuongTrinhKhuyenMaiEntity.class).setParameter("maLoaiKM", ma).getResultList();
        return dsctkm;
    }

 @Override
    public String layTenKhuyenMaiTheoMa(String maDanhMuc)throws RemoteException {
        String tenDanhMuc = null;
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement ps = null;
//
//            String sql = "SELECT tenCTKM FROM ChuongTrinhKhuyenMai WHERE maCTKM = ?";
//            ps = con.prepareStatement(sql);
//            ps.setString(1, maDanhMuc);
//
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                tenDanhMuc = rs.getString("tenCTKM");
//            }
//
//            ps.close();
//            rs.close();
//            ConnectDB.getInstance().disconnect();
//        } catch (SQLException ex) {
//            Logger.getLogger(DanhMucSanPham_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
        tenDanhMuc = em.createNamedQuery("ChuongTrinhKhuyenMaiEntity.layTenKhuyenMaiTheoMa",String.class).setParameter("maCTKM", maDanhMuc).getResultList().stream().findFirst().orElse(null).toString();
        return tenDanhMuc;
    }

    @Override
    public String layMaKhuyenMaiTheoTen(String tenDanhMuc)throws RemoteException {
//        String maDanhMuc = null;
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement ps = null;
//            String sql = "SELECT maCTKM FROM ChuongTrinhKhuyenMai WHERE tenCTKM = ? AND tinhTrang=N'Còn'";
//            ps = con.prepareStatement(sql);
//            ps.setString(1, tenDanhMuc);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                maDanhMuc = rs.getString("maCTKM");
//            }
//
//            ps.close();
//            rs.close();
//            ConnectDB.getInstance().disconnect();
//        } catch (SQLException ex) {
//            Logger.getLogger(DanhMucSanPham_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        maDanhMuc = em.createNamedQuery("ChuongTrinhKhuyenMaiEntity.layMaKhuyenMaiTheoTen",String.class).setParameter("tenCTKM", tenDanhMuc).getResultList().stream().findFirst().orElse(null);
    	try {
    	    // Thực hiện truy vấn để lấy giá trị maCTKM từ bảng "ChuongTrinhKhuyenMaiEntity"
    	    String maKM = (String) em.createNativeQuery("SELECT maCTKM FROM ChuongTrinhKhuyenMaiEntity WHERE tenCTKM = ? AND tinhTrang=N'Còn'")
    	                              .setParameter(1, tenDanhMuc)
    	                              .getSingleResult(); // Sử dụng getSingleResult() vì chỉ mong muốn một kết quả duy nhất

    	    // Trả về giá trị maCTKM nếu tồn tại trong bảng
    	    return maKM;
    	} catch (NoResultException e) {
    	    // Xử lý trường hợp không tìm thấy kết quả trong bảng
    	    // Ở đây, bạn có thể quyết định trả về một giá trị mặc định hoặc xử lý lỗi theo logic của ứng dụng của bạn
    	    return null; // Hoặc ném một ngoại lệ tùy thuộc vào logic ứng dụng của bạn
    	}

    }

    @Override
    public ChuongTrinhKhuyenMaiEntity getKMTheoma(String ma)throws RemoteException {
        ChuongTrinhKhuyenMaiEntity dsctkm = new ChuongTrinhKhuyenMaiEntity();
//        try {
//            ConnectDB.getInstance().connect();
//        } catch (SQLException ex) {
//            Logger.getLogger(ChuongTrinhKhuyenMai_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement stmt = null;
//        try {
//            String sql = "SELECT * FROM ChuongTrinhKhuyenMai WHERE maCTKM = ?";
//            stmt = con.prepareStatement(sql);
//            stmt.setString(1, ma);
////            stmt.setString(2, maLoai);
//            ResultSet  rs = stmt.executeQuery();
//            while (rs.next()){
//                 String maKM = rs.getString("maCTKM");
//                String ten = rs.getString("tenCTKM");
//                String maLoaiKM = rs.getString("maLoaiCTKM");
//                LoaiKhuyenMaiEntity lkm = new LoaiKhuyenMaiEntity(maLoaiKM);
//                double sotienTT = rs.getDouble("soTienToiThieu");
//                double sotienTD = rs.getDouble("soTienToiDa");
//                int giamgia = rs.getInt("giamGia");
//                Date ngaybatdau = rs.getDate("ngayBatDau");
//                Date ngayketthuc = rs.getDate("ngayKetThuc");
//                String tinhTrang = rs.getString("tinhTrang");
////                ChuongTrinhKhuyenMaiEntity ctkm = new ChuongTrinhKhuyenMaiEntity(ma, ten, sotienTT, giamgia, ngaybatdau, ngayketthuc);
//                 dsctkm = new ChuongTrinhKhuyenMaiEntity(maKM, ten, lkm, sotienTT, sotienTD, giamgia, ngaybatdau, ngayketthuc, tinhTrang);
//               
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        dsctkm = em.find(ChuongTrinhKhuyenMaiEntity.class, ma);
        return dsctkm;
    }

    @Override
    public ArrayList<ChuongTrinhKhuyenMaiEntity> getAllCTKMTheoLoaiKMVaTinhTrang(String loaiKM, String tinhTrang)throws RemoteException {
        ArrayList<ChuongTrinhKhuyenMaiEntity> dsctkm = new ArrayList<>();
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement stmt = null;
//            String sql = "select * from ChuongTrinhKhuyenMai where maLoaiCTKM = ? and tinhTrang=?";
//            stmt =con.prepareStatement(sql);
//            stmt.setString(1, loaiKM);
//            stmt.setString(2, tinhTrang);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()){
//                 String maKM = rs.getString("maCTKM");
//                String ten = rs.getString("tenCTKM");
//                String maLoaiKM = rs.getString("maLoaiCTKM");
//                LoaiKhuyenMaiEntity lkm = new LoaiKhuyenMaiEntity(maLoaiKM);
//                double sotienTT = rs.getDouble("soTienToiThieu");
//                double sotienTD = rs.getDouble("soTienToiDa");
//                int giamgia = rs.getInt("giamGia");
//                Date ngaybatdau = rs.getDate("ngayBatDau");
//                Date ngayketthuc = rs.getDate("ngayKetThuc");
//                String tinhTrangKM = rs.getString("tinhTrang");
////                ChuongTrinhKhuyenMaiEntity ctkm = new ChuongTrinhKhuyenMaiEntity(ma, ten, sotienTT, giamgia, ngaybatdau, ngayketthuc);
//                ChuongTrinhKhuyenMaiEntity ctkm = new ChuongTrinhKhuyenMaiEntity(maKM, ten, lkm, sotienTT, sotienTD, giamgia, ngaybatdau, ngayketthuc, tinhTrangKM);
//                dsctkm.add(ctkm);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        dsctkm = (ArrayList<ChuongTrinhKhuyenMaiEntity>) em.createNamedQuery("ChuongTrinhKhuyenMaiEntity.getAllCTKMTheoLoaiKMVaTinhTrang",ChuongTrinhKhuyenMaiEntity.class).setParameter("maLoaiKM", loaiKM).setParameter("tinhTrang", tinhTrang).getResultList();
        return dsctkm;
    }

    @Override
    public ChuongTrinhKhuyenMaiEntity getKMTheomaHD(String maHD) throws RemoteException{
        
       ChuongTrinhKhuyenMaiEntity dsctkm = null;
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement stmt = null;
//            String sql = "select * from ChuongTrinhKhuyenMai where maCTKM in(select maCTKM from HoaDon where maHD = ?)";
//            stmt =con.prepareStatement(sql);
//            stmt.setString(1, maHD);
//
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()){
//                 String maKM = rs.getString("maCTKM");
//                String ten = rs.getString("tenCTKM");
//                String maLoaiKM = rs.getString("maLoaiCTKM");
//                LoaiKhuyenMaiEntity lkm = new LoaiKhuyenMaiEntity(maLoaiKM);
//                double sotienTT = rs.getDouble("soTienToiThieu");
//                double sotienTD = rs.getDouble("soTienToiDa");
//                int giamgia = rs.getInt("giamGia");
//                Date ngaybatdau = rs.getDate("ngayBatDau");
//                Date ngayketthuc = rs.getDate("ngayKetThuc");
//                String tinhTrangKM = rs.getString("tinhTrang");
////                ChuongTrinhKhuyenMaiEntity ctkm = new ChuongTrinhKhuyenMaiEntity(ma, ten, sotienTT, giamgia, ngaybatdau, ngayketthuc);
//                ChuongTrinhKhuyenMaiEntity ctkm = new ChuongTrinhKhuyenMaiEntity(maKM, ten, lkm, sotienTT, sotienTD, giamgia, ngaybatdau, ngayketthuc, tinhTrangKM);
//                dsctkm = ctkm;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
           dsctkm = em.createNamedQuery("ChuongTrinhKhuyenMaiEntity.getKMTheomaHD", ChuongTrinhKhuyenMaiEntity.class).setParameter("maHD", maHD).getResultList().get(0);
        return dsctkm;
    }

}
