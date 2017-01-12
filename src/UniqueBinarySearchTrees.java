/**
 * Created by pengshuang on 17/1/12.
 * answer: 卡特兰数
 * 选取一个结点为根，就把结点切成左右子树，
 * 以这个结点为根的可行二叉树数量就是左右子树可行二叉树数量的乘积，
 * 所以总的数量是将以所有结点为根的可行结果累加起来。
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n<0)
            return 0;
        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=0;j<i;j++){
                f[i] += f[j]*f[i-j-1];
            }
        }
        return f[n];
    }
}
