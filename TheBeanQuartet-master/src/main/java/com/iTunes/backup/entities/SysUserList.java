package com.iTunes.backup.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SysUserList implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<SysUser> wrapper;
	
	public Collection<SysUser> getSysUserCollection() {
		return wrapper;
	}
	
	public void setSysUserCollection(Collection<SysUser> users) {
		this.wrapper = users;
	}
}
