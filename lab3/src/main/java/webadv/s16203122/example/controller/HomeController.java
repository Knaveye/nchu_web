package webadv.s16203122.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import webadv.s16203122.example.model.User;
import webadv.s16203122.example.util.IsUserExit;

@Controller
public class HomeController implements WebMvcConfigurer {
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
		//registry.addViewController("/").setViewName("login");
       registry.addViewController("/home").setViewName("welcome");
    }
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public ModelAndView initForm(ModelMap model){
	User user=new User(); //����ת����form���Ķ���
	return new ModelAndView("login").addObject(user); //��ת��addCompanyҳ��
		}	
	
@PostMapping("/login")

public String check(@Validated User user, BindingResult bindingResult, Model model) {
	
	if (bindingResult.hasFieldErrors()) {
			model.addAttribute(user);
			return "login";
		}else {
			/*���user�����ж��Ƿ����*/
			boolean isexit = new IsUserExit().isUserExit(user);
			if(isexit) {
				return "welcome";
			}
			model.addAttribute("errors","�û������ڣ�����ע��");
			return "login";
		}
	}

@GetMapping("/register")
public String register(Model model) {
	User user =new User();
	model.addAttribute(user);

	return "register";
}

@PostMapping("/register")
public String register (@Validated User user,BindingResult bindingResult, Model model) {
	if (bindingResult.hasFieldErrors()) {
		model.addAttribute(user);
		return "register";
	}else {
			new IsUserExit().addUser(user);
			model.addAttribute("user",user);
			return "welcome";
	}
}
}
