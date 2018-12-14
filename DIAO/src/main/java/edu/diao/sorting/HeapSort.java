package edu.diao.sorting;

import edu.diao.util.SortUtil;

public class HeapSort {

	public static <T extends Comparable<T>> void sort(T a[] ) {
		int n = a.length -1;
		//Build Initial Heap 
		//Last node that have children is n/2 
		//Any node less than n/2 also have children
		for(int k = n/2 ; k>= 1; k--) {
			sink(a,k,n);
		}
		
		
		for(int i = 0 ; i< a.length ; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\n");
		
		
		//start sorting
		while(n > 1) {
			SortUtil.swap(a, 1, n--);
			sink(a,1,n);
			
			for(int i = 0 ; i< a.length ; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println("");
			
		}
	}//END SORT
	
	private static <T extends Comparable<T>> void sink(T a[] , int k , int lastIndex) {
		while(2*k <= lastIndex) {
			int j = 2*k;
			if(j < lastIndex && SortUtil.isLessThan(a[j], a[j+1])) {
				j++;
			}
			if(!SortUtil.isLessThan(a[k], a[j]))
				break;
			SortUtil.swap(a, k, j);
			k = j;
		}
	}
}
