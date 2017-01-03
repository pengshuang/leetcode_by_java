import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pengshuang on 17/1/3.
 * Given binary tree [3,9,20,null,null,15,7],
 *    3
     / \
 *  9  20
   /    \
  15     7
 *  return its level order traversal as:
 *  [
 *  [3],
 *  [9,20],
 *  [15,7]
 *  ]
 */


public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode node;
        int count = 1;
        while(!q.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int temp = count;
            count = 0;
            while (temp-- > 0){
                node = q.poll();
                list.add(node.val);
                if(node.left != null){
                    count++;
                    q.offer(node.left);
                }
                if(node.right != null){
                    count++;
                    q.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
