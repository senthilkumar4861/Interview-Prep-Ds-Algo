// Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed
// Given an array, only rotation operation is allowed on array. We can rotate the array as many times as we want. Return the maximum possbile of summation of i*arr[i].
// Examples :

// Input: arr[] = {1, 20, 2, 10}
// Output: 72
// We can 72 by rotating array twice.
// {2, 10, 1, 20}
// 20*3 + 1*2 + 10*1 + 2*0 = 72

// Input: arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
// Output: 330
// We can 330 by rotating array 9 times.
// {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
// 0*1 + 1*2 + 2*3 ... 9*10 = 330
// We strongly recommend you to minimize your browser and try this yourself first.

// A Simple Solution is to find all rotations one by one, check sum of every rotation and return the maximum sum. Time complexity of this solution is O(n2).

// We can solve this problem in O(n) time using an Efficient Solution.
// Let Rj be value of i*arr[i] with j rotations. The idea is to calculate next rotation value from previous rotation, i.e., calculate Rj from Rj-1. We can calculate initial value of result as R0, then keep calculating next rotation values.



// How to efficiently calculate Rj from Rj-1?
// This can be done in O(1) time. Below are details.

// Let us calculate initial value of i*arr[i] with no rotation
// R0 = 0*arr[0] + 1*arr[1] +...+ (n-1)*arr[n-1]

// After 1 rotation arr[n-1], becomes first element of array, 
// arr[0] becomes second element, arr[1] becomes third element
// and so on.
// R1 = 0*arr[n-1] + 1*arr[0] +...+ (n-1)*arr[n-2]

// R1 - R0 = arr[0] + arr[1] + ... + arr[n-2] - (n-1)*arr[n-1]

// After 2 rotations arr[n-2], becomes first element of array, 
// arr[n-1] becomes second element, arr[0] becomes third element
// and so on.
// R2 = 0*arr[n-2] + 1*arr[n-1] +...+ (n-1)*arr[n-3]

// R2 - R1 = arr[0] + arr[1] + ... + arr[n-3] - (n-1)*arr[n-2] + arr[n-1]

// If we take a closer look at above values, we can observe 
// below pattern

// Rj - Rj-1 = arrSum - n * arr[n-j]

// Where arrSum is sum of all array elements, i.e., 

// arrSum = &Sum; arr[i]
//         0<=i<=n-1 
// Below is complete algorithm:

// 1) Compute sum of all array elements. Let this sum be 'arrSum'.

// 2) Compute R0 by doing i*arr[i] for given array. 
//    Let this value be currVal.

// 3) Initialize result: maxVal = currVal // maxVal is result.

// // This loop computes Rj from  Rj-1 
// 4) Do following for j = 1 to n-1
// ......a) currVal = currVal + arrSum-n*arr[n-j];
// ......b) If (currVal > maxVal)
//             maxVal = currVal   

// 5) Return maxVal


// Java program to find max value of i*arr[i] 

import java.util.Arrays; 

class Test 
{ 
	static int arr[] = new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9}; 
	
	// Returns max possible value of i*arr[i] 
	static int maxSum() 
	{ 
		// Find array sum and i*arr[i] with no rotation 
		int arrSum = 0; // Stores sum of arr[i] 
		int currVal = 0; // Stores sum of i*arr[i] 
		for (int i=0; i<arr.length; i++) 
		{ 
			arrSum = arrSum + arr[i]; 
			currVal = currVal+(i*arr[i]); 
		} 
	
		// Initialize result as 0 rotation sum 
		int maxVal = currVal; 
	
		// Try all rotations one by one and find 
		// the maximum rotation sum. 
		for (int j=1; j<arr.length; j++) 
		{ 
			currVal = currVal + arrSum-arr.length*arr[arr.length-j]; 
			if (currVal > maxVal) 
				maxVal = currVal; 
		} 
	
		// Return result 
		return maxVal; 
	} 
	
	// Driver method to test the above function 
	public static void main(String[] args) 
	{ 
		System.out.println("Max sum is " + maxSum()); 
	} 
} 

//Maximum sum of i*arr[i] among all rotations of a given array
// Input : arr[] = {8, 3, 1, 2}
// Output : 29
// Explanation : Let us see all rotations
// {8, 3, 1, 2} = 8*0 + 3*1 + 1*2 + 2*3 = 11
// {3, 1, 2, 8} = 3*0 + 1*1 + 2*2 + 8*3 = 29
// {1, 2, 8, 3} = 1*0 + 2*1 + 8*2 + 3*3 = 27
// {2, 8, 3, 1} = 2*0 + 8*1 + 3*2 + 1*1 = 17

// Input : arr[] = {3, 2, 1}
// Output : 7

// Method 1 (Naive Solution : O(n2) )
// A simple solution is to try all possible rotations. Compute sum of i*arr[i] for every rotation and return maximum sum. 
//Below is the implementation of this idea.

// A Naive Java program to find 
// maximum sum rotation 
import java.util.*; 
import java.io.*; 

class GFG { 

// Returns maximum value of i*arr[i] 
static int maxSum(int arr[], int n) 
{ 
// Initialize result 
int res = Integer.MIN_VALUE; 

// Consider rotation beginning with i 
// for all possible values of i. 
for (int i = 0; i < n; i++) 
{ 

	// Initialize sum of current rotation 
	int curr_sum = 0; 

	// Compute sum of all values. We don't 
	// acutally rotation the array, but compute 
	// sum by finding ndexes when arr[i] is 
	// first element 
	for (int j = 0; j < n; j++) 
	{ 
		int index = (i + j) % n; 
		curr_sum += j * arr[index]; 
	} 

	// Update result if required 
	res = Math.max(res, curr_sum); 
} 

return res; 
} 

// Driver code 
public static void main(String args[]) 
{ 
		int arr[] = {8, 3, 1, 2}; 
		int n = arr.length; 
		System.out.println(maxSum(arr, n)); 
} 

	
} 

// This code is contributed by Sahil_Bansall 


// Time Complexity : O(n2)
// Auxiliary Space : O(1)

// Method 2 (Efficient Solution : O(n) )
// The idea is to compute value of a rotation using value of previous rotation. When we rotate an array by one, following changes happen in sum of i*arr[i].
// 1) Multiplier of arr[i-1] changes from 0 to n-1, i.e., arr[i-1] * (n-1) is added to current value.
// 2) Multipliers of other terms is decremented by 1. i.e., (cum_sum – arr[i-1]) is subtracted from current value where cum_sum is sum of all numbers.

// next_val = curr_val - (cum_sum - arr[i-1]) + arr[i-1] * (n-1);

// next_val = Value of &Sum;i*arr[i] after one rotation.
// curr_val = Current value of &Sum;i*arr[i] 
// cum_sum = Sum of all array elements, i.e., &Sum;arr[i].

// Lets take example {1, 2, 3}. Current value is 1*0+2*1+3*2
// = 8. Shifting it by one will make it {2, 3, 1} and next value
// will be 8 - (6 - 1) + 1*2 = 5 which is same as 2*0 + 3*1 + 1*2
// Below is the implementation of this idea.

// An efficient Java program to compute 
// maximum sum of i*arr[i] 
import java.io.*; 

class GFG { 
	
	static int maxSum(int arr[], int n) 
	{ 
		// Compute sum of all array elements 
		int cum_sum = 0; 
		for (int i = 0; i < n; i++) 
			cum_sum += arr[i]; 

		// Compute sum of i*arr[i] for 
		// initial configuration. 
		int curr_val = 0; 
		for (int i = 0; i < n; i++) 
			curr_val += i * arr[i]; 

		// Initialize result 
		int res = curr_val; 

		// Compute values for other iterations 
		for (int i = 1; i < n; i++) 
		{ 
			// Compute next value using previous 
			// value in O(1) time 
			int next_val = curr_val - (cum_sum - 
						arr[i-1]) + arr[i-1] * 
						(n-1); 

			// Update current value 
			curr_val = next_val; 

			// Update result if required 
			res = Math.max(res, next_val); 
		} 

		return res; 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		int arr[] = {8, 3, 1, 2}; 
		int n = arr.length; 
		System.out.println(maxSum(arr, n)); 
	} 
} 
// This code is contributed by Prerna Saini 


// Method 3 (Using pivot: O(n) ):
// Below is the implementation using pivot.

// Java program to find maximum sum 
// of all rotation of i*arr[i] using pivot. 

import java.util.*; 
import java.lang.*; 
import java.io.*; 

class GFG 
{ 

// function definition 
static int maxSum(int arr[], int n) 
{ 
	int sum = 0; 
	int i; 
	int pivot = findPivot(arr, n); 

	// difference in pivot and index of 
	// last element of array 
	int diff = n - 1 - pivot; 
	for(i = 0; i < n; i++) 
	{ 
		sum= sum + ((i + diff) % n) * arr[i]; 
	} 
	return sum; 
} 

// function to find pivot 
static int findPivot(int arr[], int n) 
{ 
	int i; 
	for(i = 0; i < n; i++) 
	{ 
		if(arr[i] > arr[(i + 1) % n]) 
			return i; 
	} 
	return 0; 
} 

// Driver code 
public static void main(String args[]) 
{ 
	// rotated input array 
	int arr[] = {8, 3, 1, 2}; 
	int n = arr.length; 
	int max = maxSum(arr,n); 
	System.out.println(max); 
	
} 
} 


// Time Complexity : O(n)
// Auxiliary Space : O(1)