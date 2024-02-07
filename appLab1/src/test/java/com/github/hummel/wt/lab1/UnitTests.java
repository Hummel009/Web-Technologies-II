package com.github.hummel.wt.lab1;

import com.github.hummel.wt.lab1.task14.content.Book;
import com.github.hummel.wt.lab1.task16.Main;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UnitTests {
	@Test
	void testTask1() {
		double orig = Math.round(com.github.hummel.wt.lab1.task1.Main.calculate(14, 22));
		assertEquals(orig, 14);
	}

	@Test
	void testTask2() {
		var orig = com.github.hummel.wt.lab1.task2.Main.check(-3, 4);
		assertEquals(orig, true);
	}

	@Test
	void testTask3() {
		var orig = com.github.hummel.wt.lab1.task3.Main.fillMap(-1, 1, 0.2);
		assertNotNull(orig);
		assertEquals(orig.size(), 11);
	}

	@Test
	void testTask4() {
		var orig = com.github.hummel.wt.lab1.task4.Main.isPrime(5);
		assertEquals(orig, true);
	}

	@Test
	void testTask5() {
		var orig = com.github.hummel.wt.lab1.task5.Main.findLeastNumberOfElements(new int[]{13, 51, 93, 91, 42, 36, 96, 37, 27, 18});
		assertEquals(orig, 6);
	}

	@Test
	void testTask6() {
		var orig = com.github.hummel.wt.lab1.task6.Main.createMatrix(new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
		assertNotNull(orig);
		assertEquals(orig.length * orig[0].length, 81);
	}

	@Test
	void testTask7() {
		var orig = com.github.hummel.wt.lab1.task7.Main.sort(new double[]{4, 3, 2, 1, 52, 21, 14, 3152, 163, 112, 511, 12, 444, 124, 1, 4, 124, 567});
		assertNotNull(orig);
		assertEquals(orig.length, 18);
	}

	@Test
	void testTask8() {
		var orig = com.github.hummel.wt.lab1.task8.Main.getIndexes(new double[]{1, 2, 3, 4, 5, 6}, new double[]{0, 4, 6, 8, 9, 10});
		assertNotNull(orig);
		assertEquals(orig.size(), 6);
	}

	@Test
	void testTask9() {
		com.github.hummel.wt.lab1.task9.Main.initBucket();
		var orig = com.github.hummel.wt.lab1.task9.Main.getQuantity(com.github.hummel.wt.lab1.task9.Main.bucket, Color.BLUE);
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
		var orig = com.github.hummel.wt.lab1.task15.Main.sort(com.github.hummel.wt.lab1.task15.Main.arr);
		assertNotNull(orig);
		assertEquals(orig.length, 7);
	}

	@Test
	void testTask16() {
		var orig = Main.books;
		assertNotNull(orig);
		assertEquals(orig.size(), 5);
	}
}
