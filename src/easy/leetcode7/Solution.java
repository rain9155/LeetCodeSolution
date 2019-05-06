package easy.leetcode7;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 */
public class Solution {

    /**
     * int转成字符串，直接反转，再转换为int放回，如果溢出，捕获异常返回0 （O（n））
     */
    public int reverse(int x) {
        int ret = 0;
        String c;
        String str = String.valueOf(x);
        StringBuilder strBuilder = new StringBuilder(str);
        if(str.charAt(0) == '-'){
            c = String.valueOf(str.charAt(0));
            strBuilder.deleteCharAt(0);
            strBuilder.reverse();
            str = strBuilder.toString();
            strBuilder = new StringBuilder(c);
            strBuilder.append(str);
        }else {
            strBuilder.reverse();
        }
        try {
            ret = Integer.valueOf(strBuilder.toString());
        }catch (Exception e){
            return 0;
        }
        return ret;
    }
}
