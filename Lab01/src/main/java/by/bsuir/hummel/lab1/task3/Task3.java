package by.bsuir.hummel.lab1.task3;

import java.util.HashMap;
import java.util.Map;

public class Task3 {
	public static void main(String[] args) {
		Map<Double, Double> results = fillMap(-1, 1, 0.2);

		System.out.println("-------------------");
		for (Map.Entry<Double, Double> entry : results.entrySet()) {
			System.out.format("| %.4f | %.4f |\n", entry.getKey(), entry.getValue());
		}
		System.out.println("-------------------");
	}

	public static Map<Double, Double> fillMap(double a, double b, double h) {
		Map<Double, Double> results = new HashMap<>();
		for (double x = a; x <= b; x += h) {
			results.put(x, Math.tan(x));
		}
		return results;
	}
}
