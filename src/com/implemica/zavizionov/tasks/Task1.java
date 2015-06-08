package com.implemica.zavizionov.tasks;

import java.util.HashMap;
import java.util.Map;

/**
 * This class helps to count, how many valid brace sequences
 * can be combined with N pair of braces.
 * 
 * @author Andrii Z.
 *
 */
public class Task1 {
	/**
	 * Stores already calculated values for optimization,
	 * because this problem has overlapping subproblems.
	 */
	private static Map<Integer, Integer> storage = new HashMap<>();
	
	/**
	 * Testing code.
	 */
	public static void main(String[] args){
		for(int i=2;i<20;i++){
			System.out.println(count(i));
		}
	}
	
	
	/**
	 * Counts, how many valid brace sequences
	 * can be combined with N pair of braces.
	 */	
	public static int count(final int n){
		int result = 0;
		//empty string is a valid sequence
		if (n==0){
			return 1;
		}
		if(storage.containsKey(n)){
			return storage.get(n);
		}
		for(int i=0;i<n;i++){
			//recursion
			result += count(i)*count(n-i-1);
		}
		store(n ,result);
		return result;
	}

	
	/**
	 * Used to store calculated value, if it's not
	 * stored yet.
	 */	
	private static void store(int key, int value) {
		if (!storage.containsKey(key)){
			storage.put(key, value);
		}
	}

	

}
