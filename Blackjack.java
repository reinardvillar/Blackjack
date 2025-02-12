import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardHandGenerator deck = new CardHandGenerator();
        CardGameEx playerHand = new CardGameEx();
        CardGameEx dealerHand = new CardGameEx();

        playerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        
        System.out.println("Your hand: " + playerHand.getHand() + " (Value: " + playerHand.getHandValue() + ")");
        System.out.println("Dealer's hand: " + dealerHand.getHand().get(0) + " + [hidden card]");

        while (true) {
            System.out.print("Hit or stand? (h/s): ");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("h")) {
                playerHand.addCard(deck.dealCard());
                System.out.println("Your hand: " + playerHand.getHand() + " (Value: " + playerHand.getHandValue() + ")");

                if (playerHand.getHandValue() > 21) {
                    System.out.println("Bust! You lose.");
                    return;
                }
            } else if (action.equalsIgnoreCase("s")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'h' or 's'.");
            }
        }

        System.out.println("Dealer's turn. Dealer's hand: " + dealerHand.getHand() + " (Value: " + dealerHand.getHandValue() + ")");
        while (dealerHand.getHandValue() < 17) {
            dealerHand.addCard(deck.dealCard());
            System.out.println("Dealer hits. Dealer's hand: " + dealerHand.getHand() + " (Value: " + dealerHand.getHandValue() + ")");

            if (dealerHand.getHandValue() > 21) {
                System.out.println("Dealer busts! You win.");
                return;
            }
        }

        if (dealerHand.getHandValue() >= playerHand.getHandValue()) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("You win!");
        }
    }
}
