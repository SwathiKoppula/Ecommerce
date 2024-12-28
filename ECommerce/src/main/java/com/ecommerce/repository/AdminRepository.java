package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
	
	Admin findByUsername(String username);

}
