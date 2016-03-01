package category;

import database.Categories;
public abstract class AbsCategory implements Category {
	private String category;
	private Categories categories;

	public AbsCategory(String category){
		this.category = category;
	}

	@Override
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String getCategory() {
		return this.category;
	}

	public Categories getCategories() {
		return categories;
	}
}
