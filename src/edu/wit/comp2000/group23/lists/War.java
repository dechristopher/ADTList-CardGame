package edu.wit.comp2000.group23.lists;

import edu.wit.comp2000.group23.lists.Exceptions.EmptyDeckException;
import edu.wit.comp2000.group23.lists.Utils.*;
import java.util.*;

public class War {

	public static void main(String[] args) {
		// Scanner object for user input

		// deck instantiation and shuffle
		Deck deck = new Deck();
		deck.shuffle();
		// instantiation of table for game logic
		Table table = null;
		// counter for counting rounds
		int counter = 1;
		// instantiates the players, min 2 - max 4
		Player player1 = null;
		Player player2 = null;

		/*
		 * do while loop that gets information regarding the number of players
		 * playing instantiates 2 or 4 players based on numberOfPlayers value
		 * creates table for 2 or 4 players
		 */

		System.out.println("Welcome to War");

		player1 = new Player(1, new Hand(), new Pile());
		player2 = new Player(2, new Hand(), new Pile());
		table = new Table();

		/*
		 * Adds cards to players hands Handles both 2 and 4 players
		 */

		for (int i = 0; i < 26; i++) {
			try {
				player1.addToHand(deck.deal());
				player2.addToHand(deck.deal());
			} catch (EmptyDeckException e) {
				// Try catch for EmptyDeckException
				e.printStackTrace();
			}
		}

		/*
		 * Main game logic Round starts players put their cards down cards are
		 * compared, whoever is the highest value adds to their pile when war
		 * occurs, 3 cards get placed down, a 4th is compared to decide the
		 * winner when all players besides 1 have 0 cards in hand and pile,
		 * player X wins.
		 */

		while (!player1.getHand().isEmpty() && !player2.getHand().isEmpty()) {
			System.out.println("Round " + counter + ":");
			player1.drawsCard();
			table.playCard(player1.getCurrentCard(), 1);
			player2.drawsCard();
			table.playCard(player2.getCurrentCard(), 2);
			System.out.println("Player 1's card is : " + player1.getCurrentCard());
			System.out.println("Player 2's card is : " + player2.getCurrentCard());
			if (table.takeTurn() == 1) {
				System.out.println("Player 1 wins the round!");
				//System.out.println(table.getSpoils());
				table.getSpoils().addPileToPile(player1.getPile());
				System.out.println(player1.getPile());
				table.getSpoils().clear();
			}
			if (table.takeTurn() == 2) {
				System.out.println("Player 2 wins the round!");
				System.out.println(table.getSpoils());
				table.getSpoils().clear();
			}
			if (table.takeTurn() == 0) {
				System.out.println("War activated!");
				player1.drawsWarCard();
				player2.drawsWarCard();
			}
			/*
			 * while(player1.getPile().isEmpty() == false &&
			 * player2.getPile().isEmpty() == false) {
			 * 
			 * }
			 */
			counter++;
		}
		
		System.out.println("Player 1's Hand: " + player1.getHand().getLength());
		System.out.println("Player 2's Hand: " + player2.getHand().getLength());
		System.out.println("Player 1's Pile: " + player1.getPile().getLength());
		System.out.println("Player 2's Pile: " + player2.getPile().getLength());
	}

}