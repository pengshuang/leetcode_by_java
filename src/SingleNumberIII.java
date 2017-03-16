import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengshuang on 17/1/10.
 * 首先计算nums数组中所有数字的异或，记为xor
 * 令lowbit = xor & -xor，lowbit的含义为xor从低位向高位，第一个非0位所对应的数字
 * 例如假设xor = 6（二进制：0110），则-xor为（二进制：1010，-6的补码，two's complement）
 * 则lowbit = 2（二进制：0010）
 * 根据异或运算的性质，“同0异1”
 * 记只出现一次的两个数字分别为a与b
 * 可知 a & lowbit与b & lowbit的结果一定不同
 * 通过这种方式，即可将a与b拆分开来
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i=0;i<nums.length;i++){
            xor ^= nums[i];
        }
        int[] res = new int[2];
        // 令lowbit = xor & -xor，lowbit的含义为xor从低位向高位，第一个非0位所对应的数字
        int lowbit = xor & -xor;
        for (int i=0;i<nums.length;i++){
            if ((nums[i] & lowbit)!=0){
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}
