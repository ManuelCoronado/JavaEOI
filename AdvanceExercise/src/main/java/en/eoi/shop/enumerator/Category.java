package en.eoi.shop.enumerator;

public enum Category {
	ALIMENTACION("ALIMENTACION"),
	MATERIAL("MATERIAL"),
	MECANICO("MECANICO"),
	LUJO("LUJO");
	
	private String category;

	private Category(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String text) {
		this.category = text;
	}
	
}
