package webadv.example;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Lab2ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() throws Exception {
		MvcResult result = mockMvc
		.perform(MockMvcRequestBuilders.get("/task/1"))
        .andExpect(MockMvcResultMatchers.status().isOk()) 
        .andDo(MockMvcResultHandlers.print())  
		//.andExpect(jsonPath("$.content", Matcher.matcher))
        .andReturn();		

	}

}
