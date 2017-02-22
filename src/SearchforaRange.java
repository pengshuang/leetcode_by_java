/**
 * Created by pengshuang on 17/1/8.
 * 二分查找法
 */
public class SearchforaRange {
    public int[] searchRange(int[] A, int target) {
        if (A.length == 0) {
            return new int[]{-1, -1};
        }
        int first = binarySearchForFirst(A,target);
        int last = binarySearchForLast(A,target);
        return new int[]{first,last};
    }

    private int binarySearchForFirst(int[] A,int target){
        int left = 0;
        int right = A.length-1;
        int mid;
        while(left + 1 < right){
            mid = left + ((right-left) / 2);
            if(A[mid] >= target){
                right = mid;
            }else{	//A[mid] >= target
                left = mid;
            }
        }

        if(A[left] == target)
            return left;
        else if(A[right] == target)
            return right;
        else return -1;
    }

    private int binarySearchForLast(int[] A,int target){
        int left = 0;
        int right = A.length-1;
        int mid;
        while(left + 1 < right){
            mid = left + ((right-left) / 2);   //注意要加1
            if(A[mid] <= target){
                left = mid;
            }else{	//A[mid] <= target 此处不能拆成两个条件
                right = mid;
            }
        }

        if(A[right] == target)
            return right;
        else if(A[left] == target)
            return left;
        else
            return -1;
    }
}
