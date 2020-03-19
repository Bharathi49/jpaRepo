package com.testyantra.tyssEhub.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testyantra.tyssEhub.dto.ClientDetails;

public interface ClientDetailsRepo extends JpaRepository<ClientDetails, Integer> {

}
