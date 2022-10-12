package com.example.lab5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The type Security config.
 */
public class SecurityConfig {

	/**
	 * The constant ROLE_MANAGER.
	 */
	public static final String ROLE_MANAGER = "MANAGER";
	/**
	 * The constant ROLE_EMPLOYEE.
	 */
	public static final String ROLE_EMPLOYEE = "EMPLOYEE";

	private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

	{
		List<String> urlPatterns1 = new ArrayList<String>();

		urlPatterns1.add("/userInfo");
		urlPatterns1.add("/employeeTask");

		mapConfig.put(ROLE_EMPLOYEE, urlPatterns1);

		List<String> urlPatterns2 = new ArrayList<String>();

		urlPatterns2.add("/userInfo");
		urlPatterns2.add("/managerTask");

		mapConfig.put(ROLE_MANAGER, urlPatterns2);
	}

	/**
	 * Gets all app roles.
	 *
	 * @return the all app roles
	 */
	public static Set<String> getAllAppRoles() {
		return mapConfig.keySet();
	}

	/**
	 * Gets url patterns for role.
	 *
	 * @param role the role
	 * @return the url patterns for role
	 */
	public static List<String> getUrlPatternsForRole(String role) {
		return mapConfig.get(role);
	}

}