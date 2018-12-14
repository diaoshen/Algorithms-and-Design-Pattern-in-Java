package edu.diao.sorting;

import java.util.Stack;

import edu.diao.util.SortUtil;
/*
 * Version 1 
 *
 * Sort : 
 * 1. Push range of a[] to stack using index of first element and index of last element
 * 
 * Partition : 
 * 0. divides array a into 3 part =  a[first..j-1] , a[j] , a[j+1 .. last]
 * 1. Uses a[0] as pivot value , @Params are index of first element and index of last element
 * 2. uses cursor i  to scan from a[first+1] .. a[last]
 * 3. uses cursor j  to scan from a[last] .. a[first+1]
 * 4. When done , swaps (a[j] , a[0]) to obtain this property --> a[first..j-1] <= a[j] <= a[j+1 .. last]
 */
public class QuickSortNonRecursiveV1 {
	public static <T extends Comparable<T>> void sort(T[] a) {
		if(a == null || a.length < 2) return;
		
		Stack<Integer> stack = new Stack<Integer>();
		//Push the range of the unsorted array into stack 
		stack.push(0); //Index of first element
		stack.push(a.length-1); //Index of last element
		
		while(!stack.isEmpty()) {
			//Retrieve partition range 
			int end = stack.pop();
			int start = stack.pop();
			
			if(start >= end) { // Skip partition if there are less than 2 element to sort.
				continue;
			}
			
			int pivot = partition(a,start,end);
			
			//Push Right range to stack
			stack.push(start);
			stack.push(pivot - 1);
			
			//Push Left range to stack
			stack.push(pivot + 1);
			stack.push(end);
		} // END WHILE
		
	}//END SORT
	
	public static <T extends Comparable<T>> int partition(T[] a, int lo, int hi) { 
		int i = lo, j = hi + 1; // left and right scan indices
		T v = a[lo]; // the pivot
		while (true) {
			while (SortUtil.isLessThan(a[++i], v)) {//++i is evaluated to i+1 
				if (i == hi) {
					break;
				}
			}
			
			while (SortUtil.isLessThan(v, a[--j])) {//--j is evaluated to j-1
				if (j == lo) {
					break;
				}
			}
			
			if (i >= j) {
				break;
			}
			
			SortUtil.swap(a, i, j);
		}
		SortUtil.swap(a, lo, j); // Put v = a[j] into position

		return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi]
	}//END PARTITION

	
} //END CLASS
