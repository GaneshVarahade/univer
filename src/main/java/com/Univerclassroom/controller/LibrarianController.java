package com.Univerclassroom.controller;

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

import com.Univerclassroom.DTO.LibrarianDTO;
import com.Univerclassroom.DTO.SchoolAdminDTO;
import com.Univerclassroom.DTO.SchoolDTO;
import com.Univerclassroom.model.Admin;
import com.Univerclassroom.model.Book;
import com.Univerclassroom.model.Librarian;
import com.Univerclassroom.model.School;
import com.Univerclassroom.model.SchoolAdmin;
import com.Univerclassroom.model.Student;
import com.Univerclassroom.services.LibrarianServices;
import com.Univerclassroom.services.SchoolAdminServices;
import com.Univerclassroom.services.StudentServices;

import flexjson.JSONSerializer;


@Controller
@RequestMapping("/Librarian")
@JsonIgnoreProperties(ignoreUnknown = true)
public class LibrarianController {

	
	@Autowired
	SchoolAdminServices Schooladminservices;
	
	@Autowired
	LibrarianServices Librarianservices;
	
	@Autowired
	StudentServices studentServices;
	
	
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
		 if(value == null){
		      obj.put("Added", "unsuccessful");
		 } else{
				if ((value.toString()).equals(librarianDTO.getSessionId())) {
		      String SchoolAdminId = id.toString();
			  long SchoolAdminId1 = Long.parseLong(SchoolAdminId);
			  
			  SchoolAdmin schoolAdmin =  Schooladminservices.getSchoolAdminById(SchoolAdminId1);
			  System.out.println("id"+schoolAdmin);
			 librarian.setSchoolAdmin(schoolAdmin);
			  Librarianservices.addLibrarian(librarian);
			 obj.put("Added", "successful");
				}
		      }

		  response.setContentType("application/json; charset=UTF-8"); 
			response.getWriter().print(new JSONSerializer().exclude("class","*.class","authorities").deepSerialize(obj));
	}
	
	

	@RequestMapping(value = "/librarianLogin/", method = RequestMethod.POST, headers = "content-type=application/json")
	public @ResponseBody
	void login(@RequestBody LibrarianDTO librarianDTO,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		
		
		Map<String,Object> obj = new HashMap<String,Object>();
		 String sessionId = null;
		
		 Librarian librarian=new Librarian(librarianDTO);
		
		
	        if( Librarianservices.login(librarian))	 
	        { 
	        	
	  	
			 HttpSession sessionn = request.getSession();
			 sessionId = sessionn.getId();
			 map.put(sessionId, sessionId);
			 Librarian Librarian1=Librarianservices.getLibrarianByUsername(librarian.getUsername());
			 obj.put("sessionId", sessionId);
			 String strI = Long.toString((Librarian1.getLibrarianId()));
			 map.put("LibrarianId",strI);
			 obj.put("login", "successful");
	        }
			
	      
	        
			else
			{
				obj.put("login", "unsuccessful");
			}
			response.setContentType("application/json; charset=UTF-8");	
			response.getWriter().print(new JSONSerializer().exclude("class","*.class","authorities").deepSerialize(obj));
		
		
		
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/addBooks/", method = RequestMethod.POST,  headers = "content-type=application/json")
	public @ResponseBody
	void add1(@RequestBody LibrarianDTO librarianDTO,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		Map<String,Object> obj = new HashMap<String,Object>();
		 @SuppressWarnings("unused")
		 Librarian librarian=new Librarian(librarianDTO);
     	LibrarianController lg = new LibrarianController();
		 HashMap<String, String> map = lg.getHashmap();
		 Object value = map.get(librarianDTO.getSessionId());
		 Object id = map.get("LibrarianId");		 
		 if(value == null){
		      obj.put("BookAdded", "unsuccessful");
		 } else{
			 if ((value.toString()).equals(librarianDTO.getSessionId())) {
		      String LibrarianId = id.toString();
			  long LibrarianId1 = Long.parseLong(LibrarianId);
			  
			   librarian =  Librarianservices.getLibrarianById(LibrarianId1);
			 
			   Book book = new Book(librarianDTO);
			   book.setLibrarian(librarian);
			  Librarianservices.addBook(book);
			 obj.put("BookAdded", "successful");
			 }
		      }

		  response.setContentType("application/json; charset=UTF-8"); 
			response.getWriter().print(new JSONSerializer().exclude("class","*.class","authorities").deepSerialize(obj));
	
	
	
	}
	
	
	@RequestMapping(value = "/bookList/", method = RequestMethod.POST,  headers = "content-type=application/json")
	public @ResponseBody
	void listBooks(@RequestBody LibrarianDTO librarianDTO,HttpServletRequest request,HttpServletResponse response) throws Exception {

	
	Map<String,Object> obj = new HashMap<String,Object>();
	List<Map<String,Object>> ListofBooks = new ArrayList<Map<String,Object>>();	
	LibrarianController lg = new LibrarianController();
	 HashMap<String, String> map = lg.getHashmap();
	 Object value1= map.get("LibrarianId");
	 
	 Object value = map.get(librarianDTO.getSessionId());
	 if(value == null){
		 
	 }else{
	 } 
	 if ((value.toString()).equals(librarianDTO.getSessionId())) {
	 String LibrarianId = value1.toString();
	  long LibrarianId1 = Long.parseLong(LibrarianId);
	  System.out.println("id"+LibrarianId1);
	 List<Book> BookList =Librarianservices.getBookListByLibId(LibrarianId1);
		for (Book book : BookList) {
	   Map<String,Object> map1 = new HashMap<String, Object>();
	   
	   map1.put("ID", book.getUniqueIdentifier());
	   map1.put("Author", book.getAuthor());
	   map1.put("AuthorAddress", book.getAuthorAddress());
	   map1.put("AuthorEmail", book.getAuthorEmail());
	   map1.put("ISBN", book.getISBN());
	   map1.put("Title", book.getTitle());
	   map1.put("SpecialSectionTitle", book.getSpecialSectionTitle());
	   map1.put("SupplementalMaterial", book.getSupplementalMaterial());
	   map1.put("BookType", book.getBookType());
	   map1.put("DigitalObjectIdentifier", book.getDigitalObjectIdentifier());
	   map1.put("DocumentType", book.getDocumentType());
	   map1.put("Language", book.getLanguage());
	   map1.put("AudienceType", book.getAudienceType());
	   map1.put("Location", book.getLocation());
	   map1.put("Methodology", book.getMethodology());
	   map1.put("PageCount", book.getPageCount());
	   map1.put("PublicationDate", book.getPublicationDate());
	   map1.put("PublicationType", book.getPublicationType());
	   map1.put("PublisherName", book.getPublisherName());
	   map1.put("ReleaseDate", book.getReleaseDate());
	   map1.put("Source", book.getSource());
	   
	   
	   
	   
	   ListofBooks.add(map1);
		}
		obj.put("BookList", ListofBooks);	
	 }
		response.setContentType("application/json; charset=UTF-8"); 
		response.getWriter().print(new JSONSerializer().exclude("class","*.class","authorities").deepSerialize(obj));
}

	@RequestMapping(value = "/bookSearch/", method = RequestMethod.POST,  headers = "content-type=application/json")
	void searchBooks(@RequestBody LibrarianDTO librarianDTO,HttpServletRequest request,HttpServletResponse response) throws Exception {

		
		Map<String,Object> obj = new HashMap<String,Object>();
		List<Map<String,Object>> ListofBooks = new ArrayList<Map<String,Object>>();	
		LibrarianController lg = new LibrarianController();
		 HashMap<String, String> map = lg.getHashmap();
		 Object value = map.get(librarianDTO.getSessionId());
		 Object value1=librarianDTO.getTitle();
		
		 Object value2= map.get("LibrarianId");
		if (value == null || value1 == null) {
			obj.put("Added", "unsuccessful");
		} else {
			if ((value.toString()).equals(librarianDTO.getSessionId())) {
				
				
				 String LibrarianId = value2.toString();
				  long LibrarianId1 = Long.parseLong(LibrarianId);
		 List<Book> BookList =Librarianservices.getBookListByTitle(librarianDTO.getTitle(), LibrarianId1);
		 
		 
			for(Book book : BookList) {				
		   Map<String,Object> map1 = new HashMap<String, Object>();
		   
		   map1.put("ID", book.getUniqueIdentifier());
		   map1.put("Author", book.getAuthor());
		   map1.put("ISBN", book.getISBN()); 
		   map1.put("PageCount", book.getPageCount());
		   map1.put("PublicationDate", book.getPublicationDate());
		  
			
		   
		   
		   ListofBooks.add(map1);
			}
			
			obj.put("BookList", ListofBooks);	
		 }
		}
			response.setContentType("application/json; charset=UTF-8"); 
			response.getWriter().print(new JSONSerializer().exclude("class","*.class","authorities").deepSerialize(obj));
		   
		   
	}
	

	@RequestMapping(value = "/studentList/", method = RequestMethod.POST,  headers = "content-type=application/json")
	void StudentList(@RequestBody LibrarianDTO librarianDTO,HttpServletRequest request,HttpServletResponse response) throws Exception {
		Map<String,Object> obj = new HashMap<String,Object>();
		LibrarianController lg = new LibrarianController();
		 HashMap<String, String> map = lg.getHashmap();
		 Object value = map.get(librarianDTO.getSessionId());
		 
			List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		 Object value2= map.get("LibrarianId");
		if (value == null ) {
			obj.put("Added", "unsuccessful");
		} else {
			if ((value.toString()).equals(librarianDTO.getSessionId())) {
				
				
				 String LibrarianId = value2.toString();
				  long LibrarianId1 = Long.parseLong(LibrarianId);
				  Librarian lib = Librarianservices.getLibrarianById(LibrarianId1);
				  SchoolAdmin schoolAdmin = lib.getSchoolAdmin();
				  List<Student> studentList = studentServices.getStudentListBySchoolAdminId(schoolAdmin.getSchoolAdminId());
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
	
public HashMap<String, String> getHashmap() {
	    
	    return map;
	}
}


