package report;

import item.Composite;
import item.Item;
import item.Product;

import java.util.Iterator;

public abstract class ExtremeVisitor implements Visitor {
	@Override
	public void visitProduct(Product product) {
		System.out.print(product.toString());
	}

	@Override
	public<E extends Comparable<Item>> void visitComposite(Composite composite) {
		Item maxItem = null;
		Iterator<Item> iterator = composite.createIterator();

		if(iterator.hasNext()){
			maxItem = iterator.next();

			while(iterator.hasNext()) {
				Item currentItem = iterator.next();

				if(evaluate(currentItem, maxItem)) {
					maxItem = currentItem;
				}
			}
		}		
		System.out.print(maxItem.toString());
	}

	abstract <E extends Comparable<E>> boolean evaluate(E result, E currentItem);
}
