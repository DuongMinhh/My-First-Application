package com.me.webservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.me.common.entity.Role;
import com.me.common.entity.UserInformation;
import com.me.common.enums.RoleEnum;
import com.me.common.repository.RoleRepository;
import com.me.common.repository.UserInformationRepository;

@SpringBootApplication
@ComponentScan(basePackages = { "com.me.common", "com.me.webservice" })
@EnableJpaRepositories("com.me.common.repository")
@EntityScan(basePackages = { "com.me.common.entity" })
public class MyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
		System.out.println("Test mergin - in sub branch");
	}

	@Autowired
	private void onStartUp(UserInformationRepository userRepo, RoleRepository roleRepo,
			PasswordEncoder passwordEncoder) {

		// Create roles for app
		Role roleAdmin = new Role(RoleEnum.ROLE_ADMIN.value, RoleEnum.ROLE_ADMIN.toString());
		Role roleSeller = new Role(RoleEnum.ROLE_SELLER.value, RoleEnum.ROLE_SELLER.toString());
		Role roleCustomer = new Role(RoleEnum.ROLE_CUSTOMER.value, RoleEnum.ROLE_CUSTOMER.toString());

		List<Role> appRoles = Arrays.asList(roleAdmin, roleSeller, roleCustomer);

		appRoles.forEach(r -> {
			if (roleRepo.getById(r.getId()) != null) {
				roleRepo.save(r);
			}
		});

		// Create system admin
		if (!userRepo.findByUsername("admin").isPresent()) {
			UserInformation adminInformation = new UserInformation();
			adminInformation.setUsername("admin");
			adminInformation.setEmail("nguyenminhduong2310@gmail.com");
			adminInformation.setPhoneNumber("0978240409");
			adminInformation.setPassword(passwordEncoder.encode("123456"));
			adminInformation.setRoleId(RoleEnum.ROLE_ADMIN.value);

			userRepo.save(adminInformation);
		}
	}

}
