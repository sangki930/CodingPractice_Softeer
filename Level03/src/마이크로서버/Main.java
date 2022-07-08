package 마이크로서버;

import java.util.*;
import java.io.*;


public class Main
{
    static final int limit = 900;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n ; i++){
            int t = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[t];
            
            int cnt = 0; // cnt : 300의 개수
            for(int j = 0;j < t; j++){
                arr[j] = Integer.parseInt(input[j]);
                if(arr[j]<=300){
                    cnt++;
                }
            }
            
            Arrays.sort(arr);

            int answer = 0, start = cnt, end = t-1;

            while(start<=end){
                answer++;
                if(arr[end]>600){

                }
                else if(start != end && arr[start] + arr[end] <= 900) start++;
                else if(cnt>0) cnt--;
                end--;
            }
            answer += (cnt+2)/3;
            System.out.println(answer);  
        }

        br.close();
    }
}