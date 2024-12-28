package com.ecommerce.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.models.User;

public interface UserRepository extends JpaRepository<User, String> {
    
	 User findByUsernameAndPassword(String username, String password);
	
//	Optional<User> findByUsername(String username);
	
	Optional<User> findByEmail(String email);
	
	User findByUsername(String username);
	
	User findById(long id);
	
//	 @Query("select u from users u where u.user_name = ?1")
//   User findByUsername(String username);

}
