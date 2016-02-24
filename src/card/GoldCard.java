package card;

public class GoldCard implements Card {
	private int point;
	
	public GoldCard(){
		super();
	}
	
	@Override
	public void givePoints(int amount) {
		point = point + (amount/10);
	}

	@Override
	public int getPoint() {
		return this.point;
	}

}
