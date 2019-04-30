package leetcode13;

/**
 *  罗马数字转整数
 */
public class Solution {

    /**
     * 蛮力法：（O（n^2））
     */
    public int romanToInt(String s) {
        int ret = 0;
        int nums[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String strs[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        for(int i = 0; i < s.length();){
            String c = String.valueOf(s.charAt(i));
            String str = (i < s.length() - 1) ? s.substring(i, i + 2) : "";
            for(int j = strs.length - 1; j >= 0; j--){
                if(str.equals(strs[j])){
                    ret += nums[j];
                    i += 2;
                    break;
                }else if(c.equals(strs[j])){
                    ret += nums[j];
                    i += 1;
                    break;
                }
            }
        }
        return ret;
    }

}
