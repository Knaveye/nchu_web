package webadv.s16203122.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import webadv.s16203122.example.repository.TeacherRepository;
import webadv.s16203122.example.service.TeacherService;

@Controller
public class HomeController {
//	@Autowired
//	private TeacherRepository tr;
	@Autowired
	private TeacherService ts;
	
	@GetMapping("/")
	public String login(Model model) {
			
		return "login";
	}
	
	@GetMapping("/login")
	public String index(Model model){
		//model.addAttribute("teacher_list",tr.findAll());
		model.addAttribute("teacher_list",ts.listTeacher());
		return "plain_page";
		
	}
}
