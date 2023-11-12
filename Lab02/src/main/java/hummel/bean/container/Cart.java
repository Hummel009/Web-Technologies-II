package hummel.bean.container;

import hummel.bean.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public strictfp class Cart {
	private final List<Book> books = new ArrayList<Book>();

	public void addBook(Book book) {
		if (!books.contains(book)) {
			books.add(book);
		}
	}

	public void clear() {
		books.clear();
	}

	public List<Book> getBooks() {
		return books;
	}

	public strictfp double getSummaryPrice() {
		double sum = 0;
		for (Book book : books) {
			sum = sum + book.getPrice();
		}
		return sum;
	}

	public boolean isEmpty() {
		return books.isEmpty();
	}

	public void removeBook(int id) {
		Iterator<Book> iterator = books.iterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			if (book.getId() == id) {
				iterator.remove();
				break;
			}
		}
	}

	public int size() {
		return books.size();
	}
}