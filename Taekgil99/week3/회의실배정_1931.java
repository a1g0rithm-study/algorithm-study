package Taekgil99.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 회의실배정_1931 {
	/*
	입력:
	첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다.
	둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
	시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.

	출력:
	첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 회의의 시작시간과 끝나는 시간을 저장할 배열
		int[][] arr = new int[N][2];
		// 회의의 시작시간과 끝나는 시간을 입력받는다.
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]);
		}

		// 끝나는 시간을 기준으로 오름차순 정렬
		// 끝나는 시간이 같다면 시작시간을 기준으로 오름차순 정렬
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});

		// 회의의 끝나는 시간을 저장할 변수
		int end = 0;
		// 회의의 수를 저장할 변수
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			// 회의의 시작시간이 이전 회의의 끝나는 시간보다 크거나 같다면
			if (arr[i][0] >= end) {
				// 회의의 끝나는 시간을 저장
				end = arr[i][1];
				// 회의의 수를 증가
				cnt++;
			}
		}

		// 회의의 수를 출력
		System.out.println(cnt);
	}
}
