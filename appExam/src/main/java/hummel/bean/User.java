package hummel.bean;

import java.util.Objects;

public class User {
	private String name;
	private String age;

	public User() {
		name = "";
		age = "";
	}

	public User(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" + "name='" + name + '\'' + ", age='" + age + '\'' + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return Objects.equals(name, user.name) && Objects.equals(age, user.age);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}
}
