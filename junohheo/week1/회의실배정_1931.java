package junohheo.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실배정_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        //2의 크기를 가진 배열을 n개만큼 arr 배열에 넣는다.
        int[][] arr = new int[n][2];
        for (int i =0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
    //정렬 규칙 설정 - 시작시간이 아무리 빨라봐야 끝나는 시간이 늦으면 안됌. 종료시간이 빠를수록 더많은 회의실 사용가능.
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]) {
                    //종료시간이 같다면 시작시간이 빠른 순으로
                    return o1[0]-o2[0];
                }
                else {
                    //아니라면 종료시간이 빠른 순으로
                    return o1[1]-o2[1];

                }
            }
        }) ;
        // 초기값 설정. 무조건 첫번째 배열의 회의는 포함한다고 가정.(시작시간으로 정렬했을 경우에는 비교가 필요할 것.)
        int end = 0;
        int count =0;
        for(int i =0; i<n; i++) {
            //시작시간이 전회의시간의 종료시간보다 크거나 같으면 회의 추가되고 그 회의의 종료시간이 곧 직전회의의 종료시간이 됌.
            if(arr[i][0]>=end) {
                count++;
                end = arr[i][1];

            }

        }
        System.out.println(count);



    }
}
