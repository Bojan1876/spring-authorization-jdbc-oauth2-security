package com.example.projects.authoriyationserver.model;

import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomUser extends User {

	private static final long serialVersionUID = 1L;
	private String id;
	private String first_name;
	private String last_name;
	private String mobile;
	private String country;
	private String user_type;
	
	public CustomUser(UserEntity user) {
		super(user.getEmail_id(), user.getPassword(), user.getGrantedAuthoritiesList());
		this.id = user.getId();
		this.first_name = user.getFirst_name();
		this.last_name = user.getLast_name();
		this.mobile = user.getMobile();
		this.country = user.getCountry();
		this.user_type = user.getUser_type();
	}

}
