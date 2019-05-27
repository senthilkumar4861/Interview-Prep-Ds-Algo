// Java program to find a pair with a given 
// sum in a sorted and rotated array 
class PairInSortedRotated 
{ 
	// This function returns true if arr[0..n-1] 
	// has a pair with sum equals to x. 
	static boolean pairInSortedRotated(int arr[], 
									int n, int x) 
	{ 
		// Find the pivot element 
		int i; 
		for (i = 0; i < n - 1; i++) 
			if (arr[i] > arr[i+1]) 
				break; 
				
		int l = (i + 1) % n; // l is now index of										 
							// smallest element 
						
		int r = i;	 // r is now index of largest 
						//element 
	
		// Keep moving either l or r till they meet 
		while (l != r) 
		{ 
			// If we find a pair with sum x, we 
			// return true 
			if (arr[l] + arr[r] == x) 
				return true; 
	
			// If current pair sum is less, move 
			// to the higher sum 
			if (arr[l] + arr[r] < x) 
				l = (l + 1) % n; 
					
			else // Move to the lower sum side 
				r = (n + r - 1) % n; 
		} 
		return false; 
	} 

	/* Driver program to test above function */
	public static void main (String[] args) 
	{ 
		int arr[] = {11, 15, 6, 8, 9, 10}; 
		int sum = 16; 
		int n = arr.length; 
	
		if (pairInSortedRotated(arr, n, sum)) 
			System.out.print("Array has two elements" + 
							" with sum 16"); 
		else
			System.out.print("Array doesn't have two" + 
							" elements with sum 16 "); 
	} 
} 

//The time complexity of the above solution is O(n).
/*This code is contributed by Prakriti Gupta*/

// Java program to find 
// number of pairs with 
// a given sum in a sorted 
// and rotated array. 
import java.io.*; 

class GFG 
{ 
	
// This function returns 
// count of number of pairs 
// with sum equals to x. 
static int pairsInSortedRotated(int arr[], 
								int n, int x) 
{ 
	// Find the pivot element. 
	// Pivot element is largest 
	// element of array. 
	int i; 
	for (i = 0; i < n - 1; i++) 
		if (arr[i] > arr[i + 1]) 
			break; 
	
	// l is index of 
	// smallest element. 
	int l = (i + 1) % n; 
	
	// r is index of 
	// largest element. 
	int r = i; 
	
	// Variable to store 
	// count of number 
	// of pairs. 
	int cnt = 0; 

	// Find sum of pair 
	// formed by arr[l] 
	// and arr[r] and 
	// update l, r and 
	// cnt accordingly. 
	while (l != r) 
	{ 
		// If we find a pair with 
		// sum x, then increment 
		// cnt, move l and r to 
		// next element. 
		if (arr[l] + arr[r] == x) 
		{ 
			cnt++; 
			
			// This condition is required 
			// to be checked, otherwise 
			// l and r will cross each 
			// other and loop will never 
			// terminate. 
			if(l == (r - 1 + n) % n) 
			{ 
				return cnt; 
			} 
			
			l = (l + 1) % n; 
			r = (r - 1 + n) % n; 
		} 

		// If current pair sum 
		// is less, move to 
		// the higher sum side. 
		else if (arr[l] + arr[r] < x) 
			l = (l + 1) % n; 
		
		// If current pair sum 
		// is greater, move 
		// to the lower sum side. 
		else
			r = (n + r - 1) % n; 
	} 
	
	return cnt; 
} 

// Driver Code 
public static void main (String[] args) 
{ 
	int arr[] = {11, 15, 6, 7, 9, 10}; 
	int sum = 16; 
	int n = arr.length; 

	System.out.println( 
			pairsInSortedRotated(arr, n, sum)); 
} 
} 

// This code is contributed by ajit 
