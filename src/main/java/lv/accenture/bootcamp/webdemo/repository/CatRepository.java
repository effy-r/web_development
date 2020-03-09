package lv.accenture.bootcamp.webdemo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lv.accenture.bootcamp.webdemo.model.Cat;

@Component
public class CatRepository {

	private List<Cat> cats = new ArrayList<>();

	public CatRepository() {
		cats.add(new Cat(1L, "Kitty", 3,
				"https://www.motherjones.com/wp-content/uploads/legacy/washington_dispatch/2008/01/socks-hillary-clinton-250x200.jpg?w=990"));
		cats.add(new Cat(2L, "Garfield", 5, "https://images-na.ssl-images-amazon.com/images/I/51cTtYTNR3L.jpg"));
		cats.add(new Cat(3L, "Donald", 1,
				"https://www.masslive.com/resizer/CAVqJHn78UxYXn4uxhhgttnV3Gs=/450x0/smart/arc-anglerfish-arc2-prod-advancelocal.s3.amazonaws.com/public/7IIEZASSYJFRBM2IBU3HJ5FZT4.jpg"));
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

	public void edit(Cat editedCat) {

		for (int i = 0; i < cats.size(); i++) {

			if (cats.get(i).getId().equals(editedCat.getId())) {

				cats.set(i, editedCat);

				return;
			}

		}
		throw new IllegalArgumentException("Cat by Id: " + editedCat.getId() + "not found");

//		for (Cat cat : cats) {
//			if (cat.getId().equals(editedCat.getId())) {
//
//				cat.setNickname(editedCat.getNickname());
//				break;
//			}
		// }

	}

	public void delete(Cat deletedCat) {

		for (int i = 0; i < cats.size(); i++) {

			if (cats.get(i).getId().equals(deletedCat.getId())) {

				cats.remove(i);

				return;
			}

		}
		throw new IllegalArgumentException("Cat by Id: " + deletedCat.getId() + "not found");

		// TODO Auto-generated method stub

	}

	public List<lv.accenture.bootcamp.webdemo.model.Cat> findByNickname(String catName) {
		// TODO Auto-generated method stub

		List<Cat> catResults = new ArrayList<Cat>();

		for (int i = 0; i < cats.size(); i++) {

			if (cats.get(i).getNickname().equalsIgnoreCase(catName)) {

				catResults.add(cats.get(i));

			}

		}
		return catResults;

	}

}
