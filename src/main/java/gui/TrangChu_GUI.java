package gui;


import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import util.ToanCuc;

public class TrangChu_GUI extends javax.swing.JFrame {
    
            // Dimention
//        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        
    /**
	 * 
	 */
	private static final long serialVersionUID = -8744587646219989543L;
	public TrangChu_GUI() throws Exception {

        initComponents();
        ToanCuc tc = new ToanCuc();
        System.out.println(tc);
        jlb_name.setText(tc.getName());
        lbl_ChucVu.setText(tc.getChucvu());
        if (tc.getGioitnh().equals("Nữ")) {
            ImageIcon img_User_nu = new ImageIcon("src\\main\\java\\pic\\icon\\user_nu.png");
            Image scaled_Users_nu = img_User_nu.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            img_User_nu = new ImageIcon(scaled_Users_nu);

            lbl_Users.setIcon(img_User_nu);
        } else {
            ImageIcon img_User = new ImageIcon("src\\main\\java\\pic\\icon\\user_nam.png");
            Image scaled_Users = img_User.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            img_User = new ImageIcon(scaled_Users);
            lbl_Users.setIcon(img_User);
        }

        if (tc.getChucvu().equals("Nhân viên")) {
            Jpanel_NhanVien.setVisible(false);
            Jpanel_NhaCungCap.setVisible(false);
            Jpanel_KhuyenMai.setVisible(false);
            Jpanel_TaiKhoan.setVisible(false);
            Jpanel_PhieuNhap.setVisible(false);
        }
        setSize(1366, 768);
//        GraphicsEnvironment env=GraphicsEnvironment.getLocalGraphicsEnvironment();
//        Rectangle bounds=env.getMaximumWindowBounds();
//        setSize(bounds.width, bounds.height);
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//         System.out.println("Width: " + bounds.width);
//        System.out.println("Height: " + bounds.height);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setLayout(null);
//        setVisible(true);

        TrangChu_Panel = new TrangChu_JPanel();
        BanHang_Panel = new BanHang_JPanel();
        SanPham_Panel = new SanPham_JPanel();
        HoaDon_Panel = new HoaDon_JPanel();
        DoiTra_Panel = new DoiTra_JPanel();
        ThongKe_Panel = new ThongKe_JPanel();
        KhachHang_Panel = new KhachHang_JPanel();
        NhanVien_Panel = new NhanVien_JPanel();
        KhuyenMai_Panel = new KhuyenMai_JPanel();
        PhieuNhap_Panel = new PhieuNhap_JPanel();
        TaiKhoan_Panel = new TaiKhoan_JPanel();
        NhaCungCap_Panel = new NhaCungCap_JPanel();

        ImageIcon img_home = new ImageIcon("src\\main\\java\\pic\\icon\\home.png");
        Image scaled_home = img_home.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_home = new ImageIcon(scaled_home);
        lbl_IconTrangChu.setIcon(img_home);

        ImageIcon img_SanPham = new ImageIcon("src\\main\\java\\pic\\icon\\productbox.png");
        Image scaled_SanPham = img_SanPham.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_SanPham = new ImageIcon(scaled_SanPham);
        lbl_IconSanPham.setIcon(img_SanPham);
//    
        ImageIcon img_BanHang = new ImageIcon("src\\main\\java\\pic\\icon\\clothers.png");
        Image scaled_BanHang = img_BanHang.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_BanHang = new ImageIcon(scaled_BanHang);
        lbl_IconBanHang.setIcon(img_BanHang);

        ImageIcon img_User = new ImageIcon("src\\main\\java\\pic\\icon\\user_nam.png");
        Image scaled_Users = img_User.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_User = new ImageIcon(scaled_Users);
        lbl_Users.setIcon(img_User);

//    ImageIcon img_Settings = new ImageIcon("src\\main\\java\\pic\\settings.png");
//    Image scaled_Settings = img_Settings.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//    img_Settings = new ImageIcon(scaled_Settings);
//    lbl_Settings.setIcon(img_Settings);
        ImageIcon img_HoaDon = new ImageIcon("src\\main\\java\\pic\\icon\\hoadon.png");
        Image scaled_HoaDon = img_HoaDon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_HoaDon = new ImageIcon(scaled_HoaDon);
        lbl_IconHoaDon.setIcon(img_HoaDon);

        ImageIcon img_DoiTra = new ImageIcon("src\\main\\java\\pic\\icon\\return.png");
        Image scaled_DoiTra = img_DoiTra.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_DoiTra = new ImageIcon(scaled_DoiTra);
        lbl_IconDoiTra.setIcon(img_DoiTra);

        ImageIcon img_KhachHang = new ImageIcon("src\\main\\java\\pic\\icon\\customer.png");
        Image scaled_KhachHang = img_KhachHang.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_KhachHang = new ImageIcon(scaled_KhachHang);
        lbl_IconKhachHang.setIcon(img_KhachHang);

        ImageIcon img_NhanVien = new ImageIcon("src\\main\\java\\pic\\icon\\nhanvien.png");
        Image scaled_NhanVien = img_NhanVien.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_NhanVien = new ImageIcon(scaled_NhanVien);
        lbl_IconNhanVien.setIcon(img_NhanVien);

        ImageIcon img_ThongKe = new ImageIcon("src\\main\\java\\pic\\icon\\thongke.png");
        Image scaled_ThongKe = img_ThongKe.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_ThongKe = new ImageIcon(scaled_ThongKe);
        lbl_IconThongKe.setIcon(img_ThongKe);

        ImageIcon img_NhaCungCap = new ImageIcon("src\\main\\java\\pic\\icon\\nhacungcap.png");
        Image scaled_NhaCungCap = img_NhaCungCap.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_NhaCungCap = new ImageIcon(scaled_NhaCungCap);
        lbl_IconNhaCungCap.setIcon(img_NhaCungCap);

        ImageIcon img_PhieuNhap = new ImageIcon("src\\main\\java\\pic\\icon\\phieunhap.png");
        Image scaled_PhieuNhap = img_PhieuNhap.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_PhieuNhap = new ImageIcon(scaled_PhieuNhap);
        lbl_IconPhieuNhap.setIcon(img_PhieuNhap);

        ImageIcon img_KhuyenMai = new ImageIcon("src\\main\\java\\pic\\icon\\discount.png");
        Image scaled_KhuyenMai = img_KhuyenMai.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_KhuyenMai = new ImageIcon(scaled_KhuyenMai);
        lbl_IconKhuyenMai.setIcon(img_KhuyenMai);

        ImageIcon img_TaiKhoan = new ImageIcon("src\\main\\java\\pic\\icon\\taikhoan.png");
        Image scaled_TaiKhoan = img_TaiKhoan.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_TaiKhoan = new ImageIcon(scaled_TaiKhoan);
        lbl_IconTaiKhoan.setIcon(img_TaiKhoan);

        ImageIcon img_DangXuat = new ImageIcon("src\\main\\java\\pic\\icon\\logout.png");
        Image scaled_DangXuat = img_DangXuat.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        img_DangXuat = new ImageIcon(scaled_DangXuat);
        JMenu_DangXuat.setIcon(img_DangXuat);

        ImageIcon img_ThayMatKhau = new ImageIcon("src\\main\\java\\pic\\icon\\key.png");
        Image scaled_ThayMatKhau = img_ThayMatKhau.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        img_ThayMatKhau = new ImageIcon(scaled_ThayMatKhau);
        JMenu_ThayMatKhau.setIcon(img_ThayMatKhau);

        ImageIcon img_GioiThieu = new ImageIcon("src\\main\\java\\pic\\icon\\gioithieu.png");
        Image scaled_GioiThieu = img_GioiThieu.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        img_GioiThieu = new ImageIcon(scaled_GioiThieu);
        JMenu_GioiThieu.setIcon(img_GioiThieu);

        ImageIcon img_TroGiup = new ImageIcon("src\\main\\java\\pic\\icon\\trogiup.png");
        Image scaled_TroGiup = img_TroGiup.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        img_TroGiup = new ImageIcon(scaled_TroGiup);
        JMenu_TroGiup.setIcon(img_TroGiup);

        // Thêm Panel và Main
        Jpanel_Main.add(TrangChu_Panel);
        Jpanel_Main.add(BanHang_Panel);
        Jpanel_Main.add(SanPham_Panel);
        Jpanel_Main.add(HoaDon_Panel);
        Jpanel_Main.add(DoiTra_Panel);
        Jpanel_Main.add(ThongKe_Panel);
        Jpanel_Main.add(KhachHang_Panel);
        Jpanel_Main.add(NhanVien_Panel);
        Jpanel_Main.add(NhaCungCap_Panel);
        Jpanel_Main.add(PhieuNhap_Panel);
        Jpanel_Main.add(KhuyenMai_Panel);
        Jpanel_Main.add(TaiKhoan_Panel);
        // Gán panleTrangChu background
        Jpanel_TrangChu.setBackground(new Color(112, 128, 144));
        // Gán sự kiện click Jpanel
        Jpanel_TrangChu.addMouseListener(new PanelButtonMouseAdapter(Jpanel_TrangChu) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(112, 128, 144));
                menuClicked(TrangChu_Panel);

            }
        });

        Jpanel_BanHang.addMouseListener(new PanelButtonMouseAdapter(Jpanel_BanHang) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(112, 128, 144));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(BanHang_Panel);
            }
        });
        Jpanel_DoiTra.addMouseListener(new PanelButtonMouseAdapter(Jpanel_DoiTra) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(112, 128, 144));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(DoiTra_Panel);
            }
        });

        Jpanel_KhachHang.addMouseListener(new PanelButtonMouseAdapter(Jpanel_KhachHang) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(112, 128, 144));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(KhachHang_Panel);
            }
        });
        Jpanel_KhuyenMai.addMouseListener(new PanelButtonMouseAdapter(Jpanel_KhuyenMai) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(112, 128, 144));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(KhuyenMai_Panel);
            }
        });
        Jpanel_NhaCungCap.addMouseListener(new PanelButtonMouseAdapter(Jpanel_NhaCungCap) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(112, 128, 144));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(NhaCungCap_Panel);
            }
        });
        Jpanel_NhanVien.addMouseListener(new PanelButtonMouseAdapter(Jpanel_NhanVien) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(112, 128, 144));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(NhanVien_Panel);
            }
        });
        Jpanel_PhieuNhap.addMouseListener(new PanelButtonMouseAdapter(Jpanel_PhieuNhap) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(112, 128, 144));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(PhieuNhap_Panel);
            }
        });
        Jpanel_SanPham.addMouseListener(new PanelButtonMouseAdapter(Jpanel_SanPham) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(112, 128, 144));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(SanPham_Panel);
            }
        });
        Jpanel_TaiKhoan.addMouseListener(new PanelButtonMouseAdapter(Jpanel_TaiKhoan) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(112, 128, 144));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(TaiKhoan_Panel);
            }
        });
        Jpanel_ThongKe.addMouseListener(new PanelButtonMouseAdapter(Jpanel_ThongKe) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(112, 128, 144));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(ThongKe_Panel);
            }
        });
        Jpanel_HoaDon.addMouseListener(new PanelButtonMouseAdapter(Jpanel_HoaDon) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(112, 128, 144));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(HoaDon_Panel);
            }
        });

        // MenuBar
        jMenuBar1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        // Tạo AcTion để xử lý sự kiện cho phím O
        Action dangXuatAction = new AbstractAction("Đăng Xuất") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };

        // Gán Phím Crtl + O cho action này
        dangXuatAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
        JMenuItem_An.setAction(dangXuatAction);
        JMenuItem_An.setPreferredSize(new java.awt.Dimension(0, 0));
        JMenu_DangXuat.setToolTipText("Ctrl+0");
        JMenu_DangXuat.setAccelerator(null);

        // Tạo và cấu hình timer
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy thời gian hiện tại
                Date now = new Date();

                // Định dạng thời gian
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String formattedDate = dateFormat.format(now);

                // Đặt thời gian đã định dạng vào JLabel
                JMenu_Time.setText(formattedDate);
            }
        });
        timer.start();

        menuClicked(TrangChu_Panel);

    }

    public void menuClicked(JPanel panel) {

        TrangChu_Panel.setVisible(false);
        BanHang_Panel.setVisible(false);
        SanPham_Panel.setVisible(false);
        HoaDon_Panel.setVisible(false);
        KhachHang_Panel.setVisible(false);
        DoiTra_Panel.setVisible(false);
        ThongKe_Panel.setVisible(false);
        NhanVien_Panel.setVisible(false);
        NhaCungCap_Panel.setVisible(false);
        PhieuNhap_Panel.setVisible(false);
        KhuyenMai_Panel.setVisible(false);
        TaiKhoan_Panel.setVisible(false);

        panel.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jpanel_Menu = new javax.swing.JPanel();
        Jpanel_Users = new javax.swing.JPanel();
        jlb_name = new javax.swing.JLabel();
        lbl_Users = new javax.swing.JLabel();
        lbl_ChucVu = new javax.swing.JLabel();
        Jpanel_TaiKhoan = new javax.swing.JPanel();
        lbl_TaiKhoan = new javax.swing.JLabel();
        lbl_IconTaiKhoan = new javax.swing.JLabel();
        Jpanel_KhuyenMai = new javax.swing.JPanel();
        lbl_KhuyenMai = new javax.swing.JLabel();
        lbl_IconKhuyenMai = new javax.swing.JLabel();
        Jpanel_PhieuNhap = new javax.swing.JPanel();
        lbl_PhieuNhap = new javax.swing.JLabel();
        lbl_IconPhieuNhap = new javax.swing.JLabel();
        Jpanel_NhaCungCap = new javax.swing.JPanel();
        lbl_NhaCungCap = new javax.swing.JLabel();
        lbl_IconNhaCungCap = new javax.swing.JLabel();
        Jpanel_NhanVien = new javax.swing.JPanel();
        lbl_NhanVien = new javax.swing.JLabel();
        lbl_IconNhanVien = new javax.swing.JLabel();
        Jpanel_ThongKe = new javax.swing.JPanel();
        lbl_ThongKe = new javax.swing.JLabel();
        lbl_IconThongKe = new javax.swing.JLabel();
        Jpanel_DoiTra = new javax.swing.JPanel();
        lbl_DoiTra = new javax.swing.JLabel();
        lbl_IconDoiTra = new javax.swing.JLabel();
        Jpanel_SanPham = new javax.swing.JPanel();
        lbl_SanPham = new javax.swing.JLabel();
        lbl_IconSanPham = new javax.swing.JLabel();
        Jpanel_BanHang = new javax.swing.JPanel();
        lbl_BanHang = new javax.swing.JLabel();
        lbl_IconBanHang = new javax.swing.JLabel();
        Jpanel_TrangChu = new javax.swing.JPanel();
        lbl_TrangChu = new javax.swing.JLabel();
        lbl_IconTrangChu = new javax.swing.JLabel();
        Jpanel_HoaDon = new javax.swing.JPanel();
        lbl_IconHoaDon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Jpanel_KhachHang = new javax.swing.JPanel();
        lbl_IconKhachHang = new javax.swing.JLabel();
        lbl_KhachHang = new javax.swing.JLabel();
        Jpanel_Time = new javax.swing.JPanel();
        Jpanel_Main = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        JMenu_ThayMatKhau = new javax.swing.JMenuItem();
        JMenu_DangXuat = new javax.swing.JMenuItem();
        JMenuItem_An = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        JMenu_GioiThieu = new javax.swing.JMenuItem();
        JMenu_TroGiup = new javax.swing.JMenuItem();
        JMenu_Time = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 720));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jpanel_Menu.setBackground(new java.awt.Color(0, 51, 51));
        Jpanel_Menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Jpanel_Menu.setMinimumSize(new java.awt.Dimension(180, 672));
        Jpanel_Menu.setPreferredSize(new java.awt.Dimension(180, 768));
        Jpanel_Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jpanel_Users.setBackground(new java.awt.Color(0, 51, 51));
        Jpanel_Users.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        Jpanel_Users.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlb_name.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlb_name.setForeground(new java.awt.Color(255, 255, 255));
        jlb_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_name.setText("Đinh Nguyên Chung");
        Jpanel_Users.add(jlb_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 180, 30));
        Jpanel_Users.add(lbl_Users, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        lbl_ChucVu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_ChucVu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ChucVu.setText("Quản Lý");
        Jpanel_Users.add(lbl_ChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 110, 30));

        Jpanel_Menu.add(Jpanel_Users, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 80));

        Jpanel_TaiKhoan.setBackground(new java.awt.Color(0, 51, 51));
        Jpanel_TaiKhoan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_TaiKhoan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbl_TaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        lbl_TaiKhoan.setText("Tài Khoản");
        Jpanel_TaiKhoan.add(lbl_TaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 100, 29));
        Jpanel_TaiKhoan.add(lbl_IconTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        Jpanel_Menu.add(Jpanel_TaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 180, 50));

        Jpanel_KhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        Jpanel_KhuyenMai.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_KhuyenMai.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbl_KhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        lbl_KhuyenMai.setText("Khuyến Mãi");
        Jpanel_KhuyenMai.add(lbl_KhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 100, 29));
        Jpanel_KhuyenMai.add(lbl_IconKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        Jpanel_Menu.add(Jpanel_KhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 180, 50));

        Jpanel_PhieuNhap.setBackground(new java.awt.Color(0, 51, 51));
        Jpanel_PhieuNhap.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_PhieuNhap.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbl_PhieuNhap.setForeground(new java.awt.Color(255, 255, 255));
        lbl_PhieuNhap.setText("Phiếu Nhập");
        Jpanel_PhieuNhap.add(lbl_PhieuNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 100, 29));
        Jpanel_PhieuNhap.add(lbl_IconPhieuNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        Jpanel_Menu.add(Jpanel_PhieuNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 180, 50));

        Jpanel_NhaCungCap.setBackground(new java.awt.Color(0, 51, 51));
        Jpanel_NhaCungCap.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_NhaCungCap.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbl_NhaCungCap.setForeground(new java.awt.Color(255, 255, 255));
        lbl_NhaCungCap.setText("Nhà Cung Cấp");
        Jpanel_NhaCungCap.add(lbl_NhaCungCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 100, 29));
        Jpanel_NhaCungCap.add(lbl_IconNhaCungCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        Jpanel_Menu.add(Jpanel_NhaCungCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 180, 50));

        Jpanel_NhanVien.setBackground(new java.awt.Color(0, 51, 51));
        Jpanel_NhanVien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_NhanVien.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbl_NhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lbl_NhanVien.setText("Nhân Viên");
        Jpanel_NhanVien.add(lbl_NhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 100, 29));
        Jpanel_NhanVien.add(lbl_IconNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        Jpanel_Menu.add(Jpanel_NhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 180, 50));

        Jpanel_ThongKe.setBackground(new java.awt.Color(0, 51, 51));
        Jpanel_ThongKe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_ThongKe.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbl_ThongKe.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ThongKe.setText("Thống Kê");
        Jpanel_ThongKe.add(lbl_ThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 100, 29));
        Jpanel_ThongKe.add(lbl_IconThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        Jpanel_Menu.add(Jpanel_ThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 180, 50));

        Jpanel_DoiTra.setBackground(new java.awt.Color(0, 51, 51));
        Jpanel_DoiTra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_DoiTra.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbl_DoiTra.setForeground(new java.awt.Color(255, 255, 255));
        lbl_DoiTra.setText("Đổi Trả");
        Jpanel_DoiTra.add(lbl_DoiTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 100, 29));
        Jpanel_DoiTra.add(lbl_IconDoiTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        Jpanel_Menu.add(Jpanel_DoiTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 180, 50));

        Jpanel_SanPham.setBackground(new java.awt.Color(0, 51, 51));
        Jpanel_SanPham.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_SanPham.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbl_SanPham.setForeground(new java.awt.Color(255, 255, 255));
        lbl_SanPham.setText("Sản Phẩm");
        Jpanel_SanPham.add(lbl_SanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 100, 29));
        Jpanel_SanPham.add(lbl_IconSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        Jpanel_Menu.add(Jpanel_SanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 180, 50));

        Jpanel_BanHang.setBackground(new java.awt.Color(0, 51, 51));
        Jpanel_BanHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_BanHang.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbl_BanHang.setForeground(new java.awt.Color(255, 255, 255));
        lbl_BanHang.setText("Bán Hàng");
        Jpanel_BanHang.add(lbl_BanHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 100, 29));
        Jpanel_BanHang.add(lbl_IconBanHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        Jpanel_Menu.add(Jpanel_BanHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 180, 50));

        Jpanel_TrangChu.setBackground(new java.awt.Color(0, 51, 51));
        Jpanel_TrangChu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_TrangChu.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbl_TrangChu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_TrangChu.setText("Trang Chủ");
        Jpanel_TrangChu.add(lbl_TrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 100, 29));
        Jpanel_TrangChu.add(lbl_IconTrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        Jpanel_Menu.add(Jpanel_TrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 180, 50));

        Jpanel_HoaDon.setBackground(new java.awt.Color(0, 51, 51));
        Jpanel_HoaDon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Jpanel_HoaDon.add(lbl_IconHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hóa Đơn");
        Jpanel_HoaDon.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 100, 29));

        Jpanel_Menu.add(Jpanel_HoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 180, 50));

        Jpanel_KhachHang.setBackground(new java.awt.Color(0, 51, 51));
        Jpanel_KhachHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Jpanel_KhachHang.add(lbl_IconKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        lbl_KhachHang.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbl_KhachHang.setForeground(new java.awt.Color(255, 255, 255));
        lbl_KhachHang.setText("Khách Hàng");
        Jpanel_KhachHang.add(lbl_KhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 100, 29));

        Jpanel_Menu.add(Jpanel_KhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 180, 50));

        Jpanel_Time.setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout Jpanel_TimeLayout = new javax.swing.GroupLayout(Jpanel_Time);
        Jpanel_Time.setLayout(Jpanel_TimeLayout);
        Jpanel_TimeLayout.setHorizontalGroup(
            Jpanel_TimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        Jpanel_TimeLayout.setVerticalGroup(
            Jpanel_TimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        Jpanel_Menu.add(Jpanel_Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, 180, 18));

        getContentPane().add(Jpanel_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 750));

        Jpanel_Main.setBackground(new java.awt.Color(204, 204, 255));
        Jpanel_Main.setPreferredSize(new java.awt.Dimension(1355, 843));

        javax.swing.GroupLayout Jpanel_MainLayout = new javax.swing.GroupLayout(Jpanel_Main);
        Jpanel_Main.setLayout(Jpanel_MainLayout);
        Jpanel_MainLayout.setHorizontalGroup(
            Jpanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Jpanel_MainLayout.setVerticalGroup(
            Jpanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        getContentPane().add(Jpanel_Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 1186, 750));

        jMenu1.setText("Hệ Thống");
        jMenu1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        JMenu_ThayMatKhau.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        JMenu_ThayMatKhau.setText("Thay Mật Khẩu");
        JMenu_ThayMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JMenu_ThayMatKhauMouseClicked(evt);
            }
        });
        JMenu_ThayMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenu_ThayMatKhauActionPerformed(evt);
            }
        });
        jMenu1.add(JMenu_ThayMatKhau);

        JMenu_DangXuat.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        JMenu_DangXuat.setText("Đăng Xuất");
        JMenu_DangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JMenu_DangXuatMouseClicked(evt);
            }
        });
        JMenu_DangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenu_DangXuatActionPerformed(evt);
            }
        });
        jMenu1.add(JMenu_DangXuat);

        JMenuItem_An.setText("keyDangXuat");
        jMenu1.add(JMenuItem_An);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Trợ Giúp");
        jMenu2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jMenu2.setMargin(new java.awt.Insets(3, 6, 3, 8));

        JMenu_GioiThieu.setText("Giới Thiệu");
        JMenu_GioiThieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenu_GioiThieuActionPerformed(evt);
            }
        });
        jMenu2.add(JMenu_GioiThieu);

        JMenu_TroGiup.setText("Trợ Giúp");
        JMenu_TroGiup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenu_TroGiupActionPerformed(evt);
            }
        });
        jMenu2.add(JMenu_TroGiup);

        jMenuBar1.add(jMenu2);

        JMenu_Time.setText("Time");
        JMenu_Time.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jMenuBar1.add(JMenu_Time);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMenu_DangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenu_DangXuatActionPerformed
        // TODO add your handling code here:
        DangNhap_GUI dangnhap = new DangNhap_GUI();
        int hoi = JOptionPane.showConfirmDialog(null, "Bạn có chắn muốn đăng xuất ?", "Chú ý !", JOptionPane.YES_NO_OPTION);
        if (hoi == JOptionPane.YES_OPTION) {
            dangnhap.setVisible(true);
            dispose();
        }

    }//GEN-LAST:event_JMenu_DangXuatActionPerformed

    private void JMenu_DangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JMenu_DangXuatMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_JMenu_DangXuatMouseClicked

    private void JMenu_GioiThieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenu_GioiThieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JMenu_GioiThieuActionPerformed

    private void JMenu_ThayMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JMenu_ThayMatKhauMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JMenu_ThayMatKhauMouseClicked

    private void JMenu_ThayMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenu_ThayMatKhauActionPerformed
        ThayDoiMatKhau_GUI thayDoiMatKhay_Gui = new ThayDoiMatKhau_GUI();
        thayDoiMatKhay_Gui.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_JMenu_ThayMatKhauActionPerformed

    private void JMenu_TroGiupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenu_TroGiupActionPerformed

        try {
            System.out.println("Start..");
            File file = new java.io.File("src/HTMLFile/HELPPAGE/main.html").getAbsoluteFile();
            Desktop.getDesktop().open(file);
            System.out.println("End..");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_JMenu_TroGiupActionPerformed



    private class PanelButtonMouseAdapter extends MouseAdapter {

        JPanel panel;

        public PanelButtonMouseAdapter(JPanel panel) {
            this.panel = panel;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
//			panel.setBackground(new Color(112,128,144));
        }

        @Override
        public void mouseExited(MouseEvent e) {
//            panel.setBackground(new Color(0, 51, 51));
        }

        @Override
        public void mousePressed(MouseEvent e) {
//            panel.setBackground(new Color(60, 179, 113));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
//            panel.setBackground(new Color(112, 128, 144));
//               panel.setBackground(new Color(60, 179, 113));
        }
    }
    //

    private TrangChu_JPanel TrangChu_Panel;
    private BanHang_JPanel BanHang_Panel;
    private SanPham_JPanel SanPham_Panel;
    private HoaDon_JPanel HoaDon_Panel;
    private DoiTra_JPanel DoiTra_Panel;
    private KhachHang_JPanel KhachHang_Panel;
    private ThongKe_JPanel ThongKe_Panel;
    private NhanVien_JPanel NhanVien_Panel;
    private NhaCungCap_JPanel NhaCungCap_Panel;
    private KhuyenMai_JPanel KhuyenMai_Panel;
    private PhieuNhap_JPanel PhieuNhap_Panel;
    private TaiKhoan_JPanel TaiKhoan_Panel;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMenuItem_An;
    private javax.swing.JMenuItem JMenu_DangXuat;
    private javax.swing.JMenuItem JMenu_GioiThieu;
    private javax.swing.JMenuItem JMenu_ThayMatKhau;
    private javax.swing.JMenu JMenu_Time;
    private javax.swing.JMenuItem JMenu_TroGiup;
    private javax.swing.JPanel Jpanel_BanHang;
    private javax.swing.JPanel Jpanel_DoiTra;
    private javax.swing.JPanel Jpanel_HoaDon;
    private javax.swing.JPanel Jpanel_KhachHang;
    private javax.swing.JPanel Jpanel_KhuyenMai;
    private javax.swing.JPanel Jpanel_Main;
    private javax.swing.JPanel Jpanel_Menu;
    private javax.swing.JPanel Jpanel_NhaCungCap;
    private javax.swing.JPanel Jpanel_NhanVien;
    private javax.swing.JPanel Jpanel_PhieuNhap;
    private javax.swing.JPanel Jpanel_SanPham;
    private javax.swing.JPanel Jpanel_TaiKhoan;
    private javax.swing.JPanel Jpanel_ThongKe;
    private javax.swing.JPanel Jpanel_Time;
    private javax.swing.JPanel Jpanel_TrangChu;
    private javax.swing.JPanel Jpanel_Users;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel jlb_name;
    private javax.swing.JLabel lbl_BanHang;
    private javax.swing.JLabel lbl_ChucVu;
    private javax.swing.JLabel lbl_DoiTra;
    private javax.swing.JLabel lbl_IconBanHang;
    private javax.swing.JLabel lbl_IconDoiTra;
    private javax.swing.JLabel lbl_IconHoaDon;
    private javax.swing.JLabel lbl_IconKhachHang;
    private javax.swing.JLabel lbl_IconKhuyenMai;
    private javax.swing.JLabel lbl_IconNhaCungCap;
    private javax.swing.JLabel lbl_IconNhanVien;
    private javax.swing.JLabel lbl_IconPhieuNhap;
    private javax.swing.JLabel lbl_IconSanPham;
    private javax.swing.JLabel lbl_IconTaiKhoan;
    private javax.swing.JLabel lbl_IconThongKe;
    private javax.swing.JLabel lbl_IconTrangChu;
    private javax.swing.JLabel lbl_KhachHang;
    private javax.swing.JLabel lbl_KhuyenMai;
    private javax.swing.JLabel lbl_NhaCungCap;
    private javax.swing.JLabel lbl_NhanVien;
    private javax.swing.JLabel lbl_PhieuNhap;
    private javax.swing.JLabel lbl_SanPham;
    private javax.swing.JLabel lbl_TaiKhoan;
    private javax.swing.JLabel lbl_ThongKe;
    private javax.swing.JLabel lbl_TrangChu;
    private javax.swing.JLabel lbl_Users;
    // End of variables declaration//GEN-END:variables
}
