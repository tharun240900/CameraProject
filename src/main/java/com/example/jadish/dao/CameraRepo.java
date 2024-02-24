package com.example.jadish.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.jadish.entity.Camera;
import com.example.jadish.entity.User;

import java.util.List;


@Repository
public interface CameraRepo extends JpaRepository<Camera, Integer>{

	List<Camera> findByU(User u);
	
	@Query("from Camera where status=:n")
	List<Camera> findAvailableCam(@Param("n") String a);
	
}
