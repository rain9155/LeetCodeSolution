package medium.leetcode5;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串
 */
public class Solution {

    /**
     * 蛮力法（O（n^3））
     * 1、遍历所有字串，然后反转字串；
     * 2、看字串与反转字串是否相同，如果相同，则为回文
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        String ret = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                String str = s.substring(i, j + 1);
                if(str.equals((new StringBuilder(str)).reverse().toString()) && str.length() > ret.length())
                    ret = str;
            }
        }
        return ret;
    }

    /**
     * 中心扩展法（O(n^2)）：
     * 1、遍历字符串的每个字符和每个字符相邻的""；
     * 2、以这个字符为中心展开，以""为中心展开；（回文数为奇数时中心在回文中间的字符，回文数为偶数时中心在中间两个字符之间的"",例如 “abba” 的中心在两‘b’ 之间）
     * 3、找出回文数最大的回文
     */
    public String longestPalindrome2(String s) {
        if(s == null || s.length() < 1) return "";
        String ret = "";
        int end = 0, start = 0;
        for(int i = 0; i < s.length(); i++){
            int l1 = expandAroundCenter(s, i, i);//奇数回文情况的回文长度
            int l2 = expandAroundCenter(s, i, i + 1);//偶数回文情况回文长度
            int l = Math.max(l1, l2);//取回文长度最长的那个
            //记录下最新长度的回文在s中的位置
            if(l > end - start){
                start = i - (l - 1) / 2;
                end = i + l / 2;
            }
        }
        ret = s.substring(start, end + 1);
        return ret;
    }

    /**
     * 从s的left和right索引向两边展开，判断是否是回文，如果是回文，返回回文的长度，如果不是回文，结果返回0
     */
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    /**
     * 动态规划（O(n^2)）：改进蛮力法，减少重复计算
     * 如果bab是回文，那么ababa一定是回文，所以得到递推条件：P(i, j) = (si == sj && P(i + 1, j - 1))，i、j代表在s中索引i到j的子字符串，
     * P可以想象成二维表，它代表给定字符串中，如果字串是回文，则相应表格true，否则填false，例如abac, 表格如下(下面true代表1，false代表0)：
     *   a b a c j
     * a 1 0 1 0
     * b - 1 0 0
     * a - - 1 0
     * c - - - 1
     * i
     * 从表格可以看到，i == j 的都为true，从下面往上求，如果有前一个回文，可以推出后一个回文
     * 最优子结构：P(i, j) = (si == sj && P(i + 1, j - 1))
     *                                      true, si == sj && P(i + 1, j - 1)
     * 状态转移公式(递推公式)：P（i, j） =
     *                                      false, 其他情况
     *                  P(i，i) =  true，因为只有一个字符，所以肯定是回文，初始化一个字符情况（已知a为true，那么bab一定是回文）
     *  边界(初始条件)：
     *                  P（i, i + 1） = si == si+1，如果有两个字符，两个相等才是回文，P（i, i + 1）才为true，初始化两个字符的情况（已知aa为true，那么baab一定是回文）
     *
     */
    public String longestPalindrome3(String s) {

      if(s == null || s.isEmpty()) return "";
      int length = s.length();
      int start = 0, end = 0;
      boolean P[][] = new boolean[length][length];//初始化一个二维数组

      //要想知道当前是否是回文，必须知道前一个是否是回文
      //所以s从后面往前面求字串，并判断是否是回文
      for(int i = length - 1; i >= 0; i--){

          P[i][i] = true;//初始化一个字符情况
          //初始化两个字符的情况，并更新长度
          if((i + 1) < length && s.charAt(i) == s.charAt(i + 1)){
              P[i][i + 1] = true;
              if(end - start < 1){
                  start = i;
                  end = i + 1;
              }
          }
          for(int j = i; j < length; j++){
              if(j - i > 1)//排除调一个字符和相邻两个字符的情况，因为前面已经判断过了
                P[i][j] = s.charAt(i) == s.charAt(j) && P[i + 1][j - 1];//状态转移公式
              //判断是否是回文
              if(P[i][j] && end - start < j - i){
                  start = i;
                  end = j;
              }
          }
      }

      return s.substring(start, end + 1);
    }


}
