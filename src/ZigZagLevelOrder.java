import java.util.*;

/**
 * Created by pengshuang on 17/1/26.
 */
public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        int currentLevelNum = 1;
        int nextLevelNum = 0;
        List<List<Integer>> resultList = new ArrayList<>();
        LinkedList<Integer> levelList = new LinkedList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            levelList.add(node.val);
            currentLevelNum -= 1;
            if (node.left != null){
                queue.add(node.left);
                nextLevelNum += 1;
            }
            if (node.right != null){
                queue.add(node.right);
                nextLevelNum += 1;
            }
            if (currentLevelNum == 0){
                if (level % 2 == 1){
                    resultList.add(levelList);
                }
                else {
                    Collections.reverse(levelList);
                    resultList.add(levelList);
                }
                levelList = new LinkedList<>();
                currentLevelNum = nextLevelNum;
                nextLevelNum = 0;
                level += 1;
            }
        }
        return resultList;
    }

}
