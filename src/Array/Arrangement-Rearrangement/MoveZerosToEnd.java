// Move all zeroes to end of array
// Given an array of random numbers, Push all the zero’s of a given array 
//to the end of the array. For example, 
//if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0},
// it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. The order of all other elements should be same. Expected time complexity is O(n) and extra space is O(1).

/* Java program to push zeroes to back of array */
import java.io.*; 

class PushZero 
{ 
	// Function which pushes all zeros to end of an array. 
	static void pushZerosToEnd(int arr[], int n) 
	{ 
		int count = 0; // Count of non-zero elements 

		// Traverse the array. If element encountered is 
		// non-zero, then replace the element at index 'count' 
		// with this element 
		for (int i = 0; i < n; i++) 
			if (arr[i] != 0) 
				arr[count++] = arr[i]; // here count is 
									// incremented 

		// Now all non-zero elements have been shifted to 
		// front and 'count' is set as index of first 0. 
		// Make all elements 0 from count to end. 
		while (count < n) 
			arr[count++] = 0; 
	} 

	/*Driver function to check for above functions*/
	public static void main (String[] args) 
	{ 
		int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9}; 
		int n = arr.length; 
		pushZerosToEnd(arr, n); 
		System.out.println("Array after pushing zeros to the back: "); 
		for (int i=0; i<n; i++) 
			System.out.print(arr[i]+" "); 
	} 
} 
/* This code is contributed by Devesh Agrawal */
// Move all zeroes to end of array | Set-2 (Using single traversal)
// Given an array of n numbers. The problem is to move all the 0’s to the end of the array while maintaining the order of the other elements. Only single traversal of the array is required.

// Examples:

// Input : arr[]  = {1, 2, 0, 0, 0, 3, 6}
// Output : 1 2 3 6 0 0 0

// Input: arr[] = {0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9}
// Output: 1 9 8 4 2 7 6 9 0 0 0 0 0

// Java implementation to move 
// all zeroes at the end of array 
import java.io.*; 

class GFG { 

// function to move all zeroes at 
// the end of array 
static void moveZerosToEnd(int arr[], int n) { 
	
	// Count of non-zero elements 
	int count = 0; 
	int temp; 

	// Traverse the array. If arr[i] is 
	// non-zero, then swap the element at 
	// index 'count' with the element at 
	// index 'i' 
	for (int i = 0; i < n; i++) { 
	if ((arr[i] != 0)) { 
		temp = arr[count]; 
		arr[count] = arr[i]; 
		arr[i] = temp; 
		count = count + 1; 
	} 
	} 
} 

// function to print the array elements 
static void printArray(int arr[], int n) { 
	for (int i = 0; i < n; i++) 
	System.out.print(arr[i] + " "); 
} 

// Driver program to test above 
public static void main(String args[]) { 
	int arr[] = {0, 1, 9, 8, 4, 0, 0, 2, 
						7, 0, 6, 0, 9}; 
	int n = arr.length; 

	System.out.print("Original array: "); 
	printArray(arr, n); 

	moveZerosToEnd(arr, n); 

	System.out.print("\nModified array: "); 
	printArray(arr, n); 
} 
} 

// This code is contributed by Nikita Tiwari. 
// Given an array of n positive integers and a number k. Find the minimum number of swaps required to bring all the numbers less than or equal to k together.

// Input:  arr[] = {2, 1, 5, 6, 3}, k = 3
// Output: 1

// Explanation: 
// To bring elements 2, 1, 3 together, swap 
// element '5' with '3' such that final array
// will be-
// arr[] = {2, 1, 3, 6, 5}

// Input:  arr[] = {2, 7, 9, 5, 8, 7, 4}, k = 5
// Output: 2

// A simple solution is to first count all elements less than or equals to k(say ‘good’). Now traverse for every sub-array and swap those elements whose value is greater than k. Time complexity of this approach is O(n2)

// A simple approach is to use two pointer technique and sliding window.

// Find count of all elements which are less than or equals to ‘k’. Let’s say the count is ‘cnt’
// Using two pointer technique for window of length ‘cnt’, each time keep track of how many elements in this range are greater than ‘k’. Let’s say the total count is ‘bad’.
// Repeat step 2, for every window of length ‘cnt’ and take minimum of count ‘bad’ among them. This will be the final answer.

// Java program to find minimum 
// swaps required to club all 
// elements less than or equals 
// to k together 
import java.lang.*; 

class GFG { 
	
// Utility function to find minimum swaps 
// required to club all elements less than 
// or equals to k together 
static int minSwap(int arr[], int n, int k) { 

	// Find count of elements which are 
	// less than equals to k 
	int count = 0; 
	for (int i = 0; i < n; ++i) 
	if (arr[i] <= k) 
		++count; 

	// Find unwanted elements in current 
	// window of size 'count' 
	int bad = 0; 
	for (int i = 0; i < count; ++i) 
	if (arr[i] > k) 
		++bad; 

	// Initialize answer with 'bad' value of 
	// current window 
	int ans = bad; 
	for (int i = 0, j = count; j < n; ++i, ++j) { 

	// Decrement count of previous window 
	if (arr[i] > k) 
		--bad; 

	// Increment count of current window 
	if (arr[j] > k) 
		++bad; 

	// Update ans if count of 'bad' 
	// is less in current window 
	ans = Math.min(ans, bad); 
	} 
	return ans; 
} 

// Driver code 
public static void main(String[] args) 
{ 
	int arr[] = {2, 1, 5, 6, 3}; 
	int n = arr.length; 
	int k = 3; 
	System.out.print(minSwap(arr, n, k) + "\n"); 

	int arr1[] = {2, 7, 9, 5, 8, 7, 4}; 
	n = arr1.length; 
	k = 5; 
	System.out.print(minSwap(arr1, n, k)); 
} 
} 

// This code is contributed by Anant Agarwal. 
// Time complexity: O(n)
// Auxiliary space: O(1)

