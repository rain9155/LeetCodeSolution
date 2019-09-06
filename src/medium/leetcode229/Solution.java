package medium.leetcode229;

import java.util.ArrayList;
import java.util.List;

/**
 * 求众数 II：
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: [3]
 * 示例 2:
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 */
public class Solution {

    /**
     * 投票算法：
     * nums中所有出现超过 n/k 次的元素，最多只有 k - 1个，所以本题最多只有2个元素出现超过 n/3
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if(nums.length == 0) return ret;
        int candiA = nums[0];
        int candiB = nums[0];
        int countA = 0;
        int countB = 0;
        for(int num : nums){

            if(num == candiA){//如果等于A候选人，投票给A
                countA++;
                continue;
            }

            if(num == candiB){//如果等于B候选人，投票给B
                countB++;
                continue;
            }

            //如果两个候选人都不等于num，则不投票给AB
            //然后判断各自的投票次数是否等于0

            if(countA == 0){//如果A的投票次数等于0，则更新A候选人为num
                candiA = num;
                countA++;
                continue;
            }

            if(countB == 0){//如果B的投票次数等于0，则更新B候选人为num
                candiB = num;
                countB++;
                continue;
            }

            //若此时两个候选人的票数都不为0,那么A,B对应的票数都要--;
            countA--;
            countB--;

        }
        //看上面选出的AB候选人是否都符合出现次数大于 n/3
        countA = 0;
        countB = 0;
        for(int num : nums){
            if(num == candiA){
                countA++;
            }
            if(num == candiB){
                countB++;
            }
        }
        if(countA > nums.length / 3) ret.add(candiA);
        if(countB > nums.length / 3) ret.add(candiB);
        return ret;
    }

}
