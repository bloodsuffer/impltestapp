package com.implemica.zavizionov.tasks.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.implemica.zavizionov.tasks.MyBigInt;

public class Task3Tests {

	
	@Test
	public void addDigitTest(){
		MyBigInt bint = new MyBigInt();
		bint.setValue(39);
		bint.addDigit(8, 0);
		assertEquals(Integer.parseInt(bint.toString()), 47);
		bint.addDigit(1, 0);
		assertEquals(Integer.parseInt(bint.toString()), 48);
		bint.addDigit(5, 1);
		assertEquals(Integer.parseInt(bint.toString()), 98);
		bint.addDigit(3, 3);
		assertEquals(Integer.parseInt(bint.toString()), 3098);
	}
	
	@Test
	public void addTest(){
		MyBigInt bint1 = new MyBigInt();
		MyBigInt bint2 = new MyBigInt();
		bint1.setValue(39);
		bint2.setValue(21);
		bint1.add(bint2,0);
		assertEquals(Integer.parseInt(bint1.toString()), 60);
		bint2.setValue(5893);
		bint1.add(bint2,0);
		assertEquals(Integer.parseInt(bint1.toString()), 5953);
		bint2.setValue(31);
		bint1.add(bint2,2);
		assertEquals(Integer.parseInt(bint1.toString()), 9053);
	}
	@Test
	public void multiplyTest(){
		MyBigInt bint1 = new MyBigInt();
		MyBigInt bint2 = new MyBigInt();
		bint1.setValue(12);
		bint2.setValue(15);
		bint1.multiply(bint2);
		assertEquals(Integer.parseInt(bint1.toString()), 180);
		
	}

}
