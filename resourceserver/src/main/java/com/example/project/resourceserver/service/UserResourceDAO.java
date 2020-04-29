package com.example.project.resourceserver.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.project.resourceserver.model.UserModel;

@Repository
public class UserResourceDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	
	public List<UserModel> getListOfUsers(){
		Collection<Map<String, Object>> rows3 = jdbcTemplate.queryForList("select * from users");
		List<UserModel> usersList = new ArrayList<>();
		rows3.stream().map((row) ->{
			UserModel user = new UserModel();
			user.setCountry((String) row.get("country"));
			user.setEmail((String) row.get("email_id"));
			user.setFirstName((String) row.get("first_name"));
			user.setId((Integer) row.get("id"));
			user.setLastName((String) row.get("last_name"));
			user.setMobile((String) row.get("mobile"));
			user.setUserType((String) row.get("user_type"));
			return user;
		}).forEach((ss3)->{
			usersList.add(ss3);
		});
		return usersList;
	}
	
	public void deleteUser(String user_id) {
		jdbcTemplate.update("delete from users where id=?", new Object[] {user_id});
	}
	
	public void updateUser(String user_id, UserModel userModel) {
		jdbcTemplate.update("update users set country=?, first_name=?, last_name=?, mobile=?, where id=?", 
				new Object[] {userModel.getCountry(), userModel.getFirstName(), userModel.getLastName(), userModel.getMobile(), user_id});
		
	}
	
	public void createUser(UserModel userModel) {
		jdbcTemplate.update(
				"insert into users (country, first_name, last_name, mobile, email_id, password, user_type) values "
				+ "(?,?,?,?,?,?,?)",
				new Object[] {userModel.getCountry(), userModel.getFirstName(), userModel.getLastName(),
						userModel.getMobile(), userModel.getEmail(), 
						passwordEncoder.encode(userModel.getPassword()), userModel.getUserType()});
	}
	
	public boolean isSupperAdmin(String id) {
		return jdbcTemplate.queryForObject("selecy count(id) from users where user_type=? and id=?", new Object[] {"super_admin", id}, Integer.class) > 0;
	}

}
