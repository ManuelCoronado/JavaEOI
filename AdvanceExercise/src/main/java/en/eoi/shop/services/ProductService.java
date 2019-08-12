package en.eoi.shop.services;

import java.util.List;

import en.eoi.shop.entitites.Product;
import en.eoi.shop.repository.ProductRepository;

public class ProductService implements IProductService{

	public ProductRepository myRepository;
	
	public ProductService(List<Product> tempDB) {
		this.myRepository = new ProductRepository(tempDB);
	}
	
	@Override
	public boolean create(Product newProduct) {
		return this.myRepository.create(newProduct);
	}

	@Override
	public boolean delete(int id) {
		return this.myRepository.delete(id);
	}

	@Override
	public boolean update(int id, String newName, String newDescription, int newTax,
			double newPrice, double newAvailableProducts, double newSoldProducts, String newCategory) {
		
		return this.myRepository.update(id, newName, newDescription, newTax,
				newPrice, newAvailableProducts, newSoldProducts, newCategory);
	}

	@Override
	public Product searchById(int id) {
		return this.myRepository.searchById(id);
	}

	@Override
	public List<Product> searchByProductName(String name) {
		return this.myRepository.searchByProductName(name);
	}

	@Override
	public List<Product> searchByCategory(String category) {
		return this.myRepository.searchByCategory(category);
	}

	@Override
	public List<Product> listAll() {
		return this.myRepository.listAll();
	}

	@Override
	public boolean sell(int id, double amount) {
		return this.myRepository.sell(id, amount);
	}

}
