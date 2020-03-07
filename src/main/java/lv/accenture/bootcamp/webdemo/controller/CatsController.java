package lv.accenture.bootcamp.webdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import lv.accenture.bootcamp.webdemo.model.Cat;
import lv.accenture.bootcamp.webdemo.repository.CatRepository;

@Controller
public class CatsController {

	@Autowired
	private CatRepository catRepository;

	@GetMapping("/cats")
	public String catIndex(Model model) {
		// model.addAttribute("test", "it works!");
		// <p th:text="${test}"></p> this is according line in the html

		// Cat cat = new Cat(1L,"Muris");
		// model.addAttribute("cat", cat);

		List<Cat> cats = catRepository.findAll();

		model.addAttribute("cats", cats);
		return "cats-index";
	}

	@GetMapping("/cats/add")
	public String addCatPage(Model model) {
		model.addAttribute("cat", new Cat());

		return "add-cat";
	}

	@PostMapping("/cats/add-cat")
	public String addCat(Cat catToAdd) {
		catRepository.add(catToAdd);
		return "redirect:/cats";
	}

	@GetMapping("cats/edit/{id}")
	public String editCatPage(@PathVariable Long id, Model model) {
		// System.out.println("id =" + id);
		Cat catToEdit = catRepository.findById(id);
		model.addAttribute("cat", catToEdit);

		return "edit-cat";

	}

	@PostMapping("/cats/edit-cat/{id}")
	public String editCat(@PathVariable Long id, Cat editedCat) {

		editedCat.setId(id);
		System.out.println("changed nickname" + editedCat.getNickname());
		System.out.println("id: " + editedCat.getId());
		catRepository.edit(editedCat);
		return "redirect:/cats";
	}
}
