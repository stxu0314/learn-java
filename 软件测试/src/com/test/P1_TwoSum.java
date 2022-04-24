package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @author STXU
 * @date 2022-04-11 14:36:58
 */
public class P1_TwoSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1_TwoSum().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int[] twoSum(int[] nums, int target) {
		int[] result = {0, 1};
		if (nums.length <= 2) {
			return result;
		}

		Map<Integer, Integer> valueToIndex = new HashMap<>();
		for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
			if (nums[i] + nums[j] == target) {
				// So lucky
				result[0] = i;
				result[1] = j;
				break;
			}
			int x = target - nums[i];
			if (valueToIndex.containsKey(x)) {
				result[0] = i;
				result[1] = valueToIndex.get(x);
				break;
			}
			x = target - nums[j];
			if (valueToIndex.containsKey(x)) {
				result[0] = j;
				result[1] = valueToIndex.get(x);
				break;
			}

			valueToIndex.put(nums[i], i);
			valueToIndex.put(nums[j], j);
		}

		return result;
	}
}
}