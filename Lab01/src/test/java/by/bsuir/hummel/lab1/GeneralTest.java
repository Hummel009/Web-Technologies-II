package by.bsuir.hummel.lab1;

import by.bsuir.hummel.lab1.task1.Task1;
import by.bsuir.hummel.lab1.task2.Task2;
import by.bsuir.hummel.lab1.task3.Task3;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GeneralTest {
	@Test
	void testTask1() {
		double orig = Math.round(Task1.calculate(14, 22));
		double res = 14;
		assertEquals(orig, res);
	}

	@Test
	void testTask2() {
		boolean orig = Task2.check(-3, 4);
		boolean res = true;
		assertEquals(orig, res);
	}

	@Test
	void testTask3() {
		Map<Double, Double> res = Task3.fillMap(-1, 1, 0.2);
		assertNotNull(res);
		assertEquals(11, res.size());
	}
}
