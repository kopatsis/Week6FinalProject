package FinalProject;

public class App {
	
	public static void main(String[] args) {
		
		Deck appDeck = new Deck();
		Player player1 = new Player("Billy Bob");
		Player player2 = new Player("Cletus Jones");
		appDeck.Shuffle();
		
		for(int i = 0; i < 52; i++) {
			if(i % 2 == 0) {
				player1.Draw(appDeck.Draw());
			} else {
				player2.Draw(appDeck.Draw());
			}
		}
		
		System.out.println("Game of War between " + player1.getName() + " and " + player2.getName()+ ":");
		
		for(int i = 0; i < 26; i++) {
			Card player1Card = player1.Flip();
			Card player2Card = player2.Flip();
			if (player1Card.getValue() > player2Card.getValue()) {
				player1.incrementScore();
			} else if (player2Card.getValue() > player1Card.getValue()) {
				player2.incrementScore();
			}
		}
		
		System.out.println(player1.getName() + "'s Score: " + player1.getScore());
		System.out.println(player2.getName() + "'s Score: " + player2.getScore());
		if (player1.getScore() > player2.getScore()) {
			System.out.println("Winner: " + player1.getName());
		} else if (player2.getScore() > player1.getScore()) {
			System.out.println("Winner: " + player2.getName());;
		} else {
			System.out.println("Game ends in a Draw");
		}


	}

}
