/**
 * Created by pengshuang on 17/1/18.
 * answer: 数字反转会溢出，所以每次取数字的第一个和最后一个进行比较
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int num=0;
        int oldNum=x;
        while(x!=0)
        {
            int pre=num;
            num=num*10+x%10;
            if(num/10!=pre)
                return false;
            x/=10;
        }
        return num==oldNum;
    }
}
