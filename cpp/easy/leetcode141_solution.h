#pragma once
#include "../common/struct.h"

using namespace Common;

/**
 * 环形链表:
 * 给定一个链表，判断链表中是否有环。
 */
namespace Leetcode141
{
    class Solution 
    {
    public:
        /**
         * 快慢指针：
         * 设置两个指针，一个每次走一步的慢指针和一个每次走两步的快指针。
         * 如果不含有环，跑得快的那个指针最终会遇到 null，说明链表不含环
         * 如果含有环，快指针会超慢指针一圈，和慢指针相遇，说明链表含有环。
         */
        bool hasCycle(ListNode* head)
        {
            if(head == nullptr || head->next == nullptr)
            {
                return false;
            }
            ListNode* p1 = head;
            ListNode* p2 = head;
            while(p2 != nullptr && p2->next != nullptr)
            {
                p1 = p1->next;
                p2 = p2->next->next;
                if(p1 == p2)
                {
                    return true;
                }
            }
            return false;
        }
    };
}