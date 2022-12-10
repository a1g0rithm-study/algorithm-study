package junohheo.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        String input_n = br.readLine();
        int n = Integer.parseInt(input_n);
        for(int i = 0; i<n; i++) {
            String input = br.readLine();
            String[] command = input.split(" ");
            if(command[0].equals("push")) {
                stack.push(Integer.parseInt(command[1]));
            }
            if(command[0].equals("pop")) {
                if(stack.size()==0) {
                    System.out.println(-1);
                }
                else {
                    int result = stack.remove(stack.size()-1);
                    System.out.println(result);
                }

            }
            if(command[0].equals("size")) {
                System.out.println(stack.size());
            }
            if(command[0].equals("empty")) {
                if (stack.size()==0) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            }
            if(command[0].equals("top")) {
                if(stack.size()==0) {
                    System.out.println(-1);
                }
                else {
                    int result = stack.peek();
                    System.out.println(result);
                }
            }
        }
    }
}
