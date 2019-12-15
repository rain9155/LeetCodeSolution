package easy.leetcode7;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转:
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Solution {

    /**
     * O（n）:
     * 把int转成字符串：
     * int转成字符串，直接反转，再转换为int放回，如果溢出，捕获异常返回0
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

    /**
     * 根据运算反转int值：
     * ret 保存旧的翻转中间值, temp 保存新的翻转过程中间值
     * 依次提取 x 的末位加入 temp, 如果发生溢出则通过temp/10无法得到上一轮的翻转结果 ret
     */
    public int reverse2(int x) {
        int ret = 0;
        while (x != 0){
            int last = x % 10;
            int temp = ret * 10 + last;
            if(temp / 10 != ret){//发生溢出
                return 0;
            }
            ret = temp;
            x /= 10;
        }
        return ret;
    }
}
