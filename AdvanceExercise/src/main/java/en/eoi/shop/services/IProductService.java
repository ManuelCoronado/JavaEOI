package en.eoi.shop.services;

import java.util.List;
import en.eoi.shop.entitites.Product;

public interface IProductService {
	public boolean create(Product newProduct);
	public boolean delete(int id);
	public boolean update(int id, String newName, String newDescription, int newTax,
			double newPrice, double newAvailableProducts, double newSoldProducts, String newCategory);
	public Product searchById(int id);
	public List<Product> searchByProductName(String name);
	public List<Product> searchByCategory(String category);
	public List<Product> listAll();
	public boolean sell(int id, double amount);
}
