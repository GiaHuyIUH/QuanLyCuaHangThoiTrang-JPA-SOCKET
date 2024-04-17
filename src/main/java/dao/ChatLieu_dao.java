/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Interface.ChatLieu_Interface;


import entity.ChatLieuEntity;
import jakarta.persistence.EntityManager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tran Hien Vinh
 */
public class ChatLieu_dao extends UnicastRemoteObject implements ChatLieu_Interface{

    /**
	 * 
	 */
	private static final long serialVersionUID = 3583426779781378716L;
	private EntityManager em;
	
	public ChatLieu_dao() throws Exception {
		em = jakarta.persistence.Persistence.createEntityManagerFactory("JPA MSSQL").createEntityManager();
	}

	@Override
    public boolean themChatLieu(ChatLieuEntity cl) throws RemoteException{
		
        boolean kq=false;
		return kq;
	}
	@Override
    public ArrayList<ChatLieuEntity> getAllCL()throws RemoteException {
        ArrayList<ChatLieuEntity> dsCL=new ArrayList<ChatLieuEntity>();
        
        dsCL = (ArrayList<ChatLieuEntity>) em.createNamedQuery("ChatLieuEntity.getAllChatLieu",ChatLieuEntity.class).getResultList();       
        return dsCL;
    }

    @Override
    public String layTenChatLieuTheoMa(String maChatLieu)throws RemoteException {
        String tenChatLieu = null;
//        try {
//       
//            PreparedStatement ps = null;
//
//            String sql = "SELECT tenChatLieu FROM ChatLieu WHERE maChatLieu = ?";
////            ps = con.prepareStatement(sql);
//            ps.setString(1, maChatLieu);
//
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                tenChatLieu = rs.getString("tenChatLieu");
//            }
//
//            ps.close();
//            rs.close();
//           
//        } catch (SQLException ex) {
//            Logger.getLogger(ChatLieu_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
        tenChatLieu = em.createNamedQuery("ChatLieuEntity.getTenChatLieuTheoMa",String.class).setParameter("maChatLieu", maChatLieu)
        		.getResultList().get(0);
        return tenChatLieu;
    }

    @Override
    public String layMaChatLieuTheoTen(String tenChatLieu) throws RemoteException{
        String maChatLieu = null;
//        try {
//            
//            PreparedStatement ps = null;
//            String sql = "SELECT maChatLieu FROM ChatLieu WHERE tenChatLieu = ?";
////            ps = con.prepareStatement(sql);
//            ps.setString(1, tenChatLieu);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                maChatLieu = rs.getString("maChatLieu");
//            }
//
//            ps.close();
//            rs.close();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(ChatLieu_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
		maChatLieu = em.createNamedQuery("ChatLieuEntity.getMaChatLieuTheoTen", String.class)
				.setParameter("tenChatLieu", tenChatLieu).getResultList().get(0);

        return maChatLieu;
    }
    
}
