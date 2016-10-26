package report;

import sorter.BubbleSortCrescent;
import sorter.Sorter;
import item.Composite;
import item.Item;
import item.ConcreteProduct;
import item.DecoratedProduct;

public class BubbleSortCrescentVisitor implements Visitor {

	@Override
	public void visitConcreteProduct(ConcreteProduct product) throws Exception {
		throw new Exception("Unable to perform this operation: the element is not a list.");
	}

	@Override
	public void visitDecoratedProduct(DecoratedProduct decoratedProduct) throws Exception {
		throw new Exception("Unable to perform this operation: the element is not a list.");
	}

	@Override
	public <E extends Comparable<Item>> void visitComposite(Composite composite) {
		Sorter<Item> sort = new BubbleSortCrescent<Item>();
		sort.sort(composite.getMyItems());
	}
}
