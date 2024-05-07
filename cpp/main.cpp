#include <iostream>
#include "./easy/leetcode88_solution.h"

using namespace Leetcode88;

int main()
{
    const int m = 3;
    const int n = 3;
    std::vector<int> nums1 = {1, 2, 3, 0, 0, 0};
    std::vector<int> nums2 = {2, 5, 6};

    Solution s;
    s.merge(nums1, m, nums2, n);

    for(int i = 0; i < nums1.size(); i++)
    {
        std::cout << nums1[i] << " ";
    }

    return 0;
}