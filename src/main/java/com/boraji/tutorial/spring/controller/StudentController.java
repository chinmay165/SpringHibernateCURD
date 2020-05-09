package com.boraji.tutorial.spring.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boraji.pojo.StudentP;
import com.boraji.tutorial.spring.model.StudentE;
import com.boraji.tutorial.spring.model.User;
import com.boraji.tutorial.spring.service.StudentSer;
import com.boraji.tutorial.spring.service.StudentSerImp;

@Controller
public class StudentController {

	@Autowired
	private StudentSer stdSer;
	
	
	@GetMapping("/student")
	   public String userForm(Locale locale, Model model) {

			model.addAttribute("welcomeMsg", "Welcome to Student Portal");
	        model.addAttribute("stdEy", new StudentE());
	        model.addAttribute("stdSers", stdSer.list());

	      return "studentForm";
	   }
	
	@PostMapping("/saveStudent")
		public String saveStudent(@ModelAttribute @Valid StudentP stdP,Model model) {
				stdSer.saveStudent(stdP);
		return "redirect:student";
	}
	
	@GetMapping("/editStudent")
		public String editStudent(@ModelAttribute @RequestParam long hid_cId,Model model) {
			//StudentE stdE = stdSer.getStudentDetails(hid_cId);
				model.addAttribute("stdData", stdSer.getStudentDetails(hid_cId));
		return "editStudent";
	}
	
	@PostMapping("/updateStudent")
		public String updateStudentData(@ModelAttribute @Valid StudentP stdP, Model model) {
				stdSer.updateStudentData(stdP);
		return "redirect:student";
	}
	
	@PostMapping("/deleteStudent")
		public String deleteStudentData(@ModelAttribute @RequestParam long hid_cId, Model model) {
			String resultMsg = 	stdSer.deleteStudentData(hid_cId);
			System.out.println("delete msg  "+resultMsg);
			model.addAttribute("msg", resultMsg);
			
			model.addAttribute("welcomeMsg", "Welcome to Student Portal");
	        model.addAttribute("stdEy", new StudentE());
	        model.addAttribute("stdSers", stdSer.list());
		return "studentForm";
	}
}
