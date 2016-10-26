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

	public Composite(String description) throws Exception {
		this.category = new ConcreteCategory("Composite");
		this.description = description;
		this.discount = new BaseDiscount();
		this.myItems = new LinkedList<Item>();
		this.quantity = 1;
		this.stock.addItem(this);
	}

	@Override
	public Category getCategory() {
		return category;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public Discount getDiscount() {
		return discount;
	}
	
	public List<Item> getMyItems() {
		return myItems;
	}
	
	@Override
	public double getPrice() {
		return calcPrice();
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	
	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity; 
	}

	@Override
	public void accept(Visitor v) {
		v.visitComposite(this);
	}

	@Override
	public void addItem(Item item) throws Exception {
		item.setQuantity(quantity);
		this.myItems.add(item);
	}

	public double calcPrice() {
		double sum = 0;
		Iterator<Item> iteratorItems = getIterator();

		while(iteratorItems.hasNext()) {
			Item currentItem = iteratorItems.next();
			sum = sum+currentItem.getPrice();
		}
		return this.roundingPrice(this.discount, sum);
	}
	
	public Iterator<Item> getIterator(){
		return myItems.iterator();
	}

	@Override
	public void printItem() {
		System.out.print(this.toString());
	}

	@Override
	public void removeItem(Item item) throws Exception {
		if(this.myItems.isEmpty()) {
			throw new Exception("Unable to remove: list is empty.");
		} else {
			this.myItems.remove(item);
		}
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
}
