package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card.
 * @author KANWARPREET KAUR
 * STUDENT NUMBER : 991712544
 */ 
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        for (int i=0; i<magicHand.length; i++)
        {
            Card c = new Card(Card.SUITS[random.nextInt(4)], random.nextInt(13) + 1);
            magicHand[i] = c;
        }
        
        System.out.println("Magic Hand:");
        for (Card card : magicHand) {
            System.out.println(card.getSuit() + " " + card.getValue());
        }
        
        System.out.print("Enter a card value (1-13): ");
        int userValue = scanner.nextInt();
        System.out.print("Enter a suit (0-3 where: 0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades): ");
        int userSuitIndex = scanner.nextInt();
        
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String userSuit = suits[userSuitIndex];
        
        Card userCard = new Card(userSuit, userValue);
        
        boolean found = false;
        for (Card card : magicHand) {
            if (userCard.equals(card)) {
                found = true;
                break;
            }
        }
        
        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
        
        scanner.close();
    }
    
}
