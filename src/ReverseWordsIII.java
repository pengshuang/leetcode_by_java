/**
 * Created by pengshuang on 17/7/22.
 */
public class ReverseWordsIII {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals("")) {
                String temp = reverse(array[i]);
                sb.append(temp).append(" ");
            }
        }

        //remove the last " "
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    static String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}
