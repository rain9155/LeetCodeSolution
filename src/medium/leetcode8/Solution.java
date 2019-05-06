package medium.leetcode8;

/**
 * 将字符串转换成整数。
 */
public class Solution {
    public int myAtoi(String str) {
        if(str == null) return 0;
        str = str.trim();
        if(str.isEmpty()) return 0;
        int ret = 0, i;
        for(i = 0; i < str.length(); ++i){
            char ch = str.charAt(i);
            if(i == 0 && (ch == '-' || ch == '+'))
               continue;
            if(ch < '0' || ch > '9')
                break;
        }
        str = str.substring(0, i);
        try {
            if(str.length() == 0) return 0;
            char ch = str.charAt(0);
            if(str.length() == 1 && ((ch == '-' || ch == '+'))) return 0;
            ret = Integer.valueOf(str);
        }catch (Exception e){
            return str.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return ret;
    }
}
