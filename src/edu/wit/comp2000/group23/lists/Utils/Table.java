

package edu.wit.comp2000.group23.lists.Utils;


//Owner: Jeffrey Conner

public class Table {
	private Card player1;
	private Card player2;
	private Pile spoils;
	
	public Table(){
		this.spoils = new Pile();
	}
	
	public Table(int numOfPlayers){
		this.spoils = new Pile();
	}
	
	public Pile getSpoils(){
		return this.spoils;
	}
	
	public void playCard(Card c, int playerID){
		if(playerID==1){
			this.player1=c;
			this.spoils.add(player1); 
		} else if(playerID==2){
			this.player2=c;
			this.spoils.add(player2);
		}
	}
	
	//Returns int for winning player if a winner is determined
	//Returns other int in WAR situations
	//Returns 0 for two person WAR in two person game
	
	public int takeTurn(){
			
			//Player2 wins:
			
			if(player1.compareTo(player2)<0){
				return 2;
			}
			
			//Player1 wins:
			
			else if(player1.compareTo(player2)>0){
				return 1;
			}	
				//A war:
				
			 else if(player1.compareTo(player2)==0){
				return 0;
			}
			return 0;
	}
}