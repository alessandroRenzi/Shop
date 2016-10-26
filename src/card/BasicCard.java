package card;

public class BasicCard implements Card {
	private int point;

	public BasicCard(){
		super();
	}

	@Override
	public int getPoint() {
		return this.point;
	}

	@Override
	public void givePoints(int amount) {
		point = point+(amount/100);
	}
}
