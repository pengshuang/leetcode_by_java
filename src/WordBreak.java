import java.util.Arrays;
import java.util.List;

/**
 * Created by pengshuang on 17/2/25.
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 0)
            return s.length() == 0;

        int n = s.length();
        boolean[] cansegment = new boolean[n + 1];
        cansegment[0] = true;

        int maxLength = 0;
        for (int i = 0; i < wordDict.size(); i++){
            if (wordDict.get(i).length() > maxLength){
                maxLength = wordDict.get(i).length();
            }
        }

        for (int i = 1; i < n + 1; i++) {
            int lastWordlength = 1;
            while (lastWordlength <= maxLength && lastWordlength <= i) {
                if (!cansegment[i - lastWordlength]){
                    lastWordlength += 1;
                    continue;
                }
                String word = s.substring(i - lastWordlength, i);
                if (wordDict.contains(word)){
                    cansegment[i] = true;
                    break;
                }
                lastWordlength += 1;
            }
        }
        return cansegment[n];
    }
}
