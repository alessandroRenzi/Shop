package test;



import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import card.Card;
import card.NoCard;

public class NoCardTest {
	private Card noCard;
	
	@Before
	public void setUp() throws Exception {
		noCard = new NoCard();
		noCard.givePoints(1000);
	}

	@Test
	public void testAddPoint() {
		assertEquals(0,noCard.getPoint());
	}

}
