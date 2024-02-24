package com.example.jadish.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="camera")
public class Camera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="brand",nullable = false)
	private String brand;
	@Column(name="model",nullable = false)
	private String model;
	@Column(name="price",nullable = false)
	private double price;
	@Column(name="status",nullable = false)
	private String status;
	
	@ManyToOne
	@JoinColumn(name="U_id")
	private User u;
	
	public Camera() {
		super();
	}
	
	public Camera(String brand, String model,String status, double price, User u) {
		super();
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.status = status;
		this.u = u;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	
}


