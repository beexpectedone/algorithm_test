package com.personal.jiuZhangALG.class3_binaryTree;

import java.util.Stack;

/**
 * 设计实现一个带有下列属性的二叉查找树的迭代器：
 * next() 返回BST中下一个最小的元素
 *      元素按照递增的书序被访问（比如中序遍历）
 *      next() 和 hasNext() 的询问操作要求均摊时间复杂度是O(1)
 *
 * 转换题意：
 *      1.next() 方法每次获取的栈顶的node
 *      2.同时保证下次获取到的node节点是比这次大的节点
 *
 * 思路：
 *      1.stack中保存一路走到当前节点的所有节点（即先将树上最左侧的点全部压栈），stack.peek()一直指向iterator 指向的当前节点
 *      2.判断有没有下一个，只需要判断stack是否为空
 *      3.获取下一个值，只需要返回stack.peek() 的值，并将stack进行相应的变化，挪到下一个点
 *      遍历方式参考------inorder-traversal中的方式
 */
public class BinaryTree_BSTIterator {
    private Stack<TreeNode2> stack = new Stack<>();

    //The root of binary tree.
    //将树上最左侧的所有的点都放到栈中，在构造函数中完成
    public BinaryTree_BSTIterator(TreeNode2 root) {
        while (null != root) {
            stack.push(root);
            root = root.left;
        }
    }

    //True if there has next node, or false
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    //return next node
    public TreeNode2 next() {
        TreeNode2 curt = stack.peek(); //当前栈顶的元素
        TreeNode2 node = curt; //

        // move to the next node
        if (node.right == null) {
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().right == node) {
                stack.pop();
            }
        } else {
            node = node.right;  // 如果节点的右侧节点不为空，那么获取到该右侧节点
            while (node != null) {
                stack.push(node);
                node = node.left; // 因为是做类似于“中序遍历”的事，那么节点的读取方式就要符合 “左 - 中 - 右” 的顺序
            }
        }
        return curt;
    }
}


