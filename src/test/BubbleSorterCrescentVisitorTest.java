package test;

import static org.junit.Assert.*;
import item.Composite;
import item.Product;

import org.junit.Before;
import org.junit.Test;

import report.BubblesortCrescentVisitor;

public class BubbleSorterCrescentVisitorTest {
	private Product dvd;
	private Product cd;
	private Composite composite,compositeSorted;
	@Before
	
	public void setUp(){
		dvd = new Product("Amy Winehouse", 10);
		cd = new Product("Modest Mouse - Strangers to Ourselves", 25);
		composite = new Composite("pack one");
		compositeSorted = new Composite("pack two");
		try {
			composite.add(cd);
			composite.add(dvd);
			compositeSorted.add(dvd);
			compositeSorted.add(cd);
		} catch (Exception e) {}
	}
	
	
	@Test
	public void test() {
		doVisitor();
		assertArrayEquals(compositeSorted.getMyItems().toArray(),composite.getMyItems().toArray());
	}


	private void doVisitor() {
		BubblesortCrescentVisitor visitor = new BubblesortCrescentVisitor();
		visitor.visitComposite(composite);
	}

}
