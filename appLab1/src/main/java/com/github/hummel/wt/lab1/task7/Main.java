package com.github.hummel.wt.lab1.task7;

import java.util.Arrays;

public class Main {
	private Main() {
	}

	public static void main(String[] args) {
		var arr = sort(new double[]{4, 3, 2, 1, 52, 21, 14, 3152, 163, 112, 511, 12, 444, 124, 1, 4, 124, 567});
		System.out.println(Arrays.toString(arr));
	}

	public static double[] sort(double[] arr) {
		var h = 1;
		while (h * 3 < arr.length) {
			h = h * 3 + 1;
		}
		while (h >= 1) {
			bump(arr, h);
			h /= 3;
		}
		return arr.clone();
	}

	private static void bump(double[] arr, int h) {
		for (var i = h; i < arr.length; i++) {
			for (var j = i; j >= h; j -= h) {
				if (arr[j] < arr[j - h]) {
					var temp = arr[j];
					arr[j] = arr[j - h];
					arr[j - h] = temp;
				} else {
					break;
				}
			}
		}
	}
}
