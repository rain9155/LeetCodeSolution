package easy.leetcode405;

/**
 * 数字转换为十六进制数:
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 *
 * 注意:
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 *
 * 示例 1：
 * 输入:
 * 26
 * 输出:
 * "1a"
 * 示例 2：
 * 输入:
 * -1
 * 输出:
 * "ffffffff"
 */
public class Solution {

    /**
     * 位运算：
     * 把num的二进制位每4位为一组，分别计算出每组的16进制，然后拼接
     */
    public String toHex(int num) {
        if(num == 0) return "0";
        int mask = 1;
        if(num < 0){
            num = getComplement(num);
        }
        String ret = "";
        for(int i = 0; i < 32; i += 4){
            int sum = 0;
            for(int j = 0, pow = 1; j < 4; j++, pow *= 2){
                if((num & mask) != 0){
                    sum += pow;
                }
                mask <<= 1;
            }
            ret = getHexBySum(sum) + ret;
        }
        int i = 0;
        while (i < ret.length() && ret.charAt(i) == '0'){
            i++;
        }
        return ret.substring(i);
    }

    private String getHexBySum(int sum){
        if(sum <= 0) return "0";
        if(sum < 10) return String.valueOf(sum);
        int c = 'a' + sum - 10;
        return String.valueOf((char)c);
    }

    /**
     * 给定一个数，求它的补码：
     * 1、如果该数是正数，直接返回
     * 2、如果该数是负数，首先求负数的绝对值，然后对绝对值进行取反，最后把取反后的绝对值加一
     */
    private int getComplement(int num){
        if(num > 0) return num;
        num = Math.abs(num);
        num =~num;
        return num + 1;
    }



}
