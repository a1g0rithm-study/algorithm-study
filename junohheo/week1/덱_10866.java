package junohheo.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;


public class 덱_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque= new LinkedList<>();
        String input_n = br.readLine();
        int  n= Integer.parseInt(input_n);
        for(int i = 0; i <n; i++) {
            String input = br.readLine();
            String[] command = input.split(" ");
            if (command[0].equals("push_back")) {
                deque.addLast(Integer.parseInt(command[1]));
            }
            if (command[0].equals("push_front")) {
                deque.addFirst(Integer.parseInt(command[1]));
            }
            if (command[0].equals("pop_front")) {
                if (deque.size() == 0) {
                    System.out.println(-1);
                }
                else {
                    int result = deque.pollFirst();
                    System.out.println(result);
                }
            }
            if (command[0].equals("pop_back")) {
                if (deque.size() == 0) {
                    System.out.println(-1);
                }
                else {
                    int result = deque.pollLast();
                System.out.println(result);
                }
            }
            if (command[0].equals("size")) {
                System.out.println(deque.size());
            }
            if (command[0].equals("empty")){
                if (deque.size()==0) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            }
            if(command[0].equals("front")) {
                if(deque.size()==0) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(deque.getFirst());
                }
            }
            if(command[0].equals("back")) {
                if(deque.size()==0) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(deque.getLast());
                }
            }

        }
    }
}