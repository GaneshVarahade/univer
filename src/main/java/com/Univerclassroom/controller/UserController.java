package com.Univerclassroom.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Univerclassroom.DTO.StudentAdmissionDTO;
import com.Univerclassroom.model.Parent;
import com.Univerclassroom.model.Student;
import com.Univerclassroom.model.StudentToParent;
import com.Univerclassroom.services.ParentServices;
import com.Univerclassroom.services.StudentServices;

import flexjson.JSONSerializer;

@Controller
@RequestMapping("/user")
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserController {

	@Autowired
	ParentServices parentServices;
	
	@Autowired
	StudentServices studentServices;


	public static HashMap<String, String> userMap = new HashMap<String, String>();
	
	@RequestMapping(value = "/admission/", method = RequestMethod.POST,  headers = "content-type=application/json")
	public @ResponseBody
	void add(@RequestBody StudentAdmissionDTO admission,HttpServletRequest request,HttpServletResponse response) throws Exception {
		Map<String,Object> obj = new HashMap<String,Object>();
		
		
		
		
			Student student = new Student(admission);
			boolean isStudentSave = studentServices.addOrUpdateStudent(student);
			Parent parent = new Parent(admission);
			boolean isParentSave = parentServices.addOrUpdateParent(parent);
			Student studObj = studentServices.getStudent(admission);
			Parent parentObj = parentServices.getParent(admission);
			StudentToParent stp = new StudentToParent();
			stp.setParent(parentObj);
			stp.setStudent(studObj);
			boolean isSADSave = studentServices.addOrUpdateStudentToParent(stp);
			if(isStudentSave && isParentSave && isSADSave){
				obj.put("admission", "form submitted");
			}
			
			response.setContentType("application/json; charset=UTF-8"); 
			response.getWriter().print(new JSONSerializer().exclude("class","*.class","authorities").deepSerialize(obj));
			}
	
	
	public HashMap<String, String> getUsermap() {
	    
	    return userMap;
	}

}