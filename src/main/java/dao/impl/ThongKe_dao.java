package dao.impl;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ThongKe_dao implements dao.ThongKe_Interface {

	private EntityManager em;

	public ThongKe_dao() {
		this.em = Persistence.createEntityManagerFactory("CoLenServer").createEntityManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getListThongKeDoanhThu() {
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

		return listObj;
	}

	@Override
	public List<Object[]> getListThongKeDoanhSo() {
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
		return listResult;
	}

	@Override
	public List<Object[]> getListDoanhThuTheoThangvaNam(String thang, String nam) {
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
		return listResult;
	}

	@Override
	public List<Object[]> getListDoanhThuTrongNam(String nam) {
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
		return listResult;
	}

	@Override
	public List<Object[]> getListThongKeDoanhSoTheoThangNam(String thangNam, String sort) {
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
		return listResult;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getListTop5NhanVienDoanhThuCaoNhat(String thang, String nam) {
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
		return listResult;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getListTop5KhachHangMuaHangNhieuNhat(String thang, String nam) {
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
		return listResult;
	}

	@Override
	public List<Object[]> getListThongKeDoanhSoTheoNam(String Nam, String sort) {
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
		return listResult;
	}

	@Override
	public List<Object[]> getListDoanhThuBySort(String thang, String nam) {
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
		return listResult;
	}
}

//    private ConvertDoubleToMoney convert;
//
//    public ThongKe_dao() {
//        this.convert = new ConvertDoubleToMoney();
//    }

//    @Override
//    public ArrayList<Object[]> getListThongKeDoanhThu() {
//        ArrayList<Object[]> ds = new ArrayList<Object[]>();
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            String sql = "SELECT\n"
//                    + "    COUNT(DISTINCT ChiTietHoaDon.maSP) AS SoSanPhamDaBan,\n"
//                    + "    SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan,\n"
//                    + "    SUM(ChiTietHoaDon.thanhTien) AS TongGiaBan,\n"
//                    + "    SUM(HoaDon.tongTien) AS TongGiaChi,\n"
//                    + "    SUM(MatHangNhap.soLuongNhap * SanPham.donGia) AS TongNhapHang,\n"
//                    + "    SUM(HoaDon.tongTien - (MatHangNhap.soLuongNhap * SanPham.donGia)) AS LoiNhuan\n"
//                    + "FROM\n"
//                    + "    HoaDon\n"
//                    + "    JOIN ChiTietHoaDon ON HoaDon.maHD = ChiTietHoaDon.maHD\n"
//                    + "    LEFT JOIN SanPham ON ChiTietHoaDon.maSP = SanPham.maSP\n"
//                    + "    LEFT JOIN MatHangNhap ON SanPham.maSP = MatHangNhap.maSP;";
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                int sospban = rs.getInt("SoSanPhamDaBan");
//                int tongsoluong = rs.getInt("TongSoLuongBan");
//                double thanhtien = rs.getDouble("TongGiaBan");
//                double giachi = rs.getDouble("TongGiaChi");
//                double tongnhaphang = rs.getDouble("TongNhapHang");
//                double loinhuan = rs.getDouble("LoiNhuan");
//                Object[] row = {sospban, tongsoluong, thanhtien, giachi, tongnhaphang, loinhuan};
//                ds.add(row);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ds;
//    }
//
//    @Override
//    public ArrayList<Object[]> getListThongKeDoanhSo() {
//        ArrayList<Object[]> ds = new ArrayList<Object[]>();
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            String sql = "SELECT top 5\n"
//                    + "    SanPham.maSP AS MaSanPham,\n"
//                    + "    SanPham.tenSP AS TenSanPham,\n"
//                    + "    SUM(ChiTietHoaDon.soLuong) AS SoLuongBan\n"
//                    + "FROM\n"
//                    + "    SanPham\n"
//                    + "    JOIN ChiTietHoaDon ON SanPham.maSP = ChiTietHoaDon.maSP\n"
//                    + "GROUP BY\n"
//                    + "    SanPham.maSP, SanPham.tenSP\n"
//                    + "ORDER BY\n"
//                    + "    SoLuongBan DESC";
//
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                String ma = rs.getString("MaSanPham");
//                String ten = rs.getString("TenSanPham");
//                int soluong = rs.getInt("SoLuongBan");
//                Object[] row = {ma, ten, soluong};
//                ds.add(row);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ds;
//    }
//
//    public ArrayList<Object[]> getListThongKeDoanhSoTheoThangNam(String thangNam, String sort) {
//        ArrayList<Object[]> ds = new ArrayList<Object[]>();
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            String sql = "SELECT TOP 5\n"
//                    + "    SanPham.maSP AS MaSanPham,\n"
//                    + "    SanPham.tenSP AS TenSanPham,\n"
//                    + "    SUM(ChiTietHoaDon.soLuong) AS SoLuongBan\n"
//                    + "FROM\n"
//                    + "    SanPham\n"
//                    + "    JOIN ChiTietHoaDon ON SanPham.maSP = ChiTietHoaDon.maSP\n"
//                    + "WHERE ChiTietHoaDon.maHD LIKE 'HD__' + ? + '%'\n" // Sử dụng ? để thay thế giá trị của thangNam
//                    + "GROUP BY\n"
//                    + "    SanPham.maSP, SanPham.tenSP\n"
//                    + "ORDER BY\n"
//                    + "    SoLuongBan " + sort;
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setString(1, thangNam);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                String ma = rs.getString("MaSanPham");
//                String ten = rs.getString("TenSanPham");
//                int soluong = rs.getInt("SoLuongBan");
//                Object[] row = {ma, ten, soluong};
//                ds.add(row);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ds;
//    }
//
//    public ArrayList<Object[]> getListThongKeDoanhSoTheoNam(String Nam, String sort) {
//        ArrayList<Object[]> ds = new ArrayList<Object[]>();
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            String sql = "SELECT TOP 5\n"
//                    + "    SanPham.maSP AS MaSanPham,\n"
//                    + "    SanPham.tenSP AS TenSanPham,\n"
//                    + "    SUM(ChiTietHoaDon.soLuong) AS SoLuongBan\n"
//                    + "FROM\n"
//                    + "    SanPham\n"
//                    + "    JOIN ChiTietHoaDon ON SanPham.maSP = ChiTietHoaDon.maSP\n"
//                    + "WHERE ChiTietHoaDon.maHD LIKE 'HD____' + ? + '%'\n" // Sử dụng ? để thay thế giá trị của Nam
//                    + "GROUP BY\n"
//                    + "    SanPham.maSP, SanPham.tenSP\n"
//                    + "ORDER BY\n"
//                    + "    SoLuongBan " + sort;
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setString(1, Nam);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                String ma = rs.getString("MaSanPham");
//                String ten = rs.getString("TenSanPham");
//                int soluong = rs.getInt("SoLuongBan");
//                Object[] row = {ma, ten, soluong};
//                ds.add(row);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ds;
//    }
//
//    @Override
//    public ArrayList<Object[]> getListDoanhThuTheoThangvaNam(String thang, String nam) {
//        ArrayList<Object[]> ds = new ArrayList<Object[]>();
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            String sql = "SELECT \n"
//                    + "    FORMAT(hoadon.ngayLapHD, 'dd-MM') AS NgayBan, \n"
//                    + "    COALESCE(SUM(ChiTietDoiTra.thanhTien),0) AS TongTienDoiTra, \n"
//                    + "    COALESCE(SUM(ChiTietHoaDon.thanhTien),0) AS TongTienHoaDon,\n"
//                    + "	(COALESCE(SUM(ChiTietHoaDon.thanhTien),0) - COALESCE(SUM(ChiTietDoiTra.thanhTien),0))	AS  DoanhThuTrongNgay\n"
//                    + "FROM \n"
//                    + "    HoaDon\n"
//                    + "JOIN \n"
//                    + "    ChiTietHoaDon ON HoaDon.maHD = chitiethoadon.maHD\n"
//                    + "LEFT JOIN \n"
//                    + "    ChiTietDoiTra ON ChiTietHoaDon.maSP = ChiTietDoiTra.maSP\n"
//                    + "LEFT JOIN \n"
//                    + "    DoiTra ON ChiTietDoiTra.maDT = DoiTra.maDT\n"
//                    + "	WHERE \n"
//                    + "    YEAR(ngayLapHD) = ? AND MONTH(ngayLapHD) = ?\n"
//                    + "GROUP BY \n"
//                    + "   FORMAT(hoadon.ngayLapHD, 'dd-MM')";
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setString(1, nam);
//            stmt.setString(2, thang);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                String ngay = rs.getString("NgayBan");
//                double ttDT = rs.getDouble("TongTienDoiTra");
//                double ttHD = rs.getDouble("TongTienHoaDon");
//                double doanhthu = rs.getDouble("DoanhThuTrongNgay");
//                Object[] row = {ngay, ttDT, ttHD, doanhthu};
//                ds.add(row);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ds;
//    }
//
//    @Override
//    public ArrayList<Object[]> getListDoanhThuTrongNam(String nam) {
//        ArrayList<Object[]> ds = new ArrayList<Object[]>();
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            String sql = "SELECT \n"
//                    + "    MONTH(ngayLapHD) AS Thang,\n"
//                    + "    COALESCE(SUM(ChiTietDoiTra.thanhTien),0) AS TongTienDoiTra, \n"
//                    + "    COALESCE(SUM(ChiTietHoaDon.thanhTien),0) AS TongTienHoaDon,\n"
//                    + "	(COALESCE(SUM(ChiTietHoaDon.thanhTien),0) - COALESCE(SUM(ChiTietDoiTra.thanhTien),0))	AS  DoanhThuTrongNgay\n"
//                    + "FROM \n"
//                    + "    HoaDon\n"
//                    + "JOIN \n"
//                    + "    ChiTietHoaDon ON HoaDon.maHD = chitiethoadon.maHD\n"
//                    + "LEFT JOIN \n"
//                    + "    ChiTietDoiTra ON ChiTietHoaDon.maSP = ChiTietDoiTra.maSP\n"
//                    + "LEFT JOIN \n"
//                    + "    DoiTra ON ChiTietDoiTra.maDT = DoiTra.maDT\n"
//                    + "	WHERE \n"
//                    + "    YEAR(ngayLapHD) = ? \n"
//                    + "GROUP BY \n"
//                    + "     MONTH(ngayLapHD) ";
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setString(1, nam);
//
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                int thang = rs.getInt("Thang");
//                double ttDT = rs.getDouble("TongTienDoiTra");
//                double ttHD = rs.getDouble("TongTienHoaDon");
//                double doanhthu = rs.getDouble("DoanhThuTrongNgay");
//                Object[] row = {thang, ttDT, ttHD, doanhthu};
//                ds.add(row);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ds;
//    }
//
//    @Override
//    public ArrayList<Object[]> getListTop5NhanVienDoanhThuCaoNhat(String thang, String nam) {
//        ArrayList<Object[]> ds = new ArrayList<Object[]>();
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement stmt;
//            if (thang.isBlank()) {
//                String sql = """
//                        SELECT TOP 5
//                            	NV.maNV, NV.hoTen, SUM(tongTien) AS tongDoanhThu
//                            FROM HoaDon AS HD  JOIN NhanVien AS NV ON HD.maNV = NV.maNV
//                            WHERE YEAR(ngayLapHD) = ?
//                            GROUP BY
//                            NV.maNV, NV.hoTen
//                            ORDER BY
//                            tongDoanhThu DESC """; // Sử dụng ? để thay thế giá trị của thangNam
//                stmt = con.prepareStatement(sql);
//                stmt.setString(1, nam);
//            } else {
//                String sql = """
//                        SELECT TOP 5
//                            	NV.maNV, NV.hoTen, SUM(tongTien) AS tongDoanhThu
//                            FROM HoaDon AS HD  JOIN NhanVien AS NV ON HD.maNV = NV.maNV
//                            WHERE MONTH(ngayLapHD) = ? AND YEAR(ngayLapHD) = ?
//                            GROUP BY
//                            NV.maNV, NV.hoTen
//                            ORDER BY
//                            tongDoanhThu DESC """; // Sử dụng ? để thay thế giá trị của thangNam
//                stmt = con.prepareStatement(sql);
//                stmt.setString(1, thang);
//                stmt.setString(2, nam);
//            }
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                String maNV = rs.getString("maNV");
//                String hoTen = rs.getString("hoTen");
//                String tongDT = rs.getString("tongDoanhThu");
//                Object[] row = {maNV, hoTen, convert.toStringMoney(tongDT)};
//                ds.add(row);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ds;
//    }
//
//    @Override
//    public ArrayList<Object[]> getListTop5KhachHangMuaHangNhieuNhat(String thang, String nam) {
//        ArrayList<Object[]> ds = new ArrayList<Object[]>();
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement stmt;
//            if (thang.isBlank()) {
//                String sql = """
//                        SELECT TOP 5
//                                KH.maKH, KH.hoTen, SUM(tienThanhToan) AS tongDoanhThu
//                            FROM HoaDon AS HD  JOIN KhachHang AS KH ON HD.maKH = KH.maKH
//                            WHERE YEAR(ngayLapHD) = ?
//                            GROUP BY
//                            KH.maKH, KH.hoTen
//                            ORDER BY
//                            tongDoanhThu DESC """; // Sử dụng ? để thay thế giá trị của thangNam
//                stmt = con.prepareStatement(sql);
//                stmt.setString(1, nam);
//            } else {
//                String sql = """
//                        SELECT TOP 5
//                                KH.maKH, KH.hoTen, SUM(tienThanhToan) AS tongDoanhThu
//                            FROM HoaDon AS HD  JOIN KhachHang AS KH ON HD.maKH = KH.maKH
//                            WHERE MONTH(ngayLapHD) = ? AND YEAR(ngayLapHD) = ?
//                            GROUP BY
//                            KH.maKH, KH.hoTen
//                            ORDER BY
//                            tongDoanhThu DESC """; // Sử dụng ? để thay thế giá trị của thangNam
//                stmt = con.prepareStatement(sql);
//                stmt.setString(1, thang);
//                stmt.setString(2, nam);
//            }
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                String maKH = rs.getString("maKH");
//                String hoTen = rs.getString("hoTen");
//                String tongDT = rs.getString("tongDoanhThu");
//                Object[] row = {maKH, hoTen, convert.toStringMoney(tongDT)};
//                ds.add(row);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ds;
//    }
//
//    @Override
//    public ArrayList<Object[]> getListDoanhThuBySort(String thang, String nam) {
//        ArrayList<Object[]> ds = new ArrayList<Object[]>();
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            String sql = "SELECT FORMAT(hoadon.ngayLapHD, 'dd-MM') AS NgayBan,\n"
//                    + "			COALESCE(SUM(ChiTietDoiTra.thanhTien),0) AS TongTienDoiTra, \n"
//                    + "			COALESCE(SUM(ChiTietHoaDon.thanhTien),0) AS TongTienHoaDon,\n"
//                    + "			(COALESCE(SUM(ChiTietHoaDon.thanhTien),0) - COALESCE(SUM(ChiTietDoiTra.thanhTien),0)) AS DoanhThuTrongNgay\n"
//                    + "		FROM \n"
//                    + "			HoaDon\n"
//                    + "		JOIN \n"
//                    + "			ChiTietHoaDon ON HoaDon.maHD = ChiTietHoaDon.maHD\n"
//                    + "		LEFT JOIN \n"
//                    + "			ChiTietDoiTra ON ChiTietHoaDon.maSP = ChiTietDoiTra.maSP\n"
//                    + "		LEFT JOIN \n"
//                    + "			DoiTra ON ChiTietDoiTra.maDT = DoiTra.maDT\n"
//                    + "		WHERE \n"
//                    + "			YEAR(ngayLapHD) = ? AND MONTH(ngayLapHD) = ?\n"
//                    + "		GROUP BY \n"
//                    + "			FORMAT(hoadon.ngayLapHD, 'dd-MM')\n"
//                    + "		ORDER BY \n"
//                    + "			DoanhThuTrongNgay DESC;";
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setString(1, nam);
//            stmt.setString(2, thang);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
////                Date ngay = rs.getDate("NgayBan");
//                String ngay = rs.getString("NgayBan");
//                double ttDT = rs.getDouble("TongTienDoiTra");
//                double ttHD = rs.getDouble("TongTienHoaDon");
//                double doanhthu = rs.getDouble("DoanhThuTrongNgay");
//                Object[] row = {ngay, ttDT, ttHD, doanhthu};
//                ds.add(row);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ds;
//    }
