package com.test;

/**
 * 回文数
 * @author STXU
 * @date 2022-04-16 08:25:18
 */
public class P9_PalindromeNumber{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P9_PalindromeNumber().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
		StringBuffer str = new StringBuffer(x);
		StringBuffer str2 = str.reverse();
		if (str2.equals(str))
			return true;
		else
			return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
