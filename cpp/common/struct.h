#pragma once
#include <vector>

namespace Common
{
    struct ListNode
    {
    public:
        int val;
        ListNode* next;
        ListNode(int val) 
        {
            this->val = val;
            this->next = nullptr;
        }
        
    };

    struct TreeNode
    {
    public:
        int val;
        TreeNode* left;
        TreeNode* right;
        TreeNode(int val)
        {
            this->val = val;
            this->left = nullptr;
            this->right = nullptr;
        }
    };

    class StructHelper
    {
    public:
        //初始化单链表
        static ListNode* initList(std::vector<int>& nums);
        //销毁单链表
        static void destoryList(ListNode* head);
    };
}