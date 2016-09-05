package test.report;

import static org.junit.Assert.*;
import item.Composite;
import item.ConcreteProduct;

import org.junit.Before;
import org.junit.Test;

import category.ConcreteCategory;
import report.BubbleSortCrescentVisitor;

public class BubbleSorterCrescentVisitorTest {
	private ConcreteProduct dvd;
	private ConcreteProduct cd;
	private Composite composite;
	private Composite compositeSorted;

	@Before
	public void setUp(){
		dvd = new ConcreteProduct("Back to Black - Amy Winehouse - 2006",  new ConcreteCategory("CD e Vinili"), 9.90);
		cd = new ConcreteProduct("Strangers to Ourselves - Modest Mouse - 2015",  new ConcreteCategory("CD e Vinili"), 15.29);

		composite = new Composite("Pack one");
		compositeSorted = new Composite("Pack two");

		try {
			composite.add(cd);
			composite.add(dvd);
			compositeSorted.add(dvd);
			compositeSorted.add(cd);
		} catch (Exception e) {

		}
	}

	@Test
	public void test() {
		doVisitor();
		assertArrayEquals(compositeSorted.getMyItems().toArray(), composite.getMyItems().toArray());
	}

	private void doVisitor() {
		BubbleSortCrescentVisitor visitor = new BubbleSortCrescentVisitor();
		visitor.visitComposite(composite);
	}
}
