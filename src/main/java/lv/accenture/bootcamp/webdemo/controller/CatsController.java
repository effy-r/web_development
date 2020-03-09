package lv.accenture.bootcamp.webdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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

		Iterable<Cat> cats = catRepository.findAll();

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
		catRepository.save(catToAdd);
		return "redirect:/cats";
	}

	@GetMapping("cats/edit/{id}")
	public String editCatPage(@PathVariable Long id, Model model) {
		// System.out.println("id =" + id);
		Optional<Cat> catToEdit = catRepository.findById(id);
		model.addAttribute("cat", catToEdit.get());

		return "edit-cat";

	}

	@PostMapping("/cats/edit-cat/{id}")
	public String editCat(@PathVariable Long id, Cat editedCat) {

		editedCat.setId(id);
		catRepository.save(editedCat);

		return "redirect:/cats";
	}

	@GetMapping("cats/delete/{id}")
	public String deleteCatPage(@PathVariable Long id, Cat deletedCat) {
		
		//not sure if it works. teachers example has findbyID
		Optional<Cat> catToEdit = catRepository.findById(id);
		catRepository.delete(deletedCat);

		return "redirect:/cats";

	}

	@GetMapping("cats/search")
	public String searchCats(@RequestParam String catName, Model model) {
		
		List<Cat> matchedCats =  (List<Cat>) catRepository.findByNickname(catName);
		model.addAttribute("cats", matchedCats);

		return "cats-index";

	}

}
