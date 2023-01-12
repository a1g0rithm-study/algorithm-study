package org.algorithm.hyojoon.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 버블소트프로그램_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        mData[] arr = new mData[n];

        for (int i = 0;i<n;i++){
            // 숫자 기준으로 오름차순으로 정렬해서 (정렬 전 index) 를 정렬
            /* ex) data			1	2	3	5	10
                  정렬 전 idnex	1	3	4	2	0
              */
            arr[i] = new mData(Integer.parseInt(br.readLine()),i);
        }
        Arrays.sort(arr);
        int max = 0;
        for (int i =0;i<n;i++){

            if(max < arr[i].index-i){   // 정렬 전 index - 정렬 후 index 계산의 최댓값 저장
                max = arr[i].index -i;
            }
        }
        System.out.println(max+1);

    }
}

class mData implements Comparable<mData>{
    int value;
    int index;

    public mData(int value,int index){

        this.value =value;
        this.index = index;
    }
    // value 기준 오름차순 정렬 함수 comparable 구현
    @Override
    public int compareTo(mData o){  // value 기준 오름차순 정렬
        return this.value - o.value;
    }
}
