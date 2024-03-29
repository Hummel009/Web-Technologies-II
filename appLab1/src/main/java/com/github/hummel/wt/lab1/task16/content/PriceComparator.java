package com.github.hummel.wt.lab1.task16.content;

import java.util.Comparator;

public class PriceComparator implements Comparator<Book> {
	@SuppressWarnings("SubtractionInCompareTo")
	@Override
	public int compare(Book o1, Book o2) {
		return o1.getPrice() - o2.getPrice();
	}
}
