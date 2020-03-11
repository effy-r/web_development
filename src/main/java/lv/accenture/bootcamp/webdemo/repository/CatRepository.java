package lv.accenture.bootcamp.webdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lv.accenture.bootcamp.webdemo.model.Cat;

@Repository
public interface CatRepository extends CrudRepository<Cat, Long> {

	@Query("Select c FROM Cat c Where c.nickname LIKE %:nickname%")
	
	//List<Cat> findByNicknameContainingIgnoreCase(String catName);
	List<Cat> findByNickname(@Param(value="nickname")String catName);

	//how can function find it like %...%
	//change the function name

}
