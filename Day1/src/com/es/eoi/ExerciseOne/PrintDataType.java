package com.es.eoi.ExerciseOne;

public class PrintDataType {

	public static void main(String[] args) {

		DataTypes dataDefaultUser = new DataTypes();
		DataTypes dataFirstUser = new DataTypes("Carmen", "Rodriguez");
		DataTypes dataSecondUser = new DataTypes("Juan", "Rodriguez");
		DataTypes dataThirdUser = new DataTypes("Jorge", "Perez");
		DataTypes dataFourUser = new DataTypes("Clara", "Martinez");

		DataTypes[] dataArray = new DataTypes[4];
		dataArray[0] = dataFirstUser;
		dataArray[1] = dataSecondUser;
		dataArray[2] = dataThirdUser;
		dataArray[3] = dataFourUser;
		
		imprimirTodo(dataArray);

		String personalInfo = "Hello, my name " + dataDefaultUser.name + " " + dataDefaultUser.surname
				+ " I am " + dataDefaultUser.age + " years old.";
		String cityInfo = "I was born in " + dataDefaultUser.birthDay + "/" + dataDefaultUser.birthMonth + "/" 
				+ dataDefaultUser.birthYear + ". I live in " + dataDefaultUser.city;

		System.out.println(personalInfo);
		System.out.println(cityInfo);
	}
	
	public static void imprimirTodo(DataTypes[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i].name);
		}
	}

}
