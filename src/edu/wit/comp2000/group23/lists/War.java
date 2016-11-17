package edu.wit.comp2000.group23.lists;
import edu.wit.comp2000.group23.lists.Exceptions.EmptyDeckException;
import edu.wit.comp2000.group23.lists.Utils.*;
import java.util.*;
public class War {

	public static void main(String[] args) {
		int numberOfPlayers;
		//Scanner object for user input
		Scanner scan = new Scanner(System.in);
		Deck deck = new Deck();
		deck.shuffle();
		//instantiates the players, min 2 - max 4
		Player player1 = null;
		Player player2 = null;
		Player player3 = null;
		Player player4 = null;
		/*do while loop that gets information regarding
		 * the number of players playing
		 * instantiates 2 or 4 players based on numberOfPlayers value
		 */
		do{
		System.out.println("Welcome to War, How many players? (2 or 4)");
		
		numberOfPlayers = scan.nextInt();
		if(numberOfPlayers == 2)
		{
		player1 = new Player(1,new Hand(),new Pile());
		player2 = new Player(2,new Hand(),new Pile());
		}
		else if(numberOfPlayers == 4)
		{
		player1 = new Player(1,new Hand(),new Pile());
		player2 = new Player(2,new Hand(),new Pile());
		player3 = new Player(3,new Hand(),new Pile());
		player4 = new Player(4,new Hand(),new Pile());
		}
		
		}while(numberOfPlayers != 2 && numberOfPlayers != 4);
		
		System.out.print(deck.toString());
		
		if(numberOfPlayers == 2)
		{
			for(int i = 0; i < 14;i++)
			{
				try {
					player1.addToHand(deck.deal());
					player2.addToHand(deck.deal());
				} catch (EmptyDeckException e) {
					// Try catch for EmptyDeckException
					e.printStackTrace();
				}
			}
			
			
		}
		
		

	}

}
