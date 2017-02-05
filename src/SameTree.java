/**
 * Created by pengshuang on 17/1/2.
 * answer: 递归求解
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

    public boolean isSameTree2(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == t2;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return (isSameTree(t1.left, t2.left) && (isSameTree(t1.right, t2.right)));
    }
}
