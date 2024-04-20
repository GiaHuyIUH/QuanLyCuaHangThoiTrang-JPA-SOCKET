package dao;

import Interface.ThongKe_Interface;
import jakarta.persistence.EntityManager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import util.ConvertDoubleToMoney;

public class ThongKe_dao extends UnicastRemoteObject implements ThongKe_Interface {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7005904673561366342L;
	private ConvertDoubleToMoney convert;
    private EntityManager em;

    public ThongKe_dao() throws RemoteException {
        this.convert = new ConvertDoubleToMoney();
        em = jakarta.persistence.Persistence.createEntityManagerFactory("JPA MSSQL").createEntityManager();
    }

    @Override
    public ArrayList<Object[]> getListThongKeDoanhThu() throws RemoteException {
    	List<Object[]> listObj = new ArrayList<>();

		String jpql = "SELECT " + "COUNT(DISTINCT cthd.sanPham.maSP) AS SoSanPhamDaBan, "
				+ "SUM(cthd.soLuong) AS TongSoLuongBan, " + "SUM(cthd.thanhTien) AS TongGiaBan, "
				+ "SUM(hd.tongTien) AS TongGiaChi, " + "SUM(mhn.soLuongNhap * sp.donGia) AS TongNhapHang, "
				+ "SUM(hd.tongTien - (mhn.soLuongNhap * sp.donGia)) AS LoiNhuan " + "FROM " + "HoaDonEntity hd "
				+ "JOIN hd.chiTietHoaDon cthd " + "LEFT JOIN cthd.sanPham sp " + "LEFT JOIN sp.matHangNhap mhn";

		List<Object[]> resultList = em.createQuery(jpql).getResultList();

		for (Object[] row : resultList) {
			for (int i = 0; i < row.length; i++) {
				if (row[i] instanceof Double) {
					row[i] = String.format("%.2f", row[i]);
				}
			}
			listObj.add(row);
		}

		return (ArrayList<Object[]>) listObj;
    }

    @Override
    public ArrayList<Object[]> getListThongKeDoanhSo() throws RemoteException {
    	String jpql = "SELECT sp.maSP AS MaSanPham, " + "sp.tenSP AS TenSanPham, " + "SUM(cthd.soLuong) AS SoLuongBan "
				+ "FROM SanPhamEntity sp " + "JOIN sp.chiTietHoaDon cthd " + "GROUP BY sp.maSP, sp.tenSP "
				+ "ORDER BY SoLuongBan DESC";
		List<Object[]> listResult = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<Object[]> listObj = em.createQuery(jpql).setMaxResults(5).getResultList();

		for (Object[] row : listObj) {
			for (int i = 0; i < row.length; i++) {
				if (row[i] instanceof Double) {
					row[i] = String.format("%.2f", row[i]);
				} else if (row[i] instanceof String) {
					row[i] = row[i];
				}
			}
			listResult.add(row);
		}
		return (ArrayList<Object[]>) listResult;
    }

    public ArrayList<Object[]> getListThongKeDoanhSoTheoThangNam(String thangNam, String sort)throws RemoteException  {
    	String jpql = "SELECT sp.maSP AS MaSanPham, " + "       sp.tenSP AS TenSanPham, "
				+ "       SUM(cthd.soLuong) AS SoLuongBan " + "FROM SanPhamEntity sp " + "JOIN sp.chiTietHoaDon cthd "
				+ "JOIN cthd.hoaDon hd " + "WHERE hd.maHD LIKE CONCAT('HD__', :thangNam, '%') "
				+ "GROUP BY sp.maSP, sp.tenSP ";

		if ("ASC".equalsIgnoreCase(sort) || "DESC".equalsIgnoreCase(sort)) {
			jpql += "ORDER BY SoLuongBan " + sort;
		}

		List<Object[]> listResult = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<Object[]> listObj = em.createQuery(jpql).setParameter("thangNam", thangNam).getResultList();

		for (Object[] object : listObj) {
			for (int i = 0; i < object.length; i++) {
				if (object[i] instanceof Double) {
					object[i] = String.format("%.2f", object[i]);
				}
			}
			listResult.add(object);
		}
		return (ArrayList<Object[]>) listResult;
    }

    public ArrayList<Object[]> getListThongKeDoanhSoTheoNam(String Nam, String sort) throws RemoteException {
    	List<Object[]> listResult = new ArrayList<>();
		String jpql = "SELECT sp.maSP AS MaSanPham,\r\n" + "       sp.tenSP AS TenSanPham,\r\n"
				+ "       SUM(cthd.soLuong) AS SoLuongBan\r\n" + "FROM SanPhamEntity sp\r\n"
				+ "JOIN sp.chiTietHoaDon cthd\r\n" + "WHERE cthd.hoaDon.maHD LIKE CONCAT('HD____', :parameter, '%')\r\n"
				+ "GROUP BY sp.maSP, sp.tenSP\r\n" + "";
		if ("ASC".equalsIgnoreCase(sort) || "DESC".equalsIgnoreCase(sort)) {
			jpql += "ORDER BY SoLuongBan " + sort;
		}

		@SuppressWarnings("unchecked")
		List<Object[]> listObj = em.createQuery(jpql).setParameter("parameter", Nam).getResultList();

		for (Object[] object : listObj) {
			for (int i = 0; i < object.length; i++) {
				if (object[i] instanceof Double) {
					object[i] = String.format("%.2f", object[i]);
				} else if (object[i] instanceof String) {
					object[i] = object[i];
				}
			}
			listResult.add(object);
		}
		return (ArrayList<Object[]>) listResult;
    }

    @Override
    public ArrayList<Object[]> getListDoanhThuTheoThangvaNam(String thang, String nam)throws RemoteException  {
    	String jpql = "SELECT \r\n" + "    FUNCTION('FORMAT', hd.ngayLapHD, 'dd-MM') AS NgayBan,\r\n"
				+ "    COALESCE(SUM(dt.thanhTien), 0) AS TongTienDoiTra, \r\n"
				+ "    COALESCE(SUM(hdct.thanhTien), 0) AS TongTienHoaDon,\r\n"
				+ "    (COALESCE(SUM(hdct.thanhTien), 0) - COALESCE(SUM(dt.thanhTien), 0)) AS DoanhThuTrongNgay\r\n"
				+ "FROM \r\n" + "    HoaDonEntity hd\r\n" + "JOIN\r\n" + "    hd.chiTietHoaDon hdct\r\n"
				+ "LEFT JOIN \r\n" + "    hdct.sanPham sp\r\n" + "LEFT JOIN \r\n" + "    sp.chiTietDoiTra dt\r\n"
				+ "LEFT JOIN \r\n" + "    dt.doiTra dtDt\r\n" + "WHERE\r\n"
				+ "    FUNCTION('YEAR', hd.ngayLapHD) = :yearParam AND FUNCTION('MONTH', hd.ngayLapHD) = :monthParam\r\n"
				+ "GROUP BY \r\n" + "    FUNCTION('FORMAT', hd.ngayLapHD, 'dd-MM')\r\n";

		List<Object[]> listResult = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<Object[]> listObj = em.createQuery(jpql).setParameter("yearParam", nam).setParameter("monthParam", thang)
				.getResultList();

		for (Object[] object : listObj) {
			for (int i = 0; i < object.length; i++) {
				if (object[i] instanceof Double) {
					object[i] = String.format("%.2f", object[i]);
				} else if (object[i] instanceof String) {
					object[i] = object[i];
				}
			}
			listResult.add(object);
		}
		return (ArrayList<Object[]>) listResult;
    }

    @Override
    public ArrayList<Object[]> getListDoanhThuTrongNam(String nam) throws RemoteException {
    	String jpql = "SELECT \r\n" + "    FUNCTION('MONTH', hd.ngayLapHD) AS Thang,\r\n"
				+ "    COALESCE(SUM(dt.thanhTien), 0) AS TongTienDoiTra, \r\n"
				+ "    COALESCE(SUM(hdct.thanhTien), 0) AS TongTienHoaDon,\r\n"
				+ "    (COALESCE(SUM(hdct.thanhTien), 0) - COALESCE(SUM(dt.thanhTien), 0)) AS DoanhThuTrongNgay\r\n"
				+ "FROM \r\n" + "    HoaDonEntity hd\r\n" + "JOIN \r\n" + "    hd.chiTietHoaDon hdct\r\n"
				+ "LEFT JOIN \r\n" + "    hdct.sanPham sp\r\n" + "LEFT JOIN \r\n" + "    sp.chiTietDoiTra dt\r\n"
				+ "LEFT JOIN \r\n" + "    dt.doiTra dtDt\r\n" + "WHERE \r\n"
				+ "    FUNCTION('YEAR', hd.ngayLapHD) = :nam\r\n" + "GROUP BY \r\n"
				+ "    FUNCTION('MONTH', hd.ngayLapHD)\r\n";
		List<Object[]> listResult = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<Object[]> listObj = em.createQuery(jpql).setParameter("nam", nam).getResultList();

		for (Object[] object : listObj) {
			for (int i = 0; i < object.length; i++) {
				if (object[i] instanceof Double) {
					object[i] = String.format("%.2f", object[i]);
				} else if (object[i] instanceof String) {
					object[i] = object[i];
				}
			}
			listResult.add(object);
		}
		return (ArrayList<Object[]>) listResult;
    }

    @Override
    public ArrayList<Object[]> getListTop5NhanVienDoanhThuCaoNhat(String thang, String nam)throws RemoteException  {
    	String jpql = "";
		@SuppressWarnings("unchecked")
		List<Object[]> listObj = new ArrayList<>();
		if (thang.isBlank()) {
			jpql += "SELECT NV.maNV, NV.hoTen, SUM(HD.tongTien) AS tongDoanhThu\r\n"
					+ "FROM HoaDonEntity HD JOIN HD.nhanVien NV\r\n" + "WHERE FUNCTION('YEAR', HD.ngayLapHD) = :nam\r\n"
					+ "GROUP BY NV.maNV, NV.hoTen\r\n" + "ORDER BY tongDoanhThu DESC\r\n";
			listObj = em.createQuery(jpql).setParameter("nam", nam).getResultList();

		} else {
			jpql += "SELECT NV.maNV, NV.hoTen, SUM(HD.tongTien) AS tongDoanhThu\r\n"
					+ "FROM HoaDonEntity HD JOIN HD.nhanVien NV\r\n"
					+ "WHERE FUNCTION('MONTH', HD.ngayLapHD) = :month AND FUNCTION('YEAR', HD.ngayLapHD) = :nam\r\n"
					+ "GROUP BY NV.maNV, NV.hoTen\r\n" + "ORDER BY tongDoanhThu DESC\r\n";
			listObj = em.createQuery(jpql).setParameter("month", thang).setParameter("nam", nam).getResultList();
		}
		List<Object[]> listResult = new ArrayList<>();

		for (Object[] object : listObj) {
			for (int i = 0; i < object.length; i++) {
				if (object[i] instanceof Double) {
					object[i] = String.format("%.2f", object[i]);
				}
			}
			listResult.add(object);
		}
		return (ArrayList<Object[]>) listResult;
    }

    @Override
    public ArrayList<Object[]> getListTop5KhachHangMuaHangNhieuNhat(String thang, String nam)throws RemoteException  {
    	String jpql = "";
		@SuppressWarnings("unchecked")
		List<Object[]> listObj = new ArrayList<>();
		if (thang.isBlank()) {
			jpql += "SELECT KH.maKH, KH.hoTen, SUM(HD.tienThanhToan) AS tongDoanhThu\r\n"
					+ "FROM HoaDonEntity HD JOIN HD.khachHang KH\r\n"
					+ "WHERE FUNCTION('YEAR', HD.ngayLapHD) = :year\r\n" + "GROUP BY KH.maKH, KH.hoTen\r\n"
					+ "ORDER BY tongDoanhThu DESC\r\n";
			listObj = em.createQuery(jpql).setParameter("year", nam).setMaxResults(5).getResultList();

		} else {
			jpql += "SELECT KH.maKH, KH.hoTen, SUM(HD.tienThanhToan) AS tongDoanhThu\r\n"
					+ "FROM HoaDonEntity HD JOIN HD.khachHang KH\r\n"
					+ "WHERE FUNCTION('YEAR', HD.ngayLapHD) = :year AND FUNCTION('MONTH', HD.ngayLapHD) = :month\r\n"
					+ "GROUP BY KH.maKH, KH.hoTen\r\n" + "ORDER BY tongDoanhThu DESC\r\n";
			listObj = em.createQuery(jpql).setParameter("year", nam).setParameter("month", thang).getResultList();
		}
		List<Object[]> listResult = new ArrayList<>();

		for (Object[] object : listObj) {
			for (int i = 0; i < object.length; i++) {
				if (object[i] instanceof Double) {
					object[i] = String.format("%.2f", object[i]);
				} else if (object[i] instanceof String) {
					object[i] = object[i];
				}
			}
			listResult.add(object);
		}
		return (ArrayList<Object[]>) listResult;
    }

    @Override
    public ArrayList<Object[]> getListDoanhThuBySort(String thang, String nam)throws RemoteException  {
    	String jpql = "SELECT \r\n"
				+ "    FUNCTION('FORMAT', hd.ngayLapHD, 'dd-MM') AS NgayBan,\r\n"
				+ "    COALESCE(SUM(dt.thanhTien), 0) AS TongTienDoiTra,\r\n"
				+ "    COALESCE(SUM(cthd.thanhTien), 0) AS TongTienHoaDon,\r\n"
				+ "    (COALESCE(SUM(cthd.thanhTien), 0) - COALESCE(SUM(dt.thanhTien), 0)) AS DoanhThuTrongNgay\r\n"
				+ "FROM \r\n"
				+ "    HoaDonEntity hd\r\n"
				+ "JOIN \r\n"
				+ "    ChiTietHoaDonEntity cthd ON hd.maHD = cthd.hoaDon.maHD\r\n"
				+ "LEFT JOIN \r\n"
				+ "    ChiTietDoiTraEntity dt ON cthd.sanPham.maSP = dt.sanPham.maSP\r\n"
				+ "LEFT JOIN \r\n"
				+ "    DoiTraEntity doiTra ON dt.doiTra.maDT = doiTra.maDT\r\n"
				+ "WHERE \r\n"
				+ "    FUNCTION('YEAR', hd.ngayLapHD) = :year AND FUNCTION('MONTH', hd.ngayLapHD) = :month\r\n"
				+ "GROUP BY \r\n"
				+ "    FUNCTION('FORMAT', hd.ngayLapHD, 'dd-MM')\r\n"
				+ "ORDER BY \r\n"
				+ "    DoanhThuTrongNgay DESC\r\n"
				+ "";

		List<Object[]> listResult = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<Object[]> listObj = em.createQuery(jpql).setParameter("year", nam).setParameter("month", thang)
				.getResultList();
		for (Object[] object : listObj) {
			for (int i = 0; i < object.length; i++) {
				if (object[i] instanceof Double) {
					object[i] = String.format("%.2f", object[i]);
				} else if (object[i] instanceof String) {
					object[i] = object[i];
				}
			}
			listResult.add(object);
		}
		return (ArrayList<Object[]>) listResult;
    }

}
