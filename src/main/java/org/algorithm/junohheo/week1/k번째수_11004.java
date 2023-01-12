package org.algorithm.junohheo.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class k번째수_11004 {
    //처음 입력받을 수 2개  1번째만큼 입력을 받는 것/ 2번째수는 그 자리에 있는 요소를 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        //n만큼의 배열을 생성/숫자 배열에 넣고 오름차순 정렬 / n2번째 요소 출력

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n1];
        for(int i =0; i<n1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(arr[n2-1]);
    }
}
