package com.example.jadish.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

//@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false,name = "username")
	private String username;
	@Column(nullable = false,name = "password")
	private String password;
	@Column(nullable = false,name = "wallet")
	private Double wallet;
	
	public User( String username, String password, Double wallet) {
		super();
		this.username = username;
		this.password = password;
		this.wallet = wallet;
	}

	public User() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getWallet() {
		return wallet;
	}

	public void setWallet(Double wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", wallet=" + wallet + "]";
	}
	
	
	
}

