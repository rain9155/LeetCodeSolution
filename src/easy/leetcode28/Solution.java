package easy.leetcode28;

/**
 * 字符串匹配:
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class Solution {


    /**
     * O（n）
     * BM算法：
     * 放置两个指针p1，p2，p1指向父字符串的第一个元素，p2指向待匹配模式的第一个元素，从左到右比较
     * 如果p1和p2指向的元素相等，p1和p2同时后移
     * 如果p1和p2指向的元素不相等，则p1指针回溯到(p1 - p2 + 1)的位置，即p1初始位置 + 1的位置，同时p2指针回到待匹配模式的第一个元素，相当于p1每次向右移动一位，模式也向右滑动一位
     * 当p1走完父字符串或p2走完模式，则比较p2是否等于模式的长度，如果相等则匹配成功，返回（p1 - p2）即模式在父字符串的位置，如果不相等，表示父字符串中没有这个待匹配模式
     */
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        if(haystack == null || haystack.length() == 0) return -1;
        int p1 = 0, p2 = 0;
        while (p1 < haystack.length() && p2 < needle.length()){
            if(haystack.charAt(p1) == needle.charAt(p2)){
                p1++;
                p2++;
            }else {
                p1 = p1 - p2 + 1;
                p2 = 0;
            }
        }
        if(p2 >= needle.length()){
            return p1 - p2;
        }else {
            return -1;
        }
    }

    /**
     * KMP算法：
     * 改进BF算法，每次匹配的过程中出现字符串不等时，不回溯主指针p1，利用已得到的“部分匹配”结果将模式向右滑动尽可能远的一段距离即回溯p2，继续进行比较
     *
     */
    public int strStr2(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        if(haystack == null || haystack.length() == 0) return -1;
        int[] next = getNext(needle);
        int p1 = 0, p2 = 0;
        while (p1 < haystack.length() && p2 < needle.length()){
            if(p2 == 0 || haystack.charAt(p1) == needle.charAt(p2)){
                p1++;
                p2++;
            }else {
                p2 = next[p2];
            }
        }
        if(p2 >= needle.length()){
            return p1 - p2 + 1;
        }else {
            return -1;
        }
    }

    /**
     * 用数学归纳法获得next数组即部分匹配数组
     * 部分匹配即每个子字符串的最大共有长度，它表示该子字符串中已经与父字符串匹配过的最大长度的字符串，可以直接跳过，无需再匹配，减少比较次数
     * 最大共有长度（部分匹配值）指前缀和后缀中最大共有元素，没有则为0。
     * 前缀指除了最后一个字符以外，一个字符串的全部头部组合。
     * 后缀指除了第一个字符以外，一个字符串的全部尾部组合。
     * 例如“abab”的前缀为“a”、“ab”、“aba”,后缀为“b”、“ab”、“bab”,所以最大共有元素为“ab”,最大共有长度为2。
     * 所以部分匹配数组即给定模式串中每个子字符串的最大共有长度，它决定了p2将要回溯的位置，或者说模式要向右滑动多少
     * @param needle 模式串
     * @return  next 部分匹配数组
     */
    private int[] getNext(String needle){
        int i = 0;
        int j = -1;
        int[] next = new int[needle.length() + 1];
        next[0] = -1;
        while (i < needle.length()){
            if(j == -1 || needle.charAt(i) == needle.charAt(j)){
                ++i;
                ++j;
                next[i] = j;
            }else {
                j = next[j];
            }
        }
        return next;
    }

}
