import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengshuang on 18/2/23.
 */
public class NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        List<Character> ListJ = new ArrayList<>();
        for (char j: J.toCharArray()) ListJ.add(j);
        for (char s: S.toCharArray()) if (ListJ.contains(s)) res++;
        return res;
    }
}
