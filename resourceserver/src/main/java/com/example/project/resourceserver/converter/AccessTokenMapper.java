package com.example.project.resourceserver.converter;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccessTokenMapper {

	private String id;
	private List<String> authorities = new ArrayList<String>();
	private String first_name;
	private String last_name;
	private String email_id;
	private String user_type;
	private String mobile;
	private String country;
}
