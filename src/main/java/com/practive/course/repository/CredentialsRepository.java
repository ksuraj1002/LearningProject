package com.practive.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practive.course.model.Credentials;

public interface CredentialsRepository extends JpaRepository<Credentials, Integer> {
	@Query("select u from Credentials as u where u.username=:username or u.usermobile =:username")
	Credentials findUserDetails(String username);

}
