import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackjackHand {
	private static final Map<Rank, Integer> CARD_VALUES;
	private static final int MAX_VALUE = 21;
	private List<Card> cards = new ArrayList<>();
	private int value = 0;
	private int numAcesAs11 = 0;
	
	static {
        CARD_VALUES = new HashMap<>();
        CARD_VALUES.put(Rank.TWO, 2);
        CARD_VALUES.put(Rank.THREE, 3);
        CARD_VALUES.put(Rank.FOUR, 4);
        CARD_VALUES.put(Rank.FIVE, 5);
        CARD_VALUES.put(Rank.SIX, 6);
        CARD_VALUES.put(Rank.SEVEN, 7);
        CARD_VALUES.put(Rank.EIGHT, 8);
        CARD_VALUES.put(Rank.NINE, 9);
        CARD_VALUES.put(Rank.TEN, 10);
        CARD_VALUES.put(Rank.JACK, 10);
        CARD_VALUES.put(Rank.QUEEN, 10);
        CARD_VALUES.put(Rank.KING, 10);
        CARD_VALUES.put(Rank.ACE, 11);
    }
	
	public BlackjackHand(Card c1, Card c2) {
		this.cards.add(c1);
		this.cards.add(c2);

		this.value += CARD_VALUES.get(c1.getRank());
		this.value += CARD_VALUES.get(c2.getRank());
		
		if(c1.getRank() == Rank.ACE) {
			this.numAcesAs11++;
		}
		if(c2.getRank() == Rank.ACE) {
			this.numAcesAs11++;
		}
	}
	
	public void addCard(Card card) {
	    if (card == null) {
	        throw new NullPointerException();
	    }

	    int futureValue = this.value + CARD_VALUES.get(card.getRank());
	    if(futureValue > MAX_VALUE && this.numAcesAs11 > 0 && this.value != MAX_VALUE) {
	    	while (futureValue > MAX_VALUE && this.numAcesAs11 > 0) {
		    	this.value -= 10;
		    	futureValue -= 10;
		        this.numAcesAs11--;
	    	}
	    }
	    
	    if(this.value < MAX_VALUE) {
	    	this.cards.add(card);
	    	
		    Rank rank = card.getRank();
		    
		    if (rank == Rank.ACE) {
		        this.numAcesAs11++;
		    }
		    
		    int num = CARD_VALUES.get(rank);
		    this.value += num;
	    }
	}
	
	public int size() {
		return this.cards.size();
	}
	
	public static Map<Rank, Integer> getCardValues() {
		return new HashMap<>(CARD_VALUES);
	}
	
	public List<Card> getCards() {
		return new ArrayList<>(this.cards);
	}
	
	public int getValue() {
	    int totalValue = this.value;

	    while (totalValue > MAX_VALUE && this.numAcesAs11 > 0) {
	        this.value -= 10;
	        totalValue -= 10;
	        this.numAcesAs11--;
	    }

	    return totalValue;
	}
	
	@Override
	public String toString() {
		return this.cards.toString();
	}
}
