package com.me.common.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.common.entity.UserInformation;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {

	Optional<UserInformation> findByUsernameOrEmailOrPhoneNumber(String username, String email, String phoneNumber);
	
	Optional<UserInformation> findByUsername(String username);
}
