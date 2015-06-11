package com.implemica.zavizionov.tasks;

import java.util.ArrayList;
import java.util.List;

public class MyBigInt {

	List<Integer> number = new ArrayList<>();
	List<Integer> anotherNumber = new ArrayList<>();

	public static void main(String[] args) {
		MyBigInt t = new MyBigInt();
		MyBigInt t2 = new MyBigInt();
		t.setValue(1);
		t2.setValue(2);
		t.multiply(t2);
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

	public void multiply(MyBigInt another) {
		int result = 0;
		for (int i = 0; i < another.number.size(); i++) {
			for (int j = 0; j < number.size(); j++) {
				result += number.get(j)*another.number.get(i);
			}
		}
		
	}
	



}
