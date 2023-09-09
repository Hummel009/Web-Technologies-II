package by.bsuir.hummel.lab1.task15.content;

import java.util.Objects;

public class Book implements Comparable<Book> {
	private static int edition;
	private String title;
	private String author;
	private int price;
	private int isbn;

	public Book(String author, int isbn) {
		this.author = author;
		this.isbn = isbn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, author, price, isbn);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Book book = (Book) o;
		return price == book.price && isbn == book.isbn && Objects.equals(title, book.title) && Objects.equals(author, book.author);
	}

	@Override
	public String toString() {
		return "Book{" + "title='" + title + '\'' + ", author='" + author + '\'' + ", price=" + price + ", isbn=" + isbn + '}';
	}

	@Override
	public int compareTo(Book o) {
		return isbn - o.isbn;
	}
}
