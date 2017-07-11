import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pengshuang on 17/7/3.
 */
public class WordBreak2 {
//    static HashMap<String,List<String>> map = new HashMap<String, List<String>>();
//    public static List<String> wordBreak(String s, List<String> wordDict) {
//        List<String> res = new ArrayList<String>();
//        if(s == null || s.length() == 0) {
//            return res;
//        }
//        if(map.containsKey(s)) {
//            return map.get(s);
//        }
//        if(wordDict.contains(s)) {
//            res.add(s);
//        }
//        for(int i = 1 ; i < s.length() ; i++) {
//            String t = s.substring(i);
//            if(wordDict.contains(t)) {
//                List<String> temp = wordBreak(s.substring(0 , i) , wordDict);
//                if(temp.size() != 0) {
//                    for(int j = 0 ; j < temp.size() ; j++) {
//                        res.add(temp.get(j) + " " + t);
//                    }
//                }
//            }
//        }
//        map.put(s , res);
//        return res;
//    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    private static List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }

    public static void main(String [] args){
        String s = "catsanddog";
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        System.out.println(wordBreak(s, dict));
    }
}
