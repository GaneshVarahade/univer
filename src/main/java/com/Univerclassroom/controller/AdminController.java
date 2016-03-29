package com.Univerclassroom.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.Univerclassroom.model.Admin;
import com.Univerclassroom.DTO.AdminDTO;
import com.Univerclassroom.model.SchoolAdmin;

import com.Univerclassroom.services.AdminServices;


import flexjson.JSONSerializer;

@Controller
@RequestMapping("/Admin")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminController {

	@Autowired
	AdminServices adminservices;
	
	
	
	
	public static HashMap<String, String> map = new HashMap<String, String>();
	public static HashMap<String, String> clientMap = new HashMap<String, String>();
	
	
	
	@RequestMapping(value = "/adminLogin/", method = RequestMethod.POST, headers = "content-type=application/json")
	public @ResponseBody
	void login(@RequestBody AdminDTO adminDTO,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		
		Map<String,Object> obj = new HashMap<String,Object>();
		 String sessionId = null;
		
		System.out.println("hello");
		
		Admin admin=new Admin(adminDTO);
		System.out.println(adminDTO.getAdminPassword());
	        if( adminservices.login(admin))	 
	        { 
	        	System.out.println(adminDTO.getAdminPassword());
	        	
			 HttpSession sessionn = request.getSession();
			 sessionId = sessionn.getId();
			 map.put(sessionId, sessionId);
			 Admin admin1 = adminservices.getAdminByUsername(admin.getAdminUsername());
			 String strI = Long.toString((admin1.getAdminId()));
			 map.put("adminId",strI);
			 obj.put("sessionId", sessionId);
			 obj.put("login", "successful");
	        }
			
	      
	        
			else
			{
				obj.put("login", "unsuccessful");
			}
			response.setContentType("application/json; charset=UTF-8"); 
			
			response.getWriter().print(new JSONSerializer().exclude("class","*.class","authorities").deepSerialize(obj));
			
	}
	/*
	@RequestMapping(value = "/updateAdmin/", method = RequestMethod.POST,  headers = "content-type=application/json")
	public @ResponseBody
	void updateCar(@RequestBody AdminDTO adminDTO,HttpServletRequest request,HttpServletResponse response) throws Exception {
		Map<String,Object> obj = new HashMap<String,Object>();
	//Admin admin=new Admin(adminDTO);
		admin.setAdminId(adminDTO.getAdminId());
		 Object value = map.get(adminDTO.getSessionId());
		 Object id = map.get("adminId"); 
		 if(value == null){
			 obj.put("adminUpdated", "unsuccessful");
		 }else{
			 if(!adminservices.checkAdminUsername(admin))
				{
				   
				   obj.put("reason", "username must be  Unique");
				}			
			 else
			 {
				if(adminservices.addAdmin(admin));
				{
					 obj.put("adminUpdated", "successful");
				}
			 }
				
			 			
		 }
			
			
			 
		 
			response.setContentType("application/json; charset=UTF-8"); 
			response.getWriter().print(new JSONSerializer().exclude("class","*.class","authorities").deepSerialize(obj));
		 }	

	
	*/
	
	public HashMap<String, String> getHashmap() {
	    
	    return map;
	}
	
public HashMap<String, String> getUsermap() {
	    
	    return clientMap;
	}
	
	
	
	
	
	
	
	
	
	
}
