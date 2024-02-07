package com.github.hummel.wt.lab1.task8;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
	private Main() {
	}

	public static void main(String[] args) {
		var list = getIndexes(new double[]{1, 2, 3, 4, 5, 6}, new double[]{0, 4, 6, 8, 9, 10});
		System.out.println(list);
	}

	public static Collection<Double> getIndexes(double[] arr1, double[] arr2) {
		Collection<Double> list = new ArrayList<>();
		for (var d : arr2) {
			list.add(binarySearching(arr1, 0, arr1.length - 1, d));
		}
		return list;
	}

	private static double binarySearching(double[] arr, int leftBorder, int rightBorder, double sElem) {
		var leftBorder1 = leftBorder;
		if (sElem <= arr[leftBorder1]) {
			return leftBorder1;
		}
		var rightBorder1 = rightBorder;
		if (sElem >= arr[rightBorder1]) {
			return rightBorder1;
		}
		var m = -1;
		while (leftBorder1 <= rightBorder1) {
			m = (leftBorder1 + rightBorder1) / 2;
			if (sElem >= arr[m] && sElem < arr[m + 1]) {
				return m + 1;
			}
			if (sElem < arr[m]) {
				rightBorder1 = m - 1;
			}
			if (sElem > arr[m]) {
				leftBorder1 = m + 1;
			}
		}
		return m;
	}
}
