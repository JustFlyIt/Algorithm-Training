package util;

public class PrintSupport {
	
	public static void printArray(int[] input) {
		for (int i=0; i<input.length; i++) {
			if (i==0)
				System.out.print("Input: " + input[i]);
			else
				System.out.print(", " + input[i]);
		}
		
		System.out.println();
	}
}
