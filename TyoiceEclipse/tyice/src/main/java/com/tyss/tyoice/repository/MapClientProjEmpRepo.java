package com.tyss.tyoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tyss.tyoice.dto.MappedEmployess;

@Repository
public interface MapClientProjEmpRepo extends JpaRepository<MappedEmployess, Integer> {
	
	public MappedEmployess findByempId(int empId);
}
