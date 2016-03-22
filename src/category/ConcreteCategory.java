package category;

import stock.ConcreteStock;
import stock.Stock;

public class ConcreteCategory extends AbstractCategory {
	private Stock stock = ConcreteStock.getInstance();

	public ConcreteCategory(String category) {
		super(category);
		this.stock.addCategory(this);
	}

	@Override
	public boolean equals(Object category){
		boolean result = false;
		if(category instanceof ConcreteCategory){
			ConcreteCategory temp = (ConcreteCategory) category;
			if(temp.getCategory().equals(this.getCategory())){
				result = true;
			}
		}
		return result;
	}

}
