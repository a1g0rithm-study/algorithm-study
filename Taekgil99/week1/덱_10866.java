package Taekgil99.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class 덱_10866 {
	/*
	 * 덱 구현 후 아래 명령 구현
	 * push_front X: 정수 X를 덱의 앞에 넣는다.
	 * push_back X: 정수 X를 덱의 뒤에 넣는다.
	 * pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 * pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 * size: 덱에 들어있는 정수의 개수를 출력한다.
	 * empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
	 * front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 * back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 *
	 * 입력
	 * : 명령의 수 N (1 ≤ N ≤ 10,000)
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		// 덱 자료구조 생성
		Deque<Integer> de = new LinkedList<>();

		// 입력 N 받기
		int N = Integer.parseInt(br.readLine());

		// N번 반복문
		for (int i = 0; i < N; i++) {
			// 명령문 입력받기
			String[] arr = br.readLine().split(" ");

			// 명령문에 따라 처리
			switch (arr[0]) {
				case "push_front":
					de.addFirst(Integer.valueOf(arr[1]));
					break;
				case "push_back":
					de.addLast(Integer.valueOf(arr[1]));
					break;
				case "pop_front":
					if (de.isEmpty())
						sb.append(-1);
					else
						sb.append(de.pollFirst());
					sb.append('\n');
					break;
				case "pop_back":
					if (de.isEmpty())
						sb.append(-1);
					else
						sb.append(de.pollLast());
					sb.append('\n');
					break;
				case "size":
					sb.append(de.size()).append('\n');
					break;
				case "empty":
					sb.append(de.isEmpty() ? 1 : 0).append('\n');
					break;
				case "front":
					sb.append(de.isEmpty() ? -1 : de.peekFirst()).append('\n');
					break;
				case "back":
					sb.append(de.isEmpty() ? -1 : de.peekLast()).append('\n');
					break;
			}
		}

		// 명령 결과 출력
		bw.write(sb + "");
		bw.flush();
		bw.close();
	}
}
