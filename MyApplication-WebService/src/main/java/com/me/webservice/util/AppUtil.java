package com.me.webservice.util;

import org.springframework.security.core.context.SecurityContextHolder;

public class AppUtil {

	public static String getLoginUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
	}
}
