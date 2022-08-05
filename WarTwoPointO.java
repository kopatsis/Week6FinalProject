package FinalProject;

import java.util.ArrayList;
import java.util.List;

public class WarTwoPointO {
	
	public static Player player1 = new Player("Billy Bob");
	public static Player player2 = new Player("Cletus Jones");
	public static boolean isDraw = false;
	public static boolean gameOver = false;
	public static boolean p1wins = false;
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
		
		while(player1.getHand().size() > 0 && player2.getHand().size() > 0 && gameOver == false) {
			Card p1card = player1.Flip();
			Card p2card = player2.Flip();
			matchCount++;
			if(player1.getHand().size() > 0 && player2.getHand().size() > 0) {
				if(p1card.getValue() == p2card.getValue()) {
					if (player1.getHand().size() == 1 || player2.getHand().size() == 1) {
						tieList.add(p2card);
						tieList.add(p1card);
						tieBreakerIf1(tieList);
					} else {
						tieList.add(p2card);
						tieList.add(p1card);
						tieBreakerIf2Plus(tieList);
					}
				} else {
					if(p1card.getValue() > p2card.getValue()) {
						player1.Draw(p1card);
						player1.Draw(p2card);
					} else {
						player2.Draw(p1card);
						player2.Draw(p2card);
					}
				}
			} else {
				if(p1card.getValue() == p2card.getValue()) {
					gameOver = true;
					isDraw = true;
				} else {
					if(player1.getHand().size() == 0) {
						if (p1card.getValue() > p2card.getValue()) {
							player1.Draw(p1card);
							player1.Draw(p2card);
						} else {
							gameOver = true;
						}
					} else {
						if (p1card.getValue() > p2card.getValue()) {
							gameOver = true;
							p1wins = true;
						} else {
							player2.Draw(p1card);
							player2.Draw(p2card);
						} //Goes to p1card vs p2 card if statement
					} //Goes to p1 hand size vs p2 hand size if statement
				} //Goes to p1 card value equals p2 card value if statement

			} //Goes to both hand sizes > 0 or not if statement
		} //Goes to full match's while loop
		
		if(isDraw == true) {
			System.out.println("The game ended in a draw after " + matchCount + " matches");
		} else if(p1wins == true) {
			System.out.println(player1.getName() + " wins the game after " + matchCount + " matches");
		} else {
			System.out.println(player2.getName() + " wins the game after " + matchCount + " matches");
		}
		
		
	} //Goes to public static void main
	
	public static void tieBreakerIf2Plus(List<Card> tieList) {
		tieList.add(player1.Flip());
		tieList.add(player2.Flip());
		Card p1card = player1.Flip();
		Card p2card = player2.Flip();
		matchCount++;
		if(player1.getHand().size() > 0 && player2.getHand().size() > 0) {
			if(p1card.getValue() == p2card.getValue()) {
				if (player1.getHand().size() == 1 || player2.getHand().size() == 1) {
					tieList.add(p2card);
					tieList.add(p1card);
					tieBreakerIf1(tieList);
				} else {
					tieList.add(p2card);
					tieList.add(p1card);
					tieBreakerIf2Plus(tieList);
				}
			} else {
				if(p1card.getValue() > p2card.getValue()) {
					player1.DrawMult(tieList);
					tieList.clear();
					player1.Draw(p1card);
					player1.Draw(p2card);
				} else {
					player2.DrawMult(tieList);
					tieList.clear();
					player2.Draw(p1card);
					player2.Draw(p2card);
				}
			}
		} else {
			if(p1card.getValue() == p2card.getValue()) {
				gameOver = true;
				isDraw = true;
			} else {
				if(player1.getHand().size() == 0) {
					if (p1card.getValue() > p2card.getValue()) {
						player1.DrawMult(tieList);
						tieList.clear();						
						player1.Draw(p1card);
						player1.Draw(p2card);
					} else {
						gameOver = true;
					}
				} else {
					if (p1card.getValue() > p2card.getValue()) {
						gameOver = true;
						p1wins = true;
					} else {
						player2.DrawMult(tieList);
						tieList.clear();
						player2.Draw(p1card);
						player2.Draw(p2card);
					} //Goes to p1card vs p2 card if statement
				} //Goes to p1 hand size vs p2 hand size if statement
			} //Goes to p1 card value equals p2 card value if statement

		} //Goes to both hand sizes > 0 or not if statement
	} //Goes to tieBreakerIf2Plus method signature
	
	public static void tieBreakerIf1(List<Card> tieList) {
		Card p1card = player1.Flip();
		Card p2card = player2.Flip();
		matchCount++;
		if(p1card.getValue() == p2card.getValue()) {
			gameOver = true;
			isDraw = true;
		} else {
			if(player1.getHand().size() == 0) {
				if (p1card.getValue() > p2card.getValue()) {
					player1.DrawMult(tieList);
					tieList.clear();
					player1.Draw(p1card);
					player1.Draw(p2card);
				} else {
					gameOver = true;
				}
			} else {
				if (p1card.getValue() > p2card.getValue()) {
					gameOver = true;
					p1wins = true;
				} else {
					player2.DrawMult(tieList);
					tieList.clear();
					player2.Draw(p1card);
					player2.Draw(p2card);
				} //Goes to card value comparisons for p2 hand size 0
			} //Goes to if p1 or p2 has the hand size of 0
		} //Goes to if it's a tie or not

	} //Goes to tieBreakerIf1 method signature

} //Goes to brackets encompassing entire class WarTwoPointO
