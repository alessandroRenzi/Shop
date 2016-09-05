package item;

import java.util.*;

import category.Category;
import category.ConcreteCategory;
import discount.BaseDiscount;
import discount.Discount;
import report.Visitor;
import stock.ConcreteStock;
import stock.Stock;

public class Composite implements Item {
	private Category category;
	private String description;
	private Discount discount;
	private List<Item> myItems;
	private int quantity;
	private Stock stock = ConcreteStock.getInstance();

	public Composite(String description) {
		this.category = new ConcreteCategory("Composite");
		this.description = description;
		this.discount = new BaseDiscount();
		this.myItems = new LinkedList<Item>();
		this.quantity = 1;
		this.stock.addItem(this);
	}

	public Category getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Discount getDiscount() {
		return discount;
	}

	public List<Item> getMyItems() {
		return myItems;
	}

	@Override
	public void accept(Visitor v) {
		v.visitComposite(this);
	}

	@Override
	public void add(Item item) throws Exception {
		this.myItems.add(item);
	}

	@Override
	public double getPrice() {
		double sum = 0;
		Iterator<Item> iteratorItems = getIterator();

		while(iteratorItems.hasNext()) {
			Item currentItem = iteratorItems.next();
			sum = sum+currentItem.getPrice();
		}
		return roundingPrice(sum);
	}

	@Override
	public void printItem() {
		System.out.print(this.toString());
	}

	@Override
	public void remove(Item item) throws Exception {
		try {
			this.myItems.remove(item);
		} catch (Exception e) {
			throw new Exception("Unable to remove: list is already empty.");
		}
	}

	@Override
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		String content = "Description: " + getDescription() + " | Content:\n";
		Iterator<Item> iteratorItems = getIterator();

		while(iteratorItems.hasNext()) {
			Item currentItem = iteratorItems.next();
			content = content+currentItem.toString()+"\n";
		}
		return content;
	}

	public Iterator<Item> getIterator(){
		return myItems.iterator();
	}

	public double roundingPrice(double sum) {
		double discountedSum = discount.doDiscount(sum);
		double rounding = Math.pow(10,2);
		return Math.round(discountedSum*rounding)/rounding;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity; 
	}
}
