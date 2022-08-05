package FinalProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private List <Card> deck = new ArrayList<Card>();
	
	public Deck() {
		for(int i = 0; i < 52; i++) {
			Card current = new Card();
			current.setValue((i % 13) + 2);
			StringBuilder currentName = new StringBuilder("");
			currentName.append(valueToName(current.getValue()));
			currentName.append(suitAssigner((i / 13) % 4));
			current.setName(currentName.toString());
			deck.add(current);
		}
	}
	
	public void Shuffle() {
		Collections.shuffle(deck);
		Collections.shuffle(deck);
		Collections.shuffle(deck);
	}
	
	public Card Draw() {
		Card spaceHold = deck.get(0);
		deck.remove(0);
		return spaceHold;
	}
	
	private String valueToName(int value) {
		if (value == 2) {
			return "Two of ";
		} else if (value == 3){
			return "Three of ";
		} else if (value == 4){
			return "Four of ";
		} else if (value == 5){
			return "Five of ";
		} else if (value == 6){
			return "Six of ";
		} else if (value == 7){
			return "Seven of ";
		} else if (value == 8){
			return "Eight of ";
		} else if (value == 9){
			return "Nine of ";
		} else if (value == 10){
			return "Ten of ";
		} else if (value == 11){
			return "Jack of ";
		} else if (value == 12){
			return "Queen of ";
		} else if (value == 13){
			return "King of ";
		} else if (value == 14){
			return "Ace of ";
		} else {
			return "";
		}
	}
	
	private String suitAssigner(int suitVal) {
		if(suitVal == 0) {
			return "Hearts";
		} else if (suitVal == 1) {
			return "Diamonds";
		} else if (suitVal == 2) {
			return "Clubs";
		} else if (suitVal == 3) {
			return "Spades";
		} else {
			return "";
		}
	}
	
	public void describeDeck() {
		for(int i = 0; i < deck.size(); i++) {
			deck.get(i).describe();
		}
	}
	

}
