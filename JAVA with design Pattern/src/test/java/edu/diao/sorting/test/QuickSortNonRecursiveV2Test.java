package edu.diao.sorting.test;



import org.junit.Assert;
import org.junit.jupiter.api.Test;

import edu.diao.sorting.QuickSortNonRecursiveV2;
import edu.diao.util.SortUtil;

class QuickSortNonRecursiveV2Test {


	
	@Test
	void testSortI_1() {
		Character[] a = {'b'};
		QuickSortNonRecursiveV2.sort(a);
		Assert.assertTrue(SortUtil.isNonDecreasingOrder(a));
	}
	
	@Test
	void testSortI_2() {
		Integer[] a = {2, 1};
		QuickSortNonRecursiveV2.sort(a);
		Assert.assertTrue(SortUtil.isNonDecreasingOrder(a));
	}
	
	@Test
	void testSortI_3() {
		Integer[] a = {1, 2};
		QuickSortNonRecursiveV2.sort(a);
		Assert.assertTrue(SortUtil.isNonDecreasingOrder(a));
	}
	
	@Test
	void testSortI_4() {
		String[] a = {"1", "3", "2"};
		QuickSortNonRecursiveV2.sort(a);
		Assert.assertTrue(SortUtil.isNonDecreasingOrder(a));
	}
	

}
