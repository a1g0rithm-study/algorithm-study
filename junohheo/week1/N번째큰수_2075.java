package junohheo.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번째큰수_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        //우선순위 큐를 사용시 int형일 경우 기본적으로 작은 수가 제일 먼저 pop이된다.
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            pq.offer(num);
        }
        //큰수가 n개만큼 남게 됨
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (pq.peek() < num) {
                    pq.poll();
                    pq.offer(num);
                }


            }
        }
        System.out.println(pq.poll());

    }

}

    /*public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n*n];
        Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        int count = 0;
        for(int i = 0; i<n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++) {
                arr2[count++] = Integer.parseInt(st.nextToken());
         }
            Arrays.sort(arr2, Collections.reverseOrder());
        }
        System.out.println(arr2[n-1]);


    }
}*/

