/**
 * Created by pengshuang on 17/3/3.
 */
public class InversePairs {
    int count = 0;
    public int InversePairs(int [] array){
        if(array==null||array.length<2){
            return 0;
        }
        int[] temp = new int[array.length];
        int n=array.length;
        mSort(array,temp,0,n-1);
        return count%1000000007;
    }

    public void mSort(int[] A,int[] temp,int left,int right){
        if(left>=right){
            return;
        }
        int m=left+(right-left)/2;
        mSort(A,temp,left,m);
        mSort(A,temp,m+1,right);
        merge(A,temp,left,m,right);
    }

    public void merge(int[] A,int[] temp,int left,int mid,int right){
        int record = right;
        int m=mid+1;
        int record2=left;
        int right2=right;
        while(mid>=left&&right>=m){
            if(A[mid]>A[right]){
                count+=right-m+1;
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
                temp[record--]=A[mid--];
            }else{
                temp[record--]=A[right--];
            }
        }
        while(mid>=left){
            temp[record--]=A[mid--];
        }
        while(right>=m){
            temp[record--]=A[right--];
        }
        for(;record2<=right2;record2++){
            A[record2]=temp[record2];
        }
    }
}