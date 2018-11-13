import java.util.LinkedList;

/**
 * Created by pengshuang on 17/1/7.
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return getMin(root);
    }
    private int getMin(TreeNode root){
        if (root == null){
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }

    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        int depth = 0;
        int count = 1;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            depth++;
            int temp = count;
            count = 0;
            while(temp-- > 0){
                TreeNode node = q.poll();
                if(node.left == null && node.right == null){
                    return depth;
                }
                if(node.left != null){
                    q.offer(node.left);
                    count ++;
                }
                if(node.right != null){
                    q.offer(node.right);
                    count ++;
                }
            }
        }
        return depth;
    }
}
