#pragma once
#include "../common/struct.h"

using namespace Common;

/**
 * 合并两个有序链表：
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
namespace Leetcode21
{
    class Solution 
    {
    public:
        /**
         * 额外增加一个头结点，当合并完l1和l2后，把剩余的链表的头结点直接连到后面
         */
        ListNode* mergeTwoLists(ListNode* list1, ListNode* list2)
        {
            ListNode* head = new ListNode(-1);
            ListNode* cur = head;
            while(list1 != nullptr && list2 != nullptr) 
            {
                if(list1->val < list2->val)
                {
                    cur->next = new ListNode(list1->val);
                    list1 = list1->next;
                }
                else 
                {
                    cur->next = new ListNode(list2->val);
                    list2 = list2->next;
                }
                cur = cur->next;
            }
            if(list1 != nullptr)
            {
                cur->next = list1;
            }
            if(list2 != nullptr)
            {
                cur->next = list2;
            }
            return head->next;
        }
};
}