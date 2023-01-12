package org.algorithm.junohheo.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 큐_10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        List<Integer> queue = new ArrayList<>();
        String input_n = br.readLine();
        int n = Integer.parseInt(input_n);
        for(int i = 0; i<n; i++) {
            String input = br.readLine();
            String[] command = input.split(" ");
            if(command[0].equals("push")) {
                queue.add(Integer.parseInt(command[1]));
            }
            if(command[0].equals("pop")) {
                if(queue.size()==0) {
                    System.out.println(-1);
                }
                else {
                    int result = queue.remove(0);
                    System.out.println(result);
                }

            }
            if(command[0].equals("size")) {
                System.out.println(queue.size());
            }
            if(command[0].equals("empty")) {
                if (queue.size()==0) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            }
            if(command[0].equals("front")) {
                if(queue.size()==0) {
                    System.out.println(-1);
                }
                else {
                    int result = queue.get(0);
                    System.out.println(result);
                }
            }

            if(command[0].equals("back")) {
                if(queue.size()==0) {
                    System.out.println(-1);
                }
                else {
                    int result = queue.get(queue.size()-1);
                    System.out.println(result);
                }
            }
        }
    }
}
