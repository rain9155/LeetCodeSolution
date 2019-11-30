package medium.leetcode306;

/**
 * 累加数:
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 *
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 * 示例 1:
 * 输入: "112358"
 * 输出: true
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2:
 * 输入: "199100199"
 * 输出: true
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 *
 * 进阶:
 * 你如何处理一个溢出的过大的整数输入?
 */
public class Solution {

    /**
     * 递归 + 双指针：
     * 1、用两个指针i，j把num划分为3部分，第一部分等于num1，第二部分等于num2，第三部分等于num3，如果isAdditive返回false，就移动i或j指针（先固定前两个数，在递归求第三个数）
     * 2、判断num1 + num2 是否等于num3， 如果等于直接返回true，如果不等于，取n3 = num1 + num2，如果n3属于num3的一部分，则继续递归判断，否则返回false
     */
    public boolean isAdditiveNumber(String num) {
        if(num.length() < 3) return false;
        for(int i = 1; i < num.length(); i++){
            //取出第一个数
            String num1 = num.substring(0, i);
            for(int j = i + 1; j < num.length(); j++){
                //取出第二个数
                String num2 = num.substring(i , j);
                //取出第三个数
                String num3 = num.substring(j);
                //判断num1 + num2 是否等于 num3
                if(isAdditive(num1, num2, num3)){
                    return true;
                }
            }
        }
        return false;
    }

    //判断n1 + n2 是否等于 n3
    private boolean isAdditive(String n1, String n2, String n3){
        if(isInVaild(n1) || isInVaild(n2) || isInVaild(n3)){
            return false;
        }
        long num1 = Long.parseLong(n1);
        long num2 = Long.parseLong(n2);
        String sum = String.valueOf(num1 + num2);//num1 + num2可能溢出，用String表示

        if(sum.length() == n3.length()){//如果sum长度 == n3长度， 表示n1 + n2 可能等于 n3
            if(!isInVaild(sum) && sum.equals(n3)){//如果sum == n3，n1 + n2 等于 n3，返回true
                return true;
            }
        }else if(sum.length() > n3.length()) {//如果sum长度 > n3长度，表示sum值 > n3，不可能存在累加数，返回false
            return false;
        }
        //如果sum长度 <= n3长度，在n3中可能有一个数等于sum

        //把sum在n3中的数取出来
        String sumInN3 = n3.substring(0, sum.length());
        //判断
        if(isInVaild(sumInN3) || !sumInN3.equals(sum)){//如果根据sum在n3中取出来的值不等于n1 + n2的值，说明n1 + n2在n3中不可能存在累加数，直接返回false
            return false;
        }
        //否则，n1 + n2的累加数就是sumInN3，所以继续递归在n3的后面求累加数
        //即n1、n2、n3都往后移动一个数
        n1 = n2;
        n2 = sumInN3;
        n3 = n3.substring(sumInN3.length());
        return isAdditive(n1, n2, n3);
    }

    //判断num是否有前导零，有就返回true
    private boolean isInVaild(String num){
       return num.length() > 1 && num.charAt(0) == '0';
    }

}
