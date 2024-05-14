#include <iostream>
#include "./common/struct.h"
#include "./common/utils.h"
#include "./easy/leetcode169_solution.h"

using namespace Common;
using namespace Leetcode169;

int main()
{
    std::vector<int> nums = {0, 1, 1, 1, 4};

    Solution soluton;
    int num = soluton.majorityElement(nums);

    std::cout << num << std::endl;

    return 0;
}