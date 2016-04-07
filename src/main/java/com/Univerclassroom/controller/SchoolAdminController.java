package com.Univerclassroom.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import com.Univerclassroom.model.Account;
import com.Univerclassroom.model.Admin;
import com.Univerclassroom.model.AdmissionResult;
import com.Univerclassroom.model.FeeStructure;
import com.Univerclassroom.model.Parent;
import com.Univerclassroom.model.School;
import com.Univerclassroom.model.SchoolAdmin;
import com.Univerclassroom.model.Student;
import com.Univerclassroom.model.StudentClass;
import com.Univerclassroom.model.StudentToParent;
import com.Univerclassroom.model.Teacher;
import com.Univerclassroom.DTO.AccountDTO;
import com.Univerclassroom.DTO.AdmissionResultDTO;
import com.Univerclassroom.DTO.FeeStructureDTO;
import com.Univerclassroom.DTO.SchoolAdminDTO;
import com.Univerclassroom.DTO.StudentClassDTO;
import com.Univerclassroom.DTO.StudentDTO;
import com.Univerclassroom.DTO.TeacherDTO;
import com.Univerclassroom.services.AccountServices;
import com.Univerclassroom.services.AdminServices;
import com.Univerclassroom.services.FeeStructureServices;
import com.Univerclassroom.services.Mailer;
import com.Univerclassroom.services.ParentServices;
import com.Univerclassroom.services.SchoolAdminServices;
import com.Univerclassroom.services.SchoolServices;
import com.Univerclassroom.services.StudentClassServices;
import com.Univerclassroom.services.StudentServices;
import com.Univerclassroom.services.TeacherServices;

import flexjson.JSONSerializer;

@Controller
@RequestMapping("/SchoolAdmin")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SchoolAdminController {

	@Autowired
	SchoolServices schoolServices;

	@Autowired
	SchoolAdminServices Schooladminservices;

	@Autowired
	AdminServices adminservices;

	@Autowired
	FeeStructureServices feeStructureServices;

	@Autowired
	AccountServices accountservices;

	@Autowired
	StudentServices studentServices;

	@Autowired
	ParentServices parentServices;

	@Autowired
	TeacherServices teacherServices;
	
	@Autowired
	StudentClassServices studentClassServices;
	
	public static HashMap<String, String> map = new HashMap<String, String>();

	public static HashMap<String, String> userMap = new HashMap<String, String>();

	@RequestMapping(value = "/addSchoolAdmin/", method = RequestMethod.POST, headers = "content-type=application/json")
	public @ResponseBody void add(@RequestBody SchoolAdminDTO SchooladminDTO,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Map<String, Object> obj = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		SchoolAdmin Schooladmin = new SchoolAdmin(SchooladminDTO);
		AdminController lg = new AdminController();

		HashMap<String, String> map = lg.getHashmap();
		Object value = map.get(SchooladminDTO.getSessionId());
		Object id = map.get("adminId");

		if (value == null) {
			obj.put("Added", "unsuccessful");
		} else {
			if ((value.toString()).equals(SchooladminDTO.getSessionId())) {
				if (!Schooladminservices.checkUsername(Schooladmin)) {
					obj.put("School admin added", "unsuccessful");
					obj.put("reason", "username Is Not Unique");
				} else {

					String adminId = id.toString();
					long adminIDD = Long.parseLong(adminId);
					Admin admin = adminservices.getAdminById(adminIDD);
					School school = schoolServices.geSchoolById(SchooladminDTO
							.getSchoolId());

					Schooladmin.setSchool(school);
					Schooladmin.setAdmin(admin);
					Schooladminservices.addSchoolAdmin(Schooladmin);
					obj.put("Added", "successful");

				}
			}

		}

		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(
				new JSONSerializer().exclude("class", "*.class", "authorities")
						.deepSerialize(obj));
	}

	@RequestMapping(value = "/schoolAdminLogin/", method = RequestMethod.POST, headers = "content-type=application/json")
	public @ResponseBody void login(@RequestBody SchoolAdminDTO SchooladminDTO,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Map<String, Object> obj = new HashMap<String, Object>();
		String sessionId = null;

		SchoolAdmin Schooladmin = new SchoolAdmin(SchooladminDTO);

		if (Schooladminservices.login(Schooladmin)) {

			HttpSession sessionn = request.getSession();
			sessionId = sessionn.getId();
			map.put(sessionId, sessionId);
			SchoolAdmin Schooladmin1 = Schooladminservices
					.getSchoolAdminByUsername(Schooladmin.getUsername());
			obj.put("sessionId", sessionId);

			String strI = Long.toString((Schooladmin1.getSchoolAdminId()));
			map.put("SchoolAdminId", strI);
			System.out.println("id" + strI);
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

	@RequestMapping(value = "/getAdmissionList/", method = RequestMethod.POST, headers = "content-type=application/json")
	public @ResponseBody void getAdmissionList(
			@RequestBody SchoolAdminDTO SchooladminDTO,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		SchoolAdminController sac = new SchoolAdminController();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, String> map = sac.getHashmap();
		Object value = map.get(SchooladminDTO.getSessionId());
		List<StudentToParent> stpList = null;
		if (value == null) {
			// obj.put("Added", "unsuccessful");
		} else {
			if ((value.toString()).equals(SchooladminDTO.getSessionId())) {
				stpList = Schooladminservices.getAdmissionList();
				for (StudentToParent studentToParent : stpList) {
					HashMap<String, Object> obj = new HashMap<String, Object>();
					obj.put("Id", studentToParent.getId());
					obj.put("StudentName", studentToParent.getStudent()
							.getStudentFirstName()
							+ " "
							+ studentToParent.getStudent().getStudentLastName());
					obj.put("Class", studentToParent.getStudent()
							.getClassAdmission());
					obj.put("ParentName", studentToParent.getParent()
							.getFatherFirstName()
							+ " "
							+ studentToParent.getParent().getFatherLastName());
					obj.put("ParentEmail", studentToParent.getParent()
							.getParentEmailId());
					list.add(obj);
				}
			}

		}
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(
				new JSONSerializer().exclude("class", "*.class", "authorities")
						.deepSerialize(list));
	}

	@RequestMapping(value = "/saveAdmissionResult/", method = RequestMethod.POST, headers = "content-type=application/json")
	public @ResponseBody void saveAdmissionResult(
			@RequestBody AdmissionResultDTO ard, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> obj = new HashMap<String, Object>();
		SchoolAdminController sac = new SchoolAdminController();
		HashMap<String, String> map = sac.getHashmap();
		Object value = map.get(ard.getSessionId());
		AdmissionResult ar = new AdmissionResult(ard);

		if (value == null) {
			// obj.put("Added", "unsuccessful");
		} else {
			if ((value.toString()).equals(ard.getSessionId())) {
				StudentToParent stp = Schooladminservices
						.getStudentToParentById(ard.getAdmissionId());
				ar.setStp(stp);
				boolean flag = Schooladminservices.addAdmissionResult(ar);
				if (flag) {
					String parentEmail = stp.getParent().getParentEmailId();
					String msg = "your child is eligible for admission.Rank is "+ ar.getRank() + "and mark is " + ar.getMark();
					String header = "About Admission Eligibility";
					 String[] args = {parentEmail,msg,header};
					 Mailer.main(args);
					
					obj.put("Admission Result", "added");
				} else {
					obj.put("Admission Result", "Not added");
				}
			}
		}
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(
				new JSONSerializer().exclude("class", "*.class", "authorities")
						.deepSerialize(obj));

	}

	@RequestMapping(value = "/feeStructure/", method = RequestMethod.POST, headers = "content-type=application/json")
	public @ResponseBody void feeStructure(@RequestBody FeeStructureDTO feeDTO,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		Map<String, Object> obj = new HashMap<String, Object>();
		SchoolAdminController sac = new SchoolAdminController();
		HashMap<String, String> map = sac.getHashmap();
		Object value = map.get(feeDTO.getSessionId());
		List<FeeStructure> feeList = null;
		boolean isList = false;
		boolean isDelete = false;
		if (value == null) {

		} else {
			if ((value.toString()).equals(feeDTO.getSessionId())) {
				if (feeDTO.getAction().equals("add")) {
					boolean flag = false;
					FeeStructure fee = new FeeStructure(feeDTO);
					boolean isUnique = feeStructureServices
							.checkClassUnique(fee);
					if (isUnique) {
						flag = feeStructureServices.addFeeStructure(fee);
					} else {
						obj.put("Class", "Not unique");
					}
					if (isUnique && flag) {
						obj.put("Fee", "Added");
					} else {
						obj.put("Fee", "Not Added");
					}
				}
				if (feeDTO.getAction().equals("update")) {
					boolean flag = false;
					FeeStructure fee = feeStructureServices
							.getFeeStructurebyClassname(feeDTO.getClassName());
					fee.setFee(feeDTO.getFee());
					fee.setYear(feeDTO.getYear());

					flag = feeStructureServices.addFeeStructure(fee);

					if (flag) {
						obj.put("Fee", "Updated");
					} else {
						obj.put("Fee", "Not updated");
					}
				}
				if (feeDTO.getAction().equals("list")) {
					isList = true;
					feeList = feeStructureServices.getFeeStructureList();
					for (FeeStructure fee : feeList) {
						HashMap<String, Object> object = new HashMap<String, Object>();
						object.put("Id", fee.getId());
						object.put("ClassName", fee.getClassName());
						object.put("year", fee.getYear());
						object.put("fee", fee.getFee());
						list.add(object);
					}
				}
				if (feeDTO.getAction().equals("delete")) {
					isDelete = true;
					// FeeStructure fee =
					// feeStructureServices.getFeeStructureById(feeDTO.getFeeId());
					boolean flag = feeStructureServices
							.deleteFeeStructure(feeDTO.getFeeId());
					if (flag) {
						obj.put("Fee", "deleted");
					}
				}
			}

		}
		if (isList) {
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().print(
					new JSONSerializer().exclude("class", "*.class",
							"authorities").deepSerialize(list));
		} else {
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().print(
					new JSONSerializer().exclude("class", "*.class",
							"authorities").deepSerialize(obj));
		}

	}

	@RequestMapping(value = "/account/", method = RequestMethod.POST, headers = "content-type=application/json")
	public @ResponseBody void account(@RequestBody AccountDTO accountDTO,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolAdminController sac = new SchoolAdminController();
		HashMap<String, String> map = sac.getHashmap();
		Object value = map.get(accountDTO.getSessionId());
		Map<String, Object> obj = new HashMap<String, Object>();
		Object id = map.get("SchoolAdminId");
		String adminId = id.toString();
		long adminIDD = Long.parseLong(adminId);
		SchoolAdmin schoolAdmin = Schooladminservices
				.getSchoolAdminById(adminIDD);
		if (value == null) {

		} else {
			if ((value.toString()).equals(accountDTO.getSessionId())) {
				if (accountDTO.getAction().equals("add")){
					Account account = new Account();
					StudentToParent stp = Schooladminservices
							.getStudentToParentById(accountDTO.getAdmissionId());
					FeeStructure feeStructure = feeStructureServices
							.getFeeStructurebyClassname(stp.getStudent()
									.getClassAdmission());
					long remainingFee = feeStructure.getFee()
							- accountDTO.getPaidFee();
					account.setStp(stp);
					ArrayList<Integer> fee = new ArrayList<Integer>();
					fee.add(accountDTO.getPaidFee());
					account.setPaidFee(fee);
					account.setRemainingFee(remainingFee);
					ArrayList<String> recipt = new ArrayList<String>();
					recipt.add(accountDTO.getPaymentReceipt());
					account.setPaymentRecipt(recipt);
					if (remainingFee > 0) {
						account.setNextDate(accountDTO.getNextDate());
					}
					account.setAdmissionConfirm(accountDTO.isAdmissionConfirm());
					account.setSchoolAdmin(schoolAdmin);
					boolean flag = false;
					flag = accountservices.addAccount(account);
					// set username and password
					if (accountDTO.isAdmissionConfirm()) {
						boolean isRollNoUnique = studentServices
								.checkRollNo(accountDTO.getRollNo());
						boolean isStudentUsernameUnique = studentServices
								.checkUsername(accountDTO.getStudentUsername());
						boolean isParentUsernameUnique = parentServices
								.checkUsername(accountDTO.getParentUsername());
						if (isRollNoUnique && isStudentUsernameUnique
								&& isParentUsernameUnique) {
							Student student = stp.getStudent();
							student.setRollNo(accountDTO.getRollNo());
							student.setStudentUsername(accountDTO
									.getStudentUsername());
							student.setStudentPassword(accountDTO
									.getStudentPassword());
								student.setSchooladmin(schoolAdmin);								student.setSchooladmin(schoolAdmin);

							String studeEmail = student.getStudentEmailId();
							String msg = "your admission is confirmed. Credentials are below:\n"+"Roll No:"+student.getRollNo() +"\nUsername: "+student.getStudentUsername() +"\nPassword: "+student.getStudentPassword();
							String header = "About Admission Confirmation";
							 String[] args = {studeEmail,msg,header};
							 Mailer.main(args);
							studentServices.addOrUpdateStudent(student);
							Parent parent = stp.getParent();
							parent.setParentUsername(accountDTO
									.getParentUsername());
							parent.setParentPassword(accountDTO
									.getParentPassword());
							String parentEmail = parent.getParentEmailId();
							String parentmsg = "your child's admission is confirmed. Credentials are below:\n" +"\nUsername: "+parent.getParentUsername() +"\nPassword: "+parent.getParentPassword();
							String parentheader = "About Admission Confirmation";
							 String[] argss = {parentEmail,parentmsg,parentheader};
							 Mailer.main(argss);
							parentServices.addOrUpdateParent(parent);
						}
					}

					if (flag) {
						obj.put("Fee", "Added");
					} else {
						obj.put("Fee", "Error");
					}
					response.setContentType("application/json; charset=UTF-8");
					response.getWriter().print(
							new JSONSerializer().exclude("class", "*.class",
									"authorities").deepSerialize(obj));
				}
				if (accountDTO.getAction().equals("update")){
					Account account = accountservices.getAccountById(accountDTO.getId());
					ArrayList<Integer> fee = account.getPaidFee();
					fee.add(accountDTO.getPaidFee());
					account.setPaidFee(fee);
					ArrayList<String> receipt = account.getPaymentRecipt();
					account.setPaymentRecipt(receipt);
					long remainingFee = account.getRemainingFee();
					long pendingFee = remainingFee - accountDTO.getPaidFee();
					if(pendingFee > 0){
						account.setNextDate(accountDTO.getNextDate());
						account.setRemainingFee(pendingFee);
					}
					boolean isAdmissionConfirm = account.isAdmissionConfirm();
					if(isAdmissionConfirm ==  false){
						account.setAdmissionConfirm(accountDTO.isAdmissionConfirm());
						StudentToParent stp = account.getStp();
						boolean isRollNoUnique = studentServices
								.checkRollNo(accountDTO.getRollNo());
						boolean isStudentUsernameUnique = studentServices
								.checkUsername(accountDTO.getStudentUsername());
						boolean isParentUsernameUnique = parentServices
								.checkUsername(accountDTO.getParentUsername());
						if (isRollNoUnique && isStudentUsernameUnique
								&& isParentUsernameUnique) {
							Student student = stp.getStudent();
							student.setRollNo(accountDTO.getRollNo());
							student.setStudentUsername(accountDTO
									.getStudentUsername());
							student.setStudentPassword(accountDTO
									.getStudentPassword());
							studentServices.addOrUpdateStudent(student);
							Parent parent = stp.getParent();
							parent.setParentUsername(accountDTO
									.getParentUsername());
							parent.setParentPassword(accountDTO
									.getParentPassword());
							parentServices.addOrUpdateParent(parent);
					}
					
				}
					boolean flag = accountservices.addAccount(account);
					if(flag){
						obj.put("Fee", "updated");
					}else{
						obj.put("Fee", "Not Updated");
					}
					response.setContentType("application/json; charset=UTF-8");
					response.getWriter().print(
							new JSONSerializer().exclude("class", "*.class",
									"authorities").deepSerialize(obj));
			}
		}
		}
	}
	
	@RequestMapping(value = "/Teacher/", method = RequestMethod.POST, headers = "content-type=application/json")
	public @ResponseBody void addTeacher(@RequestBody TeacherDTO teacherDTO,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolAdminController sac = new SchoolAdminController();
		HashMap<String, String> map = sac.getHashmap();
		Object value = map.get(teacherDTO.getSessionId());
		Map<String, Object> obj = new HashMap<String, Object>();
		Object id = map.get("SchoolAdminId");
		String adminId = id.toString();
		long adminIDD = Long.parseLong(adminId);
		SchoolAdmin schoolAdmin = Schooladminservices
				.getSchoolAdminById(adminIDD);
		boolean isUnique = false;
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		if (value == null) {

		} else {
			if ((value.toString()).equals(teacherDTO.getSessionId())) {
				if (teacherDTO.getAction().equals("add")){
				Teacher teacher = new Teacher(teacherDTO);
				isUnique = teacherServices.checkUsername(teacherDTO.getTeacherUsername());
				if(isUnique){
				teacher.setSchoolAdmin(schoolAdmin);
				boolean flag = Schooladminservices.addTeacher(teacher);
				if(flag){
					obj.put("Teacher", "Added");
				}
				}else{
					obj.put("Teacher", "Not Added");
				}
				response.setContentType("application/json; charset=UTF-8");
				response.getWriter().print(
						new JSONSerializer().exclude("class", "*.class",
								"authorities").deepSerialize(obj));
				}
				if (teacherDTO.getAction().equals("list")){
					//get list of teacher by school admin id
					List<Teacher> teacherList = teacherServices.getTeacherListById(adminIDD);
					int k = 0;
					for (Teacher teacher : teacherList) {
						HashMap<String, Object> object = new HashMap<String, Object>();
						object.put("teacherFirstName", teacher.getTeacherFirstName());
						object.put("teacherLastName", teacher.getTeacherLastName());
						object.put("Id", teacher.getId());
						object.put("mobileNo", teacher.getMobileNo());
						object.put("address", teacher.getAddress());
						object.put("emailId", teacher.getEmailId());
						list.add(object);
					}
					response.setContentType("application/json; charset=UTF-8");
					response.getWriter().print(
							new JSONSerializer().exclude("class", "*.class",
									"authorities").deepSerialize(list));
				}
				if (teacherDTO.getAction().equals("delete")){
					boolean flag = teacherServices.deleteTeacher(teacherDTO.getTeacherId());
							
					if (flag) {
						obj.put("Teacher", "deleted");
					}
					response.setContentType("application/json; charset=UTF-8");
					response.getWriter().print(
							new JSONSerializer().exclude("class", "*.class",
									"authorities").deepSerialize(obj));
				}
			}
		}
		
	}
	
	
	@RequestMapping(value = "/Student/", method = RequestMethod.POST, headers = "content-type=application/json")
	public @ResponseBody void Student(@RequestBody StudentDTO studentDTO,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolAdminController sac = new SchoolAdminController();
		HashMap<String, String> map = sac.getHashmap();
		Object value = map.get(studentDTO.getSessionId());
		Map<String, Object> obj = new HashMap<String, Object>();
		Object id = map.get("SchoolAdminId");
		String adminId = id.toString();
		long adminIDD = Long.parseLong(adminId);
		SchoolAdmin schoolAdmin = Schooladminservices
				.getSchoolAdminById(adminIDD);
		boolean isUnique = false;
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		if (value == null) {

		} else {
			if ((value.toString()).equals(studentDTO.getSessionId())) {
				if (studentDTO.getAction().equals("list")){
					List<Student> studentList = studentServices.getStudentListBySchoolAdminId(adminIDD);
					int k = 0;
					for (Student student : studentList) {
						HashMap<String, Object> object = new HashMap<String, Object>();
						object.put("StudentFirstName", student.getStudentFirstName());
						object.put("StudentLastName", student.getStudentLastName());
						object.put("Id", student.getStudentId());
						object.put("RollNo", student.getRollNo());
						object.put("emailId", student.getStudentEmailId());
						list.add(object);
					}
					response.setContentType("application/json; charset=UTF-8");
					response.getWriter().print(
							new JSONSerializer().exclude("class", "*.class",
									"authorities").deepSerialize(list));
				}
			}
		}
	}
		
	@RequestMapping(value = "/Class/", method = RequestMethod.POST, headers = "content-type=application/json")
	public @ResponseBody void studentClass(@RequestBody StudentClassDTO studentClassDTO,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		SchoolAdminController sac = new SchoolAdminController();
		HashMap<String, String> map = sac.getHashmap();
		Object value = map.get(studentClassDTO.getSessionId());
		Map<String, Object> obj = new HashMap<String, Object>();
		Object id = map.get("SchoolAdminId");
		String adminId = id.toString();
		long adminIDD = Long.parseLong(adminId);
		SchoolAdmin schoolAdmin = Schooladminservices.getSchoolAdminById(adminIDD);
		
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		if (value == null) {

		} else {
			if ((value.toString()).equals(studentClassDTO.getSessionId())) {
				if (studentClassDTO.getAction().equals("add")){
					StudentClass studentClass = new StudentClass();
					studentClass.setClassName(studentClassDTO.getClassName());
					studentClass.setSchoolAdmin(schoolAdmin);
					boolean flag = studentClassServices.addStudentClass(studentClass);
					if(flag){
						obj.put("StudentClass", "Added");
					}
					}else{
						obj.put("StudentClass", "Not Added");
					}
					response.setContentType("application/json; charset=UTF-8");
					response.getWriter().print(new JSONSerializer().exclude("class", "*.class","authorities").deepSerialize(obj));
				}
			}
		}

		
		
	
	
	
	public HashMap<String, String> getHashmap() {

		return map;
	}
}