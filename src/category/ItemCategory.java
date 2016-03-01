package category;

import database.Stock;

public class ItemCategory extends AbsCategory {
	private Stock stock = Stock.getInstance();

	public ItemCategory(String category) {
		super(category);
		stock.addCategory(this);
	}
}
