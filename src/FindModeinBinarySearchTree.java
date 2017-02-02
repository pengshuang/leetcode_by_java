import java.util.*;

/**
 * Created by pengshuang on 17/2/2.
 */
public class FindModeinBinarySearchTree {
    public int[] findMode(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        inOrder(map,root);
        // int[] res = new int[map.size()];
        List<Integer> list = new ArrayList<>();
        List<Map.Entry<Integer,Integer>> list2 = new ArrayList<>(map.entrySet());
        Collections.sort(list2,new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int maxMode = 0;
        for (Map.Entry<Integer,Integer> e:list2){
            int mode = e.getValue();
            if(maxMode == 0){
                maxMode = mode;
                list.add(e.getKey());
            }else if(mode == maxMode){
                list.add(e.getKey());
            }else{
                break;
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                res[i] = list.get(i);
            }
        }
        return res;
    }

    public void inOrder(Map<Integer,Integer> map, TreeNode root){
        if(root != null){
            inOrder(map, root.left);
            if(map.containsKey(root.val)){
                map.put(root.val, map.get(root.val) + 1);
            }else {
                map.put(root.val,1);
            }
            inOrder(map, root.right);
        }
    }
}
