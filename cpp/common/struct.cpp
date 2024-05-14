#include "struct.h"

using namespace Common;

ListNode* StructHelper::initList(std::vector<int>& nums) 
{
    ListNode* head = nullptr;
    ListNode* p = nullptr;
    for(int i = 0; i < nums.size(); i++)
    {
        if(i == 0)
        {
            head = new ListNode(nums[i]);
            head->next = nullptr;
            p = head;
        }
        else
        {
            p->next = new ListNode(nums[i]);
            p = p->next;
            p->next = nullptr;
        }
    }
    return head;
}

void StructHelper::destoryList(ListNode* head)
{
    ListNode* p = head;
    while (p != nullptr)
    {
        ListNode* next = p->next;
        delete p;
        p = next;
    }
}