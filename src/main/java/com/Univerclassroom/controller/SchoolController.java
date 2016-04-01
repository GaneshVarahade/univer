package com.Univerclassroom.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		
	

	

		
		@RequestMapping(value = "/listSchool/", method = RequestMethod.POST,  headers = "content-type=application/json")
		public @ResponseBody
		void add1(@RequestBody SchoolDTO schoolDTO,HttpServletRequest request,HttpServletResponse response) throws Exception {
	
		System.out.println("hello");
		Map<String,Object> obj = new HashMap<String,Object>();
		List<Map<String,Object>> ListofSchools = new ArrayList<Map<String,Object>>();	
		AdminController lg = new AdminController();
		 HashMap<String, String> map = lg.getHashmap();
		 Object value = map.get(schoolDTO.getSessionId());
		 if(value == null){
			// obj.put("SchoolList", "unsuccessful");
		 }else{
		 }
		 List<School> SchoolList =schoolServices.getSchools();
			for (School school : SchoolList) {
		   Map<String,Object> map1 = new HashMap<String, Object>();
		   
		   map1.put("Schoolname", school.getSchoolName());
		   map1.put("PrincipalName"  ,school.getPrincipalName());
		   map1.put("PrincipalMembershipNumber",  school.getPrincipalMembershipNumber());
		   map1.put("Address",school.getAddress());
		   map1.put("Country", school.getCountry());
		   map1.put("EmailId",school.getEmailId());
		   map1.put("PostCode",school.getPostCode());
		   map1.put("FaxNumber",school.getFaxNumber());
		   map1.put("PhoneNumber",school.getPhoneNumber());
		   map1.put("SchoolMedium",school.getSchoolMedium());
		   map1.put("SchoolId",school.getSchoolId());
		   map1.put("SchoolRegistrationDate",school.getSchoolRegistrationDate());
		   map1.put("SchoolSector",school.getSchoolSector());
		   map1.put("SchoolStartDate",school.getSchoolStartDate());
		   map1.put("SchoolType",school.getSchoolType());
		   map1.put("getState",school.getState());
		   map1.put("WebsiteAddress",school.getWebsiteAddress());
		 
		   
		   
		   
		   ListofSchools.add(map1);
			}
			obj.put("SchoolList", ListofSchools);	
			response.setContentType("application/json; charset=UTF-8"); 
			response.getWriter().print(new JSONSerializer().exclude("class","*.class","authorities").deepSerialize(obj));
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
}
}
