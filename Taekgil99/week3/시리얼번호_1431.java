package Taekgil99.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 시리얼번호_1431 {
	/*
	정렬 문제
	조건 1. 길이가 짧은 순서
	조건 2. 길이가 같으면 숫자의 합이 작은 순서 (숫자가 아닌 문자는 무시)
	조건 3. 숫자의 합이 같으면 사전순

	입력 :
	첫째 줄에 시리얼 번호의 개수 N (1 <= N <= 20000)
	둘째 줄부터 N개의 줄에 시리얼 번호

	출력 :
	조건에 맞게 정렬한 결과 출력
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		// 시리얼 번호 입력 받기
		String[] arr = new String[N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

		// 정렬
		Arrays.sort(arr, (o1, o2) -> {
			// 길이가 같다면
			if (o1.length() == o2.length()) {
				// 조건 2 비교를 위한 변수
				int sum1 = 0;
				int sum2 = 0;

				// 각각의 문자열을 순회하며 숫자인지 확인
				for (int i = 0; i < o1.length(); i++) {
					if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9') {
						// 숫자라면 sum1에 더해줌
						sum1 += o1.charAt(i) - '0';
					}
				}

				// o2 문자열도 동일하게 숫자인지 확인
				for (int i = 0; i < o2.length(); i++) {
					if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9') {
						sum2 += o2.charAt(i) - '0';
					}
				}

				// 숫자의 합이 같다면
				if (sum1 == sum2) {
					// 사전순으로 정렬
					return o1.compareTo(o2);
				}
				// 아니면
				else {
					// 숫자의 합이 작은 순서로 정렬
					return sum1 - sum2;
				}
			}
			// 길이가 다르다면
			else {
				// 길이가 짧은 순서로 정렬
				return o1.length() - o2.length();
			}
		});

		// 정렬된 결과 출력
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append('\n');
		}

		System.out.println(sb);
	}
}
