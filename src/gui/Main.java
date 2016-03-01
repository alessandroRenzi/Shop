package gui;

import category.ItemCategory;
import database.Stock;
import item.ConcreteProduct;

public class Main {
	public void run() {
		Stock stock = Stock.getInstance();
		@SuppressWarnings("unused")
		ConcreteProduct product = new ConcreteProduct("The Wall - Pink Floyd - 1979",  new ItemCategory("CD e Vinili"), 6.99);
		@SuppressWarnings("unused")
		ConcreteProduct product2 = new ConcreteProduct("The Wall - Pink Floyd - 1979",  new ItemCategory("CD e Vinili"), 6.99);
		System.out.println(stock.getItems().toString());
		System.out.print(stock.getCategories().getListCategories().toString());
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
}