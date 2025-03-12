import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;
	
	public Deck() {
        this.cards = new ArrayList<>();
        
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(rank, suit);
                this.cards.add(card);
            }
        }
	}
	
	public int size() {
		return this.cards.size();
	}
	
	@Override
	public String toString() {
		return this.cards.toString();
	}
	
	public Card draw() {
		if(this.cards == null || this.cards.size() == 0) {
			return null;
		}
		
		Card cardDrawn = this.cards.get(0);
		this.cards.remove(0);
		return cardDrawn;
	}
	
	public List<Card> draw(int count) {
	    List<Card> drawn = new ArrayList<>();
	    
	    if (count >= this.cards.size()) {
	        drawn.addAll(this.cards);
	        this.cards.clear();
	        return drawn;
	    } else if (count <= 0 || this.cards.isEmpty()) {
	        return drawn;
	    }

	    for (int i = 0; i < count; i++) {
	        drawn.add(this.cards.get(i));
	    }

	    for (int i = 0; i < count; i++) {
	        this.cards.remove(0);
	    }

	    return drawn;
	}
	
	public void shuffle() {
		Collections.shuffle(this.cards);
	}
	
	public List<Card> getCardsByRank(Rank rank) {
		List<Card> sameRank = new ArrayList<>();
		
		for(int i = 0; i < this.cards.size(); i++) {
			if(this.cards.get(i).getRank().equals(rank)) {
				sameRank.add(this.cards.get(i));
			}
		}
		return sameRank; 
	}
}
