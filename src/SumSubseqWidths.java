import java.util.Arrays;

public class SumSubseqWidths {

/*
    The order in initial arrays doesn't matter,
    my first intuition is to sort the array.

    For A[i]:
    There are i smaller numbers,
    so there are 2 ^ i sequences in which A[i] is maximum.
    we should do res += A[i] * (2 ^ i)

    There are n - i - 1 bigger numbers,
    so there are 2 ^ (n - i - 1) sequences in which A[i] is minimum.
    we should do res -= A[i] * 2 ^ (n - i - 1)
*/
    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        long c = 1, res = 0, mod = (long)1e9 + 7;
        for (int i = 0; i < A.length; ++i, c = (c << 1) % mod)
            res = (res + A[i] * c - A[A.length - i - 1] * c) % mod;
        return (int)(res % mod);
    }
}
