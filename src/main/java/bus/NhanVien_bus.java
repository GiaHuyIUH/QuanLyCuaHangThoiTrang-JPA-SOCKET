package bus;

import Interface.NhanVienInterface;
import dao.NhanVien_dao;
import entity.NhanVienEntity;
import lombok.SneakyThrows;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HUY
 */
public class NhanVien_bus extends UnicastRemoteObject  implements NhanVienInterface {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 971140859121927388L;
    private static NhanVien_dao NVdao;

	public NhanVien_bus() throws RemoteException {

		NVdao = new NhanVien_dao();
	}
	
    @Override
    public NhanVienEntity findOne(String id) throws RemoteException {
        return NVdao.findOne(id);
    }

    @Override
    public boolean update(NhanVienEntity updateNV) throws RemoteException {
        return NVdao.update(updateNV);
    }

    @Override
    public boolean insert(NhanVienEntity insertNV) throws RemoteException {
        return NVdao.insert(insertNV);
    }

    @Override
    public ArrayList<NhanVienEntity> findAll() throws RemoteException {
        return NVdao.findAll();
    }

    @Override
    public boolean checkNV(String email, String sdt) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NhanVienEntity getNV(String sdt) throws RemoteException {
        return NVdao.getNV(sdt);
    }
    
}
