package 성적평가;

import java.util.*;
import java.io.*;

public class Main
{

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<3;i++){
            String[] tmp = br.readLine().split(" ");
            int[] c = new int[n];
            for(int j=0;j<tmp.length;j++){
                c[j] = Integer.parseInt(tmp[j]);
                score[j]+=c[j];
            }
            sb.append(func(c,1000)).append("\n");
        }
        sb.append(func(score,3000));
        System.out.println(sb);
        br.close();
    }

    public static String func(int[] arr, int limit){
        Map<Integer,ArrayList<Integer>> map = new TreeMap<>(
            (a,b)->b-a
        );

        for(int i=0;i<arr.length;i++){
            int s = arr[i];
            ArrayList<Integer> list = map.getOrDefault(s,new ArrayList<>());
            list.add(i);
            map.put(s,list);
        }

        int rank = 1;
        int[] ranks = new int[arr.length];
        for(int key : map.keySet()){
            ArrayList<Integer> list = map.get(key);
            for(int i : list)
                ranks[i] = rank;
            rank+=list.size();
        }
        StringBuilder ret = new StringBuilder();

        for(int i=0;i<arr.length;i++){
            ret.append(ranks[i]).append(" ");
        }

        return ret.toString().trim();
    }
}