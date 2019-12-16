package edu.diao.sorting;

import java.util.Stack;
import edu.diao.util.SortUtil;
/*
 * Version 2
 * 
 * Sort :
 * 1. Push range of a[] to stack using index of first element and length of array a
 * 
 * Partition : 
 * 0. divides array a into 3 part = a[first .. p-1] , a[p] , a[p+1 .. last+1]
 * 1. Uses median index as pivot index  , @Params are index of first element and length of array
 * 2. uses cursor L to scan from a[first .. a[a.length]
 * 3. uses cursor H to scan from a[a.length - 2 .. first]
 * 4. When done , swap(a[a.length-1], idx)
 */
public class QuickSortNonRecursiveV2 {
	
	public static<T extends Comparable<T>> void sort(T a[]) {
		if(a != null && a.length > 1) {
			Stack<Integer> stack = new Stack<Integer>();
			//Push the range of the unsorted array into stack 
			stack.push(0);
			stack.push(a.length); // Number of Elements , index of last element is numbers.length - 1
			
	 		while(!stack.isEmpty()) { // Each iteration will partition start to end  and push right half and left half 
	 			//Retrieve sort range
				int end = stack.pop();
				int start = stack.pop();
				/*
				 * When end - start = 0 - 0 == 0 , there is 0 element to sort
				 * When end - start = 1 - 0 == 1 , there is 1 element to sort
				 * So sorting only needed if end - start is 2 or more meaning end - start >= 2  
				 */
				if( end - start < 2) { // Don't need to sort if is 1 element or 0 element , continue means skip this iteration
					continue;
				}
				int p = start + ((end - start)/2); //Pivot Index 
				
				/*
				 * When partition is done, it will return index of the pivot 
				 */
				p = partition(a, p , start, end); 
				
				//Divides next partition range to be  [start ... p] [p+1 ... end]
				/*
				 * Pushing right side to stack before left side will mean when popping , it will process left side first
				 * 
				 * Also to note : lower range is always index of 1st elment and upper range is index of last element + 1 
				 * so when end - start will determine how many elements
				 */
				stack.push(p+1);
				stack.push(end);
				
				stack.push(start);
				stack.push(p);
			} //END WHILE
		}
	}//END SORT		
	
	private static <T extends Comparable<T>> int partition(T input[] , int position , int start , int end) {
		int l = start; //l cursor
		int h = end - 2; // 2nd to last element 
		T piv = input[position]; //pivot value
		SortUtil.swap(input, position , end-1); //swap last element with pivot 
		
		//this while loop uses cursor L to find any element >= pivot 
		//				  uses cursor H to find any element < pivot
		// 					then swap L with H 
		while(l < h) { // STOPS when cursor L and H points to same element
			/*
			 * 1 of the 3 things must happen inside this while loop
			 * 1. left cursor moves to right   Condition :  < Pivot
			 * 2. right cursor moves to left   Condition :  >= Pivot 
			 * 3. swap 
			 */
			if(SortUtil.isLessThan(input[l], piv)) { 
				l++;
			}else if(SortUtil.isLessThan(piv, input[h])) {
				h--;
			}
			else { // Runs when Left cursor finds value > pivot to swap with right cursor finds value < pivot
				SortUtil.swap(input,l,h); //After swap the L and H cursor stays the same because is use to be that input[l] > piv but after swapping with input[h] , is no long the case so next iteration will move cursors
			}
			
		}
		/*
		 * Now L and H points to same element meaning partition is done , we just need to put pivot into the correct position
		 * if H points to a number  > than pivot Like in this case: 
		 * Ex. 
		 * 5 11 24 68 [10]
		 *   H
		 * As can see ,  everything left of H is < pivot , everything right of H is > pivot 
		 * So swapping H with Pivot will finish partition 
		 * 
		 * if H points to a number < than pivot like in this case: 
		 * Ex. 
		 * 5 9 24 68 10 
		 *   H
		 * As can see , if H is moved 1 over 
		 * 5 9 24 68 10
		 *     H 
		 * then above scenario is created. 
		 * 
		 * Ultimately we want to swap pivot with the first number that's >= pivot
		 */
		int idx = h;
		if(SortUtil.isLessThan(input[h], piv)) {
			idx++;
		}
		SortUtil.swap(input, end-1 , idx);
		return idx;
	}// END PARTITION		

	
}//END CLASS
	


