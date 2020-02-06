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
 * 参考LinkedHashMap实现(哈希表 + 双向链表):
 * 哈希表用来保存插入的元素，实现O(1)效率的查找和插入
 * 双向链表用来实现LRU缓存机制：最近访问过或待插入的元素，把它移动到链表的尾部，如果哈希表满了，就删除链表头部的元素(最近未访问过)
 */
public class LRUCache {

    ListNode head, tail;//双向链表的头部和尾部

    class ListNode{
        ListNode pre;
        ListNode next;
        int key;
        int value;
    }

    /**
     * 在链表头部的右边删除一个元素
     */
    public ListNode removeFirst(){
        return removeNode(head.next);
    }

    /**
     * 在链表尾部的左边插入一个元素
     */
    public void addLast(ListNode node){
        if(node == null) return;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
        node.next = tail;
    }

    /**
     * 移动元素到链表尾部的左边
     */
    public void moveToLast(ListNode node){
        removeNode(node);
        addLast(node);
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
     * 如果存在这个元素就获取返回，并把这个元素移动到链表的尾部，如果不存在就返回-1
     */
    public int get(int key) {
        ListNode node = cache.getOrDefault(key, null);
        moveToLast(node);
        return node == null ? -1 : node.value;
    }

    /**
     * 添加元素:
     * 如果哈希表中有该元素，就直接更新该元素，并把该元素移动到链表的尾部
     * 如果哈希表中没有该元素，就判断哈希表有没有满：
     *      如果哈希表还没满，就把待插入元素直接插入到链表的尾部
     *      如果哈希表满了，就删除链表头部的元素，并把待插入元素插入到链表的尾部
     */
    public void put(int key, int value) {
        ListNode cacheNode = cache.get(key);
        if(cacheNode == null){
            ListNode newNode = new ListNode();
            newNode.value = value;
            newNode.key = key;
            if(cache.size() >= capacity){
                cache.remove(removeFirst().key);
            }
            addLast(newNode);
            cache.put(key, newNode);
        }else {
            cacheNode.value = value;
            moveToLast(cacheNode);
        }
    }

}
