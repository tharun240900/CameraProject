package com.example.jadish.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.jadish.entity.Camera;
import com.example.jadish.service.CamService;

@RestController
@CrossOrigin
public class CamController {
	
	@Autowired
	CamService cs;

	@PostMapping("/camera/{id}")
	public String addCam(@RequestBody Camera c,@PathVariable Integer id) {
		cs.saveCam(c,id);
		return "CamSaved";
	}
	
	@PostMapping("/camera/rent/{id}")
	public String rent(@PathVariable Integer id) {
		return cs.updateCam(id);
	}
	
	@GetMapping("/camera")
	public List<Camera> allCams() {
		return cs.getAllCameras();
	}
	
	@GetMapping("/camera/user/{id}")
	public List<Camera> allUserCams(@PathVariable Integer id) {
		return cs.getAllUserCams(id);
	}
	
	@GetMapping("/camera/status")
	public List<Camera> allAvailableCams() {
		return cs.getAvailableCams();
	}
	
	@DeleteMapping("/camera/{id}")
	public String delCam(@PathVariable Integer id) {
		return cs.removeCam(id);
	}
}
