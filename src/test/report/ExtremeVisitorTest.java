package test.report;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import category.ConcreteCategory;
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
	public void setUp() throws Exception {
		this.outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(this.outContent));

		this.product1 = new ConcreteProduct("Who's Next - The Who - 1971",new ConcreteCategory("CD e Vinili"),22.95);
		this.product2 = new DecoratedProduct(new ConcreteProduct("My Generation - The Who - 1965",new ConcreteCategory("CD e Vinili"),19.12),20);

		this.pack = new Composite("Who's Next Generation? - The Who - 2015");
		this.pack.addItem(product1);
		this.pack.addItem(product2);
		
		this.visitor = new MaxVisitor();
	}

	@Test
	public void testCompositeMax(){
		this.visitor.visitComposite(pack);
		assertEquals("Description: Who's Next - The Who - 1971 | Category: CD e Vinili | Price: 22.95 | Quantity: 1", outContent.toString());
	}
	
	@Test
	public void testDecoratedProductMax() throws Exception {
		this.visitor.visitDecoratedProduct(this.product2);
		assertEquals("Description: My Generation - The Who - 1965 | Category: CD e Vinili | Price: 19.12 | Quantity: 1 | Discount: "
				+ "20% | Discounted price: 15.3",this.outContent.toString());
	}
	
	@Test
	public void testProductMax() throws Exception {
		this.visitor.visitConcreteProduct(this.product1);
		assertEquals("Description: Who's Next - The Who - 1971 | Category: CD e Vinili | Price: 22.95 | Quantity: 1",this.outContent.toString());
	}
}
