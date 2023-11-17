package boj.gold.boj24041;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a href="https://www.acmicpc.net/problem/2688">link</a>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Material[] materials = new Material[N];
        for(int i=0;i<N;i++){
           st= new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            boolean isImportant = !st.nextToken().equals( "1");
            materials[i]=new Material(S, L, isImportant);
        }
        long start = 0;
        long end = Integer.MAX_VALUE;
        long mid;
        while(start<=end){
            mid = (start+end)/2;
            long importantGermsCount=0;
            long notImportantGermsCount;
            List<Long> notImportantGerms = new ArrayList<>();
            for(int i=0;i<N;i++){
                if(materials[i].isImportant){
                    importantGermsCount+=materials[i].S*Math.max(1, mid-materials[i].L);
                }else{
                    notImportantGerms.add(materials[i].S*Math.max(1, mid-materials[i].L));
                }
            }
            notImportantGerms.sort(Comparator.reverseOrder());
            notImportantGermsCount=notImportantGerms.subList(Math.min(notImportantGerms.size(), K), notImportantGerms.size())
                    .stream()
                    .reduce(0L,Long::sum);
            if(importantGermsCount+notImportantGermsCount<=G) start=mid+1;
            else end=mid-1;

        }
        System.out.println(end);
    }
}

class Material{
    int S; //부패 속도
    int L; // 유통기한
    boolean isImportant; //중요한지 여부
    public Material(int S, int L, boolean isImportant){
        this.S=S;
        this.L=L;
        this.isImportant=isImportant;
    }
}
