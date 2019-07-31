package com.es.eoi.ExerciseOne;

public class Maths {

	public static void main(String[] args) {
		
		double a = Double.valueOf(args[0]);
		double b = Double.valueOf(args[1]);
		double c = Double.valueOf(args[2]);
		double d = Double.valueOf(args[3]);
		
		double operation = (a/b) * (c/d);
		
		System.out.println("The result of the operation is: " + operation);
	}

}
