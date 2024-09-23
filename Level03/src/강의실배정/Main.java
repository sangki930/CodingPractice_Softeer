package 강의실배정;

import java.io.*;
import java.util.*;

class Range{
    int start,end;
    public Range(int start, int end){
        this.start=start;
        this.end=end;
    }
}

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Range> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]), f = Integer.parseInt(input[1]);
            list.add(new Range(s,f));
        }

        list.sort(
                (o1,o2)->{
                    if(o1.start == o2.start) return Integer.compare(o1.end,o2.end);
                    return Integer.compare(o1.start,o2.start);
                }
        );

        int start = -1, end = -1;
        int answer = 0;
        for(int i=0;i<n;i++){
            Range range = list.get(i);
            if(start<=range.start && range.end<=end){
                start = range.start;
                end = range.end;
                continue;
            }
            if(end <= range.start){
                end = range.end;
                answer++;

            }
        }
        System.out.println(answer);
        br.close();
    }
}