package personal.jiuZhangALG.class3_binaryTree;

import java.util.ArrayList;
import java.util.Stack;

/***
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *  Given binary tree {1,#,2,3},
 *     1
 *     \
 *      2
 *     /
 *    3
 * return [3,2,1].
 */
public class BinaryTree_postorder_traversal {

    //Recursive
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    /**
     * 感悟：
     *      先将一个分支上所有的节点全部压栈，然后再从最深层的开始弹栈，没弹出一个节点后都会
     *      转移到隔壁的分支继续遍历
     * @param root 根节点
     * @return result集合
     */
    public static ArrayList<Integer> postorderTraversal_No_Recursive(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null; // previously traversed node
        TreeNode curr = root;

        if (null == root) {
            return result;
        }
        stack.push(root);
        while (!stack.empty()) {
            curr = stack.peek();  //don not pop this item
            if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            }else if (curr.left == prev) { // traverse up the tree from the left
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            }else {
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        return result;
    }
}
