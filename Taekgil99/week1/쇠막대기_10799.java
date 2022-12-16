package Taekgil99.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 쇠막대기_10799 {
	/*
	 * () -> 레이저
	 * ( : 쇠막대 시작
	 * ) : 쇠막대 끝
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 결과 값 변수 선언
		int result = 0;

		// 괄호 문자열 입력 받기
		String input = br.readLine();

		// 스택 자료구조 생성
		Stack<Character> s = new Stack<>();

		// 반복문 시작
		for (int i = 0; i < input.length(); i++)
			// if i == '('
			if (input.charAt(i) == '(') {
				// 스택 push
				s.push('(');
			} else { // if i == ')'
				// 스택 pop
				s.pop();
				// 이전문자가 '('면 결과 += 스택사이즈
				if (input.charAt(i - 1) == '(')
					result += s.size ();
				// ')'면 +1
				else
					result++;
			}

		// 결과 출력
		bw.write(result + "");
		bw.flush();
		bw.close();
	}
}
