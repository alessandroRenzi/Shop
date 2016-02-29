package category;

public abstract class AbsCategory implements Category {
	private String category;
	
	public AbsCategory(String category){
		this.category = category;
	}
	
	@Override
	public String getCategory() {
		return this.category;
	}

	@Override
	public void setCategory(String category) {
		this.category = category;
	}

}
