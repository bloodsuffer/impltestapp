package com.implemica.zavizionov.tasks;

import java.math.BigInteger;

/**
 * Calculates the sum of digits of 100! in two ways - with Javas BigInteger
 * class and my own simple kind of BigInt.
 * 
 * @author Zavizionov A.
 *
 */
public class Task3 {

	public static void main(String[] args) {
		long start = System.nanoTime();
		BigInteger big = factorial(100);
		String bigString = big.toString();
		int sum = sumOfDigits(bigString);
		long time = System.nanoTime() - start;
		System.out.println("----- Do it java way -----");
		System.out.println("Calculated number is:");
		System.out.println(bigString);
		System.out.printf("Sum of its digits is: %s \n", sum);
		System.out.printf("Calculation time is: %d \n", time);
		start = System.nanoTime();
		MyBigInt myBig = myFactorial(100);
		String myBigString = myBig.toString();
		int mySum = sumOfDigits(myBigString);
		long myTime = System.nanoTime() - start;
		System.out.println("----- Now we do it my way -----");
		System.out.println("Calculated number is:");
		System.out.println(myBigString);
		System.out.printf("Sum of its digits is: %s \n", mySum);
		System.out.printf("Calculation time is: %d \n", myTime);
		System.out.printf("Can see, that java way is %d times faster", myTime
				/ time);
	}

	/**
	 * Calculates factorial using Java BigInteger class.
	 * 
	 * @param n
	 * @return facrotial of n
	 */
	public static BigInteger factorial(int n) {
		BigInteger big = BigInteger.valueOf(1);
		MyBigInt myBig = new MyBigInt();
		myBig.setValue(1);
		for (int i = 1; i <= n; i++) {
			big = big.multiply(BigInteger.valueOf(i));
		}
		return big;
	}

	/**
	 * Calculates factorial using my own kind of BigInt
	 * 
	 * @param n
	 * @return factorial of n
	 */
	public static MyBigInt myFactorial(int n) {
		MyBigInt big = new MyBigInt();
		big.setValue(1);
		for (int i = 1; i <= n; i++) {
			big.multiply(i);
		}
		return big;
	}

	/**
	 * Calculates sum of digits in given string
	 * 
	 * @param str
	 *            - string with some number
	 * @return
	 */
	public static int sumOfDigits(String str) {
		int sum = 0;
		for (char c : str.toCharArray()) {
			sum += Integer.parseInt(Character.toString(c));
		}
		return sum;
	}

}
