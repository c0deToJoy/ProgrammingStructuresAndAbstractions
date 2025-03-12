import java.util.Random;

public class RandomPlayer extends Player {

	private Random generator;
	
	public RandomPlayer(String name) {
		super(name);
		generator = new Random();
	}

	public int[] getMove(int[] pileSizes) {
		
		int index = -1;
		int num = -1;
		boolean legalMove = false;
		
		while (legalMove == false) {
			
			index = generator.nextInt(pileSizes.length);
			while (pileSizes[index] == 0) {
	            index = generator.nextInt(pileSizes.length);
	        }

	        num = generator.nextInt(pileSizes[index]) + 1;

	        if (pileSizes[index] >= num) {
	            legalMove = true;
	        }
	    }
		
		int[] move = {index, num};
		return move;
		
	}
	
}
