/**
 * Created by pengshuang on 18/2/24.
 */
public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        // Arrays.sort(letters); // sorted
        int n = letters.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (letters[m] > target) r = m - 1;
            else l = m + 1;
        }
        return l == n ? letters[0] : letters[l];
    }
}
