package by.bsuir.hummel.lab1.task6;

public class Task6 {
	public static void main(String[] args) {
		printMatrix(new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
	}

	public static void printMatrix(double[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				System.out.printf("%.2f ", arr[j]);
			}
			for (int k = 0; k < i; k++) {
				System.out.printf("%.2f ", arr[k]);
			}
			System.out.println();
		}
	}
}
