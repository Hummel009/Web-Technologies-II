package by.bsuir.hummel.lab1;

import by.bsuir.hummel.lab1.task1.Task1;
import by.bsuir.hummel.lab1.task14.content.Book;
import by.bsuir.hummel.lab1.task15.Task15;
import by.bsuir.hummel.lab1.task16.Task16;
import by.bsuir.hummel.lab1.task2.Task2;
import by.bsuir.hummel.lab1.task3.Task3;
import by.bsuir.hummel.lab1.task4.Task4;
import by.bsuir.hummel.lab1.task5.Task5;
import by.bsuir.hummel.lab1.task6.Task6;
import by.bsuir.hummel.lab1.task7.Task7;
import by.bsuir.hummel.lab1.task8.Task8;
import by.bsuir.hummel.lab1.task9.Task9;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GeneralTest {
	@Test
	void testTask1() {
		double orig = Math.round(Task1.calculate(14, 22));
		assertEquals(orig, 14);
	}

	@Test
	void testTask2() {
		var orig = Task2.check(-3, 4);
		assertEquals(orig, true);
	}

	@Test
	void testTask3() {
		var orig = Task3.fillMap(-1, 1, 0.2);
		assertNotNull(orig);
		assertEquals(orig.size(), 11);
	}

	@Test
	void testTask4() {
		var orig = Task4.isPrime(5);
		assertEquals(orig, true);
	}

	@Test
	void testTask5() {
		var orig = Task5.findLeastNumberOfElements(new int[]{13, 51, 93, 91, 42, 36, 96, 37, 27, 18});
		assertEquals(orig, 6);
	}

	@Test
	void testTask6() {
		var orig = Task6.createMatrix(new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
		assertNotNull(orig);
		assertEquals(orig.length * orig[0].length, 81);
	}

	@Test
	void testTask7() {
		var orig = Task7.sort(new double[]{4, 3, 2, 1, 52, 21, 14, 3152, 163, 112, 511, 12, 444, 124, 1, 4, 124, 567});
		assertNotNull(orig);
		assertEquals(orig.length, 18);
	}

	@Test
	void testTask8() {
		var orig = Task8.getIndexes(new double[]{1, 2, 3, 4, 5, 6}, new double[]{0, 4, 6, 8, 9, 10});
		assertNotNull(orig);
		assertEquals(orig.size(), 6);
	}

	@Test
	void testTask9() {
		Task9.initBucket();
		var orig = Task9.getQuantity(Task9.bucket, Color.BLUE);
		assertEquals(orig, 1);
	}

	@Test
	void testTask14() {
		var book1 = new Book();
		var book2 = (Book) book1.clone();
		assertEquals(book1, book2);
	}

	@Test
	void testTask15() {
		var orig = Task15.sort(Task15.arr);
		assertNotNull(orig);
		assertEquals(orig.length, 7);
	}

	@Test
	void testTask16() {
		var orig = Task16.books;
		assertNotNull(orig);
		assertEquals(orig.size(), 5);
	}
}
