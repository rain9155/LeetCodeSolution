#include <iostream>
#include "./common/struct.h"
#include "./common/utils.h"

using namespace Common;

int main()
{
    std::vector<int> nums = {1, 2, 3, 4};
    ListNode* head = StructHelper::initList(nums);
    Utils::printList(head);
    return 0;
}