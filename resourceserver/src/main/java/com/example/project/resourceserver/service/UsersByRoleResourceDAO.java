package com.example.project.resourceserver.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.project.resourceserver.model.UserModel;

@Repository
public class UsersByRoleResourceDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public Object viewUsersByRole(String role_id) {
		Collection<Map<String, Object>> rows = 
				jdbcTemplate.queryForList("select u.id, u.first_name, u.email_id, u.country, u.user_type, u.mobile"
						+ "from users u inner join role_users_u on u.id=role_u.user_id"
						+ "where role_u.role_id=?", new Object[] {role_id});
		List<UserModel> usersList = new ArrayList<>();
		rows.stream().map((row) ->{
			UserModel user = new UserModel();
			user.setCountry((String) row.get("country"));
			user.setEmail((String) row.get("email_id"));
			user.setFirstName((String) row.get("first_name"));
			user.setId((Integer) row.get("id"));
			user.setLastName((String) row.get("last_name"));
			user.setMobile((String) row.get("mobile"));
			user.setUserType((String) row.get("user_type"));
			return user;
		}).forEach((ss3) ->{
			usersList.add(ss3);
		});
		return null;
	}

	public void assignUsers2Role(String role_id, ArrayList<String> usersList) {
		jdbcTemplate.update("delete from role_users where role_id=?", new Object[] {role_id});
		for(String id:usersList) {
			jdbcTemplate.update("insert into role_users (role_id, user_id) values (?,?)", new Object[] {role_id, id});
		}
	}

}
