/**
 * Implement each of the 10 methods tested in JUnitTests.java. Study the tests
 * to determine how the methods should work.
 */
public class Java1Review {

	public static void main(String[] args) {
		// If you want to write your own tests, do so here. (Do not modify
		// JUnitTests.java.) To run this method in Eclipse, right-click
		// Java1Review.java in the Package Explorer and select "Run As" >
		// "Java Application" from the context menu.
	}
	
	public static double divide(double x, double y) {
		return x/y;
	}
	
	public static int divide(int x, int y) {
		return x/y;
	}
	
	public static boolean isDivisibleBy7(int x) {
		if (x%7 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static String main(String text) {
		return "Overloaded main method was passed \"" + text + "\".";
	}
	
	public static int findMin(int x, int y, int z) {
		if(x < y && x < z) {
			return x;
		}
		else if (y < x && y < z) {
			return y;
		}
		else {
			return z;
		}
	}
	
	public static int findMin(int[] arr) {
		int min = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
	
	public static double average(int[] arr) {
		int sum = 0;
		double avg = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		avg = (double)sum/(double)arr.length;
		return avg;
	}
	
	public static String[] toLowerCase(String[] arr) {
		for(int i=0; i < arr.length; i++) {
			String text = arr[i];
			arr[i] = text.toLowerCase();
		}
		return arr;
	}
	
	public static String[] toLowerCaseCopy(String[] arr) {
		String[] newArr = new String[arr.length];
		
		for(int i=0; i < arr.length; i++) {
			String text = arr[i];
			newArr[i] = text.toLowerCase();
		}
		return newArr;
	}
	
	public static int[] removeDuplicates(int[] arr) {
		int[] dupes = new int[arr.length];
		int openObject = 0;
		
		for(int i=0; i < arr.length; i++) {
			for(int k=i+1; k < arr.length; k++) {
				if(arr[i] == arr[k]) {
					dupes[openObject] = arr[i];
					openObject++;
				}
			}
		}
		
		for(int i=0; i < arr.length; i++) {
			for(int k=0; k < dupes.length; k++) {
				if(arr[i] == dupes[k]) {
					arr[i] = 0;
				}
			}
		}
		
		return arr;
	}
	
}
