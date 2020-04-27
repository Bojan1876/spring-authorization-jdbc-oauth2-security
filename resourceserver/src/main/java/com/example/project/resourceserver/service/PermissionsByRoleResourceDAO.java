package com.example.project.resourceserver.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PermissionsByRoleResourceDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<String> getViewPermissionsbyRole(String role_id) {
		Collection<Map<String, Object>> rows = jdbcTemplate.queryForList("select p.permission_name from permission p"
																	+ "inner join role_permission role_p on p.id=role_p.permission_id"
																	+ "where role_p.role_id=?", new Object[] {role_id});
		List<String> permissionList = new ArrayList<>();
		rows.stream().map((row)->{
			return (String) row.get("permission_name");
		}).forEach((ss3)->{
			permissionList.add(ss3);
		});
		return permissionList;
	}

	public void assignPermissions2Role(String role_id, ArrayList<String> permissionsList) {
		jdbcTemplate.update("delete from role_permission where role_id=?", new Object[] {role_id});
		for(String id: permissionsList) {
			jdbcTemplate.update("insert into role_permission (role_id, permission_id) values (?,?)", new Object[] {role_id, id});
		}
	}

}
