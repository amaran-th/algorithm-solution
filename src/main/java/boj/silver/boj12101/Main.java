package boj.silver.boj12101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a href="https://www.acmicpc.net/problem/12101">link</a>
 */
public class Main {
    private static List<String> result;
    private static CaseCount[] dp;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new CaseCount[n + 1];
        result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i <= 3) {
                if (i == 1) dp[1] = new CaseCount(1, new int[]{1, 0, 0});
                if (i == 2) dp[2] = new CaseCount(2, new int[]{1, 1, 0});
                if (i == 3) dp[3] = new CaseCount(4, new int[]{2, 1, 1});
            } else {
                dp[i] = new CaseCount(dp[i - 1].count + dp[i - 2].count + dp[i - 3].count,
                        new int[]{dp[i - 1].count, dp[i - 2].count, dp[i - 3].count});
            }

        }
        if (k > dp[n].count) {
            System.out.println(-1);
            return;
        }
        recursive(n, k);
        System.out.println(String.join("+", result));

    }

    private static void recursive(int n, int k) {
        if (n == 0) return;
        if (n == 1) {
            result.add("1");
            return;
        }
        int temp = k;
        for (int i = 0; i < 3; i++) {
            if (temp > dp[n].cases[i]) {
                temp -= dp[n].cases[i];
            } else {
                result.add(String.valueOf(i + 1));
                recursive(n - i - 1, temp);
                break;
            }
        }
    }

}

class CaseCount {
    int count;
    int[] cases;

    public CaseCount(int count, int[] cases) {
        this.count = count;
        this.cases = cases;
    }
}
