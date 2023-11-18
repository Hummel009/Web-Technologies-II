package by.bsuir.hummel.lab1.task1;

public class Task1 {
	public static void main(String[] args) {
		System.out.println(calculate(14, 22));
	}

	public static double calculate(double x, double y) {
		var numerator = 1 + Math.pow(Math.sin(x + y), 2);
		return numerator / (2 + Math.abs(x - 2 * x / (1 + Math.pow(x, 2) * Math.pow(y, 2)))) + x;
	}
}