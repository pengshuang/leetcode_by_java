/**
 * Created by pengshuang on 17/1/4.
 * 生成一棵二叉排序树
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }

    private TreeNode buildTree(int[] num, int start, int end) {
        if(start > end) return null;
        int mid = start + ((end - start)>>1);
        TreeNode root = new TreeNode(num[mid]);
        root.left = buildTree(num, start, mid-1);
        root.right = buildTree(num, mid+1, end);
        return root;
    }
}
