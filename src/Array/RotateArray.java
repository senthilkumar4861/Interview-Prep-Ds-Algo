// Java program to rotate an array by 
// d elements 

class RotateArray { 
	/*Function to left rotate arr[] of size n by d*/
	void leftRotate(int arr[], int d, int n) 
	{ 
		for (int i = 0; i < d; i++) 
			leftRotatebyOne(arr, n); 
	} 

	void leftRotatebyOne(int arr[], int n) 
	{ 
		int i, temp; 
		temp = arr[0]; 
		for (i = 0; i < n - 1; i++) 
			arr[i] = arr[i + 1]; 
		arr[i] = temp; 
	} 

	/* utility function to print an array */
	void printArray(int arr[], int n) 
	{ 
		for (int i = 0; i < n; i++) 
			System.out.print(arr[i] + " "); 
	} 

	// Driver program to test above functions 
	public static void main(String[] args) 
	{ 
		RotateArray rotate = new RotateArray(); 
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 }; 
		rotate.leftRotate(arr, 2, 7); 
		rotate.printArray(arr, 7); 
	} 
} 
//Time complexity : O(n * d)
//Auxiliary Space : O(1)

// This code has been contributed by Mayank Jaiswal 

//Juggling Algorithm

// Java program to rotate an array by 
// d elements 
class RotateArray { 
	/*Function to left rotate arr[] of siz n by d*/
	void leftRotate(int arr[], int d, int n) 
	{ 
		int i, j, k, temp; 
		int g_c_d = gcd(d, n); 
		for (i = 0; i < g_c_d; i++) { 
			/* move i-th values of blocks */
			temp = arr[i]; 
			j = i; 
			while (true) { 
				k = j + d; 
				if (k >= n) 
					k = k - n; 
				if (k == i) 
					break; 
				arr[j] = arr[k]; 
				j = k; 
			} 
			arr[j] = temp; 
		} 
	} 

	/*UTILITY FUNCTIONS*/

	/* function to print an array */
	void printArray(int arr[], int size) 
	{ 
		int i; 
		for (i = 0; i < size; i++) 
			System.out.print(arr[i] + " "); 
	} 

	/*Fuction to get gcd of a and b*/
	int gcd(int a, int b) 
	{ 
		if (b == 0) 
			return a; 
		else
			return gcd(b, a % b); 
	} 

	// Driver program to test above functions 
	public static void main(String[] args) 
	{ 
		RotateArray rotate = new RotateArray(); 
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 }; 
		rotate.leftRotate(arr, 2, 7); 
		rotate.printArray(arr, 7); 
	} 
} 

// This code has been contributed by Mayank Jaiswal 
