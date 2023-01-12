package org.algorithm.Taekgil99.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class 버블소트_1377 {
	/*
	입력:
	첫째 줄에 수열의 크기 N (1 <= N <= 500,000)
	둘째 줄부터 N개의 줄에 걸쳐 각 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수

	출력:
	첫째 줄에 수열을 정렬했을 때, 버블 정렬에서 교환을 하는 횟수를 출력

	- 버블 정렬: 인접한 두 수를 비교하여 정렬하는 방법
	해당문제는 버블 소트로 풀이하면 시간초과가 발생한다.
	따라서, 버블 소트를 사용하지 않고 버블 소트 횟수를 구하는 방법을 찾아야 한다.

	- 버블 소트 횟수를 구하는 방법
	배열 -> 정렬 -> 정렬된 배열
	정렬된 배열에서 원래 배열의 요소의 인덱스의 차이를 구하면 버블 소트 횟수를 알 수 있다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		ArrayList<mData> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arr.add(new mData(Integer.parseInt(br.readLine()), i));
		}

		arr.sort(Comparator.comparingInt(o -> o.value));

		int max = 0;
		for (int i = 0; i < N; i++) {
			int d = arr.get(i).idx - i; // 기존 배열과 정렬된 배열의 인덱스 차이 -> 버블 소트 횟수
			if (max < d) {
				max = d;
			}
		}

		System.out.println(max + 1); // 버블 소트 횟수는 0부터 시작하므로 +1

	}

}

// 입력 받은 데이터의 값과 인덱스 값을 저장하는 클래스
class mData implements Comparable<mData> {
	int value;
	int idx;

	public mData(int num, int idx) {
		super();
		this.value = num;
		this.idx = idx;
	}

	@Override
	public int compareTo(mData o) {
		return this.value - o.value;
	}
}
