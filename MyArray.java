package lab3;

import java.util.Arrays;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
	// Output: 3
	public int iterativeLinearSearch(int target) {
		// TODO
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target)
				return i;
		}
		return -1;
	}

	public int recursiveLinearSearchHelper(int target, int indexOfArray) {
		if (indexOfArray >= array.length)
			return -1;
		else if (array[indexOfArray] == target)
			return indexOfArray;
		else
			return recursiveLinearSearchHelper(target, indexOfArray + 1);
	}

	public int recursiveLinearSearch(int target) {
		return recursiveLinearSearchHelper(target, 0);
	}

	// To find the index of the target in the sorted array. If the
	// target is not found in the array, then the method returns -1.
	public int iterativeBinarySearch(int target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (target == array[mid])
				return 1;
			else if (target < array[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	// To find the index of the target in the sorted array. If the
	// target is not
	// found in the array, then the method returns -1.
	public int recursiveBinarySearch(int target) {
		return recursiveBinarySearchHelper(target, 0, array.length);
	}

	private int recursiveBinarySearchHelper(int target, int low, int high) {
		Arrays.sort(array);
		int mid;
		if (low > high)
			return -1;
		else
			mid = low + (high - low) / 2;
		if (target == array[mid])
			return 1;
		else if (target < array[mid])
			return recursiveBinarySearchHelper(target, low, mid - 1);
		else
			return recursiveBinarySearchHelper(target, mid + 1, high);
	}

	public static void main(String[] args) {
		int[] arr = { 12, 10, 9, 45, 2, 10, 10, 45 };
		int target = 45;
		MyArray myArray = new MyArray(arr);

		System.out.println(myArray.iterativeLinearSearch(target));
		System.out.println(myArray.recursiveLinearSearch(target));
		System.out.println(myArray.iterativeBinarySearch(target));
		System.out.println(myArray.recursiveBinarySearch(target));
	}

}
