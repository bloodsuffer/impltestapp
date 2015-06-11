package com.implemica.zavizionov.tasks;

import java.util.ArrayList;
import java.util.List;

public class MyBigInt {

	List<Integer> number = new ArrayList<>();

	public static void main(String[] args) {
		MyBigInt t = new MyBigInt();
		MyBigInt t2 = new MyBigInt();
		t.setValue(36);
		t2.setValue(2);
		System.out.println(t);
		t.addDigit(5, 0);
		System.out.println(t);
		t.addDigit(3, 0);
		System.out.println(t);
		t.addDigit(3, 1);
		System.out.println(t);
		System.out.println(t.number);
		
		

	}

	public void setValue(long value) {
		char[] chars = Long.toString(value).toCharArray();
		number = new ArrayList<>();
		for (int i = chars.length - 1; i >= 0; i--) {
			number.add(Character.digit(chars[i], 10));
		}
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = number.size() - 1; i >= 0; i--) {
				sb.append(number.get(i));
		}
		return sb.toString();
	}

	public void multiply(MyBigInt anotherNumber) {
		MyBigInt newNumber = new MyBigInt();
		for (int i = 0; i < anotherNumber.number.size(); i++) {
			for (int j = 0; j < number.size(); j++) {
				newNumber.add(number.get(j) * anotherNumber.number.get(i), i+j); 
			}
		}
		number = newNumber.number;

	}
	
	public void multiply(int anotherInteger) {
		MyBigInt anotherNumber = new MyBigInt();
		anotherNumber.setValue(anotherInteger);
		multiply(anotherNumber);
	}

	public void addDigit(int n, int power) {
		if(n>9||n<0){
			throw new IllegalArgumentException();
		}
		while (number.size() <= power) {
			number.add(0);
		}
		int currentDigit = number.get(power);
		int nextDigit = 0;
		if (number.size() > power + 1) {
			nextDigit = number.get(power + 1);
		}
		int result = currentDigit + n;
		nextDigit += result / 10;
		currentDigit = result % 10;
		number.set(power, currentDigit);
		if(nextDigit!=0){
			if(number.size() <= power+1){
				number.add(0);
			}
			number.set(power + 1, nextDigit);
		}
		
	}
	
	public void add(MyBigInt anotherNumber, int power){
		for(int i = 0; i<anotherNumber.number.size();i++){
			this.addDigit(anotherNumber.number.get(i), i+power);
		}
	}
	
	public void add(int anotherInteger, int power){
		MyBigInt anotherNumber = new MyBigInt();
		anotherNumber.setValue(anotherInteger);
		add(anotherNumber,power);
	}

}
