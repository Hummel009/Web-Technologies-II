package by.bsuir.lab1.task12;

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
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Book book = (Book) o;
		return price == book.price && title.equals(book.title) && author.equals(book.author);
	}

	@Override
	public String toString() {
		return "Book{" + "title='" + title + '\'' + ", author='" + author + '\'' + ", price=" + price + '}';
	}
}