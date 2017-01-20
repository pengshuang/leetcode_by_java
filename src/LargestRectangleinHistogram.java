import java.util.Stack;

/**
 * Created by pengshuang on 17/1/20.
 *
 * 使用递增栈来处理。每次比较栈顶与当前元素。如果当前元素小于栈顶元素，
 * 则入站，否则合并现有栈，直至栈顶元素小于当前元素。结尾入站元素0，重复合并一次。

 1. 当遇到一个违反递增关系的元素时，例如：
 2， 1， 5， 6， 2， 3
 (1).   S: 2
 (2).   S: 2
 新的元素1比2要小，表示Index = 0的这个直方图的右边界到达了，
 我们可以计算以它高度的最大直方。那么这个宽度如何计算呢？

 i = 1,而2弹出后，栈为空，宽度是从i到最左边（因为这是一个递增栈，如果现在栈为空，
 表示我们取出的当前直方是最低的直方，它的宽度可以一直延展到最左边。）
 假如栈不为空，则宽度是 i - s.peek() - 1
 (因为要减去s.peek()这个直方本身，它比s.pop()要低，阻止了s.pop()这个直方向左边延展)
 2 弹出后，栈为空。
 (3).  S: 1， 5， 6（这三个是连续递增，就让它们一直入栈）
 (4).  S: 1, 5, 6 现在我们遇到2， 6 出栈，它的宽度是6本身（i - 5所在的索引- 1)。
        5出栈，宽度是i - 1所在的索引 - 1
 (5).  因为2比1要高，所以我们停止计算直方，把2继续入栈。然后3入栈。
 (6).  这时index = len. 我们直接到第二个分支，把1， 2， 3 这三个直方计算了。
 (7).  栈为空，index = len 会入栈，然后index++ 越界，下一次就退出了。
 这里我们不可以把index < len 放在第一个判断的前面来判断，因为这样的话，当index = len,

 会直接再进入第二个分支，引发越界错误。其实我们就是假设在整个直方的最后存在一个height = 0的直方，所以我们要在一直计算到Index = len为止。而且因为它高度为0比谁都要低，所以可以把这个索引直接入栈。
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i <= heights.length; i++) {
            int curt = (i == heights.length) ? -1 : heights[i];
            while(!stack.isEmpty() && curt <= heights[stack.peek()]){
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}
