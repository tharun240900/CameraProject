package com.example.jadish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.jadish.entity.User;
import com.example.jadish.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService us;
	
	@PostMapping("/signup")
	public String signUp(@RequestBody User u) {
		us.saveUser(u);
		return "saved";
	}
	
	@PostMapping("/login")
	public String Login(@RequestParam String name,@RequestParam String password) {
		return us.userCheck(name, password)+"";
	}
	
	@PostMapping("/user/{id}")
	public String walletUpdate(@PathVariable Integer id,@RequestParam Double amt) {
		us.walletAmountUpdate(id, amt);
		return "ok";
	}
	
	@GetMapping("/user/wallet/{id}")
	public Double WalletBalance(@PathVariable Integer id) {
		return us.balance(id);
	}
}
