package narayan.embed.tomcat.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A sample controller for demo
 *
 * @author narayan-sambireddy
 */
@RestController
public class AppController {
	
	@PostConstruct
	public void init() throws Exception {
		System.out.println("1 --- " + Thread.currentThread().getContextClassLoader().getResource("classes/alpha.txt"));
		System.out.println("2 --- " + Thread.currentThread().getContextClassLoader().getResource("/classes/alpha.txt"));
		System.out.println("3 --- " + Thread.currentThread().getContextClassLoader().getResource("/BOOT-INF/classes/alpha.txt"));
		
		// WORKING 
		System.out.println("4 --- " + Thread.currentThread().getContextClassLoader().getResource("BOOT-INF/classes/alpha.txt"));
		
		BufferedReader r = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("BOOT-INF/classes/alpha.txt")));
		String line;
		while((line = r.readLine()) != null) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> " + line); 
		
		}
	}
	
    @GetMapping
    public String hello() {
        return "Hello from App";
    }

}
