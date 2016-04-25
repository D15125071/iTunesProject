package com.iTunes.backup.dao;

import java.util.Collection;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.iTunes.backup.entities.SysUser;



@Default
@Stateless
@Local
@TransactionAttribute (TransactionAttributeType.REQUIRED)
public class SysUserJPA implements SysUserDAO{
	
	
	
	@PersistenceContext
	private EntityManager em;
	

	
	public String addUser(SysUser user) {
		if(userExist(user)){
			return "Username already Exists";
		}
		em.persist(user);
		return "User Added Successfully";
	}
	public boolean userExist(SysUser user){
		Query query = em.createQuery("from SysUser");
		List<SysUser> users = query.getResultList();
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getUser_name().equals(user.getUser_name())){
				return true;
			}
		}
		return false;
	}


	public Collection<SysUser> getAllUsers() {
		Query query = em.createQuery("from SysUser");
		List<SysUser> users = query.getResultList(); 
		return users;
	}
	public String verify_user(SysUser user) {
		Query query = em.createQuery("from SysUser");
		List<SysUser> users = query.getResultList(); 
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getUser_name().equals(user.getUser_name())){
				if(users.get(i).getUser_password().equals(user.getUser_password())){
					return "true";
				}
			}
		}
		return "false";
	}


}
