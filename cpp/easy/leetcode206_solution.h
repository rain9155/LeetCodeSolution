#pragma once
#include "../common/struct.h"

using namespace Common;

/**
 * 反转链表:
 * 反转一个单链表。
 */
namespace Leetcode206
{
    class Solution
    {
    public:
        ListNode* reverseList(ListNode* head)
        {
            if(head == nullptr)
            {
                return nullptr;
            }

            ListNode* p1 = nullptr;
            ListNode* p2 = head;

            while (p2 != nullptr)
            {
                ListNode* next = p2->next;
                p2->next = p1;
                p1 = p2;
                p2 = next;
            }

            return p1;
        }
    };
}