package test.card;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import card.BasicCard;
import card.Card;

public class BasicCardTest {

private Card basicCard;
	
	@Before
	public void setUp() throws Exception {
		basicCard = new BasicCard();
		basicCard.givePoints(1000);
	}

	@Test
	public void testAddPoint() {
		assertEquals(10,basicCard.getPoint());
	}

}
