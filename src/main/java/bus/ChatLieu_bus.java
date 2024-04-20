/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import Interface.ChatLieu_Interface;
import dao.ChatLieu_dao;
import entity.ChatLieuEntity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public class ChatLieu_bus extends UnicastRemoteObject implements ChatLieu_Interface{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2222570919887217486L;
	
	ChatLieu_dao cl_dao;
	public ChatLieu_bus() throws RemoteException {
		try {
			cl_dao = new ChatLieu_dao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    @Override
    public ArrayList<ChatLieuEntity> getAllCL() throws RemoteException{
        return cl_dao.getAllCL();
    }

    @Override
    public String layTenChatLieuTheoMa(String maChatLieu)throws RemoteException {
        return cl_dao.layTenChatLieuTheoMa(maChatLieu);
    }

    @Override
    public String layMaChatLieuTheoTen(String tenChatLieu)throws RemoteException {
        return cl_dao.layMaChatLieuTheoTen(tenChatLieu);
    }
	@Override
	public boolean themChatLieu(ChatLieuEntity cl) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}
