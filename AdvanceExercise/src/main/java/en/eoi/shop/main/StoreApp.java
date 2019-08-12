package en.eoi.shop.main;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import en.eoi.shop.entitites.Product;
import en.eoi.shop.services.ProductService;


public class StoreApp {

	public static Scanner scan = new Scanner(System.in);
	public static int option_int;
	public static List<Product> tempDB = new ArrayList<Product>();
	public static String path = "Products.json";
	public static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	public static ProductService myService;
	
	public static void main(String[] args) {
		jsonRead();
		myService = new ProductService(tempDB);
		
		printMenu();
		
		jsonWrite(gson.toJson(myService.listAll()));
	}
	
	public static void printMenu() {

		do {
			
			System.out.println("PRODUCTATOR V.1.0");
			System.out.println("1 - Nuevo Producto");
			System.out.println("2 - Listado de Productos");
			System.out.println("3 - Buscar Productos");
			System.out.println("4 - Modificar Producto");
			System.out.println("5 - Eliminar Producto");
			System.out.println("6 - Vender Producto");
			System.out.println("7 - Super Informe Ejecutivo");
			
			System.out.println("0 - SALIR");

			scan = new Scanner(System.in);
			option_int = scan.nextInt();
			scan.nextLine();
			switchInitialMenu(option_int);

		} while (option_int != 0);

	}
	
	public static void switchInitialMenu(int option) {
		int id, productTax;
		String productName, productDescription, productCategory;
		double productPrice, availableProducts, soldProducts;
		List<Product> productList = new ArrayList<Product>();
		
		switch (option) {
		case 1:
			System.out.println("INTRODUCE EL NOMBRE DEL PRODUCTO: ");
			productName = scan.nextLine();
			System.out.println("INTRODUCE LA DESCRIPCION DEL PRODUCTO: ");
			productDescription = scan.nextLine();
			System.out.println("INTRODUCE LOS IMPUESTOS DEL PRODUCTO: ");
			productTax = scan.nextInt();
			scan.nextLine();
			System.out.println("INTRODUCE EL PRECIO DEL PRODUCTO: ");
			productPrice = scan.nextDouble();
			scan.nextLine();
			System.out.println("INTRODUCE LA CANTIDAD DISPONIBLE DEL PRODUCTO: ");
			availableProducts = scan.nextDouble();
			scan.nextLine();
			System.out.println("INTRODUCE LA CANTIDAD VENDIDA DEL PRODUCTO: ");
			soldProducts = scan.nextDouble();
			scan.nextLine();
			System.out.println("INTRODUCE LA CATEGORIA DEL PRODUCTO: ");
			productCategory = scan.nextLine();
			Product aux = new Product(productName, productDescription, productTax,
					productPrice, availableProducts, soldProducts, productCategory);
			aux.setCategory();
			myService.create(aux);
			break;

		case 2:
			System.out.println("Listado de productos");
			productList = myService.listAll();
			
			for (Product product : productList) {
				System.out.println(product.toString());
			}
			break;

		case 3:
			
			System.out.println("Buscar producto");
			System.out.println("Introduzca el id del producto: ");
			String parametroBusqueda = scan.nextLine();
			Product productFound = myService.searchById(Integer.parseInt(parametroBusqueda));
			
			System.out.println("Introduzca la categoria del producto: ");
			parametroBusqueda = scan.nextLine();
			productList = myService.searchByCategory(parametroBusqueda);
			
			System.out.println("Productos con ese ID: ");
			System.out.println(productFound.toString());
			
			System.out.println("Productos con la misma categoria");
			System.out.println(productList);
			

			System.out.println("Introduzca el nombre del producto: ");
			parametroBusqueda = scan.nextLine();
			productList = myService.searchByProductName(parametroBusqueda);
			
			System.out.println("Productos con ese nombre: ");
			System.out.println(productList.toString());
			break;

		case 4:
			System.out.println("Modificar producto");
			System.out.println("Introduce el ID del producto: ");
			id = scan.nextInt();
			
			System.out.println("Introduce el nuevo nombre del producto: ");
			productName = scan.nextLine();
			
			System.out.println("Introduce la nueva descripcion del producto: ");
			productDescription = scan.nextLine();
			
			System.out.println("Introduce la nueva tasa de impustos del producto: ");
			productTax = scan.nextInt();
			
			System.out.println("Introduce el nuevo precio del producto: ");
			productPrice = scan.nextDouble();
			
			System.out.println("Introduce la nueva cantidad de productos: ");
			availableProducts = scan.nextDouble();
			
			System.out.println("Introduce la nueva cantidad de productos vendidos: ");
			soldProducts = scan.nextDouble();
			
			System.out.println("Introduce la nueva categoria del producto: ");
			productCategory = scan.nextLine();
			
			if (myService.update(id, productName, productDescription, productTax,
					productPrice, availableProducts, soldProducts, productCategory)) {
				System.out.println("El producto se actualizo correctamente");
			} else {
				System.out.println("Se produjo un error en la actualizacion."
						+ " Por favor, comprueba que el ID es correcto");
			}
			break;

		case 5:
			System.out.println("Eliminar producto");
			System.out.println("Introduce el ID del producto");
			id = scan.nextInt();
			
			if (myService.delete(id)) {
				
				System.out.println("El producto se pudo borrar correctamente");
				
			} else {
				
				System.out.println("Se produjo un error al borrar el producto."
						+ "Por favor, compruebe que el ID introducido es correcto");
			}
			break;

		case 6:
			System.out.println("Vender producto");
			System.out.println("Introduce el ID del producto");
			id = scan.nextInt();
			
			System.out.println("Introduce la cantidad vendida");
			double amount = scan.nextDouble();
			
			if (myService.sell(id, amount)) {
				System.out.println("La cantidad vendida se ha actualizado correctamente");
			} else {
				System.out.println("Se ha producido un error en la operacion."
						+ "Comprueba que el ID del producto y la cantidad son correctas");
			}
			break;

		case 7:
			System.out.println("Super informe ejecutivo");
			break;
		}

	}
	
	public static void jsonWrite(String jsonText) {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			writer.write(jsonText);
			writer.close();
		} catch (Exception e) {
			System.out.println("Se ha producido un error escribiendo " + e.getMessage());
		}
	}

	public static void jsonRead() {
		
		Product[] result = null;
		
		try {
			result = gson.fromJson(new FileReader(path), Product[].class);
			
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		tempDB = Arrays.asList(result);
	}
}
