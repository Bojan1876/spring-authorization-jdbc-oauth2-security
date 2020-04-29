package com.example.project.resourceserver.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.project.resourceserver.model.UserRole;

@Repository
public class RolesDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<UserRole> getListOfRoles() {
		Collection<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from role order by id asc");
		List<UserRole> roleList = new ArrayList<>();
		rows.stream().map((row)->{
			UserRole user = new UserRole();
			user.setId((Integer) row.get("id"));
			user.setRoleName((String) row.get("role_name"));
			return user;
		}).forEach((ss3)->{
			roleList.add(ss3);
		});
		return roleList;
	}

	public void deleteRole(String role_id) {
		jdbcTemplate.update("delete from role where id=?", new Object[] {role_id});
	}

	public void updateRole(String role_id, UserRole role) {
		jdbcTemplate.update("update role set role_name=? where id=?", new Object[] {role.getRoleName(), role_id});
	}

	public void createRole(UserRole role) {
		jdbcTemplate.update("insert into role (role_name) values (?)", new Object[] {role.getRoleName()});
	}

}
