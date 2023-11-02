package boj.silver.boj1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * @see <a href="https://www.acmicpc.net/problem/1946">link</a>
 * fail
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            List<List<Integer>> scores = new ArrayList<>();
            for(int j=0;j<N;j++){
                st=new StringTokenizer(br.readLine());
                scores.add(List.of(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            scores.sort(Comparator.comparing(a->a.get(0)));
            int count=N;
            int temp=scores.get(0).get(1);
            for(int j=1;j<N;j++){
                if(temp<scores.get(j).get(1)) count--;
                else temp=scores.get(j).get(1);
            }
            System.out.println(count);
        }
    }
}

// 서류 심사 성적과 면접 시험 성적 중 다른 모든 지원자보다 떨어지는

//2 2 -> 불합격
//3 3 -> 합격
//9 2 -> 합격
//2 9 -> 합격