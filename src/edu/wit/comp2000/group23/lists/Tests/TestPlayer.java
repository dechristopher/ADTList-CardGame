package edu.wit.comp2000.group23.lists.Tests;

import org.junit.Test;

import edu.wit.comp2000.group23.lists.Enums.SUIT;
import edu.wit.comp2000.group23.lists.Utils.Card;
import edu.wit.comp2000.group23.lists.Utils.Hand;
import edu.wit.comp2000.group23.lists.Utils.Pile;
import edu.wit.comp2000.group23.lists.Utils.Player;
import junit.framework.Assert;

public class TestPlayer {
	@SuppressWarnings("deprecation")
	@Test
	/**
	 * to do later (hand needs to be implemented)
	 */
	public void testPlayer(){
		Player player = new Player(0);
		Card c1 = new Card(1, SUIT.Clubs);
		player.addToHand(c1);
		player.setCurrentCard(c1);
		String expected = "Player's playerID: 0"
				+ "\nPlayer's hand: Ace of Clubs "
				+ "\nPlayer's current card: Ace of Clubs";
		Assert.assertEquals(expected, player.toString());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void drawsCard(){
		Player player = new Player(0, new Hand(), new Pile());
		Card c1 = new Card(1, SUIT.Clubs);
		player.addToHand(c1);
		player.drawsCard();
		String expected = c1.toString();
		String actual = player.getCurrentCard().toString();
		Assert.assertEquals(expected, actual);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testPutCardInPile(){
		Player player = new Player(0, new Hand(), new Pile());
		Card c1 = new Card(1, SUIT.Clubs);
		player.setCurrentCard(c1);
		player.addCardToSpoils();
		boolean playerEmptyHand = player.getHand().isEmpty();
		Assert.assertEquals(true, playerEmptyHand);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void drawsCardEmptyHandTest(){
		Player player = new Player(0, new Hand(), new Pile());
		Card c1 = new Card(1, SUIT.Clubs);
		player.setCurrentCard(c1);
		player.addCardToSpoils();
		player.addSpoilsToPile();
		player.drawsCard();
		String expected = c1.toString();
		String actual = player.getCurrentCard().toString();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void drawsWarCardTest(){
		Player player = new Player(0, new Hand(), new Pile());
		Card c1 = new Card(1, SUIT.Clubs);
		Card c2 = new Card(2, SUIT.Clubs);
		Card c3 = new Card(3, SUIT.Clubs);
		Card c4 = new Card(3, SUIT.Clubs);
		player.addToHand(c4);
		player.addToHand(c3);
		player.addToHand(c2);
		player.addToHand(c1);
		player.drawsWarCard();
		String expected = c4.toString();
		String actual = player.getCurrentCard().toString();
		Assert.assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	/**
	 * draws three cards for war
	 */
	public void drawsWarCardEmptyHandTest(){
		Player player = new Player(0, new Hand(), new Pile());
		Card c1 = new Card(1, SUIT.Clubs);
		Card c2 = new Card(2, SUIT.Clubs);
		Card c3 = new Card(3, SUIT.Clubs);
		player.setCurrentCard(c3);
		player.addCardToSpoils();
		player.setCurrentCard(c2);
		player.addCardToSpoils();
		player.setCurrentCard(c1);
		player.addCardToSpoils();
		player.addSpoilsToPile();
		player.drawsWarCard();
		Assert.assertEquals(true, player.getHand().isEmpty());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void doNotOverDrawWarCardTest(){
		Player player = new Player(0, new Hand(), new Pile());
		Card c1 = new Card(1, SUIT.Clubs);
		Card c2 = new Card(2, SUIT.Clubs);
		Card c3 = new Card(3, SUIT.Clubs);
		Card c4 = new Card(4, SUIT.Clubs);
		Card c5 = new Card(5, SUIT.Clubs);
		Card c6 = new Card(5, SUIT.Clubs);
		
		player.addToHand(c6);
		player.addToHand(c5);
		player.addToHand(c4);
		player.addToHand(c3);
		player.addToHand(c2);
		player.addToHand(c1);
		player.drawsWarCard();
		Assert.assertEquals(2, player.getHand().getLength());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSpoils(){
		Player player = new Player(0, new Hand(), new Pile());
		Card c1 = new Card(1, SUIT.Clubs);
		Card c2 = new Card(2, SUIT.Clubs);
		Card c3 = new Card(3, SUIT.Clubs);
		Card c4 = new Card(4, SUIT.Clubs);
		Card c5 = new Card(5, SUIT.Clubs);
		Card c6 = new Card(5, SUIT.Clubs);
		
		player.addToHand(c6);
		player.addToHand(c5);
		player.addToHand(c4);
		player.addToHand(c3);
		player.addToHand(c2);
		player.addToHand(c1);
		player.drawsWarCard();
		Assert.assertEquals(4, player.getSpoils().getLength());
	}
}
