package com.se.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

@Document(collection = "roles")
public class Role extends GenericModel {

	@NotNull
	private String roleName;

	private List<User> userRoles;

	public Role(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<User> userRoles) {
		this.userRoles = userRoles;
	}
}
