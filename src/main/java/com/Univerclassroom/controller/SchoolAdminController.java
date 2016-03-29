

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

import com.Univerclassroom.model.SchoolAdmin;
import com.Univerclassroom.DTO.SchoolAdminDTO;
import com.Univerclassroom.services.AdminServices;
import com.Univerclassroom.services.SchoolAdminServices;

import flexjson.JSONSerializer;

@Controller
@RequestMapping("/SchoolAdmin")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SchoolAdminController {


	@Autowired
	SchoolAdminServices Schooladminservices;
	
	@Autowired
	AdminServices adminservices;
	
	
	public static HashMap<String, String> map = new HashMap<String, String>();
	
	public static HashMap<String, String> userMap = new HashMap<String, String>();
	@RequestMapping(value = "/addSchoolAdmin/", method = RequestMethod.POST,  headers = "content-type=application/json")
	public @ResponseBody
	void add(@RequestBody SchoolAdminDTO SchooladminDTO,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		Map<String,Object> obj = new HashMap<String,Object>();
		 @SuppressWarnings("unused")
		 SchoolAdmin Schooladmin=new SchoolAdmin(SchooladminDTO);
     	AdminController lg = new AdminController();
     	
		 HashMap<String, String> map = lg.getHashmap();
		 Object value = map.get(SchooladminDTO.getSessionId());
		 Object id = map.get("adminId");		 
		 
		 if(value == null && (value.toString()).equals(SchooladminDTO.getSessionId())){
			 obj.put("Added", "unsuccessful");
		 }else{
			  if(!Schooladminservices.checkUsername(Schooladmin)){
				 obj.put("School admin added", "unsuccessful");
				 obj.put("reason", "username Is Not Unique");
			 }else {
				
				 String adminId = id.toString();
				 long adminIDD = Long.parseLong(adminId);
				 Admin admin =  adminservices.getAdminById(adminIDD);
				 System.out.println("id"+admin);
				 Schooladmin.setAdmin(admin);
				 Schooladminservices.addSchoolAdmin(Schooladmin);
				 obj.put("Added", "successful");
			 		 

			 }
			  
		 }
			  
			    response.setContentType("application/json; charset=UTF-8"); 
				response.getWriter().print(new JSONSerializer().exclude("class","*.class","authorities").deepSerialize(obj));
	}
	
	
	@RequestMapping(value = "/schoolAdminLogin/", method = RequestMethod.POST, headers = "content-type=application/json")
	public @ResponseBody
	void login(@RequestBody SchoolAdminDTO SchooladminDTO,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		
		Map<String,Object> obj = new HashMap<String,Object>();
		 String sessionId = null;
		
		System.out.println("hello");
		
		SchoolAdmin Schooladmin=new SchoolAdmin(SchooladminDTO);
		
	        if( Schooladminservices.login(Schooladmin))	 
	        { 
	        	
	
			 HttpSession sessionn = request.getSession();
			 sessionId = sessionn.getId();
			 map.put(sessionId, sessionId);
			 SchoolAdmin Schooladmin1 = Schooladminservices.getSchoolAdminByUsername(Schooladmin.getUsername());
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
	
}