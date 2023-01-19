package org.algorithm.hyojoon.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    A E I O U 5가지 단어로 사전적으로 정렬했을때 주어진 단어가 몇번째 단어인지(길이가 5 이하)

    A -> AA -> AAA -> AAAA -> AAAAA -> AAAAE -> AAAAI -> AAAAO -> AAAAU -> AAAE
    1 -> 2 -> 3 ->      4       5       6          7       8        9        10
    E  I  U  O
    I -> 1563 번쨰 지나온 낱말 수는 총 2개 A,E  그러면 이 앞에는 1562 개가 있다는 거니까 1562/2 = 781
    그러면 E는 781+1 = 782
    앞자리가 바뀔때마다 +781 이제 이걸로 순서를 구하면

    781 -1 뺴고 780/5 하면 156 두번쨰 자리가 바뀔떄마다 156  (-1을 하는 이유는 빈칸떄문이다.)

    이제 다시 똑같이 해보면 156-1 155/5 = 31

    3번쨰는 바뀔때마다 31번

    31-1 -> 30/5  = 6

    4번쨰는 6

    5번쨰는 자동으로 1
 */

public class 모음사전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();


        String index = "AEIOU";
        int[] arr = {781, 156, 31, 6, 1};


        int answer = word.length();

        for (int i = 0; i < word.length(); i++) {
            answer += (arr[i] * index.indexOf(word.charAt(i)));
        }

        System.out.println(answer);

    }
}
