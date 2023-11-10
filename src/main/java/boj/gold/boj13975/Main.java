package boj.gold.boj13975;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            mergeFiles(br);
        }
    }

    private static void mergeFiles(BufferedReader br) throws IOException {
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());
        PriorityQueue<Long> files = new PriorityQueue<>();
        st=new StringTokenizer(br.readLine());
        for(int j=0;j<K;j++){
            files.add(Long.parseLong(st.nextToken()));
        }
        long result=0;
        while(files.size()>1){
            long a = files.poll();
            long b = files.poll();
            result+=a+b;
            files.add(a+b);
        }
        System.out.println(result);


    }
}
