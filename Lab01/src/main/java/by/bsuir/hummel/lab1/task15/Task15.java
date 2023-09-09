package by.bsuir.hummel.lab1.task15;

import by.bsuir.hummel.lab1.task15.content.Book;

import java.util.Arrays;

public class Task15 {
	public static void main(String[] args) {
		Book[] arr = {new Book("a", 4), new Book("b", 4), new Book("c", 8), new Book("d", 1), new Book("e", 5), new Book("f", 0), new Book("g", 3)};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}