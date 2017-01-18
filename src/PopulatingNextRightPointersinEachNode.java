/**
 * Created by pengshuang on 17/1/18.
 * 因为要常数空间，所以不能使用队列广搜。
 * 因为在遍历下一层的时候，上一层已经用next串好了，所以使用两个变量遍历即可。
 For example, Given the following perfect binary tree,
      1
    /  \
   2    3
  / \  / \
 4  5 6  7

 After calling your function, the tree should look like:

   1 -> NULL
  /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 */

public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        while (root != null){
            TreeLinkNode first = root; //上一层的第一个节点
            TreeLinkNode pre = null; //左子树前的节点
            for(;root != null;root=root.next){
                if(pre != null) {
                    pre.next = root.left;
                }
                if(root.left != null) {
                    root.left.next = root.right;
                }
                pre = root.right;
            }
            root = first.left;
        }
    }
}
