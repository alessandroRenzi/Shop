package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import item.*;
import report.MaxVisitor;

import report.Visitor;

public class ExtremeVisitorTest {
	private ByteArrayOutputStream outContent;
	private Composite pack;
	private ConcreteProduct product1;
	private DecoratedProduct product2;
	private Visitor visitor;

	@Before
	public void setUp() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		product1 = new ConcreteProduct("Who's Next - The Who - 1971", "CD e Vinili", 22.95);
		product2 = new DecoratedProduct(new ConcreteProduct("My Generation - The Who - 1965", "CD e Vinili", 19.12), 20);

		pack = new Composite("Who's Next Generation? - The Who - 2015");
		try {
			pack.add(product1);
			pack.add(product2);
		} catch(Exception exception) { }

		visitor = new MaxVisitor();
	}

	@Test
	public void testProductMax() {
		visitor.visitConcreteProduct(product1);
		assertEquals("Description: Who's Next - The Who - 1971 | Category: CD e Vinili | Price: 22.95", outContent.toString());
	}

	@Test
	public void testDecoratedProductMax() {
		visitor.visitDecoratedProduct(product2);
		assertEquals("Description: My Generation - The Who - 1965 | Category: CD e Vinili | Price: 19.12 | Discount: "
				+ "20% | Discounted price: 15.3", outContent.toString());
	}

	@Test
	public void testCompositeMax(){
		visitor.visitComposite(pack);
		assertEquals("Description: Who's Next - The Who - 1971 | Category: CD e Vinili | Price: 22.95", outContent.toString());
	}
}
