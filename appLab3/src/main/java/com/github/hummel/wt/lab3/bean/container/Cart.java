package com.github.hummel.wt.lab3.bean.container;

import com.github.hummel.wt.lab3.bean.Book;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private final List<Book> books = new ArrayList<>();

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

	public double getSummaryPrice() {
		double sum = 0;
		for (var book : books) {
			sum += book.getPrice();
		}
		return sum;
	}

	public boolean isEmpty() {
		return books.isEmpty();
	}

	public void removeBook(int id) {
		var iterator = books.iterator();
		while (iterator.hasNext()) {
			var book = iterator.next();
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