/**
 * Created by pengshuang on 17/5/12.
 */
public class Convert {
    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows <= 1 || numRows >= s.length())
            return s;

        StringBuilder sb = new StringBuilder("");
        int index, step;
        for (int i = 0; i < numRows; i++) {
            index = i;
            step = 2 * i - 1;
            while (index < s.length()) {
                sb.append(s.charAt(index));
                do{
                    step = 2 * (numRows - 2) - step;
                } while (step <= 0);
                index += step + 1;
            }
        }
        return sb.toString();
    }
}
