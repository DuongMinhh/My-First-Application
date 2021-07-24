package com.me.webservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.me.common.entity.Role;
import com.me.common.enums.RoleEnum;
import com.me.common.repository.RoleRepository;


@SpringBootApplication
@ComponentScan(basePackages = {"com.me.common"})
@EnableJpaRepositories("com.me.common.repository")
@EntityScan(basePackages = {"com.me.common.entity"})
public class MyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}

	@Autowired
	private void onStartUp(RoleRepository roleRepo) {
		Role roleAdmin = new Role(RoleEnum.ROLE_ADMIN.value, RoleEnum.ROLE_ADMIN.toString());
		Role roleSeller = new Role(RoleEnum.ROLE_SELLER.value, RoleEnum.ROLE_SELLER.toString());
		Role roleCustomer = new Role(RoleEnum.ROLE_CUSTOMER.value, RoleEnum.ROLE_CUSTOMER.toString());

		List<Role> appRoles = Arrays.asList(roleAdmin, roleSeller, roleCustomer);

		appRoles.forEach(r -> {
			if (roleRepo.getById(r.getId()) != null) {
				roleRepo.save(r);
			}
		});
	}

}
