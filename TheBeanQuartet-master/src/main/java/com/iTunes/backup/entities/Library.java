package com.iTunes.backup.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="library")
@XmlRootElement
public class Library implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="library_id") 
	private String library_id;
	
	@Column(name = "user_id")
	private int user_id;

	//join to SysUser
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private SysUser sysUser;
	
	//join to Playlist
	@OneToMany(mappedBy="library")
	private Collection<Playlist> playlist=new ArrayList<Playlist>();
	


	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getLibrary_id() {
		return library_id;
	}
	public void setLibrary_id(String library_id) {
		this.library_id = library_id;
	}
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}



	public Library(){}
	public Library(String libraryPID, SysUser sysUser){
		this.library_id=libraryPID;
		this.sysUser=sysUser;
	}

	
}