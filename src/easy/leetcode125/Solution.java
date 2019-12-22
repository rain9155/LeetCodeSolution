package easy.leetcode125;

/**
 * 验证回文串:
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class Solution {

    /**
     * 双指针法：
     * 定义两个指针，从头尾开始
     * 如果两个元素相同，就移动两个指针；
     * 如果两个元素不相同，就返回false；
     * 如果某个指针遇到不是字母或数字的字符，就跳过；
     * 直到两个指针相遇，返回true
     */
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++; j--;
        }
        return true;

    }

}
