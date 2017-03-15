import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> dmap = new HashMap<>();

        for (int num : nums){
            while (!stack.isEmpty() && stack.peek() < num){
                dmap.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++) {
            if (dmap.containsKey(findNums[i]))
                findNums[i] = dmap.get(findNums[i]);
            else
                findNums[i] = -1;
        }
       return findNums;
    }
}
