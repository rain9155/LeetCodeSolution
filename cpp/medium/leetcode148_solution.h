#pragma once
#include "../common/struct.h"

using namespace Common;

/**
 * 排序链表:
 * 给你链表的头结点 head，请将其按升序排列并返回 排序后的链表 。
 * 
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * 
 * 进阶：你可以在 O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */
namespace Leetcode148
{
    class Solution
    {
    public:
       /**
         * 归并排序：O(nlogn)
         * 1、首先使用快慢指针划分链表中点：快指针为slow，每次移动一步，快指针为fast，每次移动两步，当快指针移动到尽头时，以slow为分界线断开两个链表
         * 2、二分法左右划分链表：用1得到的两段链表，分别继续递归，递归结束条件是只剩下一个结点
         * 3、归并两个有序链表：当2的递归返回时，再重新把两段链表合并成一个链表
         */
        ListNode* sortList(ListNode* head)
        {
            return mergeSort(head);
        }

        ListNode* mergeSort(ListNode* head)
        {
            if(head == nullptr || head->next == nullptr)
            {
                return head;
            }

            ListNode* pre = nullptr;
            ListNode* slow = head;
            ListNode* fast = head;
            while (fast != nullptr && fast->next != nullptr)
            {
                pre = slow;
                slow = slow->next;
                fast = fast->next->next;
            }
            pre->next = nullptr;

            ListNode* left = mergeSort(head);
            ListNode* right = mergeSort(slow);
            ListNode* dumy = new ListNode(-1);
            ListNode* p = dumy;
            while (left != nullptr && right != nullptr)
            {
                if(left->val < right->val)
                {
                    p->next = left;
                    left = left->next;
                }
                else
                {
                    p->next = right;
                    right = right->next;
                }
                p = p->next;
            }
            if(left != nullptr)
            {
                p->next = left;
            }
            if(right != nullptr)
            {
                p->next = right;
            }
            return dumy->next;
        }
    };
}