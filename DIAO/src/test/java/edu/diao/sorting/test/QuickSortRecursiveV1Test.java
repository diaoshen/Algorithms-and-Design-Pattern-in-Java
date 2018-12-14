package edu.diao.sorting.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import edu.diao.sorting.*;
import edu.diao.util.SortUtil;
class QuickSortRecursiveV1Test {

	@Test
	void test() {
		Integer[] a = {85,53,38,44,32,97,99,65,46,66,57,68,13,63,98,42,50};
		QuickSortRecursiveV1.sort(a);
		Assert.assertTrue(SortUtil.isNonDecreasingOrder(a));
	}

}
