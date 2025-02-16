package CPTI;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
        long answer = 0;
        Map<Long,Long> counter = new HashMap<>();
        for(int i=0;i<n;i++){
            long key = Long.parseLong(br.readLine(),2);
            counter.put(key,counter.getOrDefault(key,0L) + 1L);
        }

        // 일치
        for(long key : counter.keySet()){
            answer += counter.get(key) * (counter.get(key)-1L) / 2L;
        }

        // 1개가 다름
        for(long key : counter.keySet()){
            for(int i=0;i<m;i++){
                long tmp = key ^ (1L<<i);
                if(counter.containsKey(tmp) && key < tmp){
                    answer += counter.get(key) * counter.get(tmp);
                }
            }
        }

        // 2개가 다름
        for(long key : counter.keySet()){
            for(int i=0;i<m;i++){
                for(int j=i+1;j<m;j++){
                    long tmp = key ^ (1L<<i) ^ (1L<<j);
                    if(counter.containsKey(tmp) && key < tmp){
                        answer += counter.get(key) * counter.get(tmp);
                    }
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}