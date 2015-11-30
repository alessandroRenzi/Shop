package report;

import item.Composite;
import item.Item;
import item.ConcreteProduct;
import item.DecoratedProduct;

public interface Visitor {
	public void visitConcreteProduct(ConcreteProduct product);
	public void visitDecoratedProduct(DecoratedProduct decoratedProduct);
	public<E extends Comparable<Item>> void visitComposite(Composite composite);
}