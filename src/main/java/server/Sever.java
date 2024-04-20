package server;

import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;

import Interface.ChatLieu_Interface;
import Interface.ChiTietDoiTra_Interface;
import Interface.ChiTietHoaDon_Interface;
import Interface.ChuongTrinhKhuyenMai_Interface;
import Interface.DanhMucSanPham_Interface;
import Interface.DoiTra_Interface;
import Interface.HoaDon_Interface;
import Interface.KhachHang_Interface;
import Interface.MatHangNhap_Interface;
import Interface.NhaCungCap_Interface;
import Interface.NhanVienInterface;
import Interface.SanPham_Interface;
import Interface.TaiKhoanInterface;
import Interface.ThongKe_Interface;
import Interface.ThuongHieu_Interface;
import bus.ChatLieu_bus;
import bus.ChiTietDoiTra_bus;
import bus.ChiTietHoaDon_bus;
import bus.ChuongTrinhKhuyenMai_bus;
import bus.DanhMucSanPham_bus;
import bus.DoiTra_bus;
import bus.HoaDon_bus;
import bus.KhachHang_bus;
import bus.MatHangNhap_bus;
import bus.NhaCungCap_bus;
import bus.NhanVien_bus;
import bus.SanPham_bus;
import bus.TaiKhoan_bus;
import bus.ThongKe_bus;
import bus.ThuongHieu_bus;


public class Sever {
	private static final String URL = "rmi://NguyenChung:7878/";
	private static ChatLieu_Interface chatLieu_interface;
	private static ChiTietDoiTra_Interface chiTietDoiTra_interface;
	private static ChiTietHoaDon_Interface chiTietHoaDon_interface;
	private static ChuongTrinhKhuyenMai_Interface chuongTrinhKhuyenMai_interface;
	private static DanhMucSanPham_Interface danhMucSanPham_interface;
	private static DoiTra_Interface doiTra_interface;
	private static HoaDon_Interface hoaDon_interface;
	private static KhachHang_Interface khachHang_interface;
	private static MatHangNhap_Interface matHangNhap_interface;
	private static NhaCungCap_Interface nhaCungCap_interface;
	private static NhanVienInterface nhanVien_interface;
	private static SanPham_Interface sanPham_interface;
	private static TaiKhoanInterface taiKhoan_interface;
	private static ThongKe_Interface thongKe_interface;
	private static ThuongHieu_Interface thuongHieu_interface;

	
	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			chatLieu_interface = new ChatLieu_bus();
			chiTietDoiTra_interface = new ChiTietDoiTra_bus();
			chiTietHoaDon_interface = new ChiTietHoaDon_bus();
			chuongTrinhKhuyenMai_interface = new ChuongTrinhKhuyenMai_bus();
			danhMucSanPham_interface = new DanhMucSanPham_bus();
			doiTra_interface = new DoiTra_bus();
			hoaDon_interface = new HoaDon_bus();
			khachHang_interface = new KhachHang_bus();
			matHangNhap_interface = new MatHangNhap_bus();
			nhaCungCap_interface = new NhaCungCap_bus();
			nhanVien_interface = new NhanVien_bus();
			sanPham_interface = new SanPham_bus();
			taiKhoan_interface = new TaiKhoan_bus();
			thongKe_interface = new ThongKe_bus();
			thuongHieu_interface = new ThuongHieu_bus();
			
			LocateRegistry.createRegistry(7878);
			context.bind(URL + "ChatLieu_bus", chatLieu_interface);
			context.bind(URL + "ChiTietDoiTra_bus", chiTietDoiTra_interface);
			context.bind(URL + "ChiTietHoaDon_bus", chiTietHoaDon_interface);
			context.bind(URL + "ChuongTrinhKhuyenMai_bus", chuongTrinhKhuyenMai_interface);
			context.bind(URL + "DanhMucSanPham_bus", danhMucSanPham_interface);
			context.bind(URL + "DoiTra_bus", doiTra_interface);
			context.bind(URL + "HoaDon_bus", hoaDon_interface);
			context.bind(URL + "KhachHang_bus", khachHang_interface);
			context.bind(URL + "MatHangNhap_bus", matHangNhap_interface);
			context.bind(URL + "NhaCungCap_bus", nhaCungCap_interface);
			context.bind(URL + "NhanVien_bus", nhanVien_interface);
			context.bind(URL + "SanPham_bus", sanPham_interface);
			context.bind(URL + "TaiKhoan_bus", taiKhoan_interface);
			context.bind(URL + "ThongKe_bus", thongKe_interface);
			context.bind(URL + "ThuongHieu_bus", thuongHieu_interface);
			
			
			
			System.out.println("Server is running...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
