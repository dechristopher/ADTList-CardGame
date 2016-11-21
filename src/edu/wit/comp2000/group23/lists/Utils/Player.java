package edu.wit.comp2000.group23.lists.Utils;

import java.util.ArrayList;

public class Player {

	// 2 to 4 players, can't have three
	private int playerID;
	private Hand hand;
	private Pile pile;
	private Pile spoils;
	private Card currentCard;

	/**
	 * constructor for player
	 * 
	 * @param playerID
	 * @param hand
	 */
	public Player(int playerID, Hand hand, Pile pile) {
		this.playerID = playerID;
		this.hand = hand;
		this.pile = pile;
		this.spoils = new Pile();
	}

	/**
	 * single arg constructor for Player
	 * 
	 * @param playerID
	 */
	public Player(int playerID) {
		this(playerID, new Hand(), new Pile());
	}

	/**
	 * getter method for player's hand
	 * 
	 * @return
	 */
	public Hand getHand() {
		return this.hand;
	}

	/**
	 * return the number of cards left in hand
	 * @return
	 */
	public int getNumCards(){
		return this.hand.getLength();
	}
	
	/**
	 * add to the player's hand
	 * 
	 * @param c
	 */
	public void addToHand(Card c) {
		this.hand.add(c);
	}

	/**
	 * getter method for player's id
	 * 
	 * @return
	 */
	public int getplayerID() {
		return this.playerID;
	}

	/**
	 * getter method for current card
	 * 
	 * @return
	 */
	public Card getCurrentCard() {
		return this.currentCard;
	}

	/**
	 * getter method for the player's spoils during war
	 * 
	 * @return
	 */
	public Pile getSpoils() {
		return this.spoils;
	}

	/**
	 * getter method for the player's pile
	 * 
	 * @return
	 */
	public Pile getPile() {
		return this.pile;
	}

	/**
	 * mutator method for current card
	 */
	public void setCurrentCard(Card c) {
		this.currentCard = c;
	}

	/**
	 * draws card once if hand is empty automatically addPileToHand
	 * 
	 * @return Card
	 */

	public void drawsCard() {
		// when the player's hand isn't empty
		if (!this.hand.isEmpty()) {
			this.getSpoils().clear();
			this.setCurrentCard(this.hand.remove(hand.getLength() - 1));
			this.getSpoils().add(this.getCurrentCard());
		}
		// when the player's hand is empty
		else {
			this.getSpoils().clear();
			this.addPileToHand();
			this.setCurrentCard(this.hand.remove(hand.getLength() - 1));
			this.getSpoils().add(this.getCurrentCard());
		}
	}

	/**
	 * Draws card three or less times during war
	 * 
	 * @return
	 */
	public void drawsWarCard() {
		// position for remove is hand.getLength() - 1 because you want
		// the top card
		int position = hand.getLength() - 1;
		int counter = 0;
		// if the player's hand isn't empty
		if (hand.getLength() != 0) {
			// clear the spoils' list every time this is called
			spoils.clear();
			while ((hand.getLength()) != 0 && (counter != 4)) {
				// remove card
				Card c = this.hand.remove(position);
				// add the card to spoils and setCurrentCard
				this.setCurrentCard(c);
				addCardToSpoils();
				position--;
				counter++;
			}
		}
		// if the player's hand is empty
		else {
			addPileToHand();
			position = hand.getLength() - 1;
			spoils.clear();
			while ((hand.getLength() != 0) && (counter != 4)) {
				Card c = this.hand.remove(position);
				this.setCurrentCard(c);
				addCardToSpoils();
				position--;
				counter++;
			}
		}
	}
	
	/**
	 * 
	 */
	public Card drawCard(){
		return this.hand.remove(hand.getLength()-1);
	}

	/**
	 * add pile to hand, also shuffles pile
	 */
	public void addPileToHand() {
		// shuffle the deck before adding pile to hand
		this.pile.shuffle();

		/*for (int i = 0; i < this.pile.getLength(); i++) {
			this.hand.add(this.pile.remove(i));
		}*/
		
		for(Card c : this.getPile().getCards()){
			this.hand.add(c);
		}
		
		this.getPile().clear();
	}

	/**
	 * (Maybe change to boolean later)?
	 * 
	 * Takes the player's currentCard, and puts it into a pile
	 */
	public void addCardToSpoils() {
		this.getSpoils().add(this.currentCard);
	}

	/**
	 * spoils to pile, player's card default location after comparing the two
	 * cards
	 */
	public void addSpoilsToPile(Pile p) {
		this.getSpoils().addPileToPile(p);
	}

	@Override
	/**
	 * toString method returns String
	 */
	public String toString() {
		return "Player's playerID: " + this.getplayerID() + "\nPlayer's hand: " + this.getHand();
	}
}
