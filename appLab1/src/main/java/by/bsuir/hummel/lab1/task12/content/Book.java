package by.bsuir.hummel.lab1.task12.content;

import java.util.Objects;

public class Book {
	private static int edition;
	private String title;
	private String author;
	private int price;

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