import java.util.Arrays;

public class Piles {
	
	private int[] sizes;
	
	public Piles(int... initSizes) {
		
	    if (initSizes == null || initSizes.length == 0) {
	        throw new IllegalArgumentException();
	    }
	    
	    for (int size : initSizes) {
	        if (size <= 0) {
	            throw new IllegalArgumentException();
	        }
	    }
	    
	    sizes = new int[initSizes.length];
	    System.arraycopy(initSizes, 0, sizes, 0, initSizes.length);
		
	}
	
	public int[] getSizes() {
		
		return Arrays.copyOf(sizes, sizes.length);
		
	}

	public void removeObjects(int[] move) throws IllegalMoveException {
		
		if(move == null) {
			throw new IllegalMoveException("null move");
		}
		else if(move.length != 2) {
			throw new IllegalMoveException("Invalid length: " + move.length);
		}
		else if(move[0] >= sizes.length || move[0] < 0) {
			throw new IllegalMoveException("Index out of bounds: " + move[0]);
		}
		else if(sizes[move[0]] == 0) {
			throw new IllegalMoveException("Pile " + move[0] + " is empty.");
		}
		else if(move[1] <= 0) {
			throw new IllegalMoveException("Nonpositive object number: " + move[1]);
		}
		else if(move[1] > sizes[move[0]]) {
			throw new IllegalMoveException("Object number greater than pile size: " + move[1] + " > " + sizes[move[0]]);
		}
		else {
			sizes[move[0]] -= move[1]; 
		}
		
	}
	
	public boolean isEmpty() {
		
		boolean nonZeroPile = false;
		
		for(int i = 0; i < sizes.length; i++) {
			if(sizes[i] > 0) {
				nonZeroPile = true;
			}
		}
		
		if(nonZeroPile == true) {
			return false;
		}
		else {
			return true;
		}
		
	}
}
