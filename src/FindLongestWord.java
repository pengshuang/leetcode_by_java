import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengshuang on 17/6/28.
 */

public class FindLongestWord {
    public static String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray())
                if (i < dictWord.length() && c == dictWord.charAt(i))
                    i++;

            if (i == dictWord.length() && dictWord.length() >= longest.length())
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0)
                    longest = dictWord;
        }
        return longest;
    }

    public static void main(String [] args) {
        List<String> d = new ArrayList<>();
        d.add("aaa");
        d.add("aa");
        d.add("a");
        System.out.println(findLongestWord("aaa", d));
    }
}
