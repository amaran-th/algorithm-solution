package boj.silver.boj26215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a href="https://www.acmicpc.net/problem/26215">link</a>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int N = Integer.parseInt(br.readLine());
        stringTokenizer=new StringTokenizer(br.readLine());
        int[] houses = new int[N];
        for(int i=0;i<N;i++){
            houses[i]=Integer.parseInt(stringTokenizer.nextToken());
        }
        int count = 0;
        if(N>1){
            while(true){
                houses= Arrays.stream(houses).sorted().toArray();
                if(houses[N-1]*houses[N-2]==0) break;
                houses[N-1]--;
                houses[N-2]--;
                count++;
            }
        }
        count+=Arrays.stream(houses).sum();
        if(count>1440){
            System.out.println(-1);
        }else{
            System.out.println(count);
        }
    }
}

//1 2 3 4
//
//가장 효율적인 방법은, 가능한 많이 두 집을 치우는 것.
//매번 눈이 가장 많이 쌓인 집과 두번째로 많이 쌓인 집의 눈을 치운다.
// 두 집 중 하나라도 눈이 0인 시점이 오면, 이제 1분에 한 집만 치울 수 있다는 의미이므로 남은 배열의 값의 합을 카운팅해줘서 더해준다.