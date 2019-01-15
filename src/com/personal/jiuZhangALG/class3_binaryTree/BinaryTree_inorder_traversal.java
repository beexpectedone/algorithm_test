package com.personal.jiuZhangALG.class3_binaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,3,2].
 */
public class BinaryTree_inorder_traversal {

    public static ArrayList<Integer> inorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode curt = root;
        while (curt != null || !stack.empty()) {
            while (curt != null) {  // 这部分的程序是将左侧分支上所有的节点全部压入栈中（类似于后序遍历）
                stack.add(curt);
                curt = curt.left;  // 这里curt最终在结束while操作的时候被赋值为null
            }
            curt = stack.pop(); //保证当前的curt一定是有值的，将当前的节点弹栈，并且将节点赋值给curt
            result.add(curt.val);
            curt = curt.right;
        }
        return result;
    }

    public ArrayList<Integer> inorderTraversal_no_recursion(TreeNode2 root) {
        Stack<TreeNode2> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        while (root != null) {
            stack.add(root);
            root = root.left;  //将一个分支上的左边节点全部压栈
        }

        while (!stack.isEmpty()) {
            TreeNode2 node = stack.peek();
            result.add(node.val);  /*第一次进到该方法的时候，被添加进去的时候肯定是“左节点”*/
            System.out.print(node.val + " ");
            if (node.right == null) {
                /* 如果该节点没有右侧节点那么就不用考虑它右侧的情况可以径直将其弹出栈 */
                node = stack.pop(); // 如果该节点没有右侧子节点就将该节点弹栈
                // 做一次弹栈操作后，此时stack.peek() 获取到的是父节点
                // 如果发现当前节点的右边节点右侧节点等于“上一步中弹出栈的节点”，即上次弹出栈的节点为右节点
                // 则再将当前的节点弹出栈，并将节点赋值给node变量
                while (!stack.isEmpty() && stack.peek().right == node) {
                    /** 该步骤主要是判断当前节点是不是右节点 ，
                     * 如果该节点自身是右侧节点，就直接弹出该节点
                     * */
                    node = stack.pop();
                    /** 这里相当于第二/~n 次的弹出右侧节点的操作，
                     如果这个节点一直有右侧节点的属性那么一直做
                     弹栈的操作*/
                }
            } else {
                node = node.right;
                while (node != null){  /*判断节点是不是还有子节点*/
                    stack.push(node);
                    /* 处理右侧节点包含子树的情况
                    * 此时的右侧节点成为这个一部分
                    * 二叉树的根节点 */
                    node = node.left;
                }
            }
        }
        return result;
    }

    public ArrayList<Integer> inorderTraversal_no_recursion2(TreeNode2 root) {
        Stack<TreeNode2> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        while (null != root) {  //先将深入到左子树上的最深层级
            stack.add(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode2 node = stack.peek(); //先拿出来一个节点
            result.add(node.val); //第一次添加到集合中的是左子树最深层的最左侧的节点
            System.out.print(node.val);

            if (node.right == null) { //如果该节点没有了右侧节点，它就作为它的这个分支上最后的节点输出
                node = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == node){ //判断节点是否为右侧节点，如果是右侧节点弹出该节点
                    node = stack.pop(); //弹出该节点就意味着这一块的二叉树结束
                }
            } else { // 如果该节点不是右侧节点，则要去找他的右侧节点
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    System.out.print(" ");
                    node = node.left;
                }
            }
        }
        return result;
    }

    public ArrayList<Integer> inorderTraversal(TreeNode2 root) {
        Stack<TreeNode2> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        if (root != null) {
            TreeNode2 curr0 = root;
            while (curr0 != null) { //先把最左边的所有节点依次压栈
                stack.add(curr0);
                curr0 = curr0.left;
            }

            while (!stack.isEmpty()) {
                TreeNode2 curr = stack.peek();
                result.add(curr.val);

                if (curr.right == null) { //如果当前的节点没有右侧节点
                    System.out.println(" ");
                    curr = stack.pop(); //弹出该节点
                    while (!stack.isEmpty() && stack.peek().right == curr) { //判断当前的节点本身是不是右侧节点
                        curr = stack.pop(); //如果当前节点本身是右侧节点就弹出该节点
                    }
                } else {
                    curr = curr.right; //如果当前节点还存在右侧节点
                    while (curr != null) {
                        stack.push(curr);
                        curr = curr.left;
                    }
                }
            }
        }
        return result;
    }

    public void inorder(TreeNode2 root){
        if (root == null) {
            return;
        }

        Stack<TreeNode2> stack = new Stack<>();
        TreeNode2 curr = root; //将根节点赋值给curr

        //traverse the tree
        while (curr != null || stack.size() > 0){
            /* Reach the left most Node of the curr Node */
            while (curr != null) {
                /*place pointer to a tree node on the stack before traversing the node's left subtree*/
                stack.push(curr);
                curr = curr.left;
            }
            /*Current must be NULL at this point*/
            curr = stack.pop(); //将最左侧节点的最深一级的节点弹出栈

            System.out.print(curr.val + " ");

            /*we have visited the node and its left subtree.
            * Now it's right subtree's turn*/
            curr = curr.right;
        }
    }
}
