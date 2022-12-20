package junohheo.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 소트인사이드_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //수를 문자열로 입력받아 -> 문자들의 배열로 나눔 -> 각 문자들을 정수로 변환 -> 내림차순 정렬
        String n = br.readLine();
        //문자 배열
        String[] arr2 = n.split("");
        //문자의 길이가 곧 배열의 길이
        int l = n.length();
        //정수 배열 선언
        Integer[] arr = new Integer[l];
        //문자열 배열 -> 정수 배열로 변환
        for (int i = 0; i < l; i++) {
            arr[i] = Integer.parseInt(arr2[i]);
        }
        //내림차순으로 정렬
        Arrays.sort(arr, Collections.reverseOrder());
        //한줄로 이어서 출력이기에 println말고 print
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }


    }
}