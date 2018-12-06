package personal.jiuZhangALG.class3_binaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree_inorder_traversal {

    public static ArrayList<Integer> inorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode curt = root;
        while (curt != null && !stack.empty()) {
            while (curt != null) {  // 这部分的程序是将一个分支上所有的节点全部压入栈中（类似于后序遍历）
                stack.add(curt);
                curt = curt.left;
            }
            curt = stack.pop();
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
                }
            } else {
                node = node.right;
                while (node != null){  /*判断节点是不是既是右节点还是父节点*/
                    stack.push(node);
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
