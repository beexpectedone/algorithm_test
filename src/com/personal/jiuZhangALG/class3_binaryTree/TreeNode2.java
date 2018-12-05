package personal.jiuZhangALG.class3_binaryTree;

public class TreeNode2 {
    public int val;
    public TreeNode2 left, right;
    public TreeNode2(int val) {
        this.val = val;
        this.left = this.right = null;
    }

    public void setLeft(TreeNode2 left) {
        this.left = left;
    }

    public void setRight(TreeNode2 right) {
        this.right = right;
    }
}
