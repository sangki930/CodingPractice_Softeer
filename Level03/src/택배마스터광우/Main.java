package 택배마스터광우;

import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m=Integer.parseInt(input[1]), k=Integer.parseInt(input[2]);
        int[] nums=new int[n];
        input = br.readLine().split(" ");
        for(int i=0;i<n;i++) nums[i]=Integer.parseInt(input[i]);
        List<List<Integer>> list = permute(nums);
        long answer=Long.MAX_VALUE;
        for(List<Integer> arr:list){
            long cum=0;
            int p=0,tmp=k;
            LinkedList<Integer> queue = new LinkedList<>();
            // System.out.println(arr);
            int idx=0;
            while(tmp>0){
                int i = arr.get(idx%n);
                idx++;
                if(p+i<=m){
                    p+=i;
                }else{
                    cum+=p;
                    tmp--;
                    p=i;
                }
            }
            
            answer=Math.min(cum,answer);
        }
        System.out.println(answer);
        br.close();   
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrace(result, tempList, nums);
        return result;
    }

    private static void backtrace(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue;
                }
                tempList.add(nums[i]);
                backtrace(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}