package com.github.hummel.wt.lab1.task16.content;

import java.util.Objects;

public class Book {
	private static int edition;
	private final String title;
	private String author;
	private int price;

	public Book(String title) {
		this.title = title;
	}

	public Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, author, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		var book = (Book) obj;
		return price == book.price && Objects.equals(title, book.title) && Objects.equals(author, book.author);
	}

	@Override
	public String toString() {
		return "Book{" + "title='" + title + '\'' + ", author='" + author + '\'' + ", price=" + price + '}';
	}
}
