package easy.leetcode383;

/**
 * 赎金信:
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 *
 * 注意：
 * 你可以假设两个字符串均只含有小写字母。
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Solution {

    /**
     * 哈希表：
     * 因为都是小写字母，所以范围为'a'到'z',只有26个字母
     * 我们可以使用一个大小为26的数组来保存ransomNote的每一个字母到索引的映射
     * 然后再去遍历magazine，遇到相同的字母到索引的映射，就把该数组的数值减一
     * 最后，如果ransomNote可以由magazine中的字母构成，那么数组的数值一定都是0
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;
        int[] nums = new int[26];
        for(int i = 0; i < ransomNote.length(); i++){
            int num = ransomNote.charAt(i) - 97;
            nums[num]++;
        }
        for(int i = 0; i < magazine.length(); i++){
            int num = magazine.charAt(i) - 97;
            if(nums[num] > 0){
                nums[num]--;
            }
        }
        for(int num : nums){
            if(num != 0){
                return false;
            }
        }
        return true;
    }

}
