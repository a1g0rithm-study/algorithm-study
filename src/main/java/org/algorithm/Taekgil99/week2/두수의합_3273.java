package org.algorithm.Taekgil99.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합_3273 {
	/*
	입력 :
	첫째 줄에 수열의 크기 n이 주어진다.
	다음 줄에는 수열에 포함되는 수가 주어진다.
	셋째 줄에는 x가 주어진다. (1 ≤ n ≤ 100000, 1 ≤ x ≤ 2000000)

	자연수 x가 주어졌을 때, ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하기
	 */
	static int N, X, count;
	static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		X = Integer.parseInt(br.readLine());

		logic(arr);
	}

	private static void logic(int[] arr) {
		Arrays.sort(arr);

		int left = 0;
		int right = N - 1;
		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum == X) {
				count++;
				left++;
				right--;
			} else if (sum > X) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println(count);
	}
	/*
	첫 번째
		public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		int c = 0;
		while (st.hasMoreTokens()) {
			arr[c] = Integer.parseInt(st.nextToken());
			c++;
		}


		for (int i = 0; i<N-1; i++) {
			for (int j = i + 1; j < N; j++) {
				int e = arr[i] + arr[j];
				if (e == x) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	검증로직이 이중 for 문이라그런지 시간초과가 떴다.
	검증부분을 투포인터로 작성해보자 -> 통과
	 */
}
