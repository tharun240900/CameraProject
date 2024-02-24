package com.example.jadish.service;

import java.util.List;
import java.util.ListIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jadish.dao.UserRepo;
import com.example.jadish.entity.User;

@Service
public class UserService {

	@Autowired
	UserRepo ur;
	
	public String saveUser(User u) {
		System.out.println(ur.save(u));
		return "saved";
	}
	
	public Integer userCheck(String name,String password) {
		List<User> l=ur.findAll();
		ListIterator<User> li=l.listIterator();
		while(li.hasNext()) {
			User u=li.next();
			if(name.equals(u.getUsername()) && password.equals(u.getPassword()))
				return u.getId();
		}
		return 0;
	}
	
	public void walletAmountUpdate(Integer id,double amt) {
		User u=ur.findById(id).get();
		u.setWallet(amt);
		ur.save(u);
	}
	
	public Double balance(Integer id) {
		return ur.findById(id).get().getWallet();
	}
	
}
