import java.util.Objects;

public class Card {
	private Rank rank;
	private Suit suit;
	
	public Card(Rank rank, Suit suit) throws NullPointerException {
	    if (rank == null || suit == null) {
	        throw new NullPointerException();
	    }
	    
		this.rank = rank;
		this.suit = suit;   
	}
	
	public int compareTo(Card card) {
	    int suitComparison = this.suit.compareTo(card.suit);
	    
	    if (suitComparison != 0) {
	        return suitComparison;
	    }

	    return this.rank.compareTo(card.rank);
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (!(obj instanceof Card)) {
	        return false;
	    }
	    
	    Card otherCard = (Card) obj;

	    return this.rank == otherCard.rank && this.suit == otherCard.suit;
	}
	
	public Rank getRank() {
		return this.rank;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.rank, this.suit);
	}
	
	@Override
	public String toString() {
		return this.rank.toString() + this.suit.toString();
	}
}
