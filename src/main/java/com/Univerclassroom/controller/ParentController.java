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

import com.Univerclassroom.DTO.ParentDTO;
import com.Univerclassroom.DTO.StudentDTO;
import com.Univerclassroom.model.Parent;
import com.Univerclassroom.model.Student;
import com.Univerclassroom.services.ParentServices;
import com.Univerclassroom.services.StudentServices;

import flexjson.JSONSerializer;

@Controller
@RequestMapping("/Parent")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParentController {

	@Autowired
	ParentServices parentServices;
	
	public static HashMap<String, String> parentMap = new HashMap<String, String>();

	@RequestMapping(value = "/login/", method = RequestMethod.POST, headers = "content-type=application/json")
	public @ResponseBody void login(@RequestBody ParentDTO parentDTO,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> obj = new HashMap<String, Object>();
		String sessionId = null;
		if (parentServices.login(parentDTO)) {
			HttpSession sessionn = request.getSession();
			sessionId = sessionn.getId();
			parentMap.put(sessionId, sessionId);
			Parent parent = parentServices.getParentByUsername(parentDTO.getUsername());	
			obj.put("sessionId", sessionId);
			String strI = Long.toString((parent.getParentId()));
			parentMap.put("ParentId", strI);
			obj.put("login", "successful");
		}else {
			obj.put("login", "unsuccessful");
		}
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(new JSONSerializer().exclude("class", "*.class", "authorities")
				.deepSerialize(obj));
		
	}
	
	public HashMap<String, String> getParentMap() {

		return parentMap;
	}
}
