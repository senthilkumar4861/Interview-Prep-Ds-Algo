// Rearrange array such that even positioned are greater than odd
// Given an array A of n elements, sort the array according to the following relations :
//  A[i] >= A[i-1]  , if i is even.
//  A[i] <= A[i-1]  , if i is odd.
// Print the resultant array.

// Input : A[] = {1, 2, 2, 1}
// Output :  1 2 1 2
// Explanation : 
// For 1st element, 1  1, i = 2 is even.
// 3rd element, 1  1, i = 4 is even.

// Input : A[] = {1, 3, 2}
// Output : 1 3 2
// Explanation : 
// Here, the array is also sorted as per the conditions. 
// 1  1 and 2 < 3.

// Observe that array consists of [n/2] even positioned elements. 
//If we assign largest [n/2] elements to the even positions and rest of the elements 
//to the odd positions, our problem is solved.
// Because element at odd position will always be less than the element at even 
//position as it is maximum element and vice versa. Sort the array and assign the first [n/2] 
//elements at even positions.

// Java program to rearrange the elements 
// in array such that even positioned are 
// greater than odd positioned elements 
import java.io.*; 
import java.util.*; 

class GFG { 

static void assign(int a[], int n) { 
	
	// Sort the array 
	Arrays.sort(a); 

	int ans[] = new int[n]; 
	int p = 0, q = n - 1; 
	for (int i = 0; i < n; i++) { 
		
	// Assign even indexes with maximum elements 
	if ((i + 1) % 2 == 0) 
		ans[i] = a[q--]; 

	// Assign odd indexes with remaining elements 
	else
		ans[i] = a[p++]; 
	} 

	// Print result 
	for (int i = 0; i < n; i++) 
	System.out.print(ans[i] + " "); 
} 

// Driver code 
public static void main(String args[]) { 
	int A[] = {1, 3, 2, 2, 5}; 
	int n = A.length; 
	assign(A, n); 
} 
} 

// This code is contributed by Nikita Tiwari. 
