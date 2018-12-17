package com.personal.jiuZhangALG.class3_binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 思路：
 *      使用 Queue ，运用其特点“先进先出”
 *      遍历同一层级节点获取到节点val值，同时获取到他们的子节点并将子节点添加到Queue当中
 */
public class BinaryTree_level_order_Traversal {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode2 root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //illegal
        if (null == root) {
            return result;
        }

        //interface
        Queue<TreeNode2> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) { // 将Queue中的节点依次去除
            int size = queue.size();
            ArrayList<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) { // 同时获取节点的子节点
                TreeNode2 head = queue.poll();
                currentLevel.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> levelOrderTest(TreeNode2 root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //illegal
        if (null == root) {
            return result;
        }

        Queue<TreeNode2> queue = new LinkedList<>(); //Queue 为interface，需要new它具体的实现类
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode2 head = queue.poll();
                currentLevel.add(head.val);
                if (null != head.left){
                    queue.offer(head.left);
                }
                if (null != head.right) {
                    queue.offer(head.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
}
