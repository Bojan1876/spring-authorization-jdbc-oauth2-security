package com.example.project.resourceserver.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.resourceserver.service.PermissionsByRoleResourceDAO;

@RestController
public class PermissionsByRoleResource {

	@Autowired
	PermissionsByRoleResourceDAO permissionssByRoleResourceDAO;
	
	@PreAuthorize("hashAnyRole('view_permissions_by_role', 'SUPERADMIN')")
	@RequestMapping(value = "/roles/{id}/permissions", method = RequestMethod.GET)
	public ResponseEntity<Object> viewPermissionsByRole(@PathVariable("id") String role_id){
		return new ResponseEntity<>(permissionssByRoleResourceDAO.getViewPermissionsbyRole(role_id), HttpStatus.OK);
	}
	
	@PreAuthorize("hashAnyRole('assign_permissions_to_role', 'SUPERADMIN')")
	@RequestMapping(value = "/roles/{id}/permissions", method = RequestMethod.PUT)
	public ResponseEntity<Object> assignPermissions2Role(@PathVariable("id") String role_id, @RequestBody ArrayList<String> permissionsList){
		permissionssByRoleResourceDAO.assignPermissions2Role(role_id, permissionsList);
		return new ResponseEntity<>("Permissions are assigned to role successfully", HttpStatus.OK);
	}
}
