package edu.diao.sorting;
import edu.diao.util.*;
/*
 * Version 1
 * 
 * Sort:
 * 0. 
 * 1. Divides array a into 3 parts  = a[first .. p-1] , a[p] , a[p+1 .. end] Using Partition()
 * 2. Recursively sort left side
 * 3. Recursively sort right side
 * 
 * Partition : 
 * 0. divides array a into 3 part =  a[first..j-1] , a[j] , a[j+1 .. last]
 * 1. Uses a[0] as pivot value , @Params are index of first element and index of last element
 * 2. uses cursor i  to scan from a[first+1] .. a[last]
 * 3. uses cursor j  to scan from a[last] .. a[first+1]
 * 4. When done , swaps (a[j] , a[0]) to obtain this property --> a[first..j-1] <= a[j] <= a[j+1 .. last]
 * 
 * SIDE NOTE: Partition algorithm used here also used in QuickSortNonRecursiveV1
 */
public class QuickSortRecursiveV1 {
	
	/*
	 * User runs sort(T a[]) to sort and sort(T a[]) calls sort(T a[], int lo , int hi) to help sort.
	 */
	public static <T extends Comparable<T>> void sort(T a[]) {
		if(a != null && a.length >1) {
			sort(a,0,a.length-1); // Runs Helper Function 
		}
	}
	private static <T extends Comparable<T>> void sort(T a[] , int lo , int hi) {
		//Base Case  : 
		// 1 Element :  lo == hi
		// 0 Element :  lo > hi 
		if(hi <= lo) {
			return;
		}
		
		//Recursive Case : 
		int j = partition(a, lo , hi);// Partition
		sort(a,lo,j-1); // Sort left a[lo..j-1]
		sort(a,j+1,hi); // Sort right a[j+1..hi]
				
	}
	private static <T extends Comparable<T>> int partition(T a[] , int lo , int hi ) {
		int i = lo, j = hi + 1;
		T pivot = a[lo];
		while(true) {
			
			/* READ ME:
			 * Cursor i's job is to find a number bigger than or equal to pivot
			 * Cursor i starts at index lo.
			 * Cursor i move to/ stop at  element >= Pivot 
			 * If there is no element >= Pivot it will reach to the end index and exit
			 * 
			 * In Short : Walks thru array from [low+1..high] to find # >= pivot.
			 * If don't find , quit.
			 */
			while(SortUtil.isLessThan(a[++i], pivot)) {
				if(i == hi) {
					break;
				}
			}
			//By the end of above while loop , cursor i either points to a # >= pivot 
			//OR is pointing to the last element.
			
			
			/* READ ME:
			 * Cursor j's job is to find a number smaller than or equal to pivot
			 * Cursor j starts at index high.
			 * Cursor j move to / stop at  element <= pivot 
			 * If there is no element <= Pivot it will reach to the start index and exit.
			 * 
			 * In Short: Walks thru array from [high..lo] to find # <= pivot.
			 * If don't find , quit
			 */
			while(SortUtil.isLessThan(pivot, a[--j])) {
				if(j == lo) {
					break;
				}
			}
			//By the end of above while loop , cursor j either points to a # <= pivot
			//OR is pointing to the first element.
			
			
			/*
			 * When above 2 while loop quit , These are the possibilities 
			 * 
			 * 1. Loop (1) found a # >= Pivot  , Loop (2) found a # <= Pivot 
			 * OR 
			 * 2. Loop (1) found a # >= Pivot  , Loop (2) !found a # <= Pivot
			 * OR
			 * 3. Loop (1) !found a # >= Pivot , Loop (2) found a # <= Pivot
			 * OR
			 * 4. Loop (1) !found a # >= Pivot , Loop (2) !found a # <= Pivot 
			 */
			
			
			/*
			 * Case 1 can potentially cause j > 1 
			 *
				 *Ex. Let element inside [] be pivot value
				 *[10] 22 8 40 9
				 *     i       j 
				 *[10] 9  8 40 22
				 *        j i
				 *In this case swap(j,i) will be incorrect 
			 *
			 * 
			 * Case 2 will cause j > i  b/c i would have found something but j reached to head
			 * In short : all element right of pivot is >= pivot so that's why j will reach
			 * to head and not find any element <= Pivot. In this case , swap(i,j) is incorrect
			 * 
				 * Ex. Let element inside [] be pivot value
				 * [10] 22 40 60 80
				 *  j   i  
			 *
			 * Case 3 will cause i = j  b/c j would have found something but i reached to end
			 * In short : all elements right of pivot is <= pivot so that's why i will reach 
			 * to end and not find any element >= Pivot. In this case , Scan is done
			 * 
			 * OR all elements is the same can cause i = j
			 * 
			 	 * Ex. Let element inside [] be pivot value
				 * [10] 1 2 3 4
				 *            j
				 *            i
			 *            
			 * Summary : Case 1 can create case i > j 
			 * 			 Case 2 creates the case i > j 
			 * 			 Case 3 creates the case i == j
			 */
			if(i >= j) {
				break;
			}
			
			/*
			 * If can get to here.. then it is a normal Case 1 that doesn't cause i >= j
			 * Example input for Case 1 :
			 * 
			 * Let element inside [] be the pivot value
			 * [10] 22 45 29 2
			 *      i        j
			 */
			SortUtil.swap(a,i,j);
		}
		/*
		 * When while(true) loop breaks , that's when scan is done , In other words
		 * all values are in correct place , just need to put pivot into correct position
		 * 
		 * index j will always point to a # <= pivot as is designed to look for # <= pivot.
		 * When scan is all done , cursor j should point to the last element <= pivot.
		 * 
		 * swap(a,lo,j) will put pivot into correct position. a will have this property 
		 * such that all element < index j is  <= a[j] and all elements > index >= a[j]
		 */
		SortUtil.swap(a,lo,j);
		return j; // Return pivot index 		
	}
}
