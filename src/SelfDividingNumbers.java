import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (i % 10 == 0) {
                continue;
            }
            String s = String.valueOf(i);
            int j;
            for (j = 0; j < s.length(); j++) {
                if (Integer.parseInt(s.substring(j, j+1)) == 0)
                    break;
                if (i % Integer.parseInt(s.substring(j, j+1)) != 0)
                    break;
            }
            if (j == s.length())
                res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22));
    }

}
