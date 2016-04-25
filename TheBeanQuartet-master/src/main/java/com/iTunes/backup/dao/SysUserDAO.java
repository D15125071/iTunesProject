package com.iTunes.backup.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.iTunes.backup.entities.SysUser;



@Local
public interface SysUserDAO {
	String addUser(SysUser user);
    Collection<SysUser> getAllUsers();
	String verify_user(SysUser user);
}
