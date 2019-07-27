package medium.leetcode146;

import java.util.*;

/**
 * LRU缓存机制:
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 示例:
 * LRUCache cache = new LRUCache(2// 缓存容量);
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 */

/**
 * 哈希表 + 双向链表实现:
 * 最近访问的元素，把它移动到链表的头部的下一个
 * 如果要插入元素，如果哈希表中由该元素就直接更新，否则如果哈希表还没满，就把它插入链表的头部的下一个，如果哈希表满了，就删除链表尾部的上一个元素，把它插入到链表的头部的下一个
 */
public class LRUCache {


    ListNode head, tail;//链表的头部和尾部

    class ListNode{
        ListNode pre;
        ListNode next;
        int key;
        int value;
    }

    /**
     * 在链表头部的右边插入元素
     */
    public void addNodeAfterHead(ListNode node){
        if(node == null) return;
        node.pre = head;
        node.next = head.next;

        node.next.pre = node;
        head.next = node;
    }

    /**
     * 移动元素到链表的头部的右边
     */
    public void moveNodeAfterHead(ListNode node){
        removeNode(node);
        addNodeAfterHead(node);
    }

    /**
     * 在链表的尾部的左边删除一个元素
     */
    public ListNode removeNodeAfterTial(){
        return removeNode(tail.pre);
    }

    /**
     * 在链表中删除一个元素
     */
    public ListNode removeNode(ListNode node){
        if(node == null) return null;
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
        return node;
    }

    Map<Integer, ListNode> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        //初始化只有头尾结点的链表
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 获取元素：
     * 并把这个元素移动到链表的头部的右边
     */
    public int get(int key) {
        ListNode node = cache.getOrDefault(key, null);
        moveNodeAfterHead(node);
        return node == null ? -1 : node.value;
    }

    /**
     * 添加元素:
     * 如果哈希表中有该元素，就直接更新该元素，并移动到链表的头部的右边
     * 如果哈希表中没有该元素，就判断哈希表有没有满：
     *      如果哈希表还没满，就把它插入链表的头部的下一个;
     *      如果哈希表满了，删除链表尾部的上一个元素，把它插入到链表的头部的下一个
     */
    public void put(int key, int value) {
        ListNode cacheNode = cache.get(key);
        if(cacheNode == null){
            ListNode newNode = new ListNode();
            newNode.value = value;
            newNode.key = key;
            if(cache.size() >= capacity){
                cache.remove(removeNodeAfterTial().key);
            }
            addNodeAfterHead(newNode);
            cache.put(key, newNode);
        }else {
            cacheNode.value = value;
            moveNodeAfterHead(cacheNode);
        }
    }

}
