package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class ChatLieuEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9194959906817190364L;
	@Id
	private String maChatLieu;
	
	private String tenChatLieu, xuatXu;
	public ChatLieuEntity(String maChatLieu, String tenChatLieu, String xuatXu) {
		super();
		this.maChatLieu = maChatLieu;
		this.tenChatLieu = tenChatLieu;
		this.xuatXu = xuatXu;
	} 
	public ChatLieuEntity(String maChatLieu) {
		super();
		this.maChatLieu = maChatLieu;
	}    
	public ChatLieuEntity() {
		super();
	}
	public String getMaChatLieu() {
		return maChatLieu;
	}
	public void setMaChatLieu(String maChatLieu) {
		this.maChatLieu = maChatLieu;
	}
	public String getTenChatLieu() {
		return tenChatLieu;
	}
	public void setTenChatLieu(String tenChatLieu) {
		this.tenChatLieu = tenChatLieu;
	}
	public String getXuatXu() {
		return xuatXu;
	}
	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maChatLieu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatLieuEntity other = (ChatLieuEntity) obj;
		return Objects.equals(maChatLieu, other.maChatLieu);
	}
	@Override
	public String toString() {
		return "ChatLieuEntity [maChatLieu=" + maChatLieu + ", tenChatLieu=" + tenChatLieu + ", xuatXu=" + xuatXu + "]";
	}
	
	
}