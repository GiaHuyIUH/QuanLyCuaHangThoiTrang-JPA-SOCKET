
package dao;

import java.util.List;

public interface ThongKe_Interface {
    public List<Object[]> getListThongKeDoanhThu();
    public List<Object[]> getListThongKeDoanhSo();
    public List<Object[]> getListDoanhThuTheoThangvaNam(String thang,String nam);
    public List<Object[]> getListDoanhThuTrongNam(String nam);
    public List<Object[]> getListThongKeDoanhSoTheoThangNam(String thangNam,String sort);
    public List<Object[]> getListTop5NhanVienDoanhThuCaoNhat(String thang, String nam);
    public List<Object[]> getListTop5KhachHangMuaHangNhieuNhat(String thang, String nam);
    public List<Object[]> getListThongKeDoanhSoTheoNam(String Nam,String sort) ;

    public List<Object[]> getListDoanhThuBySort(String  thang, String nam);
}
