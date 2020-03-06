package lv.accenture.bootcamp.webdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import lv.accenture.bootcamp.webdemo.model.Cat;
import lv.accenture.bootcamp.webdemo.repository.CatRepository;

@Controller
public class CatsController {

	@Autowired
	private CatRepository catRepository;
	
	 @GetMapping("/cats")
	    public String catIndex(Model model) {
		 //model.addAttribute("test", "it works!");
		 //<p th:text="${test}"></p> this is according line in the html
		 
		// Cat cat = new Cat(1L,"Muris");
		 //model.addAttribute("cat", cat);
		 
		 List<Cat> cats = catRepository.findAll();
		 
		 model.addAttribute("cats", cats);
	        return "cats-index";
	    }
	 
	 @GetMapping("/cats/add")
	 public String addCatPage () {
		 
		 return "add";
	 }

}
