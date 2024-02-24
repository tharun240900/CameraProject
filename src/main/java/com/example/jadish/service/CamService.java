package com.example.jadish.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jadish.dao.CameraRepo;
import com.example.jadish.dao.UserRepo;
import com.example.jadish.entity.Camera;

@Service
public class CamService {
	
	@Autowired
	CameraRepo cr;
	
	@Autowired
	UserRepo ur;

	public void saveCam(Camera c,Integer id) {
		c.setU(ur.findById(id).get());
		cr.save(c);
	}
	
	public String removeCam(Integer id) {
		cr.deleteById(id);
		return "removed";
	}
	
	public List<Camera> getAllUserCams(Integer id) {
		return cr.findByU(ur.findById(id).get());
	}
	
	public List<Camera> getAllCameras() {
		return cr.findAll();
	}
	
	public List<Camera> getAvailableCams() {
		return cr.findAvailableCam("available");
	}
	
	public String updateCam(Integer id) {
		Camera c=cr.findById(id).get();
		c.setStatus("rented");
		cr.save(c);
		return "rented";
	}
	
}
