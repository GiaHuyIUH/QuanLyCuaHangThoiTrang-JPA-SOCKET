USE [master]
GO
/****** Object:  Database [QuanLyBanHang]    Script Date: 13/12/2023 9:11:49 PM ******/
CREATE DATABASE [QuanLyBanHang]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyBanHang', FILENAME = N'D:\HK1-NAM3\PTUD\SQLServerQuanLyBanHang.mdf' , SIZE = 73728KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyBanHang_log', FILENAME = N'D:\HK1-NAM3\PTUD\SQLServer\QuanLyBanHang_log.ldf' , SIZE = 73728KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [QuanLyBanHang] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyBanHang].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyBanHang] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyBanHang] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyBanHang] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyBanHang] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyBanHang] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyBanHang] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyBanHang] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyBanHang] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyBanHang] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyBanHang] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyBanHang] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyBanHang] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyBanHang] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyBanHang] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyBanHang] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLyBanHang] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyBanHang] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyBanHang] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyBanHang] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyBanHang] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyBanHang] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyBanHang] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyBanHang] SET RECOVERY FULL 
GO
ALTER DATABASE [QuanLyBanHang] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyBanHang] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyBanHang] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyBanHang] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyBanHang] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyBanHang] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyBanHang] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QuanLyBanHang] SET QUERY_STORE = OFF
GO
USE [QuanLyBanHang]
GO
/****** Object:  Table [dbo].[ChatLieu]    Script Date: 13/12/2023 9:11:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChatLieu](
	[maChatLieu] [nvarchar](50) NOT NULL,
	[tenChatLieu] [nvarchar](255) NULL,
	[xuatXu] [nvarchar](255) NULL,
 CONSTRAINT [PK_ChatLieu] PRIMARY KEY CLUSTERED 
(
	[maChatLieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietDoiTra]    Script Date: 13/12/2023 9:11:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDoiTra](
	[maSP] [nvarchar](50) NOT NULL,
	[maDT] [nvarchar](50) NOT NULL,
	[soLuong] [int] NOT NULL,
	[giaBan] [money] NOT NULL,
	[thanhTien] [money] NOT NULL,
 CONSTRAINT [PK_ChiTietDoiTra] PRIMARY KEY CLUSTERED 
(
	[maSP] ASC,
	[maDT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 13/12/2023 9:11:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maSP] [nvarchar](50) NOT NULL,
	[maHD] [nvarchar](50) NOT NULL,
	[soLuong] [int] NOT NULL,
	[giaGoc] [money] NOT NULL,
	[giaBan] [money] NOT NULL,
	[thanhTien] [money] NOT NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[maSP] ASC,
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChuongTrinhKhuyenMai]    Script Date: 13/12/2023 9:11:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChuongTrinhKhuyenMai](
	[maCTKM] [nvarchar](50) NOT NULL,
	[tenCTKM] [nvarchar](255) NULL,
	[soTienToiDa] [money] NULL,
	[soTienToiThieu] [money] NULL,
	[giamGia] [int] NOT NULL,
	[ngayBatDau] [datetime] NOT NULL,
	[ngayKetThuc] [datetime] NOT NULL,
	[tinhTrang] [nvarchar](255) NOT NULL,
	[maLoaiCTKM] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_ChuongTrinhKhuyenMai] PRIMARY KEY CLUSTERED 
(
	[maCTKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DanhMucSanPham]    Script Date: 13/12/2023 9:11:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMucSanPham](
	[maDanhMuc] [nvarchar](50) NOT NULL,
	[tenDanhMuc] [nvarchar](255) NULL,
 CONSTRAINT [PK_DanhMucSanPham] PRIMARY KEY CLUSTERED 
(
	[maDanhMuc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DoiTra]    Script Date: 13/12/2023 9:11:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DoiTra](
	[maDT] [nvarchar](50) NOT NULL,
	[maHD] [nvarchar](50) NOT NULL,
	[maNV] [nvarchar](50) NOT NULL,
	[thoiGianDoiTra] [datetime] NOT NULL,
	[hinhThucDoiTra] [nvarchar](50) NOT NULL,
	[tongTien] [money] NOT NULL,
 CONSTRAINT [PK_DonYeuCauDoiTra] PRIMARY KEY CLUSTERED 
(
	[maDT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 13/12/2023 9:11:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHD] [nvarchar](50) NOT NULL,
	[maKH] [nvarchar](50) NULL,
	[maNV] [nvarchar](50) NOT NULL,
	[maCTKM] [nvarchar](50) NULL,
	[ngayLapHD] [datetime] NOT NULL,
	[tienKhuyenMai] [money] NOT NULL,
	[tongTien] [money] NOT NULL,
	[tienThanhToan] [money] NOT NULL,
	[tinhTrang] [nvarchar](255) NOT NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 13/12/2023 9:11:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKH] [nvarchar](50) NOT NULL,
	[hoTen] [nvarchar](255) NULL,
	[gioiTinh] [nvarchar](255) NULL,
	[soDienThoai] [nchar](10) NULL,
	[diaChi] [nvarchar](255) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiChuongTrinhKhuyenMai]    Script Date: 13/12/2023 9:11:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiChuongTrinhKhuyenMai](
	[maLoaiCTKM] [nvarchar](50) NOT NULL,
	[moTa] [nvarchar](240) NOT NULL,
 CONSTRAINT [PK_LoaiChuongTrinhKhuyenMai] PRIMARY KEY CLUSTERED 
(
	[maLoaiCTKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MatHangNhap]    Script Date: 13/12/2023 9:11:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MatHangNhap](
	[maMHN] [nvarchar](50) NOT NULL,
	[maNCC] [nvarchar](50) NOT NULL,
	[maSP] [nvarchar](50) NOT NULL,
	[soLuongNhap] [int] NOT NULL,
	[ngayNhap] [date] NULL,
 CONSTRAINT [PK_MatHangNhap] PRIMARY KEY CLUSTERED 
(
	[maMHN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 13/12/2023 9:11:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[maNCC] [nvarchar](50) NOT NULL,
	[tenNCC] [nvarchar](255) NULL,
	[soDienThoai] [nchar](10) NULL,
	[diaChi] [nvarchar](255) NULL,
	[tinhTrang] [nvarchar](255) NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[maNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 13/12/2023 9:11:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [nvarchar](50) NOT NULL,
	[hoTen] [nvarchar](255) NULL,
	[gioiTinh] [nvarchar](255) NULL,
	[ngaySinh] [date] NULL,
	[email] [nvarchar](50) NOT NULL,
	[soDienThoai] [nchar](10) NOT NULL,
	[caLamViec] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](255) NULL,
	[chucVu] [nvarchar](255) NULL,
	[tinhTrang] [nvarchar](255) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 13/12/2023 9:11:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSP] [nvarchar](50) NOT NULL,
	[tenSP] [nvarchar](255) NULL,
	[kichThuoc] [varchar](255) NULL,
	[mauSac] [nvarchar](255) NULL,
	[donGia] [money] NOT NULL,
	[tinhTrang] [nvarchar](255) NULL,
	[soLuongTonKho] [int] NULL,
	[maChatLieu] [nvarchar](50) NOT NULL,
	[maThuongHieu] [nvarchar](50) NOT NULL,
	[maDanhMuc] [nvarchar](50) NOT NULL,
	[imgUrl] [nvarchar](max) NULL,
	[maCTKM] [nvarchar](50) NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[maSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 13/12/2023 9:11:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[tenTaiKhoan] [nchar](10) NOT NULL,
	[matKhau] [nvarchar](100) NOT NULL,
	[thoiGianDNGN] [datetime] NULL,
	[tinhTrang] [nvarchar](20) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[tenTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThuongHieu]    Script Date: 13/12/2023 9:11:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThuongHieu](
	[maThuongHieu] [nvarchar](50) NOT NULL,
	[tenThuongHieu] [nvarchar](255) NULL,
 CONSTRAINT [PK_ThuongHieu] PRIMARY KEY CLUSTERED 
(
	[maThuongHieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChatLieu] ([maChatLieu], [tenChatLieu], [xuatXu]) VALUES (N'CL27102301', N'Cotton', N'Việt Nam')
INSERT [dbo].[ChatLieu] ([maChatLieu], [tenChatLieu], [xuatXu]) VALUES (N'CL27102302', N'Polyester', N'Thái Lan')
INSERT [dbo].[ChatLieu] ([maChatLieu], [tenChatLieu], [xuatXu]) VALUES (N'CL27102303', N'Da bò', N'Việt Nam')
INSERT [dbo].[ChatLieu] ([maChatLieu], [tenChatLieu], [xuatXu]) VALUES (N'CL27102304', N'
Flannel', N'Việt Nam')
INSERT [dbo].[ChatLieu] ([maChatLieu], [tenChatLieu], [xuatXu]) VALUES (N'CL27102305', N'Len', N'Việt Nam')
INSERT [dbo].[ChatLieu] ([maChatLieu], [tenChatLieu], [xuatXu]) VALUES (N'CL27102306', N'Lua', N'Việt Nam')
INSERT [dbo].[ChatLieu] ([maChatLieu], [tenChatLieu], [xuatXu]) VALUES (N'CL27102307', N'Vãi Lanh', N'Việt Nam')
INSERT [dbo].[ChatLieu] ([maChatLieu], [tenChatLieu], [xuatXu]) VALUES (N'CL27102308', N'Tơ tằm', N'Việt Nam')
INSERT [dbo].[ChatLieu] ([maChatLieu], [tenChatLieu], [xuatXu]) VALUES (N'CL27102309', N'Kaki', N'Việt Nam')
INSERT [dbo].[ChatLieu] ([maChatLieu], [tenChatLieu], [xuatXu]) VALUES (N'CL27102310', N'kate', N'Hàn quốc')
GO
INSERT [dbo].[ChiTietDoiTra] ([maSP], [maDT], [soLuong], [giaBan], [thanhTien]) VALUES (N'SP091123164600', N'DT121223180131', 2, 756000.0000, 1512000.0000)
INSERT [dbo].[ChiTietDoiTra] ([maSP], [maDT], [soLuong], [giaBan], [thanhTien]) VALUES (N'SP091123165605', N'DT231123231544', 1, 980000.0000, 980000.0000)
INSERT [dbo].[ChiTietDoiTra] ([maSP], [maDT], [soLuong], [giaBan], [thanhTien]) VALUES (N'SP091123165605', N'DT231123232940', 2, 980000.0000, 1960000.0000)
INSERT [dbo].[ChiTietDoiTra] ([maSP], [maDT], [soLuong], [giaBan], [thanhTien]) VALUES (N'SP091123165605', N'DT231123233125', 2, 980000.0000, 1960000.0000)
INSERT [dbo].[ChiTietDoiTra] ([maSP], [maDT], [soLuong], [giaBan], [thanhTien]) VALUES (N'SP091123170154', N'DT231123231544', 1, 117600.0000, 117600.0000)
INSERT [dbo].[ChiTietDoiTra] ([maSP], [maDT], [soLuong], [giaBan], [thanhTien]) VALUES (N'SP091123170154', N'DT231123232940', 1, 117600.0000, 117600.0000)
INSERT [dbo].[ChiTietDoiTra] ([maSP], [maDT], [soLuong], [giaBan], [thanhTien]) VALUES (N'SP091123170154', N'DT231123233125', 1, 117600.0000, 117600.0000)
INSERT [dbo].[ChiTietDoiTra] ([maSP], [maDT], [soLuong], [giaBan], [thanhTien]) VALUES (N'SP091123170618', N'DT231123233649', 1, 756000.0000, 756000.0000)
INSERT [dbo].[ChiTietDoiTra] ([maSP], [maDT], [soLuong], [giaBan], [thanhTien]) VALUES (N'SP091123170618', N'DT231123234532', 1, 756000.0000, 756000.0000)
INSERT [dbo].[ChiTietDoiTra] ([maSP], [maDT], [soLuong], [giaBan], [thanhTien]) VALUES (N'SP121223001106', N'DT121223180210', 2, 728000.0000, 1456000.0000)
GO
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP011022044632', N'HD121223154357', 2, 278600.0000, 278600.0000, 557200.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP011022044632', N'HD121223174332', 6, 278600.0000, 278600.0000, 1671600.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP011022044632', N'HD131223123539', 1, 278600.0000, 278600.0000, 278600.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP011022074632', N'HD131223132304', 10, 700000.0000, 700000.0000, 7000000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP031123072651', N'HD121223155506', 2, 756000.0000, 756000.0000, 1512000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP031123072651', N'HD121223174332', 3, 756000.0000, 680400.0000, 2041200.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP031123072652', N'HD121223155506', 2, 865200.0000, 865200.0000, 1730400.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP031123072652', N'HD121223155612', 2, 865200.0000, 865200.0000, 1730400.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP031123072652', N'HD121223155717', 2, 865200.0000, 865200.0000, 1730400.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP031123072652', N'HD121223165608', 4, 865200.0000, 865200.0000, 3460800.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP031123072655', N'HD121223160235', 1, 768600.0000, 768600.0000, 768600.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP031123072655', N'HD121223165608', 7, 768600.0000, 768600.0000, 5380200.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP071022075642', N'HD121223155848', 2, 756000.0000, 756000.0000, 1512000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP071023072633', N'HD121223155848', 2, 117600.0000, 117600.0000, 235200.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP071123072650', N'HD121223160235', 3, 756000.0000, 756000.0000, 2268000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP071123072651', N'HD121223155612', 2, 810600.0000, 810600.0000, 1621200.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP071123072651', N'HD121223155717', 3, 810600.0000, 810600.0000, 2431800.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP071123072651', N'HD121223155848', 1, 810600.0000, 810600.0000, 810600.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP071123082647', N'HD121223160033', 4, 728000.0000, 728000.0000, 2912000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091023044631', N'HD121223160033', 2, 952000.0000, 952000.0000, 1904000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163521', N'HD121223160033', 1, 588000.0000, 588000.0000, 588000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163553', N'HD011223003929', 1, 796600.0000, 677110.0000, 677110.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163553', N'HD181123105301', 4, 50000.0000, 50000.0000, 200000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163553', N'HD181123105303', 6, 20000.0000, 20000.0000, 120000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163553', N'HD241123154854', 3, 796600.0000, 796600.0000, 2389800.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163553', N'HD241123155720', 2, 796600.0000, 796600.0000, 1593200.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163553', N'HD241123160214', 2, 796600.0000, 796600.0000, 1593200.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163553', N'HD251123204948', 2, 796600.0000, 796600.0000, 1593200.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163553', N'HD251123205422', 3, 796600.0000, 796600.0000, 2389800.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163553', N'HD251123205612', 3, 796600.0000, 796600.0000, 2389800.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163553', N'HD271123191748', 5, 796600.0000, 716940.0000, 3584700.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163838', N'HD181123105301', 5, 40000.0000, 40000.0000, 200000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163838', N'HD181123105303', 10, 10000.0000, 10000.0000, 100000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163838', N'HD241123150114', 5, 371000.0000, 371000.0000, 1855000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163838', N'HD241123152139', 3, 371000.0000, 371000.0000, 1113000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163838', N'HD241123161108', 2, 371000.0000, 371000.0000, 742000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163838', N'HD241123161751', 2, 371000.0000, 371000.0000, 742000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163838', N'HD261123223517', 1, 371000.0000, 371000.0000, 371000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163838', N'HD261123223640', 1, 371000.0000, 371000.0000, 371000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163838', N'HD261123223837', 1, 371000.0000, 371000.0000, 371000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163838', N'HD261123224552', 1, 371000.0000, 371000.0000, 371000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163838', N'HD261123224638', 2, 371000.0000, 371000.0000, 742000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123163838', N'HD261123224732', 10, 371000.0000, 371000.0000, 3710000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123164111', N'HD261123223517', 1, 522200.0000, 522200.0000, 522200.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123164111', N'HD261123223640', 1, 522200.0000, 522200.0000, 522200.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123164111', N'HD261123223837', 1, 522200.0000, 522200.0000, 522200.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123164111', N'HD261123224552', 1, 522200.0000, 522200.0000, 522200.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123164111', N'HD261123224638', 4, 522200.0000, 522200.0000, 2088800.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123164111', N'HD261123224732', 6, 522200.0000, 522200.0000, 3133200.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123164600', N'HD121223154357', 2, 756000.0000, 756000.0000, 1512000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123164600', N'HD251123203928', 1, 756000.0000, 756000.0000, 756000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123164600', N'HD251123204454', 1, 756000.0000, 756000.0000, 756000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123164600', N'HD261123230007', 4, 756000.0000, 756000.0000, 3024000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123164600', N'HD261123230354', 1, 756000.0000, 756000.0000, 756000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123164600', N'HD261123232424', 1, 756000.0000, 756000.0000, 756000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123164600', N'HD261123233426', 1, 756000.0000, 756000.0000, 756000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123164600', N'HD261123234957', 1, 756000.0000, 756000.0000, 756000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123164600', N'HD281123211144', 5, 756000.0000, 680400.0000, 3402000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123164932', N'HD121223160235', 2, 280000.0000, 280000.0000, 560000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123164932', N'HD251123203928', 5, 280000.0000, 280000.0000, 1400000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123165605', N'HD231123223033', 3, 980000.0000, 980000.0000, 2940000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123165605', N'HD241123152139', 5, 980000.0000, 980000.0000, 4900000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123165605', N'HD261123223517', 1, 980000.0000, 980000.0000, 980000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123165605', N'HD261123223640', 1, 980000.0000, 980000.0000, 980000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123165605', N'HD261123223837', 1, 980000.0000, 980000.0000, 980000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123165605', N'HD261123224552', 1, 980000.0000, 980000.0000, 980000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123165605', N'HD261123224638', 2, 980000.0000, 980000.0000, 1960000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123165605', N'HD261123224732', 1, 980000.0000, 980000.0000, 980000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123170154', N'HD121223160033', 1, 117600.0000, 117600.0000, 117600.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123170154', N'HD231123223033', 2, 117600.0000, 117600.0000, 235200.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123170154', N'HD261123080349', 1, 117600.0000, 117600.0000, 117600.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123170154', N'HD261123230007', 3, 117600.0000, 117600.0000, 352800.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123170154', N'HD261123230354', 3, 117600.0000, 117600.0000, 352800.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123170154', N'HD261123232424', 4, 117600.0000, 117600.0000, 470400.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123170154', N'HD261123233426', 2, 117600.0000, 117600.0000, 235200.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123170154', N'HD261123234957', 4, 117600.0000, 117600.0000, 470400.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123170421', N'HD261123080349', 1, 770000.0000, 770000.0000, 770000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123170421', N'HD261123230007', 2, 770000.0000, 770000.0000, 1540000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123170421', N'HD261123230354', 3, 770000.0000, 770000.0000, 2310000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123170421', N'HD261123232424', 3, 770000.0000, 770000.0000, 2310000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123170421', N'HD261123234957', 1, 770000.0000, 770000.0000, 770000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123170618', N'HD231123221533', 2, 756000.0000, 680400.0000, 1360800.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123170953', N'HD251123203928', 2, 124600.0000, 124600.0000, 249200.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123170953', N'HD251123205422', 1, 124600.0000, 124600.0000, 124600.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123171246', N'HD251123204948', 3, 210000.0000, 210000.0000, 630000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123171246', N'HD251123205422', 2, 210000.0000, 210000.0000, 420000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123171246', N'HD251123205612', 4, 210000.0000, 210000.0000, 840000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123171246', N'HD261123080349', 3, 210000.0000, 210000.0000, 630000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123171411', N'HD251123204454', 1, 700000.0000, 700000.0000, 700000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123171411', N'HD251123204948', 1, 700000.0000, 700000.0000, 700000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123171411', N'HD251123205422', 1, 700000.0000, 700000.0000, 700000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123171411', N'HD251123205612', 12, 700000.0000, 700000.0000, 8400000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123171411', N'HD271123190951', 1, 700000.0000, 700000.0000, 700000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123171526', N'HD251123204454', 1, 420000.0000, 420000.0000, 420000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123171526', N'HD251123204948', 1, 420000.0000, 420000.0000, 420000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP091123171526', N'HD251123205422', 1, 420000.0000, 420000.0000, 420000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP101122044633', N'HD121223160235', 2, 588000.0000, 588000.0000, 1176000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP111022044623', N'HD121223160033', 2, 418600.0000, 418600.0000, 837200.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP121223001106', N'HD121223154357', 2, 728000.0000, 728000.0000, 1456000.0000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [soLuong], [giaGoc], [giaBan], [thanhTien]) VALUES (N'SP121223001106', N'HD121223154453', 7, 728000.0000, 728000.0000, 5096000.0000)
GO
INSERT [dbo].[ChuongTrinhKhuyenMai] ([maCTKM], [tenCTKM], [soTienToiDa], [soTienToiThieu], [giamGia], [ngayBatDau], [ngayKetThuc], [tinhTrang], [maLoaiCTKM]) VALUES (N'KM051223160538', N'Mừng Tết Nguyên Đán 2024', 0.0000, 0.0000, 10, CAST(N'2023-11-05T00:00:00.000' AS DateTime), CAST(N'2024-02-29T00:00:00.000' AS DateTime), N'Còn', N'GGSP')
INSERT [dbo].[ChuongTrinhKhuyenMai] ([maCTKM], [tenCTKM], [soTienToiDa], [soTienToiThieu], [giamGia], [ngayBatDau], [ngayKetThuc], [tinhTrang], [maLoaiCTKM]) VALUES (N'KM121223170136', N'Mừng Tết Nguyên Đán 2024', 5000000.0000, 2000000.0000, 15, CAST(N'2023-12-12T00:00:00.000' AS DateTime), CAST(N'2024-02-13T00:00:00.000' AS DateTime), N'Còn', N'GGHD')
INSERT [dbo].[ChuongTrinhKhuyenMai] ([maCTKM], [tenCTKM], [soTienToiDa], [soTienToiThieu], [giamGia], [ngayBatDau], [ngayKetThuc], [tinhTrang], [maLoaiCTKM]) VALUES (N'KM121223181526', N'Mừng Tết 2024', 300000.0000, 100000.0000, 25, CAST(N'2023-12-12T00:00:00.000' AS DateTime), CAST(N'2024-02-12T00:00:00.000' AS DateTime), N'Còn', N'GGHD')
INSERT [dbo].[ChuongTrinhKhuyenMai] ([maCTKM], [tenCTKM], [soTienToiDa], [soTienToiThieu], [giamGia], [ngayBatDau], [ngayKetThuc], [tinhTrang], [maLoaiCTKM]) VALUES (N'KM121223181623', N'Mừng Tết 2024', 0.0000, 0.0000, 25, CAST(N'2023-12-12T00:00:00.000' AS DateTime), CAST(N'2024-01-31T00:00:00.000' AS DateTime), N'Còn', N'GGSP')
INSERT [dbo].[ChuongTrinhKhuyenMai] ([maCTKM], [tenCTKM], [soTienToiDa], [soTienToiThieu], [giamGia], [ngayBatDau], [ngayKetThuc], [tinhTrang], [maLoaiCTKM]) VALUES (N'KM201123145901', N'Mừng ngày nhà giáo Việt Nam', 500000.0000, 200000.0000, 15, CAST(N'2023-11-10T00:00:00.000' AS DateTime), CAST(N'2024-01-20T00:00:00.000' AS DateTime), N'Còn', N'GGHD')
INSERT [dbo].[ChuongTrinhKhuyenMai] ([maCTKM], [tenCTKM], [soTienToiDa], [soTienToiThieu], [giamGia], [ngayBatDau], [ngayKetThuc], [tinhTrang], [maLoaiCTKM]) VALUES (N'KM201123145902', N'Mừng Tết Dương 2024', 0.0000, 0.0000, 10, CAST(N'2023-11-05T00:00:00.000' AS DateTime), CAST(N'2024-01-30T00:00:00.000' AS DateTime), N'Còn', N'GGSP')
INSERT [dbo].[ChuongTrinhKhuyenMai] ([maCTKM], [tenCTKM], [soTienToiDa], [soTienToiThieu], [giamGia], [ngayBatDau], [ngayKetThuc], [tinhTrang], [maLoaiCTKM]) VALUES (N'KM231123214418', N'Mừng ngày giáng sinh', 0.0000, 0.0000, 15, CAST(N'2023-11-05T00:00:00.000' AS DateTime), CAST(N'2023-12-06T00:00:00.000' AS DateTime), N'Còn', N'GGSP')
INSERT [dbo].[ChuongTrinhKhuyenMai] ([maCTKM], [tenCTKM], [soTienToiDa], [soTienToiThieu], [giamGia], [ngayBatDau], [ngayKetThuc], [tinhTrang], [maLoaiCTKM]) VALUES (N'KM281123204731', N'Mừng ngày 2-9', 0.0000, 0.0000, 10, CAST(N'2023-11-21T00:00:00.000' AS DateTime), CAST(N'2023-12-01T00:00:00.000' AS DateTime), N'Đã hết', N'GGSP')
INSERT [dbo].[ChuongTrinhKhuyenMai] ([maCTKM], [tenCTKM], [soTienToiDa], [soTienToiThieu], [giamGia], [ngayBatDau], [ngayKetThuc], [tinhTrang], [maLoaiCTKM]) VALUES (N'KM281123205807', N'Mừng Tết Trung Thu', 0.0000, 0.0000, 20, CAST(N'2023-11-28T00:00:00.000' AS DateTime), CAST(N'2023-11-30T00:00:00.000' AS DateTime), N'Đã hết', N'GGSP')
INSERT [dbo].[ChuongTrinhKhuyenMai] ([maCTKM], [tenCTKM], [soTienToiDa], [soTienToiThieu], [giamGia], [ngayBatDau], [ngayKetThuc], [tinhTrang], [maLoaiCTKM]) VALUES (N'KM281123211008', N'Mừng ngày 20-11', 0.0000, 0.0000, 10, CAST(N'2023-11-28T00:00:00.000' AS DateTime), CAST(N'2023-12-04T00:00:00.000' AS DateTime), N'Đã hết', N'GGSP')
GO
INSERT [dbo].[DanhMucSanPham] ([maDanhMuc], [tenDanhMuc]) VALUES (N'DM27102301', N'Áo thun nam')
INSERT [dbo].[DanhMucSanPham] ([maDanhMuc], [tenDanhMuc]) VALUES (N'DM27102302', N'Áo sơ mi nam')
INSERT [dbo].[DanhMucSanPham] ([maDanhMuc], [tenDanhMuc]) VALUES (N'DM27102303', N'Áo vest nam')
INSERT [dbo].[DanhMucSanPham] ([maDanhMuc], [tenDanhMuc]) VALUES (N'DM27102304', N'Áo khoác nam')
INSERT [dbo].[DanhMucSanPham] ([maDanhMuc], [tenDanhMuc]) VALUES (N'DM27102305', N'Áo hoodie nam')
INSERT [dbo].[DanhMucSanPham] ([maDanhMuc], [tenDanhMuc]) VALUES (N'DM27102306', N'Áo thun nữ')
INSERT [dbo].[DanhMucSanPham] ([maDanhMuc], [tenDanhMuc]) VALUES (N'DM27102307', N'Áo sơ mi nữ')
INSERT [dbo].[DanhMucSanPham] ([maDanhMuc], [tenDanhMuc]) VALUES (N'DM27102308', N'Áo vest nữ')
INSERT [dbo].[DanhMucSanPham] ([maDanhMuc], [tenDanhMuc]) VALUES (N'DM27102309', N'Áo khoác nữ')
INSERT [dbo].[DanhMucSanPham] ([maDanhMuc], [tenDanhMuc]) VALUES (N'DM27102310', N'Áo hoodie nữ')
INSERT [dbo].[DanhMucSanPham] ([maDanhMuc], [tenDanhMuc]) VALUES (N'DM27102311', N'Vớ')
INSERT [dbo].[DanhMucSanPham] ([maDanhMuc], [tenDanhMuc]) VALUES (N'DM27102312', N'Giày')
INSERT [dbo].[DanhMucSanPham] ([maDanhMuc], [tenDanhMuc]) VALUES (N'DM27102313', N'Nón')
INSERT [dbo].[DanhMucSanPham] ([maDanhMuc], [tenDanhMuc]) VALUES (N'DM27102314', N'Thắt lưng')
INSERT [dbo].[DanhMucSanPham] ([maDanhMuc], [tenDanhMuc]) VALUES (N'DM27102315', N'Quần nam')
INSERT [dbo].[DanhMucSanPham] ([maDanhMuc], [tenDanhMuc]) VALUES (N'DM27102316', N'Quần lót nam')
INSERT [dbo].[DanhMucSanPham] ([maDanhMuc], [tenDanhMuc]) VALUES (N'DM27102317', N'Chân váy')
INSERT [dbo].[DanhMucSanPham] ([maDanhMuc], [tenDanhMuc]) VALUES (N'DM27102318', N'Đầm nữ')
INSERT [dbo].[DanhMucSanPham] ([maDanhMuc], [tenDanhMuc]) VALUES (N'DM27102319', N'Quần nữ')
GO
INSERT [dbo].[DoiTra] ([maDT], [maHD], [maNV], [thoiGianDoiTra], [hinhThucDoiTra], [tongTien]) VALUES (N'DT121223180131', N'HD121223154357', N'NV091123190034', CAST(N'2023-12-12T00:00:00.000' AS DateTime), N'Hoàn trả', 1512000.0000)
INSERT [dbo].[DoiTra] ([maDT], [maHD], [maNV], [thoiGianDoiTra], [hinhThucDoiTra], [tongTien]) VALUES (N'DT121223180210', N'HD121223154357', N'NV091123190034', CAST(N'2023-12-12T00:00:00.000' AS DateTime), N'Đổi mới', 0.0000)
INSERT [dbo].[DoiTra] ([maDT], [maHD], [maNV], [thoiGianDoiTra], [hinhThucDoiTra], [tongTien]) VALUES (N'DT231123231544', N'HD231123223033', N'NV091123191028', CAST(N'2023-11-23T00:00:00.000' AS DateTime), N'Hoàn trả', 1097600.0000)
INSERT [dbo].[DoiTra] ([maDT], [maHD], [maNV], [thoiGianDoiTra], [hinhThucDoiTra], [tongTien]) VALUES (N'DT231123232940', N'HD231123223033', N'NV091123191028', CAST(N'2023-11-23T00:00:00.000' AS DateTime), N'Đổi mới', 0.0000)
INSERT [dbo].[DoiTra] ([maDT], [maHD], [maNV], [thoiGianDoiTra], [hinhThucDoiTra], [tongTien]) VALUES (N'DT231123233125', N'HD231123223033', N'NV091123191028', CAST(N'2023-11-23T00:00:00.000' AS DateTime), N'Hoàn trả', 2077600.0000)
INSERT [dbo].[DoiTra] ([maDT], [maHD], [maNV], [thoiGianDoiTra], [hinhThucDoiTra], [tongTien]) VALUES (N'DT231123233649', N'HD231123221533', N'NV091123191028', CAST(N'2023-11-23T00:00:00.000' AS DateTime), N'Hoàn trả', 756000.0000)
INSERT [dbo].[DoiTra] ([maDT], [maHD], [maNV], [thoiGianDoiTra], [hinhThucDoiTra], [tongTien]) VALUES (N'DT231123234532', N'HD231123221533', N'NV091123191028', CAST(N'2023-11-23T00:00:00.000' AS DateTime), N'Hoàn trả', 756000.0000)
GO
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD011223003929', NULL, N'NV091123191028', N'KM201123145901', CAST(N'2023-12-01T00:00:00.000' AS DateTime), 101566.5000, 677110.0000, 575543.5000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD011223004535', NULL, N'NV091123191028', N'KM201123145901', CAST(N'2023-12-01T00:00:00.000' AS DateTime), 420000.0000, 2800000.0000, 2380000.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD011223004819', NULL, N'NV091123191028', N'KM201123145901', CAST(N'2023-12-01T00:00:00.000' AS DateTime), 210000.0000, 1400000.0000, 1190000.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD121223154357', N'KH121223150910', N'NV121223151505', N'KM201123145901', CAST(N'2023-12-12T00:00:00.000' AS DateTime), 500000.0000, 3525200.0000, 3025200.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD121223154453', N'KH121223150944', N'NV121223151505', N'KM201123145901', CAST(N'2023-12-12T00:00:00.000' AS DateTime), 500000.0000, 5096000.0000, 4596000.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD121223155506', N'KH121223151011', N'NV121223151732', N'KM201123145901', CAST(N'2023-12-12T00:00:00.000' AS DateTime), 486360.0000, 3242400.0000, 2756040.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD121223155612', N'KH121223151226', N'NV121223151732', N'KM201123145901', CAST(N'2023-12-12T00:00:00.000' AS DateTime), 500000.0000, 3351600.0000, 2851600.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD121223155717', N'KH121223151108', N'NV121223151732', N'KM201123145901', CAST(N'2023-12-12T00:00:00.000' AS DateTime), 500000.0000, 4162200.0000, 3662200.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD121223155848', N'KH121223151328', N'NV121223152032', N'KM201123145901', CAST(N'2023-12-12T00:00:00.000' AS DateTime), 383670.0000, 2557800.0000, 2174130.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD121223160033', N'KH121223151257', N'NV121223152032', N'KM201123145901', CAST(N'2023-12-12T00:00:00.000' AS DateTime), 500000.0000, 6358800.0000, 5858800.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD121223160235', N'KH121223151035', N'NV121223151830', N'KM201123145901', CAST(N'2023-12-12T00:00:00.000' AS DateTime), 500000.0000, 4772600.0000, 4272600.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD121223165608', N'KH071223135141', N'NV091123190034', N'KM201123145901', CAST(N'2023-12-12T00:00:00.000' AS DateTime), 500000.0000, 8841000.0000, 8341000.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD121223174332', NULL, N'NV091123190034', N'KM201123145901', CAST(N'2023-12-12T00:00:00.000' AS DateTime), 500000.0000, 3712800.0000, 3212800.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD131223123539', N'KH091123012957', N'NV091123190034', N'KM121223181526', CAST(N'2023-12-13T00:00:00.000' AS DateTime), 69650.0000, 278600.0000, 208950.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD131223132304', NULL, N'NV091123190034', N'KM121223181526', CAST(N'2023-12-13T00:00:00.000' AS DateTime), 300000.0000, 7000000.0000, 6700000.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD181123105301', N'KH091123012123', N'NV091123190034', NULL, CAST(N'2023-11-10T00:00:00.000' AS DateTime), 0.0000, 2000000.0000, 2000000.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD181123105303', N'KH091123012349', N'NV091123190034', NULL, CAST(N'2023-11-18T00:00:00.000' AS DateTime), 0.0000, 5000000.0000, 5000000.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD231123221533', NULL, N'NV091123191028', N'KM201123145901', CAST(N'2023-11-23T00:00:00.000' AS DateTime), 200000.0000, 1360800.0000, 1160800.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD231123223033', NULL, N'NV091123191028', N'KM201123145901', CAST(N'2023-11-23T00:00:00.000' AS DateTime), 200000.0000, 3175200.0000, 2975200.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD241123150114', N'KH091123012123', N'NV091123191028', N'KM201123145901', CAST(N'2023-11-24T00:00:00.000' AS DateTime), 200000.0000, 1855000.0000, 1655000.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD241123152139', NULL, N'NV091123191028', N'KM201123145901', CAST(N'2023-11-24T00:00:00.000' AS DateTime), 200000.0000, 6013000.0000, 5813000.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD241123154854', NULL, N'NV091123191028', N'KM201123145901', CAST(N'2023-11-24T00:00:00.000' AS DateTime), 200000.0000, 2389800.0000, 2189800.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD241123155720', NULL, N'NV091123191028', N'KM201123145901', CAST(N'2023-11-24T00:00:00.000' AS DateTime), 200000.0000, 1593200.0000, 1393200.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD241123160214', NULL, N'NV091123191028', N'KM201123145901', CAST(N'2023-11-24T00:00:00.000' AS DateTime), 200000.0000, 1593200.0000, 1393200.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD241123161108', NULL, N'NV091123191028', N'KM201123145901', CAST(N'2023-11-24T00:00:00.000' AS DateTime), 111300.0000, 742000.0000, 630700.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD241123161751', NULL, N'NV091123191028', N'KM201123145901', CAST(N'2023-11-24T00:00:00.000' AS DateTime), 111300.0000, 742000.0000, 630700.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD251123203928', N'KH091123013019', N'NV091123191028', NULL, CAST(N'2023-11-25T00:00:00.000' AS DateTime), 0.0000, 2405200.0000, 2405200.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD251123204454', N'KH091123013041', N'NV091123191028', NULL, CAST(N'2023-11-25T00:00:00.000' AS DateTime), 0.0000, 1876000.0000, 1876000.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD251123204948', N'KH091123013218', N'NV091123191028', NULL, CAST(N'2023-11-25T00:00:00.000' AS DateTime), 0.0000, 3343200.0000, 3343200.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD251123205422', N'KH091123012957', N'NV091123190405', NULL, CAST(N'2023-11-25T00:00:00.000' AS DateTime), 0.0000, 4054400.0000, 4054400.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD251123205612', N'KH091123013235', N'NV091123190405', NULL, CAST(N'2023-11-25T00:00:00.000' AS DateTime), 0.0000, 11629800.0000, 11629800.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD261123080349', N'KH091123012754', N'NV091123191028', NULL, CAST(N'2023-10-26T00:00:00.000' AS DateTime), 0.0000, 1517600.0000, 1517600.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD261123223517', N'KH091123013304', N'NV091123191028', NULL, CAST(N'2023-10-26T00:00:00.000' AS DateTime), 0.0000, 1873200.0000, 1873200.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD261123223640', N'KH091123013156', N'NV091123191028', NULL, CAST(N'2023-10-26T00:00:00.000' AS DateTime), 0.0000, 1873200.0000, 1873200.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD261123223837', N'KH091123012817', N'NV091123191028', NULL, CAST(N'2023-10-26T00:00:00.000' AS DateTime), 0.0000, 1873200.0000, 1873200.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD261123224552', N'KH091123013156', N'NV091123190405', NULL, CAST(N'2023-09-26T00:00:00.000' AS DateTime), 0.0000, 1873200.0000, 1873200.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD261123224638', N'KH091123013304', N'NV091123190405', NULL, CAST(N'2023-09-26T00:00:00.000' AS DateTime), 0.0000, 4790800.0000, 4790800.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD261123224732', N'KH091123013235', N'NV091123190405', NULL, CAST(N'2023-09-26T00:00:00.000' AS DateTime), 0.0000, 7823200.0000, 7823200.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD261123230007', N'KH091123013135', N'NV091123190530', NULL, CAST(N'2023-10-26T00:00:00.000' AS DateTime), 0.0000, 4916800.0000, 4916800.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD261123230354', N'KH091123013218', N'NV091123190937', NULL, CAST(N'2023-10-26T00:00:00.000' AS DateTime), 0.0000, 3418800.0000, 3418800.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD261123232424', N'KH091123013135', N'NV091123190034', NULL, CAST(N'2023-11-26T00:00:00.000' AS DateTime), 0.0000, 3536400.0000, 3536400.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD261123233426', N'KH091123013041', N'NV091123190034', NULL, CAST(N'2023-09-26T00:00:00.000' AS DateTime), 0.0000, 991200.0000, 991200.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD261123234957', N'KH091123013135', N'NV091123190937', NULL, CAST(N'2023-11-26T00:00:00.000' AS DateTime), 0.0000, 1996400.0000, 1996400.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD271123003610', N'KH091123013218', N'NV091123191028', NULL, CAST(N'2023-11-27T00:00:00.000' AS DateTime), 0.0000, 1526000.0000, 1526000.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD271123003803', N'KH091123013218', N'NV091123191028', NULL, CAST(N'2023-11-27T00:00:00.000' AS DateTime), 0.0000, 1526000.0000, 1526000.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD271123190951', NULL, N'NV091123191028', N'KM201123145901', CAST(N'2023-11-27T00:00:00.000' AS DateTime), 105000.0000, 700000.0000, 595000.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD271123191748', N'KH091123012754', N'NV091123191028', N'KM201123145901', CAST(N'2023-11-27T00:00:00.000' AS DateTime), 500000.0000, 3584700.0000, 3084700.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD281123211144', NULL, N'NV091123191028', N'KM201123145901', CAST(N'2023-11-28T00:00:00.000' AS DateTime), 500000.0000, 3402000.0000, 2902000.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD301123212354', NULL, N'NV091123191028', N'KM201123145901', CAST(N'2023-11-30T00:00:00.000' AS DateTime), 420000.0000, 2800000.0000, 2380000.0000, N'Đã thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maKH], [maNV], [maCTKM], [ngayLapHD], [tienKhuyenMai], [tongTien], [tienThanhToan], [tinhTrang]) VALUES (N'HD301123213020', NULL, N'NV091123191028', N'KM201123145901', CAST(N'2023-11-30T00:00:00.000' AS DateTime), 420000.0000, 2800000.0000, 2380000.0000, N'Đã thanh toán')
GO
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH071223135141', N'Nguyễn Đình Nam', N'Nam', N'0102030405', N'Quận 1, TPHCM')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH091123012123', N'Đỗ Tường An', N'Nam', N'0123654789', N'Sông Hinh, Phú Yên')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH091123012349', N'Trần Trường An', N'Nam', N'0147258963', N'Quận Tân Bình, TPHCM')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH091123012754', N'Trần Cao Vót', N'Nam', N'0125874963', N'Sông Hinh, Phú Yên')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH091123012817', N'Trần Tiểu Linh', N'Nữ', N'0145236987', N'Sông Hinh, Phú Yên')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH091123012843', N'Đỗ Cao Nguyệt', N'Nam', N'0123658974', N'Sông Hinh, Phú Yên')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH091123012905', N'Đỗ Thành Đạt', N'Nam', N'0159753685', N'Sông Hinh, Phú Yên')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH091123012957', N'Vạn Sinh', N'Nữ', N'0159852364', N'Sông Hinh, Phú Yên')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH091123013019', N'Vạn Tượng', N'Nam', N'0789987789', N'Sông Hinh, Phú Yên')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH091123013041', N'Triệu Linh', N'Nữ', N'0123654456', N'Sông Hinh, Phú Yên')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH091123013103', N'Ngọc Như Ý', N'Nữ', N'0147852258', N'Sông Hinh, Phú Yên')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH091123013135', N'Lý Lạc', N'Nam', N'0123658976', N'Sông Hinh, Phú Yên')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH091123013156', N'Lý Công Công', N'Khác', N'0125987463', N'Sông Hinh, Phú Yên')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH091123013218', N'Đỗ Đạt', N'Nam', N'0856974231', N'Sông Hinh, Phú Yên')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH091123013235', N'Đỗ Thánh', N'Nam', N'0125478639', N'Sông Hinh, Phú Yên')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH091123013304', N'Đỗ Bảo Linh', N'Nữ', N'0567412398', N'Sông Hinh, Phú Yên')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH121223150406', N'Lê Thị Khuyên', N'Nữ', N'0312221133', N'Ngã 5 Chuồng Chó, Gò Vấp')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH121223150434', N'Lưu Văn Lâm', N'Nam', N'0936278113', N'Đồng Nai')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH121223150501', N'Trần Văn Sơn', N'Nam', N'0956781223', N'Bà Rịa Vũng Tàu')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH121223150536', N'Nguyễn Văn Trỗi', N'Nam', N'0933277377', N'Đống Đa, Hà Nội')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH121223150608', N'Nguyễn Chí Cường', N'Nam', N'0927672772', N'Phường 5, Gò Vấp')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH121223150634', N'Nguyễn Văn Nghi', N'Nam', N'0951277833', N'Đà Nẵng')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH121223150705', N'Nguyễn Công Phượng', N'Nam', N'0836781992', N'Trần Văn Ơn, Gò Vấp')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH121223150735', N'Nguyễn Chiêu Văn', N'Nam', N'0926781992', N'Bình Định')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH121223150815', N'Lý Xuân Phương', N'Nam', N'0967811233', N'Quãng Ngãi')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH121223150910', N'Cao Diệu Linh', N'Nữ', N'0937878979', N'Chợ Mới, An Giang')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH121223150944', N'Nguyễn Huyền Trân', N'Nữ', N'0938223773', N'Sóc Xà Bai, Sóc Trăng')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH121223151011', N'Lưu Chí Vĩ', N'Nam', N'0937891991', N'Quận 1, TPHCM')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH121223151035', N'Lê Văn Lai', N'Nam', N'0987112443', N'Quận 12, TPHCM')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH121223151108', N'Nguyễn Thiên Tứ', N'Nam', N'0937672110', N'Cần Đước, Long An')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH121223151146', N'Trần Văn Khoẻn', N'Nam', N'0981667223', N'Cần Thơ')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH121223151226', N'Võ Thị Đơn', N'Nữ', N'0981665223', N'Heaven Palace')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH121223151257', N'Nguyễn Phước Điền', N'Nam', N'0987221333', N'Chợ Gạo, Tiền Giang')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH121223151328', N'Nguyễn Thị Nguyên', N'Nữ', N'0922767881', N'Gia Lai')
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH121223175804', N'Nguyễn Văn Linh', N'Nam', N'0504030607', N'12 Nguyễn Văn Bảo, Quận Gò Vấp, TPHCM')
GO
INSERT [dbo].[LoaiChuongTrinhKhuyenMai] ([maLoaiCTKM], [moTa]) VALUES (N'GGHD', N'Giảm giá cho hoá đơn')
INSERT [dbo].[LoaiChuongTrinhKhuyenMai] ([maLoaiCTKM], [moTa]) VALUES (N'GGSP', N'Giảm giá cho sản phẩm')
GO
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN031223172836', N'NCC091123005924', N'SP091123171122', 5, CAST(N'2023-12-03' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN031223172945', N'NCC091123005543', N'SP091123171122', 1, CAST(N'2023-12-03' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN041223153935', N'NCC091123005543', N'SP091123171122', 10, CAST(N'2023-12-04' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172701', N'NCC121223070607', N'SP071022074632', 7, CAST(N'2023-11-20' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172710', N'NCC121223073958', N'SP031123072651', 20, CAST(N'2023-11-15' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172712', N'NCC121223070912', N'SP031123072655', 3, CAST(N'2023-11-18' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172721', N'NCC121223070607', N'SP031123072653', 14, CAST(N'2023-11-16' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172732', N'NCC121223074146', N'SP071022084652', 44, CAST(N'2023-11-21' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172738', N'NCC091123010211', N'SP091123163553', 7, CAST(N'2023-11-09' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172739', N'NCC091123010211', N'SP041223145447', 7, CAST(N'2023-11-11' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172747', N'NCC121223071812', N'SP070923072631', 9, CAST(N'2023-11-19' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172750', N'NCC091123010524', N'SP091123164111', 10, CAST(N'2023-11-09' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172751', N'NCC091123010524', N'SP031123072653', 10, CAST(N'2023-11-12' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172752', N'NCC121223071812', N'SP031123072655', 10, CAST(N'2023-11-13' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172753', N'NCC121223064651', N'SP011022074632', 4, CAST(N'2023-11-05' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172754', N'NCC121223070912', N'SP041223145447', 42, CAST(N'2023-12-05' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172805', N'NCC091123010738', N'SP091123164932', 100, CAST(N'2023-11-09' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172816', N'NCC091123005543', N'SP091123170802', 200, CAST(N'2023-11-09' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172824', N'NCC091123005543', N'SP091123171246', 10, CAST(N'2023-11-09' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172834', N'NCC091123005543', N'SP091123171526', 20, CAST(N'2023-11-09' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172844', N'NCC091123010349', N'SP091123171411', 30, CAST(N'2023-11-09' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172854', N'NCC091123005543', N'SP091123170802', 50, CAST(N'2023-11-09' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172919', N'NCC091123010738', N'SP091123170421', 30, CAST(N'2023-11-09' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123172935', N'NCC091123005543', N'SP091123170154', 110, CAST(N'2023-11-09' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123182711', N'NCC121223073845', N'SP081022071637', 101, CAST(N'2023-12-10' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123182712', N'NCC121223063854', N'SP071123052649', 7, CAST(N'2023-11-25' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123182723', N'NCC121223073351', N'SP091023013612', 15, CAST(N'2023-12-02' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123182734', N'NCC121223073519', N'SP091022044631', 12, CAST(N'2023-11-29' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123182744', N'NCC091123011300', N'SP071123072646', 75, CAST(N'2023-11-26' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123182745', N'NCC091123011405', N'SP071023072640', 3, CAST(N'2023-11-24' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123182754', N'NCC121223063721', N'SP071123072651', 84, CAST(N'2023-11-27' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN091123182759', N'NCC121223064651', N'SP071023072633', 5, CAST(N'2023-11-01' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN121223074911', N'NCC091123005543', N'SP041223145447', 10, CAST(N'2023-12-01' AS Date))
INSERT [dbo].[MatHangNhap] ([maMHN], [maNCC], [maSP], [soLuongNhap], [ngayNhap]) VALUES (N'MHN121223181245', N'NCC091123010211', N'SP121223003047', 100, CAST(N'2023-12-12' AS Date))
GO
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC091123005543', N'The North Face', N'0966654109', N'61 Hàng Gai, Hoàn Kiếm, Hà Nội', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC091123005924', N'Cty TNHH Tường An', N'0976474170', N'216 Hai bà trưng, Sông Hinh, Phú Yên', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC091123010106', N'ACFC', N'0523456785', N'216 Nguyễn Oanh, Gò Vấp, TPHCM', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC091123010211', N'Cty TNHH Bảo Linh', N'0987456123', N'116 Ngũ Hành Sơn, An Khê, Đà Nẵng', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC091123010349', N'Teelab', N'0956789321', N'50 Võ Thị Sáu, Tân Phú, TPHCM', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC091123010524', N'CTy phân phối quần áo Đại Nhật', N'0582369741', N'12 Quang Trung, Bình Thạnh, TPHCM', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC091123010738', N'Cty phân phối da quốc gia Đại Khẩu', N'0861238545', N'Bắc Kinh, Trung quốc', N'Ngừng nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC091123011055', N'Cty TNHH Đại Phát', N'0323968574', N'11 Nguyễn Văn Lượng, Gò Vấp, TPHCM', N'Ngừng nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC091123011300', N'Cty phân phối giày Hỏa Tốc', N'0869574102', N'Triết Giang, Trung Quốc', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC091123011405', N'Nike', N'0723985674', N'Beaverton, Oregon', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223063721', N'Cty cổ phần may Việt Tiến', N'0348498458', N'54 Lê Quang Định, Gò Vấp, TPHCM', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223063854', N'Cty cổ phần dệt may Phong Phú', N'0956248241', N'159 Điện Biên Phủ, Bình Thạnh, TPHCM', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223064319', N'Cty TNHH thời trang dệt may Hải Đường', N'0789484896', N'351 Lê Văn Sỹ, Quận Tân Bình, TPHCM', N'Ngừng nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223064651', N'Cty TNHH sản xuất và thương mại Vĩnh Tài', N'0345678987', N'12 Lê Lợi, Quận 3, TPHCM', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223070328', N'Cty TNHH sản xuất thương mại dịch vụ Trường Nam', N'0345678926', N'12 Đỗ Nhuận, Tân Phú, TPHCM', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223070607', N'Xưởng may Nguyễn Thanh', N'0907856988', N'Hóc Môn, TPHCM', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223070912', N'Kho sỉ may mặc 3579', N'0909312917', N'36 Lương Thế Vinh, Tân Thới Hòa, Tân Phú, TPHCM', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223071111', N'Cty TNHH thương mại và sản xuất Vĩnh Tiến', N'0385274777', N'45 Võ Thị Sáu, Quận 1, TPHCM', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223071211', N'Cty TNHH xuất khẩu Chất Việt', N'0909237573', N'Quận 8, TPHCM', N'Ngừng nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223071334', N'Cty TNHH may xuất nhập khẩu Đức Thành', N'0903643993', N'18 Trần Hưng Đạo, Mỹ Thới, Long Xuyên, An Giang', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223071445', N'Xưởng áo khoác MBP', N'0783377776', N'4 Ấp Tây Lân, Xã Bà Điểm, Huyện Hóc Môn, TPHCM', N'Ngừng nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223071542', N'Xưởng áo Sài Gòn', N'0971800201', N'Ấp 5, Xã Vĩnh Lộc A, Huyện Bình Chánh, TPHCM', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223071651', N'Cty TNHH thương mại sản xuất Meta', N'0939839789', N'Thuận An, Bình Dương', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223071812', N'Cty TNHH may thêu giày An Phước', N'0393918920', N'12 An Dương Vương, Phường 9, Quận 5, TPHCM', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223072017', N'Cty TNHH Esquel Garment Manufacturing Việt Nam', N'0356947855', N'12 Thống Nhất, Quận 1, TPHCM', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223072247', N'Cty TNHH dệt may Nguyên Dung', N'0598175187', N'3A Ba Gia, Phường 7, Tân Bình, TPHCM', N'Ngừng nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223073249', N'Cty cổ phần An Đô Quốc Tế', N'0389764564', N'16 Lý Thái Tổ, Phường 2, Quận 3, TPHCM', N'Ngừng nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223073351', N'Cty TNHH thời trang Ban Mai', N'0907418423', N'149 Trịnh Đình Trọng, Phường Phú Trung, Quận Tân Phú, TPHCM', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223073519', N'Cty may đồng phục thời trang Việt Lê', N'0814798742', N'4 Trần Khánh Dư, Phường Tân Định, Quận 1, TPHCM', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223073639', N'Cty TNHH dệt lụa tơ tằm Phúc Hưng', N'0333487497', N'Số 17 Phú Thọ Hòa, Phú Thọ Hòa, Tân Phú, TPHCM', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223073845', N'Cơ sở sản xuất và phân phối thời trang HT Jeans', N'0964131189', N'128 Tân Hương, Tân Quý, Tân Phú, TPHCM', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223073958', N'Cty TNHH thiết kế thời trang Hoa Hồng', N'0348959786', N'Số 2, Ngõ 401 Xuân Đỉnh, Bắc Từ Liêm, Hà Nội', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223074146', N'Cơ sở quần áo Ngọc Thành', N'0934153959', N'50 Gò Dầu, Phường Tân Phú, Quận Tân Phú, TPHCM', N'Đang nhập')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [diaChi], [tinhTrang]) VALUES (N'NCC121223181103', N'Cty TNHH Việt Tiến', N'0304050607', N'12 Nguyễn Văn Bảo, Quận Gò Vấp, TPHCM', N'Đang nhập')
GO
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [gioiTinh], [ngaySinh], [email], [soDienThoai], [caLamViec], [diaChi], [chucVu], [tinhTrang]) VALUES (N'NV041223200313', N'Trần Văn Vinh', N'Nam', CAST(N'2000-12-06' AS Date), N'hoang123@gmail.com', N'0102030405', N'Ca 1', N'TPHCM', N'Nhân viên', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [gioiTinh], [ngaySinh], [email], [soDienThoai], [caLamViec], [diaChi], [chucVu], [tinhTrang]) VALUES (N'NV071223142153', N'Nguyễn Huy Hưng', N'Nam', CAST(N'2000-12-08' AS Date), N'hung123@gmail.com', N'0123456666', N'Ca 1', N'Quận 1, SG', N'Quản lý', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [gioiTinh], [ngaySinh], [email], [soDienThoai], [caLamViec], [diaChi], [chucVu], [tinhTrang]) VALUES (N'NV091123190034', N'Nguyễn Huy Hoàng', N'Nam', CAST(N'2003-11-07' AS Date), N'tranvinh141203@gmail.com', N'0123456798', N'Ca 2', N'Quận Tân Bình, TP.HCM', N'Quản lý', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [gioiTinh], [ngaySinh], [email], [soDienThoai], [caLamViec], [diaChi], [chucVu], [tinhTrang]) VALUES (N'NV091123190405', N'Trần Gia Huy', N'Nam', CAST(N'2003-11-07' AS Date), N'tranhuy12072003@gmail.com', N'0367819442', N'Ca 2 ', N'Cần Giuộc, Long An', N'Nhân viên', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [gioiTinh], [ngaySinh], [email], [soDienThoai], [caLamViec], [diaChi], [chucVu], [tinhTrang]) VALUES (N'NV091123190530', N'Đinh Nguyên Chung', N'Nam', CAST(N'2003-11-08' AS Date), N'dinhnguyenchung240403@gmail.com', N'0123456789', N'Ca 2 ', N'Nha Trang, Khánh Hoà', N'Nhân viên', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [gioiTinh], [ngaySinh], [email], [soDienThoai], [caLamViec], [diaChi], [chucVu], [tinhTrang]) VALUES (N'NV091123190937', N'Trần Hiển VInh', N'Nam', CAST(N'2003-11-02' AS Date), N'vinhtran2003@gmail.com', N'0987654321', N'Ca 1', N'Khánh Hòa', N'Quản lý', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [gioiTinh], [ngaySinh], [email], [soDienThoai], [caLamViec], [diaChi], [chucVu], [tinhTrang]) VALUES (N'NV091123191028', N'Đỗ Chí Tường', N'Nam', CAST(N'2003-11-02' AS Date), N'tieutuong257@gmail.com', N'0976474170', N'Ca 1      ', N'Phú Yên', N'Quản lý', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [gioiTinh], [ngaySinh], [email], [soDienThoai], [caLamViec], [diaChi], [chucVu], [tinhTrang]) VALUES (N'NV121223151505', N'Nguyễn Thượng Tôn', N'Nam', CAST(N'2006-11-17' AS Date), N'ttvip@gmail.com', N'0965228119', N'Ca 1', N'Quận 5, TPHCM', N'Nhân viên', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [gioiTinh], [ngaySinh], [email], [soDienThoai], [caLamViec], [diaChi], [chucVu], [tinhTrang]) VALUES (N'NV121223151605', N'Trần Văn Dũng', N'Nam', CAST(N'2001-12-15' AS Date), N'vDung1231@gmail.com', N'0965278113', N'Ca 2', N'Cần Giuộc, Long An', N'Quản lý', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [gioiTinh], [ngaySinh], [email], [soDienThoai], [caLamViec], [diaChi], [chucVu], [tinhTrang]) VALUES (N'NV121223151732', N'Nguyễn Thi Huyền Trân', N'Nữ', CAST(N'1999-12-15' AS Date), N'tranHuyenN@gmail.com', N'0978223113', N'Ca 1', N'Phú Yên', N'Nhân viên', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [gioiTinh], [ngaySinh], [email], [soDienThoai], [caLamViec], [diaChi], [chucVu], [tinhTrang]) VALUES (N'NV121223151830', N'Trần Thị Nở', N'Nữ', CAST(N'2004-12-04' AS Date), N'tno2213@gmail.com', N'0988227331', N'Ca 1', N'Vũ Đại', N'Nhân viên', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [gioiTinh], [ngaySinh], [email], [soDienThoai], [caLamViec], [diaChi], [chucVu], [tinhTrang]) VALUES (N'NV121223151921', N'Nguyễn Thị Phương Hằng', N'Nam', CAST(N'1990-12-15' AS Date), N'hangNguyen123@gmail.com', N'0978652113', N'Ca 1', N'Quận 1, TPHCM', N'Quản lý', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [gioiTinh], [ngaySinh], [email], [soDienThoai], [caLamViec], [diaChi], [chucVu], [tinhTrang]) VALUES (N'NV121223152032', N'Trần Xuân Lộc', N'Nam', CAST(N'2002-12-13' AS Date), N'locTranX@gmaim', N'0987221333', N'Ca 1', N'Hà Tĩnh', N'Nhân viên', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [gioiTinh], [ngaySinh], [email], [soDienThoai], [caLamViec], [diaChi], [chucVu], [tinhTrang]) VALUES (N'NV121223180932', N'Nguyễn Văn Quý', N'Nam', CAST(N'2000-12-12' AS Date), N'quy123@gmail.com', N'0145678903', N'Ca 1', N'12 Nguyễn Văn Bảo, Quận Gò Vấp, TPHCM', N'Quản lý', N'Nghỉ phép')
GO
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP011022044632', N'Nón Camper Phối Màu Basic', N'FREESIZE', N'Trắng', 199000.0000, N'Đang bán', 70, N'CL27102309', N'TH27102309', N'DM27102313', N'src//pic//imageProduct//nonCamper.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP011022074632', N'Quần Jean Nam Ống Ôm Trơn Form Slim', N'L', N'Đen', 500000.0000, N'Đang bán', 44, N'CL27102307', N'TH27102302', N'DM27102315', N'src//pic//imageProduct/quanJeanOngOm.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP021022044636', N'Nón Lưỡi Trai Flannel Kẻ Sọc Freesize', N'FREESIZE', N'Đen', 245000.0000, N'Đang bán', 10, N'CL27102309', N'TH27102307', N'DM27102313', N'src//pic//imageProduct//nonLuoiTrai.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP031123072651', N'Quần Nữ Jean Ống Đứng Trơn Form Straight Crop', N'L', N'Đen', 540000.0000, N'Đang bán', 30, N'CL27102301', N'TH27102303', N'DM27102319', N'src//pic//imageProduct//quanNuJean.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP031123072652', N'Quần Nữ Kaki Ống Rộng Rayon Xếp Ly Trơn Form Wide Leg', N'XL', N'Xám', 618000.0000, N'Đang bán', 75, N'CL27102309', N'TH27102306', N'DM27102319', N'src//pic//imageProduct//quanNuKakiOngRong.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP031123072653', N'Quần Nữ Vải Ống Rộng Rút Dây Trơn Form Wide Leg', N'S', N'Trắng', 579000.0000, N'Đang bán', 47, N'CL27102307', N'TH27102304', N'DM27102319', N'src//pic//imageProduct//quanNuVaiOngRong.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP031123072654', N'Quần Nữ Short Ống Rộng Vải Tweed Trơn Form Relax', N'L', N'Trắng', 490000.0000, N'Đang bán', 100, N'CL27102309', N'TH27102302', N'DM27102319', N'src//pic//imageProduct//quanNuNganOngRong.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP031123072655', N'Quần Nữ Jean Trơn Form Loose', N'XXL', N'Trắng', 549000.0000, N'Đang bán', 34, N'CL27102301', N'TH27102311', N'DM27102319', N'src//pic//imageProduct//quanNuJeanTron.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP041023014632', N'Giày Loafer Mũi Nhọn', N'XL', N'Đen', 629000.0000, N'Đang bán', 25, N'CL27102303', N'TH27102305', N'DM27102312', N'src//pic//imageProduct//giayLoafer.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP041223145447', N'Quần Nữ Kaki', N'S', N'Trắng', 200000.0000, N'Đang bán', 59, N'CL27102301', N'TH27102300', N'DM27102319', N'src//pic//imageProduct//quanDui.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP051023014631', N'Vớ Ngắn Thể Thao Trơn Có Logo Freesize', N'FREESIZE', N'Xám', 29000.0000, N'Đang bán', 20, N'CL27102301', N'TH27102311', N'DM27102311', N'src//pic//imageProduct//voNganTheThao.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP070923072631', N'Chân Váy Midi Nữ Lưng Thun Xếp Ly Trơn Form Aline', N'L', N'Đen', 649000.0000, N'Đang bán', 141, N'CL27102307', N'TH27102309', N'DM27102317', N'src//pic//imageProduct//chanvayLungThun.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP071022074632', N'Thắt Lưng Owen', N'FREESIZE', N'Đen', 450000.0000, N'Đang bán', 37, N'CL27102303', N'TH27102305', N'DM27102314', N'src//pic//imageProduct//thatLungOwen.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP071022075642', N'Quần Kaki Nam Ống Rộng Lưng Thun Cotton Trơn Form Relax', N'XL', N'Trắng', 540000.0000, N'Đang bán', 73, N'CL27102309', N'TH27102303', N'DM27102315', N'src//pic//imageProduct//quanKakiOngRong.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP071022084652', N'Quần Nỉ Unisex Chun Gấu, Gân Trước Trơn Form Jogger', N'XXL', N'Trắng', 569000.0000, N'Đang bán', 51, N'CL27102307', N'TH27102304', N'DM27102315', N'src//pic//imageProduct//quanNiUnisex.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP071023014651', N'Giày Sneaker Canvas Trơn Basic Poin Label', N'L', N'Trắng', 580000.0000, N'Đang bán', 50, N'CL27102307', N'TH27102307', N'DM27102312', N'src//pic//imageProduct//giaySneakerCanvas.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP071023072632', N'Quần Dài Baggy Nam Trơn Lưng Thun Xếp Ly Ống Form Baggy', N'XL', N'Trắng', 638000.0000, N'Đang bán', 10, N'CL27102307', N'TH27102304', N'DM27102315', N'src/pic//imageProduct//quanDaiBaggy.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP071023072633', N'Quần Lót Nam Organic Cotton Trơn Form Boxer', N'M', N'Trắng', 84000.0000, N'Đang bán', 10, N'CL27102301', N'TH27102305', N'DM27102316', N'src//pic//imageProduct//quanLotNamCotton.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP071023072634', N'Quần Lót Nam Seamless Co Giãn Thêu Form Fitted', N'L', N'Đen', 129000.0000, N'Đang bán', 20, N'CL27102301', N'TH27102309', N'DM27102316', N'src//pic//imageProduct//quanLotNamCoGian.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP071023072635', N'Quần Lót Nam Boxer Form Fitted', N'XL', N'Trắng', 39000.0000, N'Đang bán', 100, N'CL27102301', N'TH27102306', N'DM27102316', N'src//pic//imageProduct//quanLotNamBoxer.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP071023072636', N'Quần Lót Nam Boxer Seamless', N'M', N'Đen', 129000.0000, N'Đang bán', 17, N'CL27102301', N'TH27102307', N'DM27102316', N'src//pic/imageProduct//quanLotNamBoxerSeamless.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP071023072637', N'Chân Váy Chữ A Nữ Mini Vải Tweed Trơn Form A Line', N'M', N'Trắng', 490000.0000, N'Đang bán', 20, N'CL27102309', N'TH27102303', N'DM27102317', N'src//pic//imageProduct//chanVayChuA.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP071023072640', N'Chân Váy Jean Nữ Dáng Dài Form Regular', N'L', N'Trắng', 529000.0000, N'Đang bán', 103, N'CL27102309', N'TH27102302', N'DM27102317', N'src//pic//imageProduct//chanVayJean.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP071023082643', N'Chân Váy Chữ A Xếp Ly Trước Trơn', N'XS', N'Đen', 429000.0000, N'Đang bán', 56, N'CL27102301', N'TH27102311', N'DM27102317', N'src//pic//imageProduct//chanVayChuAXapLy.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP071123052649', N'Đầm Nữ Midi 2 Dây Cổ Yếm Xếp Ly Trơn Form Straight', N'M', N'Đen', 716000.0000, N'Đang bán', 94, N'CL27102301', N'TH27102306', N'DM27102318', N'src//pic//imageProduct//damNu2Day.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP071123072645', N'Chân Váy Chữ A Nữ Kẻ Sọc Caro Xếp Ly Nhỏ Form A Line', N'XL', N'Trắng', 687000.0000, N'Đang bán', 8, N'CL27102309', N'TH27102305', N'DM27102317', N'src//pic//imageProduct//chanVayCaro.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP071123072646', N'Đầm Nữ Chữ A Sát Nách Kẻ Sọc Caro Cổ V Form A line', N'L', N'Đen', 785000.0000, N'Đang bán', 145, N'CL27102309', N'TH27102307', N'DM27102318', N'src//pic//imageProduct//damNuChuA.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP071123072650', N'Đầm Nữ Midi Viscose Kẻ Sọc Ngang Form Straight', N'L', N'Trắng', 540000.0000, N'Đang bán', 16, N'CL27102307', N'TH27102309', N'DM27102318', N'src//pic//imageProduct//damNuKeSoc.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP071123072651', N'Đầm Nữ Mini Nhún Tay Trơn Form A Line', N'S', N'Đen', 579000.0000, N'Đang bán', 162, N'CL27102309', N'TH27102303', N'DM27102318', N'src//pic//imageProduct//damNuMini.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP071123082647', N'Đầm Nữ Polo Tay Ngắn Cotton Pique In Form Straight', N'XL', N'Trắng', 520000.0000, N'Đang bán', 9, N'CL27102307', N'TH27102304', N'DM27102318', N'src//pic//imageProduct//damNuPoloTayNgan.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP081022054635', N'Thắt Lưng Cá Sấu', N'FREESIZE', N'Đen', 1050000.0000, N'Đang bán', 12, N'CL27102303', N'TH27102309', N'DM27102314', N'src//pic//imageProduct//thatLungCaSau.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP081022071637', N'Quần Short Nam Nylon Rút Dây Trơn Có Túi Sau Form Relax', N'M', N'Xám', 441000.0000, N'Đang bán', 144, N'CL27102309', N'TH27102307', N'DM27102315', N'src//pic//imageProduct//quanSortNylon.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP081023015631', N'Giày Crazy In Creation Ver.1 Da Suede', N'XS', N'Đen', 720000.0000, N'Đang bán', 10, N'CL27102303', N'TH27102309', N'DM27102312', N'src//pic//imageProduct//giayCrazy.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091022044631', N'Nón Vành Jean Nhãn Trang Trí Fressize', N'FREESIZE', N'Đen', 220000.0000, N'Đang bán', 112, N'CL27102309', N'TH27102304', N'DM27102313', N'src//pic//imageProduct//nonVanhJean.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091022054637', N'Thắt Lưng Nam Có Khóa Xoay Trơn Basic', N'FREESIZE', N'Đen', 490000.0000, N'Đang bán', 70, N'CL27102303', N'TH27102302', N'DM27102314', N'src//pic//imageProduct//thatLungKhoaXoayTron.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091023013612', N'Giày Tây Nam Da Trơn Form Basic', N'S', N'Đen', 736000.0000, N'Đang bán', 35, N'CL27102303', N'TH27102309', N'DM27102312', N'src//pic//imageProduct//giayTayNamBasic.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091023044631', N'Giày Sneaker Phối Bản Thun Kẻ Sọc Basic', N'L', N'Trắng', 680000.0000, N'Đang bán', 30, N'CL27102307', N'TH27102303', N'DM27102312', N'src//pic//imageProduct//giayThunKeSoc.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123163512', N'Áo Thun Nam Tay Ngắn Kẻ Sọc Form Fitted', N'XL', N'Xám', 320000.0000, N'Đang bán', 56, N'CL27102301', N'TH27102303', N'DM27102301', N'src//pic//imageProduct//aoThunNamKeSoc.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123163515', N'Áo Thun Nam Tay Dài Nam Viscose Cổ Cao Form Fitted', N'L', N'Đen', 380000.0000, N'Đang bán', 23, N'CL27102301', N'TH27102302', N'DM27102301', N'src//pic//imageProduct//aoThunNamTayDai.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123163521', N'Áo Thun Nam Thể Thao Nam Tay Ngắn Phối Màu Form Slim', N'XXL', N'Đen', 420000.0000, N'Đang bán', 43, N'CL27102308', N'TH27102307', N'DM27102301', N'src//pic//imageProduct//aoThunNamTayNganTheThao.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123163553', N'Quần Nữ Nỉ Túi Ốp Trước Ống Rộng Form Wide Leg', N'S', N'Trắng', 569000.0000, N'Đang bán', 99996, N'CL27102301', N'TH27102300', N'DM27102319', N'src//pic//imageProduct//quanNu.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123163554', N'Áo Thun Nam Tay Ngắn In Hình Form Loose ', N'XL', N'Đen', 422000.0000, N'Đang bán', 50, N'CL27102305', N'TH27102308', N'DM27102301', N'src//pic//imageProduct//aoThunNamInHinhForm.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123163555', N'Áo Thun Nam Tay Ngắn In Hình Form Regular', N'L', N'Đen', 274000.0000, N'Đang bán', 35, N'CL27102307', N'TH27102305', N'DM27102301', N'src//pic//imageProduct//aoThunNamTayNganRegular.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123163565', N'Áo Thun Nam Tay Ngắn Nhãn Trang Trí Form Fitted', N'S', N'Trắng', 149000.0000, N'Đang bán', 65, N'CL27102309', N'TH27102308', N'DM27102301', N'src//pic//imageProduct//aoThunNamTayNganFitted.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123163566', N'Áo Thun Nam Tay Ngắn Nam In Họa Tiết Rubber Form Fitted', N'XL', N'Trắng', 280000.0000, N'Đang bán', 15, N'CL27102308', N'TH27102311', N'DM27102301', N'src//pic//imageProduct//aoThunNamTayNganRubber.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123163570', N'Áo Thun Nam Tay Ngắn Nam In Hình Quý Mão Form Loose', N'L', N'Đen', 349000.0000, N'Đang bán', 110, N'CL27102301', N'TH27102306', N'DM27102301', N'src//pic//imageProduct//aoThunNamTayNganQuyMao.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123163838', N'Áo Thun Nữ Tay Ngắn In Hình Form Regular', N'S', N'Trắng', 265000.0000, N'Đang bán', 178, N'CL27102301', N'TH27102300', N'DM27102306', N'src//pic//imageProduct//aoThunNu.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123164111', N'Quần Nữ Nỉ Ống Rộng Túi Ốp Cột Dây Trơn Form Relax', N'S', N'Trắng', 373000.0000, N'Đang bán', 3, N'CL27102301', N'TH27102300', N'DM27102319', N'src//pic//imageProduct//quanNu1.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123164600', N'Quần Nam Jean Ống Ôm Trơn Form Slim', N'M', N'Xám', 540000.0000, N'Đang bán', 1006, N'CL27102301', N'TH27102300', N'DM27102315', N'src//pic//imageProduct//quạnean.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123164932', N'Áo Thun Nam S.Café Thêu chữ Coffee Lovers Form Loose', N'S', N'Xám', 200000.0000, N'Đang bán', 197, N'CL27102304', N'TH27102300', N'DM27102301', N'/pic/imageProduct/aoThunNam.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123165605', N'Áo Sơ Mi Nam Tay Dài Trơn Cổ Mao Phối Nẹp 1/2 Form Loose', N'XL', N'Trắng', 700000.0000, N'Đang bán', 87, N'CL27102301', N'TH27102300', N'DM27102302', N'src//pic//imageProduct//aoThunNam1.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123170154', N'Quần Lót Nam Organic Cotton Trơn Form Boxer', N'S', N'Trắng', 384000.0000, N'Đang bán', 113, N'CL27102301', N'TH27102300', N'DM27102316', N'src//pic//imageProduct//quanLotNam.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123170421', N'Áo Thun Nam Tay Ngắn Vải Nổi Trơn Phối Nhãn Form Loose ', N'L', N'Đen', 550000.0000, N'Đang bán', 150, N'CL27102301', N'TH27102300', N'DM27102301', N'src//pic//imageProduct//aoThunNam2.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123170618', N'Quần Nam Ống Rộng Trơn Form Straight Crop', N'L', N'Đen', 540000.0000, N'Đang bán', 3, N'CL27102301', N'TH27102300', N'DM27102315', N'src//pic//imageProduct//quanJean1.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123170802', N'Quần Lót Nam Boxer Form Fitted', N'M', N'Đen', 284000.0000, N'Đang bán', 262, N'CL27102302', N'TH27102300', N'DM27102316', N'src//pic//imageProduct//quanShipDen.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123170953', N'Quần Nữ Cotton Trơn Form Panama', N'M', N'Trắng', 189000.0000, N'Đang bán', 120, N'CL27102301', N'TH27102300', N'DM27102319', N'src//pic//imageProduct//quanDui.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123171122', N'Áo Thun Nữ Tay Ngắn Trơn Form Regular', N'M', N'Đen', 100000.0000, N'Đang bán', 21, N'CL27102302', N'TH27102303', N'DM27102306', N'src//pic//imageProduct//aoThunNuNgan.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123171246', N'Quần Nữ Ống Rộng Gấp Lai Trơn Form Straight', N'M', N'Đen', 150000.0000, N'Đang bán', 16, N'CL27102303', N'TH27102303', N'DM27102319', N'src//pic//imageProduct//quanJean.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123171411', N'Quần Nữ Ống Loe Trơn Form Flare Crop', N'S', N'Trắng', 500000.0000, N'Đang bán', 480, N'CL27102301', N'TH27102305', N'DM27102319', N'src//pic//imageProduct//quanJean2.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123171526', N'Áo Sơ Mi Nữ Tay Dài Satin Cổ Đức Trơn Form Regular', N'L', N'Trắng', 300000.0000, N'Đang bán', 213, N'CL27102301', N'TH27102304', N'DM27102302', N'src//pic//imageProduct//aoToi.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP091123182736', N'Quần Nữ MVC', N'S', N'Trắng', 432000.0000, N'Ngừng bán', 50, N'CL27102301', N'TH27102300', N'DM27102319', N'src//pic//imageProduct//quanDui.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP101022054657', N'Thắt Lưng Liam', N'FREESIZE', N'Trắng', 600000.0000, N'Đang bán', 10, N'CL27102307', N'TH27102303', N'DM27102314', N'src//pic//imageProduct//thatLungLiam.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP101023013658', N'Áo Sơ Mi Nữ Tay Dài Vải Coffee Túi Đắp Trơn Form Loose', N'L', N'Trắng', 579000.0000, N'Đang bán', 100, N'CL27102304', N'TH27102305', N'DM27102307', N'/pic/imageProduct/aoSoMiNuVaiCoffee.jpg', N'KM041223203913')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP101122044633', N'Thắt Lưng Nomad', N'FREESIZE', N'Đen', 420000.0000, N'Đang bán', 45, N'CL27102303', N'TH27102302', N'DM27102314', N'src//pic//imageProduct//thatLuongNomad.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP111022044623', N'Nón Bucket Rộng Vành Bấm Nút', N'FREESIZE', N'Trắng', 299000.0000, N'Đang bán', 50, N'CL27102309', N'TH27102302', N'DM27102313', N'src//pic//imageProduct//nonRongVanh.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP111023024635', N'Nón Bucket Unisex Washing Họa Tiết Thêu', N'FREESIZE', N'Trắng', 225000.0000, N'Đang bán', 40, N'CL27102307', N'TH27102311', N'DM27102313', N'src//pic//imageProduct//nonBucKet.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121023013655', N'Áo Thun Nữ Lửng Tay Ngắn Cổ Henley Form Fitted Crop', N'L', N'Đen', 279000.0000, N'Đang bán', 10, N'CL27102307', N'TH27102307', N'DM27102306', N'src//pic//imageProduct//aoThunNuCrop.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121023013751', N'Áo Thun Nữ Tay Ngắn Cổ Tròn Kẻ Sọc Ngang Form Fitted', N'M', N'Trắng', 299000.0000, N'Đang bán', 9, N'CL27102307', N'TH27102303', N'DM27102306', N'src//pic//imageProduct//aoThunNuCaro.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121023014750', N'Áo Thun Nữ Cotton Tay Ngắn In Hình Form Regular', N'M', N'Trắng', 320000.0000, N'Đang bán', 37, N'CL27102301', N'TH27102309', N'DM27102306', N'src//pic//imageProduct//aoThunNuCotton.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121123013749', N'Áo Thun Nữ Croptop Tay Ngắn In Chữ Form Regular Crop', N'XS', N'Đen', 320000.0000, N'Đang bán', 9, N'CL27102307', N'TH27102311', N'DM27102306', N'src//pic//imageProduct//aoThunNuCroptop.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223001106', N'Áo Sơ Mi Nam Tay Dài Cổ Trụ Phối Rib Form Loose', N'L', N'Trắng', 520000.0000, N'Đang bán', 65, N'CL27102309', N'TH27102303', N'DM27102302', N'src//pic//imageProduct//aoSoMiNamTayDaiCoTru.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223001606', N'Áo Sơ Mi Nam Tay Ngắn Không Cổ Nhãn Trang Trí Form Loose', N'L', N'Đen', 520000.0000, N'Đang bán', 30, N'CL27102301', N'TH27102306', N'DM27102302', N'src//pic//imageProduct//aoSoMiNamTayNganKhongCoNhan.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223003047', N'Áo Thun Nam Tay Ngắn Coffee Trơn S.Café Form Loose', N'M', N'Trắng', 490000.0000, N'Hết hàng', 0, N'CL27102307', N'TH27102301', N'DM27102301', N'src//pic//imageProduct//aoThunNamTayNganCoffee.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223003306', N'Áo Thun Nam Tay Ngắn Cổ Tròn Họa Tiết In Form Regular', N'M', N'Đen', 343000.0000, N'Hết hàng', 0, N'CL27102301', N'TH27102303', N'DM27102301', N'src//pic//imageProduct//aoThunNamCoTron.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223003601', N'Áo Sơ Mi Nam Tay Dài Nút Ẩn Trơn Form Fitted', N'XL', N'Xám', 390000.0000, N'Đang bán', 34, N'CL27102307', N'TH27102311', N'DM27102302', N'src//pic//imageProduct//aoSoMiNamTayDaiNutAn.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223003606', N'Áo Sơ Mi Nam Tay Dài Cổ V Túi Đắp Trơn Form Boxy', N'XL', N'Trắng', 540000.0000, N'Đang bán', 47, N'CL27102309', N'TH27102309', N'DM27102302', N'src//pic//imageProduct//aoSoMiNamTayDaiCoV.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223003607', N'Áo Sơ Mi Nam Tay Dài Lai Tưa Nhãn Trang Trí Form Loose', N'S', N'Đen', 599000.0000, N'Đang bán', 46, N'CL27102309', N'TH27102306', N'DM27102302', N'src//pic//imageProduct//aoSoMiNamTayDaiLoTua.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223003706', N'Áo Sơ Mi Nam Tay Dài Lai Cao Thấp Form Fitted', N'L', N'Trắng', 420000.0000, N'Đang bán', 218, N'CL27102304', N'TH27102309', N'DM27102302', N'/pic/imageProduct/aoSoMiNamTayDaiLaiCao.png', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223004306', N'Áo sơ Mi Nam Tay Dài Sợi Coffee', N'XL', N'Đen', 429000.0000, N'Đang bán', 7, N'CL27102301', N'TH27102302', N'DM27102302', N'src//pic//imageProduct//aoSoMiNamTayDaiSoiCoffee.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223004606', N'Áo Sơ Mi Nam Tay Ngắn Vải Gân Túi Đắp Trơn Form Regular', N'XXL', N'Đen', 499000.0000, N'Đang bán', 78, N'CL27102309', N'TH27102309', N'DM27102302', N'src//pic//imageProduct//aoSoMiNamTayNganVaiNganTui.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223005006', N'Áo Sơ Mi Nam Rayon Cổ Cuban Họa Tiết In Form Regular', N'XL', N'Trắng', 529000.0000, N'Đang bán', 20, N'CL27102304', N'TH27102307', N'DM27102302', N'/pic/imageProduct/aoSoMiNamRayonCoCuban.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223005606', N'Áo Sơ Mi Nam Tay Dài Đũi Cổ Gài Nút Kẻ Sọc Form Regular', N'L', N'Trắng', 549000.0000, N'Đang bán', 5, N'CL27102307', N'TH27102304', N'DM27102302', N'src//pic//imageProduct//aoSoMiNamTayDaiKeSoc.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223005715', N'Áo Hoodie Nam Lông Thêu Logo Form Regular', N'XL', N'Trắng', 350000.0000, N'Đang bán', 10, N'CL27102308', N'TH27102302', N'DM27102305', N'src//pic//imageProduct//aoHoodieNamLongTheu.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223010112', N'Áo Vest Nam Tay Dài Trơn Vạt Đắp Chéo Form Regular', N'XXL', N'Đen', 1325000.0000, N'Đang bán', 19, N'CL27102307', N'TH27102307', N'DM27102303', N'src//pic//imageProduct//aoVestNamTayDaiTronVat.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223011205', N'Áo Vest Nam Tay Dài Trơn Form Fitted', N'XL', N'Đen', 1350000.0000, N'Đang bán', 7, N'CL27102301', N'TH27102302', N'DM27102303', N'src//pic//imageProduct//aoVestNamBlazerTayDai.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223011812', N'Áo Khoác Nam Bomber Kaki Khóa Kéo Gập Ly Form Regular', N'L', N'Đen', 1178000.0000, N'Đang bán', 13, N'CL27102301', N'TH27102309', N'DM27102304', N'src//pic//imageProduct//aoKhoacNamBomber.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223012013', N'Áo Khoác Nam Tay Dài Nylon Túi Có Nắp Trơn Form Regular', N'XL', N'Đen', 785000.0000, N'Đang bán', 6, N'CL27102301', N'TH27102307', N'DM27102304', N'src//pic//imageProduct//aoKhoacNamTayDaiNilong.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223012119', N'Áo Khoác Nam Sọc Caro Nhãn Trang Trí Form Regular', N'L', N'Xám', 979000.0000, N'Đang bán', 75, N'CL27102307', N'TH27102304', N'DM27102304', N'src//pic//imageProduct//aoKhoacNamSocCaro.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223012309', N'Áo Khoác Nam Jean Wash Mềm Gài Nút Trơn Form Loose', N'XXL', N'Đen', 785000.0000, N'Đang bán', 10, N'CL27102309', N'TH27102311', N'DM27102304', N'src//pic//imageProduct//aoKhoacNamJean.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223013119', N'Áo Khoác Nam Gió Unisex Tay Dài Phối Màu Form Regular', N'XXL', N'Trắng', 599000.0000, N'Đang bán', 8, N'CL27102301', N'TH27102302', N'DM27102304', N'src//pic//imageProduct//aoKhoacNamGioUnisex.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223013707', N'Áo Vest Nam Dạ', N'L', N'Xám', 1050000.0000, N'Đang bán', 10, N'CL27102308', N'TH27102306', N'DM27102303', N'src//pic//imageProduct//aoVestNamDa.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223013711', N'Áo Vest Nam Tay Dài Linen Trơn Form Fitted', N'XL', N'Trắng', 1325000.0000, N'Đang bán', 10, N'CL27102308', N'TH27102309', N'DM27102303', N'src//pic//imageProduct//aoVestNamBlazer.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223013759', N'Áo Hoodie Nam Thêu Hình Phối Piping Form Regular', N'L', N'Đen', 529000.0000, N'Đang bán', 21, N'CL27102307', N'TH27102307', N'DM27102305', N'src//pic//imageProduct//aoHoodieNamTheu.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223013906', N'Áo Vest Nam Dạ Cao Cấp Kẻ Caro', N'XL', N'Đen', 1050000.0000, N'Đang bán', 2, N'CL27102309', N'TH27102303', N'DM27102303', N'src//pic//imageProduct//aoVestCaro.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223014852', N'Áo Thun Nữ Lửng Sát Nách Cổ Mockneck Form Slim Cropped', N'S', N'Trắng', 274000.0000, N'Đang bán', 70, N'CL27102308', N'TH27102304', N'DM27102306', N'src//pic//imageProduct//aoThunNuLungSatNach.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223015129', N'Áo Hoodie Nam Unisex Tay Dài Có Túi Mũ In Hình Form Loose', N'L', N'Trắng', 638000.0000, N'Đang bán', 1, N'CL27102307', N'TH27102305', N'DM27102305', N'src//pic//imageProduct//aoHoodieNamUnisex.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223015219', N'Áo Hoodie Nam Tay Dài Phối Dây Kéo Cổ Form Loose', N'XL', N'Xám', 529000.0000, N'Đang bán', 32, N'CL27102308', N'TH27102306', N'DM27102305', N'src//pic//imageProduct//aoHoodieNamCoKeo.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223015608', N'Áo Vest Nam Tay Dài Trơn Form Fitted', N'L', N'Trắng', 1250000.0000, N'Đang bán', 12, N'CL27102309', N'TH27102309', N'DM27102303', N'src//pic//imageProduct//aoVestNamTayDaiTron.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP121223053118', N'Áo Hoodie Nam Thể Thao Có Nón Form Regular', N'L', N'Đen', 890000.0000, N'Đang bán', 6, N'CL27102307', N'TH27102309', N'DM27102305', N'src//pic//imageProduct//aoHoodieNamTheThao.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP131023013622', N'Áo Vest Nữ Tay Dài Linen Xẻ Sau Form Fitted', N'L', N'Trắng', 950000.0000, N'Đang bán', 24, N'CL27102301', N'TH27102303', N'DM27102308', N'src//pic//imageProduct//aoVestNuLinen.jpg', NULL)
GO
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP131023013654', N'Áo Sơ Mi Nữ Sát Nách Trơn Dây Rút Vai Form Regular', N'XL', N'Đen', 490000.0000, N'Đang bán', 37, N'CL27102304', N'TH27102307', N'DM27102307', N'/pic/imageProduct/aoSoMiNuSatNach.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP141023014622', N'Áo Khoác Gió Nữ Có Mũ Túi Đắp Trơn Form Cargo', N'XXL', N'Đen', 499000.0000, N'Đang bán', 76, N'CL27102305', N'TH27102311', N'DM27102309', N'src//pic//imageProduct//aoKhoacNuCoMu.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP151023013643', N'Áo Vest Nữ Crop Lai Tay Dài Trơn Form Relax', N'L', N'Trắng', 890000.0000, N'Đang bán', 4, N'CL27102301', N'TH27102302', N'DM27102308', N'src//pic//imageProduct//aoVestNuCropTop.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP151023014655', N'Áo Sơ Mi Nữ Lửng Kẻ Sọc Xếp Ly Lai Form Regular Cropped', N'M', N'Đen', 392000.0000, N'Đang bán', 86, N'CL27102307', N'TH27102304', N'DM27102307', N'src//pic//imageProduct//aoSoMiNuSatNachKeSoc.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP151023025622', N'Áo Hoodie Nữ Tay Dài Dây Rút In Hình Form Regular Crop', N'S', N'Trắng', 349000.0000, N'Đang bán', 15, N'CL27102307', N'TH27102309', N'DM27102310', N'src//pic//imageProduct//aoHoodieNuDayRut.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP151023034625', N'Áo Hoodie Nữ Rộng Tay Dài Cổ Tròn In Hình Form Loose', N'M', N'Đen', 299000.0000, N'Đang bán', 9, N'CL27102307', N'TH27102307', N'DM27102310', N'src//pic//imageProduct//aoHoodieNuCoTron.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP171023023658', N'Áo Vest Nữ Tay Dài Vải Sọc Trơn Form Regular Crop', N'S', N'Đen', 883000.0000, N'Đang bán', 5, N'CL27102309', N'TH27102307', N'DM27102308', N'src//pic//imageProduct//aoVestNuvaiSoc.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP171023043622', N'Áo Khoác Nữ Chần Bông Nylon Phối Màu Form Regular', N'XL', N'Đen', 1178000.0000, N'Đang bán', 10, N'CL27102301', N'TH27102305', N'DM27102309', N'src//pic//imageProduct//aoKhoacNuChanBong.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP171023074021', N'Áo Hoodie Nữ Tay Dài Thêu Logo Form Regular', N'XL', N'Trắng', 599000.0000, N'Đang bán', 30, N'CL27102308', N'TH27102311', N'DM27102310', N'src//pic//imageProduct//aoHoodieNuTheuLogo.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP171023113658', N'Áo Vest Nữ Tay Lửng Kẻ Caro Form Regular Crop', N'M', N'Trắng', 678000.0000, N'Đang bán', 150, N'CL27102307', N'TH27102304', N'DM27102308', N'src//pic//imageProduct//aoVestNuCaro.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP181023013623', N'Áo Khoác Nữ Nhung Croptop Phối Viền Form Regular Crop', N'S', N'Đen', 680000.0000, N'Đang bán', 9, N'CL27102307', N'TH27102307', N'DM27102309', N'src//pic//imageProduct//aoKhoacNuCropTop.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP181023014429', N'Áo Hoodie Nữ Vải Nỉ Tay Dài Trơn Form Regular', N'L', N'Trắng', 542000.0000, N'Đang bán', 74, N'CL27102307', N'TH27102306', N'DM27102310', N'src//pic//imageProduct//aoHoodieNuVaiNi.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP191023012623', N'Vớ Ngắn Phối Sọc Freesize', N'FREESIZE', N'Đen', 39000.0000, N'Đang bán', 50, N'CL27102301', N'TH27102303', N'DM27102311', N'src//pic//imageProduct//voNganPhoiSoc.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP191023013648', N'Áo Vest Nữ Tay Lửng Túi Đắp Trơn Form Relax ', N'XL', N'Đen', 950000.0000, N'Đang bán', 10, N'CL27102308', N'TH27102303', N'DM27102308', N'src//pic//imageProduct//aoVestNuTayLung.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP191023014621', N'Áo Hoodie Nữ Unisex Tay Dài Có Túi Mũ In Hình Form Loose', N'XS', N'Đen', 465000.0000, N'Đang bán', 10, N'CL27102308', N'TH27102305', N'DM27102310', N'src//pic//imageProduct//aoHoodieNuCoTuiMu.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP191023113622', N'Áo Khoác Nữ Jean Tay Dài Túi Đắp Trơn Form Regular', N'L', N'Trắng', 650000.0000, N'Đang bán', 25, N'CL27102309', N'TH27102306', N'DM27102309', N'src//pic//imageProduct//aoKhoacNuJean.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP201023023645', N'Áo Sơ Mi Nữ Tay Dài Polyester Trơn Form Relax', N'S', N'Đen', 520000.0000, N'Đang bán', 8, N'CL27102301', N'TH27102309', N'DM27102307', N'src//pic//imageProduct//aoSoMiNuTayDai.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP21023015621', N'Vớ Nike Freesize', N'FREESIZE', N'Trắng', 50000.0000, N'Đang bán', 10, N'CL27102301', N'TH27102305', N'DM27102311', N'src//pic//imageProduct//voNike.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP211023013659', N'Áo Khoác Nữ Lửng Cổ Vest Tay Dài Form Regular Crop', N'XL', N'Đen', 720000.0000, N'Đang bán', 80, N'CL27102301', N'TH27102309', N'DM27102309', N'src//pic//imageProduct//aoKhoacNuLung.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP221023013756', N'Áo Sơ Mi Nữ Tay Dài Satin Phối Vải Form Regular', N'XS', N'Đen', 549000.0000, N'Đang bán', 10, N'CL27102301', N'TH27102311', N'DM27102307', N'src//pic//imageProduct//aoSoMiNuTayDaiSatin.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP231023015621', N'Vớ Hài Trơn Logo Freesize', N'FREESIZE', N'Đen', 25000.0000, N'Đang bán', 100, N'CL27102301', N'TH27102307', N'DM27102311', N'src//pic//imageProduct//voHaiTron.jpg', NULL)
INSERT [dbo].[SanPham] ([maSP], [tenSP], [kichThuoc], [mauSac], [donGia], [tinhTrang], [soLuongTonKho], [maChatLieu], [maThuongHieu], [maDanhMuc], [imgUrl], [maCTKM]) VALUES (N'SP291023014621', N'Vớ Dài Cổ Cao Dệt Họa Tiết Freesize', N'FREESIZE', N'Trắng', 49000.0000, N'Đang bán', 20, N'CL27102301', N'TH27102309', N'DM27102311', N'src//pic//imageProduct//voDaiCoCao.jpg', NULL)
GO
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [thoiGianDNGN], [tinhTrang]) VALUES (N'0102030405', N'1111', CAST(N'2023-12-04T20:03:13.673' AS DateTime), N'Đang hoạt động')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [thoiGianDNGN], [tinhTrang]) VALUES (N'0123456666', N'1111', CAST(N'2023-12-07T14:21:53.637' AS DateTime), N'Đang hoạt động')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [thoiGianDNGN], [tinhTrang]) VALUES (N'0123456789', N'670b14728ad9902aecba32e22fa4f6bd', CAST(N'2023-11-15T17:18:57.910' AS DateTime), N'Đang hoạt động')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [thoiGianDNGN], [tinhTrang]) VALUES (N'0123456798', N'e10adc3949ba59abbe56e057f20f883e', CAST(N'2023-12-13T20:59:30.293' AS DateTime), N'Đang hoạt động')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [thoiGianDNGN], [tinhTrang]) VALUES (N'0145678903', N'1111', CAST(N'2023-12-12T18:09:32.177' AS DateTime), N'Đang hoạt động')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [thoiGianDNGN], [tinhTrang]) VALUES (N'0367819442', N'e10adc3949ba59abbe56e057f20f883e', CAST(N'2023-11-10T09:06:47.050' AS DateTime), N'Đang hoạt động')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [thoiGianDNGN], [tinhTrang]) VALUES (N'0965228119', N'b59c67bf196a4758191e42f76670ceba', CAST(N'2023-12-12T15:42:06.720' AS DateTime), N'Đang hoạt động')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [thoiGianDNGN], [tinhTrang]) VALUES (N'0965278113', N'b59c67bf196a4758191e42f76670ceba', CAST(N'2023-12-12T15:16:05.350' AS DateTime), N'Đang hoạt động')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [thoiGianDNGN], [tinhTrang]) VALUES (N'0976474170', N'b59c67bf196a4758191e42f76670ceba', CAST(N'2023-12-13T20:58:39.947' AS DateTime), N'Đang hoạt động')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [thoiGianDNGN], [tinhTrang]) VALUES (N'0978223113', N'b59c67bf196a4758191e42f76670ceba', CAST(N'2023-12-12T15:51:06.380' AS DateTime), N'Đang hoạt động')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [thoiGianDNGN], [tinhTrang]) VALUES (N'0978652113', N'b59c67bf196a4758191e42f76670ceba', CAST(N'2023-12-12T15:19:21.837' AS DateTime), N'Đang hoạt động')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [thoiGianDNGN], [tinhTrang]) VALUES (N'0987221333', N'b59c67bf196a4758191e42f76670ceba', CAST(N'2023-12-12T15:57:30.330' AS DateTime), N'Đang hoạt động')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [thoiGianDNGN], [tinhTrang]) VALUES (N'0987654321', N'b59c67bf196a4758191e42f76670ceba', CAST(N'2023-11-10T09:06:47.050' AS DateTime), N'Đang hoạt động')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [thoiGianDNGN], [tinhTrang]) VALUES (N'0988227331', N'b59c67bf196a4758191e42f76670ceba', CAST(N'2023-12-12T16:01:14.590' AS DateTime), N'Đang hoạt động')
GO
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu]) VALUES (N'TH27102300', N'No Brand ')
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu]) VALUES (N'TH27102301', N'Elise')
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu]) VALUES (N'TH27102302', N'Vascara')
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu]) VALUES (N'TH27102303', N'Juno')
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu]) VALUES (N'TH27102304', N'IVY Moda')
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu]) VALUES (N'TH27102305', N'HNOSS')
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu]) VALUES (N'TH27102306', N'FM Style')
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu]) VALUES (N'TH27102307', N'Adam Store')
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu]) VALUES (N'TH27102308', N'SSStutter')
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu]) VALUES (N'TH27102309', N'Routine')
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu]) VALUES (N'TH27102310', N'NEM Fashion')
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu]) VALUES (N'TH27102311', N'Form Skinny')
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu]) VALUES (N'TH27102312', N'Routine ')
GO
ALTER TABLE [dbo].[ChiTietDoiTra]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDoiTra_DoiTra] FOREIGN KEY([maDT])
REFERENCES [dbo].[DoiTra] ([maDT])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietDoiTra] CHECK CONSTRAINT [FK_ChiTietDoiTra_DoiTra]
GO
ALTER TABLE [dbo].[ChiTietDoiTra]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDoiTra_SanPham] FOREIGN KEY([maSP])
REFERENCES [dbo].[SanPham] ([maSP])
GO
ALTER TABLE [dbo].[ChiTietDoiTra] CHECK CONSTRAINT [FK_ChiTietDoiTra_SanPham]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDon] ([maHD])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_SanPham] FOREIGN KEY([maSP])
REFERENCES [dbo].[SanPham] ([maSP])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_SanPham]
GO
ALTER TABLE [dbo].[ChuongTrinhKhuyenMai]  WITH CHECK ADD  CONSTRAINT [FK_ChuongTrinhKhuyenMai_LoaiChuongTrinhKhuyenMai] FOREIGN KEY([maLoaiCTKM])
REFERENCES [dbo].[LoaiChuongTrinhKhuyenMai] ([maLoaiCTKM])
GO
ALTER TABLE [dbo].[ChuongTrinhKhuyenMai] CHECK CONSTRAINT [FK_ChuongTrinhKhuyenMai_LoaiChuongTrinhKhuyenMai]
GO
ALTER TABLE [dbo].[DoiTra]  WITH CHECK ADD  CONSTRAINT [FK_DoiTra_HoaDon] FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDon] ([maHD])
GO
ALTER TABLE [dbo].[DoiTra] CHECK CONSTRAINT [FK_DoiTra_HoaDon]
GO
ALTER TABLE [dbo].[DoiTra]  WITH CHECK ADD  CONSTRAINT [FK_DoiTra_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[DoiTra] CHECK CONSTRAINT [FK_DoiTra_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_ChuongTrinhKhuyenMai] FOREIGN KEY([maCTKM])
REFERENCES [dbo].[ChuongTrinhKhuyenMai] ([maCTKM])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_ChuongTrinhKhuyenMai]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[MatHangNhap]  WITH CHECK ADD  CONSTRAINT [FK_MatHangNhap_NhaCungCap] FOREIGN KEY([maNCC])
REFERENCES [dbo].[NhaCungCap] ([maNCC])
GO
ALTER TABLE [dbo].[MatHangNhap] CHECK CONSTRAINT [FK_MatHangNhap_NhaCungCap]
GO
ALTER TABLE [dbo].[MatHangNhap]  WITH CHECK ADD  CONSTRAINT [FK_MatHangNhap_SanPham] FOREIGN KEY([maSP])
REFERENCES [dbo].[SanPham] ([maSP])
GO
ALTER TABLE [dbo].[MatHangNhap] CHECK CONSTRAINT [FK_MatHangNhap_SanPham]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_TaiKhoan] FOREIGN KEY([soDienThoai])
REFERENCES [dbo].[TaiKhoan] ([tenTaiKhoan])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_TaiKhoan]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_ChatLieu] FOREIGN KEY([maChatLieu])
REFERENCES [dbo].[ChatLieu] ([maChatLieu])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_ChatLieu]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_DanhMucSanPham] FOREIGN KEY([maDanhMuc])
REFERENCES [dbo].[DanhMucSanPham] ([maDanhMuc])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_DanhMucSanPham]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_ThuongHieu] FOREIGN KEY([maThuongHieu])
REFERENCES [dbo].[ThuongHieu] ([maThuongHieu])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_ThuongHieu]
GO
USE [master]
GO
ALTER DATABASE [QuanLyBanHang] SET  READ_WRITE 
GO
