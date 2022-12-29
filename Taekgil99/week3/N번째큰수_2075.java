package Taekgil99.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번째큰수_2075 {
	/*

	입력
	첫째 줄에 배열의 크기 N(1 ≤ N ≤ 1,500)이 주어진다. 둘째 줄부터 N개의 줄에 배열 A에 들어있는 수가 주어진다. 배열에 들어있는 수는 -10억보다 크거나 같고, 10억보다 작거나 같은 정수이다.

	출력
	첫째 줄에 N번째 큰 수를 출력한다.

	예제 입력 1
	5
	12 7 9 15 5
	13 8 11 19 6
	21 10 26 31 16
	48 14 28 35 25
	52 20 32 41 49
	예제 출력 1
	35

	해당 문제는 그냥 배열에 넣고 정렬해서 인덱스로 접근해서 풀 수 있지만
	태그에 우선순위 큐가 있어 우선순위 큐를 이용해서 풀어보았다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		// 우선순위 큐를 내림차순으로 정렬 .equals(Collections.reverseOrder())
		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
		}

		// 우선순위 큐에서 N-1번째 수까지 poll
		for (int i = 0; i < N - 1; i++) {
			q.poll();
		}

		// N번째 수 출력
		System.out.println(q.poll());

	}
}
