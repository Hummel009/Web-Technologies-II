package com.github.hummel.wt.lab1.task2;


public class Main {
	private Main() {
	}

	public static void main(String[] args) {
		System.out.println(check(-3, 4));
	}

	public static boolean check(int x, int y) {
		return checkLowerPart(x, y) || checkUpperPart(x, y);
	}

	private static boolean checkLowerPart(int x, int y) {
		return x >= -6 && x <= 6 && y >= -3 && y <= 0;
	}

	private static boolean checkUpperPart(int x, int y) {
		return x >= -4 && x <= 4 && y >= 0 && y <= 5;
	}
}