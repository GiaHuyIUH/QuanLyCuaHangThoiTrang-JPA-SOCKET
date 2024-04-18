package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.DoiTra_Interface;
import dao.HoaDon_Interface;
import dao.impl.DoiTra_dao;
import dao.impl.HoaDon_dao;
import entity.HoaDonEntity;
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
		System.out.println(doiTra.kiemTraThoiHanDoiTra("HD041824114503"));
	}
}
