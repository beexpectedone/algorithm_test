package com.personal.jiuZhangALG.class3_binaryTree;

import java.util.Stack;

/**
 * Design an iterator over a binary search tree with the following rules:
 *      Elements are visited in ascending order (i.e. an in-order traversal)
 *      next() and hasNext() queries run in O(1) time in average.
 *  For the following binary search tree, in-order traversal by using iterator is [1, 6, 10, 11, 12]
 *
 *    10
 *  /    \
 * 1      11
 *  \       \
 *   6       12
 *
 *   感悟：
 *          与BSTIterator的区别是：它在hasNext() 方法中可能会做压栈操作
 */
public class BinaryTree_BSTIterator2 {
    private Stack<TreeNode2> stack = new Stack<>();
    TreeNode2 next  = null; //next初始值为null
    //每次调用了hasNext() 方法以后再去查看next节点是否还有子节点
    void AddNodeToStack(TreeNode2 root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    //the root of binary tree.
    public BinaryTree_BSTIterator2(TreeNode2 root) {
        next = root;
    }

    //True if there has next node, or false
    //每次判断是否有next（下一个）元素的同时，如果存在下一个元素就将这一分支上
    //所有的最左侧的节点添加到stack中
    public boolean hasNext() {
        if (null != next) {
            AddNodeToStack(next);
            next = null;
        }
        return !stack.isEmpty();
    }

    // 每次都获取right（右侧）节点作为next，
    //如果right没有那么下一次next返回的就是被压栈的左侧节点
    public TreeNode2 next() {
        if (!hasNext()) {
          return null;
        }
        TreeNode2 cur = stack.pop();
        next = cur.right;
        return cur;
    }
}
