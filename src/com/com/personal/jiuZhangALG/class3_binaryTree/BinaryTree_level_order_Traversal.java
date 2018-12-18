package com.personal.jiuZhangALG.class3_binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    /**
     * 思路：
     *      对于整棵二叉树，每次递进一层节点，将这一层节点全部存入到一个level集合当中
     * 实现：
     *      1.使用while(true)的方式一直往深层遍历
     *      2.root为根节点不变，将每次遍历的层级设置为maxLevel
     *      3.控制递归每次只进行一层递进（curtLevel > maxLevel）是return
     *
     * @param root 根节点
     * @return
     */
    public List<List<Integer>> levelOrder_with_DFS(TreeNode2 root) {
        List<List<Integer>> results = new ArrayList<>();

        //illegal
        if (root == null) {
            return results;
        }

        int maxLevel = 0;
        while (true) {
            List<Integer> level = new ArrayList<>();
            dfs(root, level, 0, maxLevel);
            if (level.size() == 0) { /** 保证遍历完最深层节点后调出整个循环 */
                break;
            }
            results.add(level);
            maxLevel++;
        }
        return results;
    }

    private void dfs(TreeNode2 root, List<Integer> level, int curtlevel, int maxLevel) {
        if (null == root || curtlevel > maxLevel) {
            return;
        }
        if (curtlevel == maxLevel) {
            level.add(root.val);
        }

        dfs(root.left, level, curtlevel + 1, maxLevel);
        dfs(root.right, level, curtlevel + 1, maxLevel);
    }
}
