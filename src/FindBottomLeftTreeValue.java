import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by pengshuang on 17/2/17.
 */

public class FindBottomLeftTreeValue {
    int ans=0;
    int h = 0;
    public int findLeftMostNode(TreeNode root) {
        dfs(root, 1);
        return ans;
    }
    private void dfs(TreeNode root, int depth) {
        if (h<depth) {
            ans=root.val;
            h=depth;
        }
        if (root.left!=null)
            dfs(root.left, depth+1);
        if (root.right!=null)
            dfs(root.right, depth+1);
    }

    /*
    方法二,广度优先遍历
     */

    public int findLeftMostNode2(TreeNode root) {
        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        Integer res = null;
        while(list.size()>0){
            Queue<TreeNode> next = new LinkedList<>();
            int size = list.size();
            for(int i = 0; i<size; i++){
                TreeNode cur = list.poll();
                if(i==0)
                    res = cur.val;
                if(cur.left!=null)
                    next.add(cur.left);
                if(cur.right!=null)
                    next.add(cur.right);
            }
            list = next;
        }
        return res;
    }
}
