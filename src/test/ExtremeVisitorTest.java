package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import item.*;
import report.MaxVisitor;
import report.MinVisitor;
import report.Visitor;

public class ExtremeVisitorTest {
	private ByteArrayOutputStream outContent;
	private Composite pack;
	private Product product1;
	private Product product2;
	private Visitor max;
	private Visitor min;

	@Before
	public void setUp() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		product1 = new Product("Nevermind (20th Anniversary) - Nirvana - 2011", 5.99);
		product2 = new Product("Ten - Pearl Jam - 1992", 7.99);

		pack = new Composite("Best of Grunge - Various artists - 2015");
		try {
			pack.add(product1);
			pack.add(product2);
		} catch(Exception exception) {

		}

		max = new MaxVisitor();
		min = new MinVisitor();
	}

	@Test
	public void testProductMax() {
		max.visitProduct(product1);
		assertEquals("Nevermind (20th Anniversary) - Nirvana - 2011 - price: 5.99",outContent.toString());
	}

	@Test
	public void testProductMin(){
		min.visitProduct(product1);
		assertEquals("Nevermind (20th Anniversary) - Nirvana - 2011 - price: 5.99",outContent.toString());
	}

	@Test
	public void testCompositeMax(){
		max.visitComposite(pack);
		assertEquals("Ten - Pearl Jam - 1992 - price: 7.99",outContent.toString());
	}

	@Test
	public void testCompositeMin(){
		min.visitComposite(pack);
		assertEquals("Nevermind (20th Anniversary) - Nirvana - 2011 - price: 5.99",outContent.toString());
	}
}
