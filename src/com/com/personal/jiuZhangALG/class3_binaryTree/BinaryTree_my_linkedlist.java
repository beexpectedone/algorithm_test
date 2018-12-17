package com.personal.jiuZhangALG.class3_binaryTree;

import java.util.NoSuchElementException;

public class BinaryTree_my_linkedlist {
    private int size;
    private ListNode<T> head;

    /*内部类ListNode*/
    static class ListNode<T> {
        private T value;
        private ListNode<T> next;

        public ListNode(T val) {
            this.value = val;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public ListNode<T> getNext() {
            return next;
        }

        public void setNext(ListNode<T> nextNode) {
            this.next = nextNode;
            return;
        }

        public String toString() {
            if(this.value == null) {
                return "null";
            }
            return this.value.toString();
        }
    }

    public BinaryTree_my_linkedlist() {
        head = new ListNode(0);
        head.setNext(null);
        size = 0;
    }

    /**
     * 思路：
     *      遍历list表到最后一个元素的位置，然后将该元素添加上去
     * @param val 要添加的元素
     */
    public void add(T val) {
        ListNode<T> cur = new ListNode<>(val);
        if(size == 0) {
            head.setNext(cur);
            size++;
            return;
        }

        ListNode<T> prev = head;
        while(prev.getNext() != null) {
            prev = prev.getNext();
        }

        prev.setNext(cur);
        size++;
        return;
    }

    /**
     * 思路：
     *      遍历找到“删除元素”的前一个元素
     *      找到“删除元素”的后一个元素
     *      将后一个元素，设置给 前一个元素的next
     * @param val 要删除的元素
     * @return
     */
    public boolean remove(T val) {
        if(size == 0) {
            throw new NoSuchElementException();
        }

        ListNode<T> cur = head;
        ListNode<T> prev = null;
        while(cur.getNext() != null && cur.getNext().getValue() != val) {
            prev = cur;
            //最终获取到的cur是T的前一项
            cur = cur.getNext();
        }

        if(cur.getNext() != null && cur.getNext().getValue() == val) {
            prev = cur;
            cur = cur.getNext(); //找到要删除的 cur
            prev.setNext(cur.getNext());  // 将当前cur中的next 赋给prev中的next元素
            size--;
        }
        else {
            return false;
        }
        return true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head.setNext(null);
        size = 0;
        return;
    }

    /**
     * 思路：
     *      根据index角标大小，从根节点开始遍历
     * @param index 元素角标
     * @return
     */
    public ListNode<T> get(int index) {
        if(index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int curIndex = index;
        ListNode<T> cur = head;

        while(cur.getNext() != null && curIndex-- > 0) {
            cur = cur.getNext();
        }

        if(curIndex != -1) {
            throw new NoSuchElementException();
        }
        return cur.getNext();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode<T> cur = head;
        sb.append(cur.getValue() + "->");

        while(cur.getNext() != null) {
            sb.append(cur.getNext().getValue() + "->");
            cur = cur.getNext();
        }
        sb.append("null");
        return sb.toString();
    }
}
