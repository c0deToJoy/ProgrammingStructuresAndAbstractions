import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class HumanPlayer extends Player {

	private Scanner keyboard;
	
	public HumanPlayer(String name, Scanner keyboard) {
		super(name);
		this.keyboard = keyboard;
	}
	
	@Override
	public int[] getMove(int[] pileSizes) {
		System.out.println("Piles: " + Arrays.toString(pileSizes));
		int pileIdx = getUserInput("Enter pile index: ");
		int numObjects = getUserInput("Enter object number: ");
		return new int[] {pileIdx, numObjects};
	}

	public int getUserInput(String prompt) {
		
		int userNum = 0;
		boolean integerNum = false;
		
		while(integerNum == false) {
			
			System.out.print(prompt);
			
			try {
				userNum = keyboard.nextInt();
				integerNum = true;
				
			}
			catch (InputMismatchException e) {
				keyboard.nextLine();
			}
		}
		
		return userNum;
		
	}
	
	@Override
	public void notifyIllegalMove(String moveInfo) {
		System.out.println(moveInfo);
		System.out.println();
	}
	
	@Override
	public void notifyOpponentMove(String name, int[] move) {
		String notification = name + " removed " + move[1] + " from pile " 
				+ move[0] + ".";
		System.out.println(notification);
		System.out.println();
	}
	
	@Override
	public void notifyWin() {
		System.out.println("Nice job, " + getName() + ". You win!");
	}
	
	@Override
	public void notifyLose() {
		System.out.println("Sorry, " + getName() + ". You lose :(");
	}
}
