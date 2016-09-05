package test.stock;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;

import stock.ConcreteStock;
import stock.Stock;

public class StockTest {
	private ByteArrayOutputStream outContent;
	private Stock stock;
	
	@Before
	public void setUp() throws Exception {
		this.outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		this.setStock(ConcreteStock.getInstance());
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
}
