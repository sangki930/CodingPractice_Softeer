package ±³Â÷·Î;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Integer,LinkedList<Character>> map = new TreeMap<>();

        for(int i=0;i<n;i++){
            String[] input = br.readLine().split(" ");
            int time = Integer.parseInt(input[0]);
            char dir = input[1].charAt(0);
            LinkedList<Character> list = map.getOrDefault(time,new LinkedList<>());
            list.offer(dir);
            map.put(time,list);
        }

        System.out.println(map);
        long elapsed = 0L;
        long[] times = new long[n];
        LinkedList[] roads = new LinkedList[n];
        Arrays.fill(roads,new LinkedList<Integer>());
        int idx = 0;
        loop : for(int time : map.keySet()){
            elapsed += time;
            LinkedList<Character> q = map.getOrDefault(time,new LinkedList<>());
            while(!q.isEmpty()){
                char dir = q.poll();
                switch(dir){
                    case 'A':
                        break;
                }
            }

        }

        br.close();
    }
}
