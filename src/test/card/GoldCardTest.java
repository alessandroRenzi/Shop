package test.card;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import card.Card;
import card.GoldCard;

public class GoldCardTest {
	private Card goldCard;

	@Before
	public void setUp() throws Exception {
		this.goldCard = new GoldCard();
		this.goldCard.givePoints(1000);
	}

	@Test
	public void testAddPoint() {
		assertEquals(100,goldCard.getPoint());
	}

}
