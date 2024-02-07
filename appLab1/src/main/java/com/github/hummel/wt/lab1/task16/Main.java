package com.github.hummel.wt.lab1.task16;

import com.github.hummel.wt.lab1.task16.content.AuthorComparator;
import com.github.hummel.wt.lab1.task16.content.Book;
import com.github.hummel.wt.lab1.task16.content.PriceComparator;
import com.github.hummel.wt.lab1.task16.content.TitleComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static final List<Book> books = new ArrayList<>();

	static {
		books.add(new Book("title4", "author3", 14));
		books.add(new Book("title3", "author6", 9));
		books.add(new Book("title2", "author0", 4));
		books.add(new Book("title1", "author-1", 1));
		books.add(new Book("title0", "author312", 4));
	}

	public static void main(String[] args) {
		Comparator<Book> titleComparator = new TitleComparator();
		var titleAuthorComparator = new TitleComparator().thenComparing(new AuthorComparator());
		var authorTitleComparator = new AuthorComparator().thenComparing(new TitleComparator());
		var authorTitlePriceComparator = new AuthorComparator().thenComparing(new TitleComparator().thenComparing(new PriceComparator()));


		books.sort(titleComparator);
		System.out.println(books);
		books.sort(titleAuthorComparator);
		System.out.println(books);
		books.sort(authorTitleComparator);
		System.out.println(books);
		books.sort(authorTitlePriceComparator);
		System.out.println(books);
	}
}
