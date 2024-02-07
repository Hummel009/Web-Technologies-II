package com.github.hummel.wt.lab1.task4;

import java.math.BigInteger;

public class Main {
	private Main() {
	}

	public static void main(String[] args) {
		printIndexesOfPrimeNumbers(new int[]{1, 2, 3, 4});
	}

	private static void printIndexesOfPrimeNumbers(int[] arr) {
		var hasNoPrimeNumbers = true;
		for (var item : arr) {
			if (isPrime(item)) {
				hasNoPrimeNumbers = false;
				System.out.println(item);
			}
		}
		if (hasNoPrimeNumbers) {
			System.out.println("There are no prime numbers!");
		}
	}

	public static boolean isPrime(int n) {
		var bigInt = BigInteger.valueOf(n);
		return bigInt.isProbablePrime(95);
	}
}