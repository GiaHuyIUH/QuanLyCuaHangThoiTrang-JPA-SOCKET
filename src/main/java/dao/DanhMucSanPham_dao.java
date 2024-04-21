/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Interface.DanhMucSanPham_Interface;
import entity.DanhMucSanPhamEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
/**
 *
 * @author Tran Hien Vinh
 */
public class DanhMucSanPham_dao extends UnicastRemoteObject implements DanhMucSanPham_Interface{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6618766286250931252L;
	private EntityManager em;
	public DanhMucSanPham_dao() throws RemoteException {
		em = Persistence.createEntityManagerFactory("JPA MSSQL").createEntityManager();
	}

    @Override
    public ArrayList<DanhMucSanPhamEntity> getAllDMSP() throws RemoteException{
         ArrayList<DanhMucSanPhamEntity> dsDMSP=new ArrayList<DanhMucSanPhamEntity>();
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con=ConnectDB.getConnection();
//            PreparedStatement ps=null;
//            String sql="select * from DanhMucSanPham";
//            ps=con.prepareStatement(sql);
//            ResultSet rs=ps.executeQuery();
//            while (rs.next()) {                
//                String maDanhMuc=rs.getString("maDanhMuc");
//                String tenDanhMuc=rs.getString("tenDanhMuc");
//                DanhMucSanPhamEntity dmsp=new DanhMucSanPhamEntity(maDanhMuc, tenDanhMuc);
//                dsDMSP.add(dmsp);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DanhMucSanPham_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
         dsDMSP = (ArrayList<DanhMucSanPhamEntity>) em.createNamedQuery("DanhMucSanPhamEntity.getAllDanhMucSanPham",DanhMucSanPhamEntity.class).getResultList();
        return dsDMSP;
    }

    @Override
    public String layTenDanhMucTheoMa(String maDanhMuc) throws RemoteException{
        String tenDanhMuc = null;
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement ps = null;
//
//            String sql = "SELECT tenDanhMuc FROM DanhMucSanPham WHERE maDanhMuc = ?";
//            ps = con.prepareStatement(sql);
//            ps.setString(1, maDanhMuc);
//
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                tenDanhMuc = rs.getString("tenDanhMuc");
//            }
//
//            ps.close();
//            rs.close();
//            ConnectDB.getInstance().disconnect();
//        } catch (SQLException ex) {
//            Logger.getLogger(DanhMucSanPham_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
        tenDanhMuc = em.createNamedQuery("DanhMucSanPhamEntity.getTenDanhMucTheoMa",String.class).setParameter("maDanhMuc", maDanhMuc).getResultList().stream().findFirst().orElse(null).toString();
        return tenDanhMuc;
    }

    @Override
    public String layMaDanhMucTheoTen(String tenDanhMuc)throws RemoteException {
        String maDanhMuc = null;
//        try {
//            ConnectDB.getInstance().connect();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement ps = null;
//            String sql = "SELECT maDanhMuc FROM DanhMucSanPham WHERE tenDanhMuc = ?";
//            ps = con.prepareStatement(sql);
//            ps.setString(1, tenDanhMuc);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                maDanhMuc = rs.getString("maDanhMuc");
//            }
//
//            ps.close();
//            rs.close();
//            ConnectDB.getInstance().disconnect();
//        } catch (SQLException ex) {
//            Logger.getLogger(DanhMucSanPham_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
        maDanhMuc = em.createNamedQuery("DanhMucSanPhamEntity.getMaDanhMucTheoTen",String.class).setParameter("tenDanhMuc", tenDanhMuc).getResultList().stream().findFirst().orElse(null).toString();
        return maDanhMuc;
    }
    
}
