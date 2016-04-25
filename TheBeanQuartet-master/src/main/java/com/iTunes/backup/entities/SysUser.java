package com.iTunes.backup.entities;



import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;






//@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="user")

@XmlRootElement
public class SysUser implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7686433746648178330L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id") private int user_id;
	@Column(name="user_name") private String user_name;
	@Column(name="user_password") private String user_password;
	
	
	public SysUser(){}
	public SysUser(String user_name, String user_password){
		this.user_name = user_name;
		this.user_password = user_password;
	}
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
