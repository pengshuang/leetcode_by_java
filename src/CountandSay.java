/**
 * Created by pengshuang on 16/12/29.
 */
public class CountandSay {
    public String countAndSay(int n) {
        if(n < 0){
            return null;
        }
        String say = "1";
        while(--n > 0){
            say = readOff(say);
        }
        return say;
    }
    private String readOff(String str){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char ch = str.charAt(0);
        for(int i=1;i<str.length();i++){
            if(ch == str.charAt(i)){
                count++;
            }else {
                sb.append(count).append(ch);
                count = 1;
                ch = str.charAt(i);
            }
        }
        sb.append(count).append(ch);
        return sb.toString();
    }
}
