package com.Univerclassroom.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Univerclassroom.DTO.SchoolDTO;
import com.Univerclassroom.model.Admin;
import com.Univerclassroom.model.School;
import com.Univerclassroom.services.AdminServices;
import com.Univerclassroom.services.SchoolAdminServices;
import com.Univerclassroom.services.SchoolServices;

import flexjson.JSONSerializer;


@Controller
@RequestMapping("/School")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SchoolController {

	
	@Autowired
	SchoolServices schoolServices;
	
	@Autowired
	AdminServices adminservices;

	public static HashMap<String, String> map = new HashMap<String, String>();
		
		public static HashMap<String, String> userMap = new HashMap<String, String>();
		@RequestMapping(value = "/addSchool/", method = RequestMethod.POST,  headers = "content-type=application/json")
		public @ResponseBody
		void add(@RequestBody SchoolDTO schoolDTO,HttpServletRequest request,HttpServletResponse response) throws Exception {
			
			Map<String,Object> obj = new HashMap<String,Object>();
			 @SuppressWarnings("unused")
			 School school=new School(schoolDTO);
			 
	     	AdminController lg = new AdminController();
	     	
			 HashMap<String, String> map = lg.getHashmap();
			 System.out.println(schoolDTO.getSessionId());
			 Object value = map.get(schoolDTO.getSessionId());
			 
			 Object id = map.get("adminId");		 
			 
			 if(value == null ){
				 obj.put("School Added", "unsuccessful");
			 }else{
				 
					 String adminId = id.toString();
					 long adminIDD = Long.parseLong(adminId);
					 Admin admin =  adminservices.getAdminById(adminIDD);
					 System.out.println("id"+admin);
					 school.setAdmin(admin);
					 schoolServices.addSchool(school);
					 obj.put("Added", "successful");
				 		 
	
				 }
				  
			 
				  
				    response.setContentType("application/json; charset=UTF-8"); 
					response.getWriter().print(new JSONSerializer().exclude("class","*.class","authorities").deepSerialize(obj));
		}
		
	

	
	
	
	
}
