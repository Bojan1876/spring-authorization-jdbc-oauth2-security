package com.example.project.resourceserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.resourceserver.converter.AccessTokenMapper;
import com.example.project.resourceserver.service.PermissionResourceDAO;

@RestController
public class PermissionResource {

	@Autowired
	PermissionResourceDAO permissionResourceDAO;
	
	@PreAuthorize("hashAnyRole('view_permission', 'SUPERADMIN')")
	
	@RequestMapping(value = "/permissions", method = RequestMethod.GET)
	public ResponseEntity<Object> getListOfPermissions(){
		AccessTokenMapper accessTokenMapper = (AccessTokenMapper) 
				((OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getDecodedDetails();
		
		System.out.println("accessTokenMapper.getFirst_name()::" + accessTokenMapper.getFirstName());
		System.out.println("accessTokenMapper.getLast_name()::" + accessTokenMapper.getLastName());
		
		return new ResponseEntity<Object>(permissionResourceDAO.getListOfPermissions(), HttpStatus.OK);
	}
}
