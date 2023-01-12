package org.algorithm.Taekgil99.week1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 카드2_2164 {
    /*
     * 문제
     * : N장의 카드. 1번 카드부터 N번 카드까지 순서대로 놓여있다.
     * 첫번째 버림 -> 두번째 카드 맨 아래로 -> 세번째 버림 -> 네번째 카드 맨 아래로 -> ... 반복
     * 마지막에 남는 숫자 구하기
     *
     * 입력
     * : N(1 ≤ N ≤ 500,000)
     */
    public static void main(String[] args) throws IOException {
        // 큐 선입선출 자료구조
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // N 입력받기
        int N = Integer.parseInt(br.readLine());


        if (N != 1) {
            // 큐 자료구조에 1 ~ N + 1 큐에 넣기
            Queue<Integer> qu = IntStream
                    .range(1, N + 1)
                    .boxed()
                    .collect(Collectors.toCollection(LinkedList::new));


            // 반복문 시작 ( 큐.size != 1 )
            while (qu.size() != 1) {
                // poll or remove
                qu.remove();
                // offer(add)
                qu.offer(qu.poll());
            }

            // 남은 숫자 bw 버퍼에 쓰기
            bw.write(qu.poll().toString());
        } else {
            // N이 1이라면 bw에 1 쓰기
            bw.write('1');
        }

        // bw 출력
        bw.flush();
        bw.close();
    }
}
