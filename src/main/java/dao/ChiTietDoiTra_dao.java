/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Interface.ChiTietDoiTra_Interface;
//import connectDB.ConnectDB;
import entity.ChiTietDoiTraEntity;
import entity.ChiTietHoaDonEntity;
import entity.DoiTraEntity;
import entity.HoaDonEntity;
import entity.SanPhamEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConvertStringToEnum;

/**
 *
 * @author Nguyen Huy Hoang
 */
public class ChiTietDoiTra_dao extends UnicastRemoteObject implements ChiTietDoiTra_Interface{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -4002633381206682186L;
	private EntityManager em;

	public ChiTietDoiTra_dao() throws RemoteException{
        em = Persistence.createEntityManagerFactory("JPA MSSQL").createEntityManager();
    }
    
    @Override
    public boolean themChiTietDoiTra(ChiTietDoiTraEntity ctdt)throws RemoteException {
    	EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(ctdt);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
    }

    @Override
    public ArrayList<ChiTietDoiTraEntity> getAllCTDTTheoMaDT(String ma) throws RemoteException{
     return (ArrayList<ChiTietDoiTraEntity>) em
		.createNamedQuery("ChiTietDoiTra.getAllCTDTTheoMaDT", ChiTietDoiTraEntity.class)
		.setParameter("ma", ma).getResultList();
    }
}
