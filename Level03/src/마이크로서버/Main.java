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
            int cnt = 0, start = 0;
            for(int j = 0;j < t; j++){
                arr[j] = Integer.parseInt(input[j]);
                if(arr[j]==300) cnt++;
            }
            
            Arrays.sort(arr);
            int answer = cnt/3, index = t-1;

            for(int j=(cnt/3)*3;j<=index;j++,answer++){
                while(index>j && arr[j]+arr[index--]>limit){
                    answer++;
                }
                // int sum = arr[j];
                // while(index>j && sum+arr[index]<=limit){
                //     sum+=arr[index--];
                // }
                // System.out.println("인덱스 : "+index);
            }
             System.out.println(answer);  
        }

        br.close();
    }
}