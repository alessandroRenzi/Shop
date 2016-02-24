package card;

public class BasicCard implements Card {
	private int point;
	
	public BasicCard(){
		super();
	}
	
	@Override
	public void givePoints(int amount) {
		point = point + (amount/100);
	}

	@Override
	public int getPoint() {
		return this.point;
	}

}
