package com.personal.jiuZhangALG.class3_binaryTree;

/**
 * Created by mingyue on 2018/12/9.
 */
public class BinaryTree_lowest_common_tree {

    public static TreeNode2 getAncestor(TreeNode2 root, TreeNode2 node1, TreeNode2 node2) {
        if (root == null) {
            return null;
        }
        if (root == node1 || root == node2) { /* 这里是递归之后取到了传入的node1或者node2节点 */
            /** 取到传入的节点以后，就不需要再在这个分支上往下进行遍历了 */
            return root;
        }

        //Divide
        TreeNode2 left = getAncestor(root.left, node1, node2);
        TreeNode2 right = getAncestor(root.right, node1, node2);

        //Conquer
        if (left != null && right != null) {
            System.out.println("left = " + left.val);
            System.out.println("right = " + right.val);
            System.out.println("root = " + root.val); /** 最后肯定是会走到这里的 */
            return root;
        }
        if (left != null) { /* 两个不等于null的判断是为了，让传入的节点最终能转化为一个分枝上的两个节点
                               当传入的节点，其中一个分支为空时，那么传的另外一个节点肯定不是和它在一个分
                               支上的。那么此时就要向上去去

                            */
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}
