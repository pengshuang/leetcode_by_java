import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pengshuang on 17/1/20.
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 1;i < numRows; i++){
            Integer[] row = new Integer[i];
            row[0] = 1;
            row[i-1] = 1;
            if (i <= 2) {
                res.add(Arrays.asList(row));
                continue;
            }
            List<Integer> pre = res.get(res.size()-1);
            for (int j = 1; j < i - 1; j++) {
                row[j] = pre.get(j-1) + pre.get(j);
            }
            res.add(Arrays.asList(row));
        }
        return res;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        ArrayList<Integer> first = new ArrayList<>();
        first.add(0,1);
        res.add(first);
        for (int i=1;i<numRows;i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < i+1; j++){
                tmp.add(-1);
            }
            List<Integer> prev = res.get(i-1);
            tmp.set(0,prev.get(0));
            tmp.set(i,prev.get(i-1));
            for (int j = 1; j < i; j++){
                tmp.set(j, prev.get(j-1) + prev.get(j));
            }
            res.add(tmp);
        }
        return res;
    }
}
