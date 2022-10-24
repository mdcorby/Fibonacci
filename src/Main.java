import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//all this scanner stuff I wrote while I was bored at night, enjoy the ease of use
		//if you want to just mess with the inputs directly in the code u can do that as well idc
		Scanner L = new Scanner(System.in);
		System.out.println("What number in the Fibonnaci sequence do you want:");
		int num = L.nextInt();
		System.out.println("That number is:");
		System.out.println(Iterative(num));
		//System.out.println(Recursive(7)); //less efficient
		//BELOW THIS IS PREMADE STUFF TO TEST 
		
		//define new Array of Fibonacci sequence
		System.out.println();
		System.out.println("Array of Fibonnaci Number stuff:");
		System.out.println("How many numbers would you like in the array?");
		int arrNum = L.nextInt();
		FibArray n = new FibArray(arrNum);
		n.Print();
		
		
		//remove something from n
		System.out.println("What number would you like to remove?");
		int usrRem = L.nextInt();
		System.out.println("all "+usrRem+"s have been removed from the array");
		n.remove(usrRem);
		n.Print();
		System.out.println();
		
		
		
		
		//check for a number
		System.out.println("What number would you like to check for:");
		int usrCheck = L.nextInt();
		System.out.println("does the array contain "+usrCheck+": "+n.ifContains(usrCheck));
		
		System.out.println();
		
		//check for another number
		System.out.println("What is another number you would like to check for:");
		int usrCheck2 = L.nextInt();
		System.out.println("does the array contain "+usrCheck2+": "+n.ifContains(usrCheck2));

		System.out.println();
		
		//grab random from n
		n.Print();
		System.out.println("Here is a random number from the array: "+ n.grab());
		
		System.out.println();
		
		/*System.out.println("remove any 1s from the array");
		n.remove(1);
		n.Print();*/
		//get the amount of unique numbers in n
		n.Print();
		System.out.println("The number of unique items in the array is: " +n.numItems());
		
		System.out.println();
		
		//add a number to the end of the array
		System.out.println("What number would you like to the end of the array?");
		int addEnd = L.nextInt();
		n.add(addEnd);
		System.out.println("done");
		n.Print();
		
		System.out.println();
		
		//add a number to any index in the array
		System.out.println("What number would you like to add to the array?");
		int addS = L.nextInt();
		System.out.println("And at what index in the array?");
		int index = L.nextInt();
		n.add(addS,index);
		System.out.println("done");
		n.Print(); 
		
	}
	
	//O(n)
	//int n = nth number in fibonacci
	public static int Iterative(int n) {
		//base cases (0 is 0th term of sequence)
		if (n==0) {
			return 0;
		}
		if (n==1||n==2) {
			return 1;
		}
		//used only for addition
		int prev = 0;
		//what will eventually be returned
		int target = 1;
		for (int i=0;i<n-1;i++) {
			int a = prev+target;
			prev=target;
			target=a;
		}
		return target;
		
	}
	
	//O(2^n)
    //int n = nth number in fibonacci
	private static int Recursive(int n) {
		//base case
		if (n==0) {
			return 0;
		}
		//base case pt 2
		if (n==1||n==2) {
			return 1;
		}
		return Recursive(n-1)+Recursive(n-2);
	}
	
	

}


