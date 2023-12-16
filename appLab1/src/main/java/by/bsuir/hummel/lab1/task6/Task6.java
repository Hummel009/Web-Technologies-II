package by.bsuir.hummel.lab1.task6;

public class Task6 {
	public static void main(String[] args) {
		var matrix = createMatrix(new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
		printMatrix(matrix);
	}

	public static double[][] createMatrix(double[] arr) {
		var n = arr.length;
		var matrix = new double[n][n];

		for (var i = 0; i < n; i++) {
			System.arraycopy(arr, i, matrix[i], i, n - i);
			System.arraycopy(arr, 0, matrix[i], 0, i);
		}

		return matrix;
	}

	public static void printMatrix(double[][] matrix) {
		for (var arr : matrix) {
			for (var item : arr) {
				System.out.printf("%.2f ", item);
			}
			System.out.println();
		}
	}
}
