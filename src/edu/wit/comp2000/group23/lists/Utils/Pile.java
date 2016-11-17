package edu.wit.comp2000.group23.lists.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Pile implements Iterable<Card>{
	
	private ArrayList<Card> cards;
	private int id;
	private static int idNext = 0;
	
	/**
	 * Constructor for Pile
	 */
	public Pile(){
		this.cards = new ArrayList<Card>();
		this.id = idNext;
		Pile.idNext++;
	}
	
	/**
	 * shuffle uses Collections.sort
	 */
	public void shuffle(){
		Collections.shuffle(cards);
	}
	
	@Override
	/**
	 * toString() for Pile
	 */
	public String toString(){
		String cardPile = "";
		for(Card c : this.cards){
			cardPile += c + " ";
		}
		return cardPile + "Pile ID: " + id;
	}
	
	/**
	 * add card to pile's ArrayList
	 * @param c
	 */
	public void add(Card c){
		this.cards.add(c);
	}
	
	/**
	 * remove card from the list from Pile
	 * @param position
	 * @return
	 */
	public Card remove(int position){
		return this.cards.remove(position);
	}
	
	/**
	 * get length for Pile
	 * @return
	 */
	public int getLength(){
		return this.cards.size();
	}
	
	/**
	 * isEmpty method for private data field
	 * @return
	 */
	public boolean isEmpty(){
		if(this.cards.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * clear method for Pile's list
	 */
	public void clear(){
		this.cards.clear();
	}

	@Override
	public Iterator<Card> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
