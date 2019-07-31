package com.es.eoi.ExerciseOne;

public class Months {
	public static void main(String[] args) {
		String[] months = new String[12];
		
		months[0] = "January";
		months[1] = "February";
		months[2] = "March";
		months[3] = "April";
		months[4] = "May";
		months[5] = "June";
		months[6] = "July";
		months[7] = "August";
		months[8] = "September";
		months[9] = "October";
		months[10] = "November";
		months[11] = "December";
		
		displayMonths(months);
	}
	
	public static void displayMonths(String[] months) {
		for (int i = 0; i < months.length; i++) {
			int currentMonth = i+1; // Al iniciar i en 0, sumamos 1 para empezar en el primer mes
			System.out.println("The " + currentMonth + " of the year is " + months[i]);
		}
	}
}
