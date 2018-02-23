import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pengshuang on 18/2/23.
 */
public class FindCheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][][] graph = new int[n][n][2];
        for(int[] curr:flights){
            int u = curr[0];
            int v = curr[1];
            int p = curr[2];
            graph[u][v][0] = 1;
            graph[u][v][1] = p;
        }
        if(K == 0){
            return (graph[src][dst][0] == 1) ? graph[src][dst][1] : -1;
        }
        Queue<Integer> index = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        index.add(src);
        dist[src] = 0;
        int step = 0, res = Integer.MAX_VALUE;
        while(!index.isEmpty()){
            int sz = index.size();
            for(int i=0;i<sz;i++){
                int loc = index.poll();
                if(step > K)
                    break;
                for(int j=0;j<n;j++){
                    if(graph[loc][j][0] == 1 && dist[j] > dist[loc] + graph[loc][j][1]){
                        index.add(j);
                        dist[j] = dist[loc] + graph[loc][j][1];
                    }
                }
            }
            step++;
            if(step > K)
                break;
        }
        return (dist[dst] != Integer.MAX_VALUE) ? dist[dst] : -1;
    }
}
