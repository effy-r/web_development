package lv.accenture.bootcamp.webdemo.model;

public class Cat {

	private Long id;
	private String nickname;

	Cat(Long id, String nickname) {
		this.id = id;
		this.nickname = nickname;
	}

	Cat() {
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

}
