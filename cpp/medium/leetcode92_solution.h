#pragma once
#include "../common/struct.h"

using namespace Common;

/**
 * 反转链表 II:
 * 给你单链表的头指针 head 和两个整数 m 和 n，其中 1 ≤ m ≤ n ≤ 链表长度
 * 请你反转从位置 m 到位置 n 的链表节点，返回反转后的链表 
 * 
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
namespace Leetcode92
{
    class Solution 
    {
    public:
        /**
         * 三指针反转链表：
         * 首先初始化一个值为0的虚拟头指针dumy指向head，然后用p0指向m位置上一个位置，如下
         *           m         n
         * 0 -> 1 -> 2 -> 3 -> 4 -> 5
         *      p0
         * 然后用p1指向m位置，p2保存m位置的节点，p2就是反转链表后的尾节点，如下：
         *           m         n
         * 0 -> 1 -> 2 -> 3 -> 4 -> 5
         *     p0   p1
         *          p2
         * 然后把p1指向的节点插入p0指向的下一个位置，直到n，如下：
         *      m              n
         * 0 -> 1 -> 4 -> 3 -> 2    5
         *      p0            p2    p1
         * 最后把把p2的下一个位置指向p1，如下：
         *      m              n
         * 0 -> 1 -> 4 -> 3 -> 2 -> 5
         *     p0             p2    p1
         * 最后返回dumy.next就行
         */
        ListNode* reverseBetween(ListNode* head, int m, int n) 
        {
            ListNode* dumy = new ListNode(-1);
            dumy->next = head;
            ListNode* p0 = dumy;
            for(int i = 1; i < m; i++)
            {
                p0 = p0->next;
            }
            ListNode* p1 = p0->next;
            ListNode* p2 = p1;
            for(int i = m; i <= n; i++)
            {
                ListNode* next = p1->next;
                p1->next = p0->next;
                p0->next = p1;
                p1 = next;
            }
            p2->next = p1;
            return dumy->next;
        }
    };
}