package webadv.s162031.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import webadv.s162031.demo.util.Operation;
import webadv.s162031.demo.util.Result;

@Controller
public class HomeController {
	private Random random = new Random();
	private static Result result1 = new Result();
	@GetMapping("/")
	public String index(Model model) {
		String[] list = {"+","-","*","/"};  //运算符号
	
		int num = random.nextInt(10)+1; //总共多少题
		List<Operation> numlist =new ArrayList();
		Operation operation = null;
		List<String> reslsit =new ArrayList<>();
		for(int i=0;i<num;i++) {
			operation =new Operation();
			operation.setM(random.nextInt(20));
			operation.setN(random.nextInt(15)+1);//防止除数为0
			operation.setOp(list[random.nextInt(4)]);
			reslsit.add(operation.getResult());
			numlist.add(operation);	
		}
	
		result1.setS(reslsit);
				
		model.addAttribute("numlist",numlist);
		model.addAttribute("re",new Result());
		return "index";
	}
	@PostMapping("/getresult")
	public String getresult(Model model,@Validated Result result) {
		
		int rightnum=0;
		for(int i=0;i<result.getS().size();i++) {
			if(result1.getS().get(i).equals(result.getS().get(i))) {
				rightnum++;
			}
		}
		model.addAttribute("rightnum",rightnum);
		model.addAttribute("right",result1);
		model.addAttribute("you",result);
		return "result";
	}

}

