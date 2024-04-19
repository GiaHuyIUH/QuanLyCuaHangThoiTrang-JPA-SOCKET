package dao;

import entity.ChiTietDoiTraEntity;
import entity.DoiTraEntity;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Huy
 */
public interface DoiTra_Interface {
    public boolean taoDoiTra(DoiTraEntity dt, ArrayList<ChiTietDoiTraEntity> ctdtList);
    public ArrayList<DoiTraEntity> getAllDoiTra();
    public DoiTraEntity getDoiTraTheoMa(String ma);
    public ArrayList<DoiTraEntity> getDoiTraTheoNgayLap(Date ngayLap);
    public DoiTraEntity getDoiTraTheoDieuKien(String ma, Date ngayLap);
    public Long getTongSoLuongSPDoiTra(String maHD, String maSP);
    public boolean kiemTraThoiHanDoiTra(String maHD);
}
