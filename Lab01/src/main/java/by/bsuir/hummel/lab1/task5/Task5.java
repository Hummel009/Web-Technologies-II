package by.bsuir.hummel.lab1.task5;

public class Task5 {
	public static void main(String[] args) {
		System.out.println(findLeastNumberOfElements(new int[]{13, 51, 93, 91, 42, 36, 96, 37, 27, 18}));
		System.out.println(findLeastNumberOfElements(new int[]{1, 2, 3, 4, 5, 6}));
	}

	public static int findLeastNumberOfElements(int[] arr) {
		var isSort = true;
		for (var i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				isSort = false;
				break;
			}
		}

		if (isSort) {
			return 0;
		}

		var n = arr.length;
		var length = 0;
		final var MIN = -2147483648;
		final var MAX = 2147483647;

		var extraArray = new int[n];
		extraArray[0] = MIN;
		for (var i = 1; i < n; i++) {
			extraArray[i] = MAX;
		}

		for (var i = 0; i < n - 1; i++) {
			var j = binarySearch(extraArray, 0, n - 1, arr[i]);
			if (extraArray[j - 1] < arr[i] && arr[i] < extraArray[j]) {
				extraArray[j] = arr[i];
				length = Math.max(length, j);
			}
		}
		return n - length;
	}

	private static int binarySearch(int[] arr, int l, int r, int sElem) {
		var m = -1;
		if (sElem < arr[l]) {
			return l;
		}
		if (sElem > arr[r]) {
			return r;
		}
		while (l <= r) {
			m = (l + r) / 2;
			if (sElem >= arr[m] && sElem < arr[m + 1]) {
				return m + 1;
			}
			if (sElem < arr[m]) r = m - 1;
			if (sElem > arr[m]) l = m + 1;
		}
		return m;
	}
}