package com.implemica.zavizionov.tasks;

import java.math.BigInteger;

public class Task3 {
	

	public static void main(String[] args) {
		BigInteger big = factorial(100);
		String bigString = big.toString();
		System.out.println(sumOfDigits(bigString));	
	}
	
	public static BigInteger factorial(int n){
		BigInteger big = BigInteger.valueOf(1);
		for (int i = 1; i <= n; i++) {
			big = big.multiply(BigInteger.valueOf(i));
		}
		return big;
	}
	
	public static int sumOfDigits(String str){
		int sum = 0;
		for (char c : str.toCharArray()){
			sum += Integer.parseInt(Character.toString(c));
		}
		return sum;
	}
	

}
