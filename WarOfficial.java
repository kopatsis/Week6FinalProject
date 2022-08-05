package FinalProject;

import java.util.ArrayList;
import java.util.List;

public class WarOfficial {
	
	public static Player player1 = new Player("Billy Bob");
	public static Player player2 = new Player("Cletus Jones");
	public static boolean isDraw = false;
	public static boolean gameOver = false;
	public static List<Card> tieList = new ArrayList<Card>();
	public static int matchCount = 0;
	
	public static void main(String[] args) {
		
		Deck warDeck = new Deck();
		warDeck.Shuffle();
		
		for(int i = 0; i < 52; i++) {
			if(i % 2 == 0) {
				player1.Draw(warDeck.Draw());
			} else {
				player2.Draw(warDeck.Draw());
			}
		}
				
		while(gameOver == false) {
			if(player1.getHand().size() == 1 || player2.getHand().size() == 1 ) {
				finalMatch();
			} else {
				Card player1Card = player1.Flip();
				Card player2Card = player2.Flip();
				matchCount++;
				if (player1Card.getValue() > player2Card.getValue()) {
					player1.Draw(player1Card);
					player1.Draw(player2Card);
				} else if (player1Card.getValue() < player2Card.getValue()) {
					player2.Draw(player1Card);
					player2.Draw(player2Card);
				} else {
					tieList.add(player1Card);
					tieList.add(player2Card);
					tieBreaker(tieList);
				}
			}
		}
		
		if (isDraw == true) {
			System.out.println("The game ended in a draw after " + matchCount + " matches");
		} else if (player1.getHand().size() == 0) {
			System.out.println(player2.getName() + " is the winner after " + matchCount + " matches");
		} else {
			System.out.println(player1.getName()+ " is the winner after " + matchCount + " matches");
		}
		
	}

	private static void finalMatch() {
		Card finalCard1 = player1.Flip();
		Card finalCard2 = player2.Flip();
		matchCount++;
		if (player1.getHand().size() == 0 && finalCard1.getValue() > finalCard2.getValue()) {
			player1.Draw(finalCard1);
			player1.Draw(finalCard2);
		} else if (player2.getHand().size() == 0 && finalCard1.getValue() < finalCard2.getValue()) {
			player2.Draw(finalCard1);
			player2.Draw(finalCard2);
		} else if (finalCard1.getValue() == finalCard2.getValue()) {
			isDraw = true;
			gameOver = true;
		} else {
			gameOver = true;
		}
	}

	private static void tieBreaker(List<Card> tieList) {
		if(player1.getHand().size() == 1 || player2.getHand().size() == 1 ) {
			finalMatch();
			for(int i = 0; i < tieList.size(); i++) {
				tieList.remove(0);
			}
		} else {
			tieList.add(player1.Flip());
			tieList.add(player2.Flip());
			Card tieCard1 = player1.Flip();
			Card tieCard2 = player2.Flip();
			matchCount++;
			if (tieCard1.getValue() > tieCard2.getValue()) {
				for(int i = 0; i < tieList.size(); i++) {
					player1.Draw(tieList.get(0));
				}
				for(int i = 0; i < tieList.size(); i++) {
					tieList.remove(0);
				}
				player1.Draw(tieCard1);
				player1.Draw(tieCard2);
			} else if (tieCard1.getValue() < tieCard2.getValue()) {
				for(int i = 0; i < tieList.size(); i++) {
					player2.Draw(tieList.get(0));
				}
				for(int i = 0; i < tieList.size(); i++) {
					tieList.remove(0);
				}
				player2.Draw(tieCard1);
				player2.Draw(tieCard2);
			} else if (player1.getHand().size() == 0 || player2.getHand().size() == 0) {
				isDraw = true;
				gameOver = true;
			} else {
				tieList.add(tieCard1);
				tieList.add(tieCard2);
				tieBreaker(tieList);
			}
		}
	}

}
