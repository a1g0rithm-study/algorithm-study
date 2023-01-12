package org.algorithm.Taekgil99.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 좌표압축_18870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[N];
		int[] sort = new int[N];

		for (int i = 0; i < N; i++) {
			sort[i] = arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sort);

		HashMap<Integer, Integer> map = new HashMap<>();

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (!map.containsKey(sort[i])) {
				map.put(sort[i], cnt++);
			}
		}

		for (int i : arr) {
			sb.append(map.get(i)).append(" ");
		}

		System.out.println(sb);
	}
}
