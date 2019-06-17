package webadv.s162031.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import webadv.s162031.demo.util.Operation;

@Controller
public class HomeController {
	Random random = new Random();
	@GetMapping("/")
	public String index(Model model) {
		String[] list = {"+","-","*","/"};  //运算符号
	
		int num = random.nextInt(10); //总共多少题
		List<Operation> numlist =new ArrayList();
		Operation operation = null;
		for(int i=0;i<num;i++) {
			operation =new Operation();
			operation.setM(random.nextInt(20));
			operation.setN(random.nextInt(15)+1);//防止除数为0
			operation.setOp(list[random.nextInt(4)]);
			
			numlist.add(operation);
			
			System.out.print("M:"+operation.getM()+";N:"+operation.getN()+",OP:"+operation.getClass());
		}
		
		model.addAttribute("list",numlist);
		
		return "index";
	}
	

}
