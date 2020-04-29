package com.example.project.resourceserver.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table("role")
public class UserRole {
	
	@Id
	private int id;
	private String roleName;

}
