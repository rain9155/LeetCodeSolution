#include "utils.h"
#include <iostream>

using namespace Common;

void Utils::printNums(std::vector<int>& nums)
{
    for(int i = 0; i < nums.size(); i++)
    {
        std::cout << nums[i];
        if(i != nums.size() - 1)
        {
            std::cout << " ";
        }
        else
        {
            std::cout << std::endl;
        }
    }
}

void Utils::printList(ListNode* head)
{
    ListNode* p = head;
    while (p != nullptr)
    {
        std::cout << p->val;
        if(p->next != nullptr)
        {
            std::cout << "->";
        }
        else
        {
            std::cout << std::endl;
        }
        p = p->next;
    }
    
}