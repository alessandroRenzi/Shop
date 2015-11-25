package report;

import sorter.BubbleSortCrescent;
import item.Composite;
import item.Item;
import item.Product;

public class BubblesortCrescentVisitor implements Visitor {

	@Override
	public void visitProduct(Product product) {

	}

	@Override
	public <E extends Comparable<Item>> void visitComposite(Composite composite) {
		BubbleSortCrescent<Item> sort = new BubbleSortCrescent<Item>();
		sort.sort(composite.getMyItems());
	}

}
