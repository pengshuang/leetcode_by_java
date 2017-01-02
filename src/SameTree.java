/**
 * Created by pengshuang on 17/1/2.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            if (p == null && q == null){
                return true;
            }else {
                return false;
            }
        }
        if(p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
