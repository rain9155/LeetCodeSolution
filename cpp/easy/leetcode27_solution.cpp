#include "leetcode27_solution.h"

using namespace Leetcode22;

int Solution::removeElement(std::vector<int>& nums, int val)
{
    if(nums.size() == 0)
    {
        return 0;
    }
    int slow = 0;
    int fast = 0;
    while(fast < nums.size())
    {
        if(nums[fast] != val)
        {
            nums[slow++] = nums[fast];
        }
        fast++;
    }
    return slow;
}