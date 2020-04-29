package com.example.project.resourceserver.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table("permission")
public class Permission {

	@Id
	private int id;
	private String permissionName;
}
