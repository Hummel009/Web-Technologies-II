package com.github.hummel.wt.lab1.task3;

import java.util.HashMap;
import java.util.Map;

public class Main {
	private Main() {
	}

	public static void main(String[] args) {
		var results = fillMap(-1, 1, 0.2);

		System.out.println("-------------------");
		for (var entry : results.entrySet()) {
			System.out.format("| %.4f | %.4f |\n", entry.getKey(), entry.getValue());
		}
		System.out.println("-------------------");
	}

	public static Map<Double, Double> fillMap(double a, double b, double h) {
		Map<Double, Double> results = new HashMap<>();
		for (var x = a; x <= b; x += h) {
			results.put(x, Math.tan(x));
		}
		return results;
	}
}
