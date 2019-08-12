package en.eoi.shop.entitites;

import java.util.concurrent.atomic.AtomicInteger;

import en.eoi.shop.enumerator.Category;

public class Product {
	//This allows to create an ID from zero then increment it's value using the method getAndIncrement
	private static AtomicInteger ID_GENERATOR = new AtomicInteger();
	
	private int id;
	private String name;
	private String description;
	private int tax;
	private double price;
	private double availableProducts;
	private double soldProducts;
	private String cat;
	private Category category;
	
	public Product(String name, String description, int tax, double price, double availableProducts,
			double soldProducts, String cat) {
		super();
		this.id = ID_GENERATOR.getAndIncrement();
		this.name = name;
		this.description = description;
		this.tax = tax;
		this.price = price;
		this.availableProducts = availableProducts;
		this.soldProducts = soldProducts;
		this.cat = cat;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getAvailableProducts() {
		return availableProducts;
	}
	public void setAvailableProducts(double availableProducts) {
		this.availableProducts = availableProducts;
	}
	public double getSoldProducts() {
		return soldProducts;
	}
	public void setSoldProducts(double soldProducts) {
		this.soldProducts = soldProducts;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String category) {
		this.cat = category;
	}
	
	public void setCategory() {

		if (cat.toUpperCase().equals("ALIMENTACION")) {
			category = Category.ALIMENTACION;
		} else if (cat.toUpperCase().equals("MATERIAL")) {
			category = Category.MATERIAL;
		} else if (cat.toUpperCase().equals("LUJO")) {
			category = Category.LUJO;
		} else {
			category = Category.MECANICO;
		}
	}

	public boolean isAlimentacion() {
		return this.category== Category.ALIMENTACION;
	}
	
	public boolean isMaterial() {
		return this.category == Category.MATERIAL;
	}
	
	public boolean isMecanico() {
		return this.category == Category.MECANICO;
	}
	
	public boolean isLujo() {
		return this.category == Category.LUJO;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + " ID: " + this.id + " Description: " + this.description
				+ " Tax: " + this.tax + " Price: " + this.price + " Available products: " 
				+ this.availableProducts + " Sold products: " + this.availableProducts
				+ " Category: " + this.category;
	}
	
	
}
