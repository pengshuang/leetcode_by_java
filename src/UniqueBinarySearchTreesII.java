import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengshuang on 17/1/12.
 * 思路是每次一次选取一个结点为根，然后递归求解左右子树的所有结果，
 * 最后根据左右子树的返回的所有子树，依次选取然后接上（每个左边的子树跟所有右边的子树匹配，
 * 而每个右边的子树也要跟所有的左边子树匹配，总共有左右子树数量的乘积种情况），
 * 构造好之后作为当前树的结果返回
 */

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n){
        if(n==0) return new ArrayList<TreeNode>();
        return helper(1, n);
    }

    private ArrayList<TreeNode> helper(int left, int right){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if(left>right)
        {
            res.add(null);
            return res;
        }
        for(int i=left;i<=right;i++)
        {
            ArrayList<TreeNode> leftList = helper(left,i-1);
            ArrayList<TreeNode> rightList = helper(i+1,right);
            for(int j=0;j<leftList.size();j++)
            {
                for(int k=0;k<rightList.size();k++)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = leftList.get(j);
                    root.right = rightList.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
