package com.boraji.tutorial.spring.controller;

import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.PostRemove;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boraji.pojo.Bookpojo;
import com.boraji.pojo.Employeepojo;
import com.boraji.pojo.Registerpojo;
import com.boraji.pojo.Userpojo;
import com.boraji.tutorial.spring.model.BookEnty;
import com.boraji.tutorial.spring.model.EmployeeEnty;
import com.boraji.tutorial.spring.model.RegisterEnty;
import com.boraji.tutorial.spring.model.User;
import com.boraji.tutorial.spring.service.BookService;
import com.boraji.tutorial.spring.service.EmpService;
import com.boraji.tutorial.spring.service.RegService;
import com.boraji.tutorial.spring.service.UserService;

/**
 * @author imssbora
 */
@Controller
public class UserController {

   @Autowired
   private UserService userService;
   @Autowired
   private EmpService empServeice;
   @Autowired
   private RegService regService;
   @Autowired
   private BookService bookService;
   

   @GetMapping("/")
   public String userForm(Locale locale, Model model) {

      model.addAttribute("user", new User());
      model.addAttribute("users", userService.list());

      return "userForm";
   }

   @PostMapping("/saveUser")
   public String saveUser(@ModelAttribute @Valid Userpojo userpojo,
         BindingResult result, Model model) {

      if (result.hasErrors()) {
         
         model.addAttribute("users", userService.list());
         return "userForm";
      }

      userService.save(userpojo);

      return "redirect:/";
   }
   
   @GetMapping("/employee")
   public String employeeForm(Locale locale, Model model) {

      model.addAttribute("empEnty", new EmployeeEnty());
      model.addAttribute("empSer", empServeice.list());

      return "empForm";
   }
  
   @PostMapping("/deleteEmp")
   public String deleteEmployee(Model model, @RequestParam String empid) {	
	   	 String result =  empServeice.deleteEmployee(empid);
	   	 model.addAttribute("msg",result);
	   	 
	 return "redirect:/employee";
	   
   }
   @PostMapping("/saveEmployee")
   public String saveEmployee(@ModelAttribute @Valid Employeepojo empojo,
         BindingResult result, Model model) {

      if (result.hasErrors()) {
         
         model.addAttribute("empSer", empServeice.list());
         return "empForm";
      }

      empServeice.save(empojo);

      return "redirect:/employee";
   }
   
   @GetMapping("/editEmp")
   public String editEmpForm(Locale locale, Model model, @RequestParam String empid) {

     
		   	model.addAttribute("edit", empServeice.getEmpbyID(empid));     
		      return "editEmp";
	   
      
   }
   
   @PostMapping("/updateEmp")
   public String updateEmployee(@ModelAttribute @Valid Employeepojo empojo,
         BindingResult result, Model model) {

      if (result.hasErrors()) {
         
         model.addAttribute("empSer", empServeice.list());
         return "empForm";
      }

      empServeice.update(empojo);

      return "redirect:/employee";
   }
   
   // Registration Form OPerations
   
   @GetMapping("/register")
   public String registerData(Model model) {
	   
	   model.addAttribute("regEnty", new RegisterEnty());
	   model.addAttribute("regSer", regService.list());
	   return "registrationForm";
   }
   
   
   @PostMapping("/saveData")
   public String saveRegister(@ModelAttribute @Valid Registerpojo regpojo,
         BindingResult result, Model model) {

      if (result.hasErrors()) {
         
         model.addAttribute("regSer", regService.list());
         return "registrationForm";
      }

      	regService.saveRegister(regpojo);

      return "redirect:/register";
   }

   @GetMapping("/editReg")
   public String editRegisterForm(Model model, @RequestParam Long hid_regId) {

     
		   	model.addAttribute("editReg", regService.getEmpbyID(hid_regId));     
		      return "editRegister";
	        
   }
   
   @PostMapping("/updateData")
   public String updateRegister(@ModelAttribute @Valid Registerpojo regpojo, BindingResult result, Model model) {
	   
	   if (result.hasErrors()) {
	         
	         model.addAttribute("regSer", regService.list());
	         return "editRegister";
	      }
	   System.out.println("update Register method");

	   		regService.updateRegister(regpojo);

	      return "redirect:/register";
   }
   
   @PostMapping("/deleteData")
   public String deleteRegister(Model model, @RequestParam Long hid_regId)
   {
	   String resultMsg = regService.deleteRegister(hid_regId);
	   model.addAttribute("msg", resultMsg);
	   
	   return "redirect:/register";
   }

   // Book CURD 
   
   @GetMapping("/book")
   public void bookForm(Model model) {
	   
	   model.addAttribute("bookEnty", new BookEnty());
	   model.addAttribute("bookSer", bookService.list());
   }
   
   @PostMapping("/saveBook")
   public String saveBook(@ModelAttribute @Valid Bookpojo bpojo, BindingResult result, Model model) {
	   
	   if(result.hasErrors()) {
		   System.out.println("error found");
		   
		   Map<String, String> errors = result.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
		   model.addAttribute("errlist",errors);
		   return "book";
	   }else {
		   bookService.saveBook(bpojo);
		   model.addAttribute("bookSer", bookService.list());
			return "redirect:/book";
	   }
   }   
	
   @GetMapping("/editBook")
	public String editBook(Model model, @RequestParam Long hid_bId) {
		model.addAttribute("bookSer",bookService.getBookDetails(hid_bId));
		return "editBook";
	}
	   
	@PostMapping("/updateBook")
	public String updateBook(@ModelAttribute @Valid Bookpojo bpojo, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
	        
			Map<String, String> errors = result.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
		   model.addAttribute("errlist",errors);
	         
	         return "editBook";
	      }else {
	   System.out.println("update Book method");
	   //model.addAttribute("bookSer", bookService.list());
	   		bookService.updateBook(bpojo);

	      return "redirect:/book";

	      	}
	}
	
	@PostMapping("/deleteBook")
	public String deteleBook(Model model, @RequestParam Long hid_bId)
	{
		String result = bookService.deteleBook(hid_bId);
		model.addAttribute("msg", result);
		
		return "redirect:/book";
	}
   
}
