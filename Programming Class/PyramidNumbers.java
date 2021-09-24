/*
	Lessons Learned:
	
When I first made the pyramid the single digit numbers worked but double digit numbers made the pyramid wonky.
 11
12 12

 or

  11
12 12

I needed to have the spacing between the numbers equal to the length of the biggest number.

  11
12  12

This method works for larger numbers but the lower numbers are now wonky.

  9
10  10

 or 

   9
10  10

To help understand this, I theorised making they pyramid with blocks of a certain length.
These blocks (all the same size) either contain a number or are blank.
To make the numbers appear centered in their blocks is impossible since odd and even lines in the pyramid would need different block lengths.
As a solution to this I padded the lower numbers with zeros to create a standard length.

  09
10  10

Edit:
I have now learned about String formatting which would make the padding easier than printing 0s and spaces!
*/

public class PyramidNumbers {
	public static int BlockLength(int numRows) {
		int numLength = String.valueOf(numRows).length();
		return numLength;
	}
	
	public static void BlankBlock (int numRows) {
		int blockLength = BlockLength(numRows);
		for (int i=0; i<blockLength; i++) {
			System.out.print(" ");
		}
	}
	
	public static void NumBlock (int numRows, int number) {
		int blockLength = BlockLength(numRows);
		int numberLength = String.valueOf(number).length();
		
		//how many 0's does it need to make the number the length of the block?
		int numZeros = blockLength - numberLength;
		
		//create 0's
		for (int i=0; i<numZeros; i++) {
			System.out.print("0");
		}
		System.out.print(number);
	}
	
	public static void main (String[] args) {
		// How many rows do you want?
		int numRows = 101;
		
		for (int i=1; i<=numRows; i++) { //repeats line for number of rows
			
			// space before numbers
			for (int j=0; j<=(numRows-i); j++) {
				BlankBlock(numRows);
			}
			
			// numbers
			for (int k=0; k<i; k++) {
				NumBlock(numRows, i);
				BlankBlock(numRows);
			}
			
			//new line for next iteration
			System.out.println("");
		}	
	}
}