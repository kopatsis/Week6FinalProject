package FinalProject;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List <Card> hand = new ArrayList<Card>();
	private int score;
	private String name;
	

	public Player(String name) {
		this.name = name;
		setScore(0);
	}
	
	
	public void Draw(Card drawnCard) {
		hand.add(drawnCard);
	}
	
	public void DrawMult(List<Card> cardList) {
		hand.addAll(cardList);
	}
	
	public Card Flip() {
			Card topCard = hand.get(0);
			hand.remove(0);
			return topCard;

	}
	
	public void incrementScore() {
		score += 1;
	}
	
	public void describe() {
		System.out.println(name + "'s Hand:");
		for(int i = 0; i < hand.size(); i++) {
			hand.get(i).describe();
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public List<Card> getHand(){
		return hand;
	}


}
