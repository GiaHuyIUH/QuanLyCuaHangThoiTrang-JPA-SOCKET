package dao;

import entity.ChiTietDoiTraEntity;
import java.util.ArrayList;

/**
 *
 * @author Huy
 */
public interface ChiTietDoiTra_Interface {
    public boolean themChiTietDoiTra(ChiTietDoiTraEntity ctdt);
    public ArrayList<ChiTietDoiTraEntity> getAllCTDTTheoMaDT(String ma);
}
