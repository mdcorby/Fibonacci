import java.util.Arrays;

public class FibArray {
	private int[] arr;
	
	public FibArray(int n){
		arr=new int[n];
		arr[0]=0;
		for(int a=n-1;a>0;a--) {
			arr[a]=Iterative(a);
		}
	}
	
	// int n = int to add at end
	public void add(int n) {
		int[] o = new int[arr.length+1];
		for (int l=0;l<arr.length;l++) {
			o[l]=arr[l];
		}
		o[arr.length]=n;
		arr=o;
	}
	
	// int n = int to add at index i
	public void add(int n, int i) {
		int[] o = new int[arr.length+1];
		//arrIndex so I can go along the old r after I insert something in the middle of the new index (to account for +1 in middle)
		int arrIndex = 0;
		for (int j=0;j<i;j++) {
			o[j]=arr[arrIndex];
			arrIndex++;
		}
		o[i]=n;
		for(int j=i+1;j<arr.length+1;j++) {
			o[j]=arr[arrIndex];
			arrIndex++;
		}
		arr=o; 
	}
	
	//used to test FibArray making (worked)
	public void Print() {
		System.out.println(Arrays.toString(arr));
	}
	
	//removes a from arr if a is contained in arr
	//a = what item to remove
	public void remove(int a) {
		//if there are double ints in arr must remove 2 off length otherwise will have empty at the end, or triple, quad, etc.
		int count = 0;
		for (int f =0;f<arr.length;f++) {
			if (arr[f]==a) {
				count++;
			}
		}
		//have to define new array to fully remove number, otherwise space left over (like in commented out code)
		int[] o = new int[arr.length-count];
		//cant be inside for loop otherwise will keep getting redefined as zero
		int p = 0;
		for (int i = 0;i<arr.length;i++) {
			//int p =0; NOPE
			if (arr[i]!=a) {
				o[p]=arr[i];
				p++;
			}
		}
		arr=o;
	}
	
	/* REMOVE METHODS FOR IF NOT SUPPOSED TO DEFINE NEW, SMALLER ARRAY
	public void remove(int a) {
		for (int i =0;i<arr.length;i++) {
			if(arr[i]==a) {
				//remove the value and leave the empty space as "0" as null
				//arr[i]=0; 
				//remove the value and move over all to the right, leaving last empty space as "0" as null
				for(int b=i;b<arr.length-1;b++) {
					arr[b]=arr[b+1];
					arr[b+1]=0;
				}
			}
		}
	} */
	
	//checks to see if arr contains s
	public boolean ifContains(int s) {
		boolean ret = false;
		for (int i =0;i<arr.length;i++) {
			if(arr[i]==s) {
				ret=true;
				break;
			}
		}
		return ret;
	}

	//grabs random element of arr
	public int grab() {
		int n = (int)((Math.random())*(arr.length));
		return arr[n];
	}
	
	//returns the amount of unique items in the array (1 only counted once)
	public int numItems() {
		int ret = 0; 
		for (int i =0;i<arr.length;i++) {
			int check = arr[i];
			ret++;
			for (int j =i+1; j<arr.length;j++) {
				if (check==arr[j]) {
					ret--;
					break;
				}
			}
		}
		return ret;
	}
	
	
	
	//copy pasted from Main class in order to use to make array
	//O(n)
		//int n = nth number in fibonacci
		public static int Iterative(int n) {
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
	
}
