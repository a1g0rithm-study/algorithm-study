package org.algorithm.hyojoon.week3;

import java.io.*;
import java.util.StringTokenizer;

public class 수열의합_1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        boolean bo = true;

        while (l <=100){
            int start = n/l - (l-1) / 2;
            if(start<0)
                break;

            if (n == (start * 2 + l -1) * l /2){
                for (int i = 0; i<l ;i++){
                    bw.write(start + i + " ");
                }
                bo = false;
                break;
            }

            l += 1 ;
        }

        if (bo)
            bw.write("-1");

        bw.write("\n");
        bw.flush();
    }
}
