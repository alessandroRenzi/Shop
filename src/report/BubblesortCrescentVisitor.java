package report;

import sorter.BubbleSortCrescent;
import item.Composite;
import item.Item;
import item.ConcreteProduct;
import item.DecoratedProduct;

public class BubblesortCrescentVisitor implements Visitor {

	@Override
	public void visitConcreteProduct(ConcreteProduct product) {

	}

	@Override
	public void visitDecoratedProduct(DecoratedProduct decoratedProduct) {

	}

	@Override
	public <E extends Comparable<Item>> void visitComposite(Composite composite) {
		BubbleSortCrescent<Item> sort = new BubbleSortCrescent<Item>();
		sort.sort(composite.getMyItems());
	}
}
