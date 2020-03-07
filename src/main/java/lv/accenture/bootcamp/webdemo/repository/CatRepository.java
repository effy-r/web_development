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

	public List<Cat> findAll() {

		return cats;
	}

	public void add(Cat catToAdd) {
		// TODO Auto-generated method stub
		// find biggest id and +1
		// give a new id to incoming cat
		// add incoming cat to the list

		Cat biggestCat = cats.get(0);

		for (int i = 0; i < cats.size(); i++) {
			if (cats.get(i).getId() > biggestCat.getId()) {
				biggestCat = cats.get(i);

			} else {
				continue;
			}
		}

		Long newId = biggestCat.getId() + 1;
		catToAdd.setId(newId);
		cats.add(catToAdd);

		// Long maxId=0L;
		// for(Cat c: cats){
		//

	}

	public Cat findById(Long id) {

		// Cat foundCat = new Cat();

		for (Cat cat : cats) {
			if (cat.getId().equals(id)) {
				// foundCat = cats.get(i);
				// break;
				return cat;
			} 
		}
		
				throw new IllegalArgumentException("Cat by Id: " + id + "not found");
				
		
		}
		// return foundCat;
	}

