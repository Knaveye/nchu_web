package webadv.example.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

	 private List<String> tasks = Arrays.asList("Git", "Maven", "Gradle", "Spring", "Bootstrap", "jQuery", "MyBatis","Redis");
	   
	
@GetMapping("/task/{id}")
    public Task task(@PathVariable (value="id") int id) {
	
        return new Task(id,tasks.get(id-1));
    }
}

