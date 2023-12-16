package hummel.bean;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "authors", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "imagePath")
	private String imagePath;

	public static Builder builder() {
		return new Builder();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		var other = (Author) obj;
		return Objects.equals(id, other.id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	public static class Builder {
		private Author instance = new Author();

		public Author build() {
			return instance;
		}

		public Builder id(int id) {
			instance.id = id;
			return this;
		}

		public Builder imagePath(String imagePath) {
			instance.imagePath = imagePath;
			return this;
		}

		public Builder name(String name) {
			instance.name = name;
			return this;
		}
	}
}