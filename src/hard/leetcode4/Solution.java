package hard.leetcode4;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2，请你找出这两个有序数组的中位数
 */
public class Solution {

    /**
     * 合并两个有序数组，然后求中位数（O（max(n, m)））
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double ret = 0;
        int l1 = nums1.length, l2 = nums2.length, l3 = l1 + l2;
        int nums[] = new int[l3];
        int i = 0, j = 0, t = 0;

        while (i < l1 && j < l2){
            if(nums1[i] < nums2[j]){
                nums[t] = nums1[i++];
            }else {
                nums[t] = nums2[j++];
            }
            t++;
        }
        if(i != l1){
            while (i < l1){
                nums[t] = nums1[i++];
                t++;
            }
        }
        if(j != l2){
            while (j < l2){
                nums[t] = nums2[j++];
                t++;
            }
        }

        ret = ((l3 % 2) == 0) ? ((nums[l3 / 2] + nums[l3 / 2 - 1]) / 2.0) : nums[l3 / 2];

        return ret;
    }

}
