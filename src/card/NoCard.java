package card;

public class NoCard implements Card {
	private int point;

	public NoCard(){
		super();
	}

	@Override
	public int getPoint() {
		return point;
	}

	@Override
	public void givePoints(int amount) {
		this.point = 0;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}
