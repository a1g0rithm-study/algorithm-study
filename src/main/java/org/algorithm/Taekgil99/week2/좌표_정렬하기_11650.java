package org.algorithm.Taekgil99.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 좌표_정렬하기_11650 {
	/*
	입력 N 개의 (x, y) 좌표를 x 오름차순, x가 같다면 y 오름차순으로 정렬
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(s[0]);
			arr[i][1] = Integer.parseInt(s[1]);
		}

		Arrays.sort(arr, (e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);

		for (int i = 0; i < N; i++) {
			bw.write(arr[i][0] + " " + arr[i][1] + "\n");
		}

		bw.flush();
		bw.close();
	}
	/*
	첫번째
		public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		TreeMap<Integer, Integer> treeMap = new TreeMap<>();

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			treeMap.put(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
		}
		Collection<Integer> values = treeMap.values();
		System.out.println(values);

		bw.flush();
		bw.close();
	}
	treeMap 을 사용하면 엔트리를 추가할때마다 알아서 정렬을 해줘서 사용하려고했는데 키가 중복으로 들어오면
	덮어쓰기가 적용돼서 실패

	2차원 배열 만들어서 커스텀 정렬로 가자
	 */
}
