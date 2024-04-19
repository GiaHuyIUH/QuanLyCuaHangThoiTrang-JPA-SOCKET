package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.ChiTietDoiTra_Interface;
import dao.DoiTra_Interface;
import dao.HoaDon_Interface;
import dao.ThongKe_Interface;
import dao.impl.DoiTra_dao;
import dao.impl.HoaDon_dao;
import entity.ChiTietDoiTraEntity;
import entity.DoiTraEntity;
import entity.HinhThucDoiTraEnum;
import entity.HoaDonEntity;
import entity.NhanVienEntity;
import entity.SanPhamEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Test {
	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CoLenServer");
//		
//		EntityManager em = emf.createEntityManager();
//		
//		EntityTransaction tx = em.getTransaction();
//		
//		try {
//			tx.begin();
//			tx.commit();
//		} catch (Exception e) {
//			tx.rollback();
//			e.printStackTrace();
//		}

//		HoaDon_Interface hoaDon = new HoaDon_dao();
//		List<HoaDonEntity> list = hoaDon.getallHoaDon();
//		for (HoaDonEntity hoaDonEntity : list) {
//			System.out.println(hoaDonEntity.toString());
//		}

//		System.out.println(hoaDon.getHoaDonTheoMaHD("HD121223154357"));

//		hoaDon.getHoaDonTheoNgayLap(Date.valueOf(("2023-12-12"))).forEach(System.out::println);

//		System.out.println(hoaDon.getSoLuongTonTheoMa("SP011022044632"));

//		hoaDon.timKiemHoaDonChuaThanhToan("0937891991").forEach(System.out::println);

//		System.out.println(hoaDon.timKiemHoaDonTheoMa("HD121223154453"));

		DoiTra_Interface doiTra = new DoiTra_dao();
//		System.out.println(doiTra.kiemTraThoiHanDoiTra("HD121223154357"));

//		System.out.println(doiTra.getTongSoLuongSPDoiTra("HD231123223033", "SP091123165605"));

//		Nhân viên bị kỳ
//		System.out.println(doiTra.getDoiTraTheoDieuKien("DT231123231544", Date.valueOf("2023-11-23")));

//		doiTra.getDoiTraTheoNgayLap(Date.valueOf("2023-11-23")).forEach(System.out::println);

//		doiTra.getAllDoiTra().forEach(System.out::println);


//		ChiTietDoiTra_Interface chiTietDoiTra_Interface = new dao.impl.ChiTietDoiTra_dao();
//		chiTietDoiTra_Interface.getAllCTDTTheoMaDT("DT231123231544").forEach(System.out::println);
		
		ThongKe_Interface thongKe = new dao.impl.ThongKe_dao();
		List<Object[]> list = thongKe.getListDoanhThuBySort("12", "2023");

		for (Object[] row : list) {
		    for (Object value : row) {
		        System.out.print(value + "\t");
		    }
		    System.out.println(); // Move to the next line after printing all values in the row
		}

	}
}
