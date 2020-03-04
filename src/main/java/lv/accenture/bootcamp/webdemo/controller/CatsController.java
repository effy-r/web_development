package lv.accenture.bootcamp.webdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatsController {

	
	 @GetMapping("/cats")
	    public String toCats() {
	        return "cats-index";
	    }

}
