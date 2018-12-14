package edu.diao.sorting;




public class MergeSortV1 {
	/*
	 * All type inherits from class "Object" 
	 * so Object is a super type of String
	 * so Object[] is a super type of String[]
	 * so Object[] arr = new String[10] is valid  
	 *
	 * so.. Why No Generic/Template Array creation? 
	 * 
	 * Say we got this function
	 * 
	 * public <T> T[] getArray(int size){
	 * 		T[] arr = new T[size];
	 * 		return arr;
	 * }
	 * 
	 * Since the type "T" is not known at runtime , at compile time compiler will replace "T" with Object[] 
	 * So the above method becomes
	 * 
	 * public Object[] getArray(int size){
	 * 		Object[] arr = new Object[size];
	 * 		return arr;
	 * }
	 * 
	 * Now suppose you call this method as :
	 * 
	 * Integer[] arr = getArray(10);  
	 * 
	 * Then the problem with this is ... getArray(10) returns a Object[] and now trying to assign Object[] to Integer[]
	 * And we know Integer[] is a Object[]     BUT     Object[] is not a Integer[].
	 * This is the reason why No Generic Array
	 * 
	 * 
	 * 
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void sort(T a[]) {
		if(a != null && a.length > 1) {
			T aux[] = (T[]) new Comparable[a.length];
			sort(a , 0 , a.length - 1 , aux);
		}
	}//END SORT
	private static <T extends Comparable<T>> void sort(T a[] , int lo , int hi , T aux[]) {
		if(lo >= hi) {
			return;
		}
		int mid = (lo+hi)/2;
		sort(a, lo , mid , aux);
		sort(a, mid+1 , hi , aux);
		merge(a , lo , mid , hi , aux);
	}//END SORT
	
	private static <T extends Comparable<T>> void merge(T a[], int lo , int mid , int hi, T aux[]) {
		int i = lo , j = mid + 1;
		//Copy a[lo..hi] to aux[lo..hi]
		for(int k = lo ; k <= hi ; k++) {
			aux[k] = a[k];
		}
		
		//Merge back to a[lo..hi]
		for(int k = lo ; k <= hi ; k++) {
			//Left half exhausted (take from right)
			if(i > mid) {
				a[k] = aux[j++];
			}
			//Right half exhasuted (take from left)
			else if(j > hi) {
				a[k] = aux[i++];
			}
			//Current key on right  <  current key on left  (take from right)
			else if(aux[j].compareTo(aux[i])< 0) {
				a[k] = aux[j++];
			}
			//Current key on left < current key on right ( take from left)
			else {
				a[k] = aux[i++];
			}
		}//END FOR	
	}//END MERGE
	
	
	
	
}//END CLASS
