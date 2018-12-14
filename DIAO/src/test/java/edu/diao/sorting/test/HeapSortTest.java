package edu.diao.sorting.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import edu.diao.sorting.HeapSort;
import edu.diao.util.SortUtil;

class HeapSortTest {


	
	@Test
	void test1() {
		Integer[] a = {-1,85,53,38,44,32,97,99,65,46,66,57,68,13,63,98,42,50};
		HeapSort.sort(a);
		Assert.assertTrue(SortUtil.isNonDecreasingOrder(a));
	}

}
