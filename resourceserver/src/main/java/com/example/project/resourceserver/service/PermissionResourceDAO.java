package com.example.project.resourceserver.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.project.resourceserver.model.Permission;

@Repository
public class PermissionResourceDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Permission> getListOfPermissions() {
		Collection<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from permision");
		List<Permission> permissionList = new ArrayList<>();
		rows.stream().map((row)->{
			Permission permission = new Permission();
			permission.setId(String.valueOf(row.get("id")));
			permission.setPermission_name((String) row.get("permission_name"));
			return permission;
		}).forEach((ss3)->{
			permissionList.add(ss3);
		});
		return permissionList;
	}

}
