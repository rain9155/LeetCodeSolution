#include "leetcode26_solution.h"

using namespace Leetcode26;

int Solution::removeDuplicates(std::vector<int>& nums)
{
    if(nums.size() == 0)
    {
        return 0;
    }

    int slow = 0;
    for(int fast = 1; fast < nums.size(); fast++)
    {
        if(nums[slow] != nums[fast])
        {
            slow++;
            nums[slow] = nums[fast];
        }
    }
    
    return slow + 1;
}