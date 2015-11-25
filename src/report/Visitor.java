package report;

import item.Composite;
import item.Item;
import item.Product;

public interface Visitor {
	public void visitProduct(Product product);
	public<E extends Comparable<Item>> void visitComposite(Composite composite);
}