import java.io.*;
import java.util.*;

class Data{
    int node;
    int dis;
    public Data(int node, int dis){
        this.node = node;
        this.dis = dis;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]), k = Integer.parseInt(input[2]);

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for(int i=0;i<m;i++){
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]), e = Integer.parseInt(input[1]);
            if(!graph[s].contains(e)) graph[s].add(e);
            if(!graph[e].contains(s))  graph[e].add(s);
        }

        boolean[] visited = new boolean[n+1];
        for(int i=1;i<=n;i++){
            LinkedList<Data> queue = new LinkedList<>();
            queue.offer(new Data(i,0));
            loop : while(!queue.isEmpty()){
                Data data = queue.poll();
                ArrayList<Integer> list = graph[data.node];
                for(int node : list){
                    if(data.node == node && !visited[node]){
                        break loop;
                    }
                    queue.offer(new Data(node,data.dis+1));
                }
            }
        }

        System.out.println();
        br.close();
    }
}
