package by.bsuir.hummel.lab1.task7;

import java.util.Arrays;

public class Task7 {
	public static void main(String[] args) {
		double[] arr = {4, 3, 2, 1, 52, 21, 14, 3152, 163, 112, 511, 12, 444, 124, 1, 4, 124, 567};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(double[] arr) {
		int h = 1;
		while (h * 3 < arr.length) {
			h = h * 3 + 1;
		}
		while (h >= 1) {
			bump(arr, h);
			h = h / 3;
		}
	}

	private static void bump(double[] arr, int h) {
		for (int i = h; i < arr.length; i++) {
			for (int j = i; j >= h; j = j - h) {
				if (arr[j] < arr[j - h]) {
					double temp = arr[j];
					arr[j] = arr[j - h];
					arr[j - h] = temp;
				} else {
					break;
				}
			}
		}
	}
}
