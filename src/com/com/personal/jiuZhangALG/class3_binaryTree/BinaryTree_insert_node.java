package com.personal.jiuZhangALG.class3_binaryTree;

/***
 * Given a binary search tree and a new tree node, insert the node into the tree.
 * You should keep the tree still be a valid binary search tree.
 *
 *   2             2
 *  / \           / \
 * 1   4   -->   1   4
 *    /             / \
 *   3             3   6
 *   Can you do it without recursion?  要求不使用递归的方式
 *
 *       1
 *    / \
 *   2   3
 *  / \   \
 * 4   5   6
 *    / \
 *   7   8
 * it will be serialized to {1,2,3,4,5,#,6,#,#,7,8}.
 */
public class BinaryTree_insert_node {
    public static TreeNode2 insertNode(TreeNode2 rootOld, TreeNode2 newNode) {
        if (null == rootOld) {  //做合理性判断
            return newNode;
        }
        int newNodeVal = newNode.val;// 获取到 newNode 的值
        TreeNode2 root = rootOld;
        while (root.left != null || root.right != null) { //一直遍历到最深一级的节点，即当root的左边子节点和右边子节点都为空时
            int rootVal = root.val; // 获取到 root 的值
            if (rootVal > newNodeVal) { //如果root的值大于newNode 的值的话，就要向树的左侧移动
                root = root.left;
            } else if (rootVal < newNodeVal){ //如果root的值小于newNode的值，就要向树的右侧移动
                root = root.right;
            } else { //如果发现newNode的值等于其中某个节点的值，那么直接结束掉循环就可以了
                return rootOld;
            }
        }
        //判断最深一级节点的值和新节点值的大小
        if (root.val >= newNodeVal ) {
            root.left = newNode;
        }
        if (root.val < newNodeVal) {
            root.right = newNode;
        }
        return rootOld;
    }

    public TreeNode2 insertNode_with_recursion (TreeNode2 root, TreeNode2 node){
        if (root == null) {
            return node;
        }

        if (root.val > node.val) {
            /* 这里一定要是 if else 的形式，不能使用 两个if的形式，
             * 如果使用的是两个if的话，在不符合判断条件的时候就无
             * 法进到另外一个分支进行遍历了 */
            root.left = insertNode_with_recursion(root.left, node);
        } else {
            root.right = insertNode_with_recursion(root.right, node);
        }
        return root;
    }
}
