package boj.silver.boj2688;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @see <a href="https://www.acmicpc.net/problem/2688">link</a>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[65][10];
        for(int i=0;i<10;i++){
            dp[0][i]=1;
        }
        for(int i=0;i<65;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<65;i++){
            for(int j=1;j<10;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        for(int i=0;i<T;i++){
            int n=Integer.parseInt(br.readLine());
            System.out.println(dp[n][9]);
        }
    }
}
