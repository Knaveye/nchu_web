package webadv.s16203122.p4;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {		
    private List<String> tasks = Arrays.asList("Jakarta EE", "Maven", "Gradle", "Spring", "Bootstrap", "jQuery", "MyBatis","Redis");    
    @GetMapping("/")
		public String welcome(Model model) {    	
        model.addAttribute("tasks", tasks);  
        return "welcome";		
		}
    
    @RequestMapping(value="/ajax",produces={"text/html;charset=UTF-8;"})
    @ResponseBody 
    public String ajax() {      
    	System.out.println("welcome");
        return "AjaxÊµÀý£ºThis is an Ajax example";
    }
}


