package lv.accenture.bootcamp.webdemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;



@Entity
public class Cat implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(min = 2, max = 256)
	private String nickname;
	@NotNull (message = "Age should be added!")
	@PositiveOrZero (message = "Age should be a natural number!")
	private Integer age;
	private String photo;

	public Cat(Long id, String nickname) {
		this.id = id;
		this.nickname = nickname;
	}

	public Cat(Long id, String nickname, Integer age, String photo) {
		this.id = id;
		this.nickname = nickname;
		this.age = age;
		this.photo = photo;
	}

	public Cat() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
