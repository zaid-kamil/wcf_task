package com.wipro.talentnext.day2;

import com.wipro.talentnext.Calculator;

public class ArithmeticOperation {
 public static void main(String[] args) {
	Operation op = (a, b) -> (a * b);
	System.out.println(op.performCalc(10,23));
}
}
