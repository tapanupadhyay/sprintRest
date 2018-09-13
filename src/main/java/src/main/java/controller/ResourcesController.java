package src.main.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResourcesController {
	
	@GetMapping("/printHello")
	public String printHello(Model model){
		
		model.addAttribute("name", "Tapan");
		return "welcome";
	}
	
	
}
