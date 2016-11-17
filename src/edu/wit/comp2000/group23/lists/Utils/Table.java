package edu.wit.comp2000.group23.lists.Utils;

import edu.wit.comp2000.group23.lists.Enums.SUIT;
import edu.wit.comp2000.group23.lists.Exceptions.EmptyDeckException;
import java.util.ArrayList;

//Owner: Jeffrey Conner

public class Table {
	private Card player1;
	private Card player2;
	private Card player3;
	private Card player4;
	private int numberOfPlayers;
	private Pile spoils;
	private int spoilsWinner;
	
	public Table(){
		
	}

	
	public Table(int numOfPlayers){
		numberOfPlayers=numOfPlayers;
		spoils = new Pile();
	}
	
	public Pile getSpoils(){
		return spoils;
		
	}
	
	//Returns true if a winner is determined returns false if a war is required
	
	public boolean takeTurn(int numOfPlayers){
		if(numOfPlayers==2){
			
			//Player2 wins
			
			if(player1.compareTo(player2)<0){
				spoilsWinner=2;
				spoils.add(player1);
				spoils.add(player2);
				return true;
			}
			
			//Player1 wins
			
			else if(player1.compareTo(player2)>0){
				spoilsWinner=1;
				spoils.add(player1);
				spoils.add(player2);
				return true;
			}	
				//A war:
				
			 else if(player1.compareTo(player2)==0){
				//add three cards to spoils
				spoils.add(player1);
				spoils.add(player2);
				takeTurn(2);
				return true;
			}
		} else if(numOfPlayers==4){
			
			//Player1 wins
			
			if((player1.compareTo(player2)>0) && (player1.compareTo(player3)>0) && (player1.compareTo(player3)>0) && player1.compareTo(player4)>0){
				spoils.add(player1);
				spoils.add(player2);
				spoils.add(player3);
				spoils.add(player4);
				spoilsWinner=1;
				return true;
			}
			
			//Player2 wins
			
			else if((player2.compareTo(player1)>0) && (player2.compareTo(player3)>0) && (player2.compareTo(player4)>0)){
				spoils.add(player1);
				spoils.add(player2);
				spoils.add(player3);
				spoils.add(player4);
				spoilsWinner=2;
				return true;
			}
			
			//Player3 wins
			
			else if((player3.compareTo(player1)>0) && (player3.compareTo(player2)>0) && (player3.compareTo(player4)>0)){
				spoils.add(player1);
				spoils.add(player2);
				spoils.add(player3);
				spoils.add(player4);
				spoilsWinner=3;
				return true;
			}
			
			//Player4 wins
			
			else if((player4.compareTo(player1)>0) && (player4.compareTo(player2)>0) && (player4.compareTo(player3)>0)){
				spoils.add(player1);
				spoils.add(player2);
				spoils.add(player3);
				spoils.add(player4);
				spoilsWinner=4;
				return true;
			}
		}
		return false;
	}
	
}
