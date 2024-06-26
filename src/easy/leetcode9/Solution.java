package easy.leetcode9;

/**
 * 判断一个数是否是回文数:
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class Solution {

    /**
     * 字符串：O(n)
     * 先把整数转换成字符串，再判断字符串是否是回文（如果字符串是回文，则反转后的字符串与源字符串相同）
     */
    public boolean isPalindrome(int x) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
        return stringBuilder.toString().equals(stringBuilder.reverse().toString());
    }

    /**
     * 数学：O(log10(n))
     * 反转一半数字, 再把反转的一半数字与前一半比较，如果相同就是回文数
     */
    public boolean isPalindrome2(int x) {
        //负数不是回文
        //同样地，如果数字的最后一位是 0，为了使该数字为回文， 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
       int reverseNum = 0;
       //当原数字小于反转后的一半数字时，代表已经反转了一半数字
       while (x > reverseNum){
           reverseNum = reverseNum * 10 + x % 10;
           x /= 10;
       }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
       return x == reverseNum || x == reverseNum / 10;
    }

}
