package com.Univerclassroom.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

import com.Univerclassroom.DTO.StudentAdmissionDTO;
import com.Univerclassroom.DTO.TeacherDTO;
import com.Univerclassroom.model.Experience;
import com.Univerclassroom.model.SchoolAdmin;
import com.Univerclassroom.model.Teacher;
import com.Univerclassroom.services.SchoolAdminServices;
import com.Univerclassroom.services.TeacherServices;

import flexjson.JSONSerializer;


@Controller
@RequestMapping("/teacher")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeacherController {

	@Autowired
	TeacherServices teacherServices;
	
	@Autowired
	SchoolAdminServices Schooladminservices;
	
	public static HashMap<String, String> teacherMap = new HashMap<String, String>();
	
	@RequestMapping(value = "/login/", method = RequestMethod.POST,  headers = "content-type=application/json")
	public @ResponseBody
	void login(@RequestBody TeacherDTO teacherDTO,HttpServletRequest request,HttpServletResponse response) throws Exception {
		Map<String,Object> obj = new HashMap<String,Object>();
		String sessionId = null;

		

		if (teacherServices.TeacherLogin(teacherDTO)) {

			HttpSession sessionn = request.getSession();
			sessionId = sessionn.getId();
			teacherMap.put(sessionId, sessionId);
			Teacher teacher = teacherServices.getTeacherByUsername(teacherDTO.getTeacherUsername());
			obj.put("sessionId", sessionId);

			String strI = Long.toString((teacher.getId()));
			teacherMap.put("teacherId", strI);
			obj.put("login", "successful");
		}

		else {
			obj.put("login", "unsuccessful");
		}
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(
				new JSONSerializer().exclude("class", "*.class", "authorities")
						.deepSerialize(obj));

		
	}
	

	@RequestMapping(value = "/updateProfile/", method = RequestMethod.POST,  headers = "content-type=application/json")
	public @ResponseBody
	void updateProfile(@RequestBody TeacherDTO teacherDTO,HttpServletRequest request,HttpServletResponse response) throws Exception {
		TeacherController sac = new TeacherController();
		HashMap<String, String> map = sac.getteacherMap();
		Object value = map.get(teacherDTO.getSessionId());
		Map<String, Object> obj = new HashMap<String, Object>();
		Object id = map.get("teacherId");
		String teacherId = id.toString();
		long teacherIDD = Long.parseLong(teacherId);
		Teacher teacher = teacherServices.getTeacherById(teacherIDD);
				
		if (value == null) {

		} else {
			if ((value.toString()).equals(teacherDTO.getSessionId())) {
				teacherServices.updateTeacherField(teacherDTO, teacher);
				boolean flag = Schooladminservices.addTeacher(teacher);
				if(flag){
					obj.put("teacher", "updated");
			}

			else {
				obj.put("teacher", "not updated");
			}
			}
		}
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(
				new JSONSerializer().exclude("class", "*.class", "authorities")
						.deepSerialize(obj));
		
	}
			
			public HashMap<String, String> getteacherMap() {

				return teacherMap;
			}

	
}
