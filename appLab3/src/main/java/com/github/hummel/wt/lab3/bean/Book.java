package com.github.hummel.wt.lab3.bean;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "books", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "imagePath")
	private String imagePath;

	@Column(name = "author")
	private String author;

	@Column(name = "price")
	private double price;

	public static Builder builder() {
		return new Builder();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		var other = (Book) obj;
		return id == other.id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	public static class Builder {
		private final Book instance = new Book();

		public Builder author(String author) {
			instance.author = author;
			return this;
		}

		public Book build() {
			return instance;
		}

		public Builder description(String description) {
			instance.description = description;
			return this;
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

		public Builder price(double price) {
			instance.price = price;
			return this;
		}
	}
}