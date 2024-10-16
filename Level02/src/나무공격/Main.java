package 나무공격;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m= Integer.parseInt(input[1]);
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i=0;i<2;i++){
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0])-1, e = Integer.parseInt(input[1])-1;
            for(int j=s;j<=e;j++){
                for(int k=0;k<m;k++){
                    if(arr[j][k]==1){
                        arr[j][k]=0;
                        break;
                    }
                }
            }
        }

        int answer = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    answer++;
                }
            }
        }
        System.out.println(answer);

        br.close();
    }
}
