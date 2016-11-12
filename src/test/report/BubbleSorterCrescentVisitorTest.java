package test.report;

import static org.junit.Assert.*;
import item.Composite;
import item.ConcreteProduct;
import item.DecoratedProduct;

import org.junit.Before;
import org.junit.Test;

import category.ConcreteCategory;
import report.BubbleSortCrescentVisitor;

public class BubbleSorterCrescentVisitorTest {
	private Composite composite;
	private Composite compositeSorted;
	private ConcreteProduct concreteProduct;
	private DecoratedProduct decoratedProduct;
	private ConcreteProduct product1;
	private ConcreteProduct product2;

	private void doCompositeVisitor() {
		BubbleSortCrescentVisitor visitor = new BubbleSortCrescentVisitor();
		visitor.visitComposite(this.composite);
	}
	
	private void doConcreteProductVisitor() {
		BubbleSortCrescentVisitor visitor = new BubbleSortCrescentVisitor();
		try {
			visitor.visitConcreteProduct(this.concreteProduct);
		} catch(Exception e) {
			e = new Exception("Unable to perform this operation: the element is not a list.");
		}
	}
	
	private void doDecoratedProductVisitor() {
		BubbleSortCrescentVisitor visitor = new BubbleSortCrescentVisitor();
		try {
			visitor.visitDecoratedProduct(this.decoratedProduct);
		} catch(Exception e) {	
			e = new Exception("Unable to perform this operation: the element is not a list.");
		}
	}
	
	@Before
	public void setUp() throws Exception{
		this.product1 = new ConcreteProduct("Back to Black - Amy Winehouse - 2006",  new ConcreteCategory("CD e Vinili"), 9.90);
		this.product2 = new ConcreteProduct("Strangers to Ourselves - Modest Mouse - 2015",  new ConcreteCategory("CD e Vinili"), 15.29);

		this.composite = new Composite("Pack one");
		this.composite.addItem(this.product2);
		this.composite.addItem(this.product1);
		
		this.compositeSorted = new Composite("Pack two");
		this.compositeSorted.addItem(this.product1);
		this.compositeSorted.addItem(this.product2);
		
		this.concreteProduct = new ConcreteProduct("The Wall - Pink Floyd - 1979",new ConcreteCategory("CD e Vinili"),6.99);
	}

	@Test
	public void testVisitComposite() {
		this.doCompositeVisitor();
		assertArrayEquals(this.compositeSorted.getMyItems().toArray(),this.composite.getMyItems().toArray());
	}
	
	@Test
	public void testVisitConcreteProduct() throws Exception {
		this.doConcreteProductVisitor();
	}
	
	@Test
	public void testVisitDecoratedProduct() throws Exception {
		this.doDecoratedProductVisitor();
	}
}
