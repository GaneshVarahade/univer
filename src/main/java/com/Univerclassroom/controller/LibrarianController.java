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

import com.Univerclassroom.DTO.LibrarianDTO;
import com.Univerclassroom.DTO.SchoolAdminDTO;
import com.Univerclassroom.model.Admin;
import com.Univerclassroom.model.Librarian;
import com.Univerclassroom.model.SchoolAdmin;
import com.Univerclassroom.services.LibrarianServices;
import com.Univerclassroom.services.SchoolAdminServices;

import flexjson.JSONSerializer;


@Controller
@RequestMapping("/Librarian")
@JsonIgnoreProperties(ignoreUnknown = true)
public class LibrarianController {

	
	@Autowired
	SchoolAdminServices Schooladminservices;
	
	
	
	@Autowired
	LibrarianServices Librarianservices;
	
	
public static HashMap<String, String> map = new HashMap<String, String>();
	
	public static HashMap<String, String> userMap = new HashMap<String, String>();
	@RequestMapping(value = "/addLibrarian/", method = RequestMethod.POST,  headers = "content-type=application/json")
	public @ResponseBody
	void add(@RequestBody LibrarianDTO librarianDTO,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		Map<String,Object> obj = new HashMap<String,Object>();
		 @SuppressWarnings("unused")
		 Librarian librarian=new Librarian(librarianDTO);
     	SchoolAdminController lg = new SchoolAdminController();
		 HashMap<String, String> map = lg.getHashmap();
		 Object value = map.get(librarianDTO.getSessionId());
		 Object id = map.get("SchoolAdminId");		 
		 System.out.println("id"+id);
		 if(value == null){
		      obj.put("Added", "unsuccessful");
		 } else{
		      String SchoolAdminId = id.toString();
			  long SchoolAdminId1 = Long.parseLong(SchoolAdminId);
			  
			  SchoolAdmin schoolAdmin =  Schooladminservices.getSchoolAdminById(SchoolAdminId1);
			  System.out.println("id"+schoolAdmin);
			 librarian.setSchoolAdmin(schoolAdmin);
			  Librarianservices.addLibrarian(librarian);
			 obj.put("Added", "successful");
			 
		      }

		  response.setContentType("application/json; charset=UTF-8"); 
			response.getWriter().print(new JSONSerializer().exclude("class","*.class","authorities").deepSerialize(obj));
	}
	
	
	
	
public HashMap<String, String> getHashmap() {
	    
	    return map;
	}
}


