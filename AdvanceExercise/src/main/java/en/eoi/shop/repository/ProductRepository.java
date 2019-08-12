package en.eoi.shop.repository;


import java.util.ArrayList;
import java.util.List;


import en.eoi.shop.entitites.*;

public class ProductRepository implements IProductRepository{
	
	private List<Product> dataBase;
	
	public ProductRepository(List<Product> tempDB) {
		this.dataBase = new ArrayList<Product>(tempDB);
	}

	@Override
	public boolean create(Product newProduct) {
		//TODO add ID check
		if (newProduct == null) {
			return false;
		}
		return this.dataBase.add(newProduct);
	}

	@Override
	public boolean delete(int id) {
		for (Product product : dataBase) {
			if (product.getId() == id) {
				dataBase.remove(product);
			}
		}
		return false;
	}

	@Override
	public boolean update(int id, String newName, String newDescription, int newTax,
			double newPrice, double newAvailableProducts, double newSoldProducts, String newCategory) {

		for (Product product : dataBase) {
			if (product.getId() == id) {
				
				//TODO Add checks for new values to avoid null or negative values
				product.setName(newName);
				product.setDescription(newDescription);
				product.setTax(newTax);
				product.setPrice(newPrice);
				product.setAvailableProducts(newAvailableProducts);
				product.setSoldProducts(newSoldProducts);
				product.setCat(newCategory);
				product.setCategory();
				
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Product searchById(int id) {
		for (Product product : dataBase) {
			if (product.getId() == id) {
				return this.dataBase.get(id);
			}
		}
		
		return null;
	}

	@Override
	public List<Product> searchByProductName(String filter) {
		List<Product> selectedBooks = new ArrayList<Product>();
		
		for(Product product : this.dataBase) {
			
			if (!filter.equals("") && product.getCat().equals(filter)) {
				selectedBooks.add(product);
			}
		}
	
		return selectedBooks;
	}

	@Override
	public List<Product> searchByCategory(String filter) {
		List<Product> selectedBooks = new ArrayList<Product>();
		
		for(Product myBook : this.dataBase) {
			
			if (!filter.equals("") && myBook.getCat().equals(filter)) {
				selectedBooks.add(myBook);
			}
		}
	
		return selectedBooks;
	}

	@Override
	public List<Product> listAll() {
		
		List<Product> results = this.dataBase;
		
		return results;
	}

	@Override
	public boolean sell(int id, double amount) {
		for (Product product : dataBase) {
			if (product.getId() == id) {
				if (product.getAvailableProducts() >= amount) {
					
					double productsAvailable = product.getAvailableProducts() - amount;
					double soldProducts = product.getSoldProducts() + amount;
					
					product.setAvailableProducts(productsAvailable);
					product.setSoldProducts(soldProducts);
					
					return true;
					
				} else {
					
					return false;
				}
			}
		}
		return false;
	}
	
}
