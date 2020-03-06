package lv.accenture.bootcamp.webdemo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lv.accenture.bootcamp.webdemo.model.Cat;

@Component
public class CatRepository {

	private List<Cat> cats = new ArrayList<>();

	public CatRepository() {
		cats.add(new Cat(2L, "Kitty"));
		cats.add(new Cat(3L, "Donald"));
	}
	
	public List<Cat> findAll(){
		
		return cats;
	}
}
