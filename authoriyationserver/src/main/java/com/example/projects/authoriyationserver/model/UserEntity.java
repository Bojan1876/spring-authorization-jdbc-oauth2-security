package com.example.projects.authoriyationserver.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserEntity {

	private String email_id;
	private String password;
	private Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
	private String id;
	private String first_name;
	private String last_name;
	private String mobile;
	private String country;
	private String user_type;

}
