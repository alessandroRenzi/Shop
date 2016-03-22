package category;

import stock.ConcreteStock;
import stock.Stock;

public class ConcreteCategory extends AbstractCategory {
	private Stock stock = ConcreteStock.getInstance();

	public ConcreteCategory(String category) {
		super(category);
		this.stock.addCategory(this);
	}
}
