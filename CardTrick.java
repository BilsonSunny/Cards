package exercise1;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a hand of 7 cards with random Card Objects and then asks the user to pick a card.
 * It then searches the array of cards for the match to the user's card.
 * To be used as starting code in Exercise
 * 
 * Note: The Card class and its SUITS array are not provided in this code snippet.
 * You would need to define the Card class and its properties (value and suit) for the code to work correctly.
 * 
 * @author dancye
 * @author Bilson
 * @date May 27, 2022
 */
public class CardTrick {

    public static void main(String[] args) {

        Card[] hand = new Card[7];

        Random random = new Random();
        for (int i = 0; i < hand.length; i++) {
            Card card = new Card();
            card.setValue(random.nextInt(13) + 1); // Generates a random value between 1 and 13
            card.setSuit(Card.SUITS[random.nextInt(4)]); // Generates a random suit index between 0 and 3
            hand[i] = card;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of your card (1-13): ");
        int value = scanner.nextInt();
        System.out.print("Enter the suit of your card (1-4): ");
        int suitIndex = scanner.nextInt();

        // Adjust the user's input to match array indices
        value--; // Subtract 1 to match the 0-based array indices
        suitIndex--;

        Card userCard = new Card();
        userCard.setValue(value);
        userCard.setSuit(Card.SUITS[suitIndex]);

        boolean foundMatch = false;
        for (Card card : hand) {
            if (card.equals(userCard)) {
                foundMatch = true;
                break;
            }
        }

        if (foundMatch) {
            printInfo();
        }
    }

    /**
     * A simple method to print out personal information. Replace this information with your own.
     */
    private static void printInfo() {
        System.out.println("Congratulations, you guessed right!");
        System.out.println();
        System.out.println("Personal Information:");
        System.out.println("-- Name: Bilson");
        System.out.println("-- Age: 21");
        System.out.println("-- Occupation: Student");
        System.out.println();
        System.out.println("Hobbies:");
        System.out.println("-- Playing guitar");
        System.out.println("-- Cooking");
        System.out.println("-- Reading books");
        System.out.println("-- Playing video games");
    }
}
