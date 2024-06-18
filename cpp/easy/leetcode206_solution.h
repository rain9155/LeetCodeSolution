#pragma once
#include "../common/struct.h"

using namespace Common;

/**
 * 反转链表:
 * 反转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
namespace Leetcode206
{
    class Solution
    {
    public:
       /**
         * 双指针：
         * 1、初始化两个指针pre，cur，一个指向当前遍历结点的上一个结点，一个指向当前遍历结点
         * 2、遍历时，先把临时变量保存当前遍历节点的下一个节点，然后把当前遍历结点的next指向上一个结点，然后两个指针都向后移动一步，直到链表底部
         * 3、最终cur = null， pre指向反转后的链表底部，所以返回pre
         */
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