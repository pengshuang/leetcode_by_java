import java.util.*;

class Node2 {
    public int val;
    public List<Node2> children;

    public Node2() {}

    public Node2(int _val,List<Node2> _children) {
        val = _val;
        children = _children;
    }
}

public class MaximumDepthofNaryTree {
    public int maxDepth(Node2 root) {
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        } else {
            List<Integer> heights = new LinkedList<>();
            for (Node2 item : root.children) {
                heights.add(maxDepth(item));
            }
            return Collections.max(heights) + 1;
        }
    }
}
