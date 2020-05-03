package com.example.project.resourceserver.converter;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccessTokenMapper {

	private int id;
	private List<String> authorities = new ArrayList<String>();
	private String firstName;
	private String lastName;
	private String email;
	private String userType;
	private String mobile;
	private String country;
}
