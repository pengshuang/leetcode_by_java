/**
 * Created by pengshuang on 17/1/10.
 * answer：使用位运算，时间O(N) 空间O(1)
 * 用两个数one和two，当一个数第一次出现会先保存在one中；第二次出现在one中清除，
 * 保存在two中；第三次出现会将two中清除。最后输出one即可。 "用二进制模拟三进制"
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;
        int three = 0;
        for (int i=0;i<nums.length;i++){
            two |= one & nums[i];
            one ^= nums[i];
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }

    public int singleNumber2(int[] nums) {
        int cnt[] = new int[32];
        int single = 0;
        for (int i=0;i<32;i++){
            for (int j=0;j<nums.length;j++){
                cnt[i] += (nums[j]>>i) & 0x1;
            }
            single |= cnt[i] % 3 << i;
        }
        return single;
    }

    public int singleNumber3(int[] A) {
        int one = 0;
        int two = 0;
        for(int i=0;i<A.length;i++){
            one = (one ^ A[i]) & ~two;
            two = (two ^ A[i]) & ~one;
        }
        return one;
    }
}
