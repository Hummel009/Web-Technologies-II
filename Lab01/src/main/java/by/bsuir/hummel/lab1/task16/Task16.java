package by.bsuir.hummel.lab1.task16;

import by.bsuir.hummel.lab1.task16.content.AuthorComparator;
import by.bsuir.hummel.lab1.task16.content.Book;
import by.bsuir.hummel.lab1.task16.content.PriceComparator;
import by.bsuir.hummel.lab1.task16.content.TitleComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task16 {
	public static List<Book> books = new ArrayList<>();

	static {
		books.add(new Book("title4", "author3", 14));
		books.add(new Book("title3", "author6", 9));
		books.add(new Book("title2", "author0", 4));
		books.add(new Book("title1", "author-1", 1));
		books.add(new Book("title0", "author312", 4));
	}

	public static void main(String[] args) {
		Comparator<Book> titleComparator = new TitleComparator();
		Comparator<Book> titleAuthorComparator = new TitleComparator().thenComparing(new AuthorComparator());
		Comparator<Book> authorTitleComparator = new AuthorComparator().thenComparing(new TitleComparator());
		Comparator<Book> authorTitlePriceComparator = new AuthorComparator().thenComparing(new TitleComparator().thenComparing(new PriceComparator()));


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
