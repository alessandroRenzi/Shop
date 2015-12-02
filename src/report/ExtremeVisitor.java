package report;

import item.Composite;
import item.Item;
import item.ConcreteProduct;
import item.DecoratedProduct;

import java.util.Iterator;

public abstract class ExtremeVisitor implements Visitor {
	@Override
	public void visitConcreteProduct(ConcreteProduct product) {
		product.print();
	}

	@Override
	public void visitDecoratedProduct(DecoratedProduct decoratedProduct) {
		decoratedProduct.print();
	}

	@Override
	public<E extends Comparable<Item>> void visitComposite(Composite composite) {
		Item searchedItem = null;
		Iterator<Item> iterator = composite.createIterator();

		if(iterator.hasNext()){
			searchedItem = iterator.next();

			while(iterator.hasNext()) {
				Item currentItem = iterator.next();

				if(evaluate(currentItem, searchedItem)) {
					searchedItem = currentItem;
				}
			}
		}		
		searchedItem.print();
	}

	abstract <E extends Comparable<E>> boolean evaluate(E result, E currentItem);
}
