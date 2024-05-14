package com.github.hummel.wt.lab1.task15.content;

import java.util.Objects;

public class Book implements Comparable<Book> {
	private static int edition;
	private final String author;
	private final int isbn;
	private String title;
	private int price;

	public Book(String author, int isbn) {
		this.author = author;
		this.isbn = isbn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, author, price, isbn);
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
		return price == book.price && isbn == book.isbn && Objects.equals(title, book.title) && Objects.equals(author, book.author);
	}

	@Override
	public String toString() {
		return "Book{" + "title='" + title + '\'' + ", author='" + author + '\'' + ", price=" + price + ", isbn=" + isbn + '}';
	}

	@SuppressWarnings("SubtractionInCompareTo")
	@Override
	public int compareTo(Book o) {
		return isbn - o.isbn;
	}
}
