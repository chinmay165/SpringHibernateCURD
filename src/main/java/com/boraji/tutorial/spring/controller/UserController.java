package com.boraji.tutorial.spring.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boraji.pojo.Employeepojo;
import com.boraji.pojo.Userpojo;
import com.boraji.tutorial.spring.model.EmployeeEnty;
import com.boraji.tutorial.spring.model.User;
import com.boraji.tutorial.spring.service.EmpService;
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

     // model.addAttribute("empEnty", new EmployeeEnty());
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
}
