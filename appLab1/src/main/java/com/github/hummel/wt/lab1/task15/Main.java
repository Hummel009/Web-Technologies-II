package com.github.hummel.wt.lab1.task15;

import com.github.hummel.wt.lab1.task15.content.Book;

import java.util.Arrays;

public class Main {
	public static final Book[] arr = {new Book("a", 4), new Book("b", 4), new Book("c", 8), new Book("d", 1), new Book("e", 5), new Book("f", 0), new Book("g", 3)};

	private Main() {
	}

	public static void main(String[] args) {
		var newArr = sort(arr);
		System.out.println(Arrays.toString(newArr));
	}

	public static Book[] sort(Book[] arr) {
		Arrays.sort(arr);
		return arr.clone();
	}
}