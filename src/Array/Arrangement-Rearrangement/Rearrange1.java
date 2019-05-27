// Rearrange array such that arr[i] >= arr[j] if i is even and arr[i]<=arr[j] if i is odd and j < i
// Given an array of n elements. Our task is to write a program to rearrange the array such that elements at even positions are greater than all elements before it and elements at odd positions are less than all elements before it.

// Examples:

// Input : arr[] = {1, 2, 3, 4, 5, 6, 7}
// Output : 4 5 3 6 2 7 1

// Input : arr[] = {1, 2, 1, 4, 5, 6, 8, 8} 
// Output : 4 5 2 6 1 8 1 8


// Java program to rearrange the array 
// as per the given condition 
import java.util.*; 
import java.lang.*; 

public class GfG{ 
	// function to rearrange the array 
	public static void rearrangeArr(int arr[], 
										int n) 
	{ 
		// total even positions 
		int evenPos = n / 2; 

		// total odd positions 
		int oddPos = n - evenPos; 

		int[] tempArr = new int [n]; 

		// copy original array in an 
		// auxiliary array 
		for (int i = 0; i < n; i++) 
			tempArr[i] = arr[i]; 

		// sort the auxiliary array 
		Arrays.sort(tempArr); 

		int j = oddPos - 1; 

		// fill up odd position in 
		// original array 
		for (int i = 0; i < n; i += 2) { 
			arr[i] = tempArr[j]; 
			j--; 
		} 

		j = oddPos; 

		// fill up even positions in 
		// original array 
		for (int i = 1; i < n; i += 2) { 
			arr[i] = tempArr[j]; 
			j++; 
		} 

		// display array 
		for (int i = 0; i < n; i++) 
			System.out.print(arr[i] + " "); 
	} 
	
	// Driver function 
	public static void main(String argc[]){ 
		int[] arr = new int []{ 1, 2, 3, 4, 5, 
										6, 7 }; 
		int size = 7; 
		rearrangeArr(arr, size); 
		
	} 
} 

/* This code is contributed by Sagar Shukla */
// Rearrange positive and negative numbers in O(n) time and O(1) extra space
// An array contains both positive and negative numbers in random order. Rearrange the array elements so that positive and negative numbers are placed alternatively. Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array. If there are more negative numbers, they too appear in the end of the array.

// For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9], then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]

// A JAVA program to put positive numbers at even indexes 
// (0, 2, 4,..) and negative numbers at odd indexes (1, 3, 
// 5, ..) 
import java.io.*; 

class Alternate { 

	// The main function that rearranges elements of given 
	// array. It puts positive elements at even indexes (0, 
	// 2, ..) and negative numbers at odd indexes (1, 3, ..). 
	static void rearrange(int arr[], int n) 
	{ 
		// The following few lines are similar to partition 
		// process of QuickSort. The idea is to consider 0 
		// as pivot and divide the array around it. 
		int i = -1, temp = 0; 
		for (int j = 0; j < n; j++) 
		{ 
			if (arr[j] < 0) 
			{ 
				i++; 
				temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
		} 

		// Now all positive numbers are at end and negative numbers at 
		// the beginning of array. Initialize indexes for starting point 
		// of positive and negative numbers to be swapped 
		int pos = i+1, neg = 0; 

		// Increment the negative index by 2 and positive index by 1, i.e., 
		// swap every alternate negative number with next positive number 
		while (pos < n && neg < pos && arr[neg] < 0) 
		{ 
			temp = arr[neg]; 
			arr[neg] = arr[pos]; 
			arr[pos] = temp; 
			pos++; 
			neg += 2; 
		} 
	} 

	// A utility function to print an array 
	static void printArray(int arr[], int n) 
	{ 
		for (int i = 0; i < n; i++) 
			System.out.print(arr[i] + " "); 
	} 

	/*Driver function to check for above functions*/
	public static void main (String[] args) 
	{ 
		int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9}; 
		int n = arr.length; 
		rearrange(arr,n); 
		System.out.println("Array after rearranging: "); 
		printArray(arr,n); 
	} 
} 
/*This code is contributed by Devesh Agrawal*/




// Rearrange array in alternating positive & negative items with O(1) extra space | Set 1
// Given an array of positive and negative numbers, arrange them in an alternate fashion such that every positive number is followed by negative and vice-versa maintaining the order of appearance.
// Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array. If there are more negative numbers, they too appear in the end of the array.

// Examples :

// Input:  arr[] = {1, 2, 3, -4, -1, 4}
// Output: arr[] = {-4, 1, -1, 2, 3, 4}

// Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
// output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0} 