import java.util.Random;

/**
 * 从大小为 n 的数组中随机选出 m 个整数。要求每个数被选中的概率相同。
 */
public class PickMiteratively {
    public int[] pick(int[] original, int m) {
        int[] subset = new int[m];
        Random rand = new Random();

        for (int i = 0; i < m; i++) {
            subset[i] = original[i];
        }

        for (int i = m; i < original.length; i++) {
            int k = rand.nextInt(i);
            if (k < m){
                subset[k] = original[i];
            }
        }
        return subset;
    }
}
