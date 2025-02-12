import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardHandGenerator {

    private List<Card> deck;

    public CardHandGenerator() {
        initializeDeck();
    }

    private void initializeDeck() {
        deck = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        shuffleDeck();
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public Card dealCard() {
        if (deck.isEmpty()) {
            initializeDeck();
        }
        return deck.remove(0);
    }

    public List<Card> getNewHand(int numCards) {
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < numCards; i++) {
            hand.add(dealCard());
        }
        return hand;
    }
}
