/**
 * Created by pengshuang on 17/2/13.
 * 计算数组间两数异或的最大值
 */

public class MaximumXOR {
    private static class Node {
        Node[] next;

        public Node() {
            next = new Node[2];
        }
    }

    private void buildTrie(Node root, int x) {
        Node head = root;
        for (int i = 30; i >= 0; i--) {
            int bit = x & (1 << i);
            int flag = bit == 0 ? 0 : 1;
            if (head.next[flag] == null) {
                head.next[flag] = new Node();
            }
            head = head.next[flag];
        }
    }

    private int findMatchXor(Node root, int num) {
        int res = 0;
        Node head = root;
        for (int i = 30; i >=0; i--) {
            int bit = num & (1 << i);
            int flag = bit == 0 ? 0 : 1;
            /*
                异或的最大值就是找到与num同等位相反的,
                这样才是最大值,如果不存在这样分支,
                则找与num同等位相同的
             */
            if (head.next[1 - flag] == null) {
                head = head.next[flag];
                res += flag << i;
            } else {
                head = head.next[1 - flag];
                res += (1 - flag) << i;
            }
        }
        return res;
    }

    public int findMaximumXOR(int[] nums) {
        int res = 0;
        Node root = new Node();
        for (int num : nums) {
            buildTrie(root, num);
        }
        for (int value : nums) {
            int xorValue = findMatchXor(root, value);
            res = Math.max(res, xorValue ^ value);
        }
        return res;
    }
}
