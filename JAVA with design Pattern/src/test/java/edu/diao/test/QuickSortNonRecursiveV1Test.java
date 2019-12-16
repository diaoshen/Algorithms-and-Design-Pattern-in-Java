package edu.diao.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import edu.diao.sorting.QuickSortNonRecursiveV1;
import edu.diao.util.SortUtil;

class QuickSortNonRecursiveV1Test {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testSortI_1() {
		Character[] a = {'b'};
		QuickSortNonRecursiveV1.sort(a);
		Assert.assertTrue(SortUtil.isNonDecreasingOrder(a));
	}
	
	@Test
	void testSortI_2() {
		Integer[] a = {2, 1};
		QuickSortNonRecursiveV1.sort(a);
		Assert.assertTrue(SortUtil.isNonDecreasingOrder(a));
	}
	
	@Test
	void testSortI_3() {
		Integer[] a = {1, 2};
		QuickSortNonRecursiveV1.sort(a);
		Assert.assertTrue(SortUtil.isNonDecreasingOrder(a));
	}
	
	@Test
	void testSortI_4() {
		String[] a = {"1", "3", "2"};
		QuickSortNonRecursiveV1.sort(a);
		Assert.assertTrue(SortUtil.isNonDecreasingOrder(a));
	}
	

}
