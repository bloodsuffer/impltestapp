package com.implemica.zavizionov.tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * My own simple class to manage the big integer numbers. Designed mainly to
 * help to compute factorial.
 * 
 * @author Zavizionov A.
 *
 */
public class MyBigInt {

	/**
	 * Every integer in position represents a single digit.
	 */
	List<Integer> number = new ArrayList<>();

	/**
	 * Sets the value of BigInt the same as the given long.
	 * 
	 * @param value
	 */
	public void setValue(long value) {
		//convert String to char array
		char[] chars = Long.toString(value).toCharArray();
		number = new ArrayList<>();
		//add every digit sequentially to list of digits
		for (int i = chars.length - 1; i >= 0; i--) {
			number.add(Character.digit(chars[i], 10));
		}
	}

	/**
	 * Returns a string representation of number.
	 * 
	 * @return String with number
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = number.size() - 1; i >= 0; i--) {
			sb.append(number.get(i));
		}
		return sb.toString();
	}

	/**
	 * Multiplies this number anotherNumber times.
	 * 
	 * @param anotherNumber
	 *            - another BigInt
	 */
	public void multiply(MyBigInt anotherNumber) {
		MyBigInt newNumber = new MyBigInt();
		for (int i = 0; i < anotherNumber.number.size(); i++) {
			for (int j = 0; j < number.size(); j++) {
				//multiply like we did it at school
				newNumber.add(number.get(j) * anotherNumber.number.get(i), i
						+ j);
			}
		}
		number = newNumber.number;

	}

	/**
	 * Multiplies this number anotherInteger times.
	 * 
	 * @param anotherInteger
	 *            - another BigInt
	 */
	public void multiply(int anotherInteger) {
		//simply creates big int from int 
		//and call overloaded method
		MyBigInt anotherNumber = new MyBigInt();
		anotherNumber.setValue(anotherInteger);
		multiply(anotherNumber);
	}

	/**
	 * Adds a single digit to BigInt number.
	 * 
	 * @param n
	 *            - single digit.
	 * @param power
	 *            - position of digit
	 */
	public void addDigit(int n, int power) {
		//check if it's not a digit
		if (n > 9 || n < 0) {
			throw new IllegalArgumentException();
		}
		//make sure that we have enough positions
		//in list for digits
		while (number.size() <= power) {
			number.add(0);
		}
		int currentDigit = number.get(power);
		int nextDigit = 0;
		if (number.size() > power + 1) {
			nextDigit = number.get(power + 1);
		}
		int result = currentDigit + n;
		//add tens to next digit
		nextDigit += result / 10;
		//add a modulo of 10 to current digit
		currentDigit = result % 10;
		number.set(power, currentDigit);
		//make sure that next digit have changed
		//and position for it exists
		if (nextDigit != 0) {
			if (number.size() <= power + 1) {
				number.add(0);
			}
			number.set(power + 1, nextDigit);
		}

	}
	
	/**
	 * Adds another BigInt to this one.
	 * @param anotherNumber - another BigInt
	 * @param power - power of 10 for anotherNumber
	 */
	public void add(MyBigInt anotherNumber, int power) {
		//add every digit separately
		for (int i = 0; i < anotherNumber.number.size(); i++) {
			this.addDigit(anotherNumber.number.get(i), i + power);
		}
	}

	/**
	 * Adds integer to this BigInt one.
	 * @param anotherNumber - integer number
	 * @param power - power of 10 for integer
	 */
	public void add(int anotherInteger, int power) {
		//create BigInt and call overloaded method
		MyBigInt anotherNumber = new MyBigInt();
		anotherNumber.setValue(anotherInteger);
		add(anotherNumber, power);
	}

}
