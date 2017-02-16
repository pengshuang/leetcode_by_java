/**
 * Created by pengshuang on 17/2/16.
 */
public class MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        int[] max = new int[words.length];

        max[0] = words[0].length();
        int result = words[0].length();

        for (int i = 1; i < words.length; i++){
            if (!contains(words[i], words[i-1])){
                max[i] = Math.max(max[i], max[i-1]*words[i].length());
                result = Math.max(result, max[i]);
            }
        }
        return result;
    }

    public boolean contains(String a, String b){
        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();
        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                if (ch2[j] == ch1[i]){
                    return true;
                }
            }
        }
        return false;
    }
}
