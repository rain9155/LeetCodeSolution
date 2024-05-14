#pragma once
#include <vector>
#include "struct.h"

namespace Common
{
    class Utils
    {
    public:
        //给定一个数组打印
        static void printNums(std::vector<int>& nums);
        //打印单链表
        static void printList(ListNode* head);
    };
}