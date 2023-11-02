package boj.bronze.boj2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @see <a href="https://www.acmicpc.net/problem/2775">link</a>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int result = calculate(k, n);
            System.out.println(result);
        }
    }
    private static int calculate(int k, int n){
        if(k==0) return n;
        if(n==0) return 0;
        return calculate(k, n-1)+ calculate(k-1, n);
    }
}


//2 |
//1 | 1 3 6
//0 | 1 2 3 4 5
