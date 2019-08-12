package en.eoi.shop.repository;

import java.util.List;

import en.eoi.shop.entitites.Product;

public interface IProductRepository {
	public boolean create(Product newProduct);
	public boolean delete(int id);
	public boolean update(int id, String newName, String newDescription, int newTax,
			double newPrice, double newAvailableProducts, double newSoldProducts, String newCategory);
	public Product searchById(int id);
	public List<Product> searchByProductName(String filter);
	public List<Product> searchByCategory(String filter);
	public List<Product> listAll();
	public boolean sell(int id, double amount);
}
