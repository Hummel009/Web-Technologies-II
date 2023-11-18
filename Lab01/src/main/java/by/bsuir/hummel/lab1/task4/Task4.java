package by.bsuir.hummel.lab1.task4;

import java.math.BigInteger;

public class Task4 {
	public static void main(String[] args) {
		printIndexesOfPrimeNumbers(new int[]{1, 2, 3, 4});
	}

	private static void printIndexesOfPrimeNumbers(int[] arr) {
		var hasPrimeNumbers = false;
		for (var item : arr) {
			if (isPrime(item)) {
				hasPrimeNumbers = true;
				System.out.println(item);
			}
		}
		if (!hasPrimeNumbers) {
			System.out.println("There are no prime numbers!");
		}
	}

	public static boolean isPrime(int n) {
		var bigInt = BigInteger.valueOf(n);
		return bigInt.isProbablePrime(95);
	}
}