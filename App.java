import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//creates a class to hold cards 
class Card {
    public int value;
    public String name;
//creates a public method of card which takes an integer value/string value
    public Card(int value, String name) {
        this.value = value;
        this.name = name;
    }
// method to return value of card
    public int getValue() {
        return value;
    }
//method that returns the name of the card
    public String getName() {
        return name;
    }

//method to describe the cards
    public void describe() {
        System.out.println("Card: " + name);
    }
}
//Class to represent the deck of cards
class Deck {
    private List<Card> cards;
//Constructor for the deck. Creates a full deck of 52 cards.
    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] names = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < names.length; j++) {
                cards.add(new Card(j + 2, names[j] + " of " + suits[i]));
            }
        }
    }
//Method to shuffle the deck of cards.
    public void shuffle() {
        Collections.shuffle(cards);
    }
//Method to draw a card from the deck.
    public Card draw() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }
}

class Player {
    private List<Card> hand;
    private int score;
    private String name;
//constructor for player
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public void describe() {
        System.out.println("Player: " + name + ", Score: " + score);
        for (Card card : hand) {
            card.describe();
        }
    }

    public Card flip() {
        if (!hand.isEmpty()) {
            return hand.remove(0);
        }
        return null;
    }

    public void draw(Deck deck) {
        Card card = deck.draw();
        if (card != null) {
            hand.add(card);
        }
    }

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
//APP class which runs the card game with 2 players
public class App {
    public static void main(String[] args) {
        
        Deck deck = new Deck();
        
        deck.shuffle();
        
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        // Deal 26 cards to each player (alternating).
        for (int i = 0; i < 52; i++) {
            if (i % 2 == 0) {
                player1.draw(deck);
            } else {
                player2.draw(deck);
            }
        }
        // Play 25 rounds of the game.
        for (int i = 0; i < 25; i++) {
            System.out.println("--- Round " + (i + 1) + " ---");
            // Each player flips a card.
            Card card1 = player1.flip();
            Card card2 = player2.flip();
            // Check if both players have cards.
            if (card1 != null && card2 != null) {
                // Describe the cards played.
                card1.describe();
                card2.describe();
                // Compare the card values and award a point to the winner.
                if (card1.getValue() > card2.getValue()) {
                    player1.incrementScore();
                    System.out.println(player1.getName() + " wins the round!");
                } else if (card1.getValue() < card2.getValue()) {
                    player2.incrementScore();
                    System.out.println(player2.getName() + " wins the round!");
                } else {
                    System.out.println("Tie! No points awarded.");
                }
                // Print the current scores.
                System.out.println(player1.getName() + " score: " + player1.getScore());
                System.out.println(player2.getName() + " score: " + player2.getScore());
            }
        }
        // Print the final scores.
        System.out.println(" Final Scores ---");
        System.out.println(player1.getName() + " score: " + player1.getScore());
        System.out.println(player2.getName() + " score: " + player2.getScore());
        // Determine and print the winner of the game.
        if (player1.getScore() > player2.getScore()) {
            System.out.println(player1.getName() + " wins the game!");
        } else if (player1.getScore() < player2.getScore()) {
            System.out.println(player2.getName() + " wins the game!");
        } else {
            System.out.println("Draw!");
        }
    }
}

