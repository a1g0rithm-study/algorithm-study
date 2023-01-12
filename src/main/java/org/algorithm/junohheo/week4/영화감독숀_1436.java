package org.algorithm.junohheo.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영화감독숀_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(findName(Integer.parseInt(br.readLine())));
        //666부터 시작해서 계속 1씩 늘려가고 매번 그 숫자가 666을 3개 포함하고 있으면, 카운트++ 카운트=N일때의 수를 출력
    }
    static int name =666;
    static int count = 0;
    public static int findName(int N) {
        if(Integer.toString(name).contains("666")) {
            count++;
        }
        if(count==N) {
            return name;
        }
        name++;
        return findName(N);
    }
}
