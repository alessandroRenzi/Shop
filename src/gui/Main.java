package gui;

import category.ConcreteCategory;
import item.ConcreteProduct;
import stock.ConcreteStock;
import stock.Stock;

public class Main {
	public void run() {
		Stock stock = ConcreteStock.getInstance();
		@SuppressWarnings("unused")
		ConcreteProduct product = new ConcreteProduct("The Wall - Pink Floyd - 1979",  new ConcreteCategory("CD e Vinili"), 6.99);
		@SuppressWarnings("unused")
		ConcreteProduct product2 = new ConcreteProduct("IKIK",  new ConcreteCategory("hjgjg"), 6.99);
		System.out.println(stock.getItems().toString());
		System.out.print(stock.getCategories().toString());
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
}