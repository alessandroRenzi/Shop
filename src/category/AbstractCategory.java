package category;

public abstract class AbstractCategory implements Category {
	private String category;

	public AbstractCategory(String category){
		this.category = category;
	}

	@Override
	public String getCategory() {
		return category;
	}

	@Override
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public boolean equals(Category category) {
		if(this.getCategory().toString() == category.getCategory()) {
			return true;
		}
		return false;
	}
}
