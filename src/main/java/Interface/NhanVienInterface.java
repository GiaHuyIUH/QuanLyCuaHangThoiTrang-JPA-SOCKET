package Interface;

import entity.NhanVienEntity;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HUY
 */
public interface NhanVienInterface {
    public boolean checkNV(String email, String sdt) throws RemoteException ;
    public NhanVienEntity getNV( String sdt) throws RemoteException ;
    NhanVienEntity findOne(String id)throws RemoteException;
    boolean update(NhanVienEntity updateNV)throws RemoteException;
    boolean insert(NhanVienEntity insertNV) throws RemoteException;
    ArrayList<NhanVienEntity> findAll() throws RemoteException;
//    int count(String id);
}
