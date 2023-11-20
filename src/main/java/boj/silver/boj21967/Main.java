package boj.silver.boj21967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @see <a href="https://www.acmicpc.net/problem/21967">link</a>
 * fail
 */
public class Main {
    private static int[] numbers;
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque=new ArrayDeque<>();
        numbers=new int[11];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        for(int i=0;i<N;i++){
            int back=Integer.parseInt(st.nextToken());
            deque.offer(back);
            numbers[back]++;
            while(!isBanSeok()){
                int front=deque.peek();
                deque.poll();
                numbers[front]--;
            }
            result = Math.max(result, deque.size());
        }
        System.out.println(result);
    }
    private static boolean isBanSeok(){
        int min=11;
        int max=0;
        for(int i=1;i<=10;i++){
            if(numbers[i]>0){
                min=i;
                 break;
            }
        }
        for(int i=10;i>0;i--){
            if(numbers[i]>0){
                max=i;
                break;
            }
        }
        return max-min<=2;
    }

}
