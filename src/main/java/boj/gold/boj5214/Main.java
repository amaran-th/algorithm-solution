package boj.gold.boj5214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @see <a href="https://www.acmicpc.net/problem/5214">link</a>
 */
public class Main {
    private void solution() throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] stations = new ArrayList[M + N + 1];
        boolean[] v = new boolean[M + N + 1];

        for (int i = 1; i <= M + N; i++) {
            stations[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                int station = Integer.parseInt(st.nextToken());
                stations[station].add(i + N);
                stations[i + N].add(station);
            }
        }
        int result = -1;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 1});   // 역 번호
        v[1] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == N) {
                result = cur[1];
                break;
            }
            for (int nextStation : stations[cur[0]]) {
                if (v[nextStation]) continue;
                v[nextStation] = true;
                q.add(new int[]{nextStation, cur[0] <= N ? cur[1] + 1 : cur[1]});
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
