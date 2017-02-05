/**
 * Created by pengshuang on 17/2/5.
 */
public class Subtree {
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T2 == null){
            return true;
        }
        if (T1 == null){
            return false;
        }
        if (isSameTree(T1, T2)){
            return true;
        }

        return (isSubtree(T1.left, T2) || isSubtree(T1.right, T2));
    }

    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == t2;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return (isSameTree(t1.left, t2.left) && (isSameTree(t1.right, t2.right)));
    }
}
