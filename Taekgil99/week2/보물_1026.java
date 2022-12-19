package Taekgil99.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 보물_1026 {
	/*
	 * 두 배열에 인자끼리의 곱의 합이 최소인 경우의 값 구하기
	 * S = A[0] × B[0] + ... + A[N-1] × B[N-1]
	 *
	 * 입력 :
	 * 	첫째 줄 -> 각 배열에 인자의 수 ( 0 < N <= 50 )
	 * 	둘째 줄 -> A 배열의 인자 ( 0 < N < 100 )
	 * 	셋째 줄 -> B 배열의 인자 ( 0 < N < 100 )
	 *
	 * 결과가 최소가 되는 경우 :
	 * 	ex) A 배열에서 가장 큰값과 B 배열에서 가장 작은수를 매칭하고 남은 인자끼리 반복
	 *
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int result = 0;
		// N 입력 받기
		int N = Integer.parseInt(br.readLine());

		// A, B 배열 " "로 구분해서 인자 채우기
		String[] A = br.readLine().split(" ");
		String[] B = br.readLine().split(" ");

		// 한 배열을 오름차순, 나머지 배열을 내림차순 정렬

		Integer[] integersA = getIntegers(A);
		Arrays.sort(integersA);

		Integer[] integersB = getIntegers(B);
		Arrays.sort(integersB, Comparator.reverseOrder());

		// 각 배열의 같은 인덱스 끼리의 곱을 더하기
		for (int i = 0; i < N; i++) {
			result += integersA[i] * integersB[i];
		}

		// 결과 출력
		System.out.println(result);
	}

	public static Integer[] getIntegers(String[] arr) {
		return Arrays.stream(arr)
			.map(Integer::parseInt)
			.toArray(Integer[]::new);
	}

	/* 처음 작성했던 코드
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int result = 0;
		// N 입력 받기
		int N = Integer.parseInt(br.readLine());

		// A, B 배열 " "로 구분해서 인자 채우기
		String[] A = br.readLine().split(" ");
		String[] B = br.readLine().split(" ");

		// 한 배열을 오름차순, 나머지 배열을 내림차순 정렬
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());

		// 각 배열의 같은 인덱스 끼리의 곱을 더하기
		for (int i = 0; i < N; i++) {
			result += Integer.parseInt(A[i]) * Integer.parseInt(B[i]);
		}

		// 결과 출력
		System.out.println(result);
	}
	-> 이 경우 정렬 부분에서 문자열의 첫문자부터 비교해서
	5 15 100 39 0 -> 0 100 39 5 15 와 같이 정렬 됨

	2차 정렬 기준에 '길이'를 추가해서 재시도
		// Arrays.sort(A, (String s1, String s2) -> s1.length() - s2.length());
		// Arrays.sort(B, (String s1, String s2) -> s1.length() - s2.length());
	이제는 숫자 정렬이 안됨,,

	3차 Integer[]로 바꿔서 재 정렬 시도
	 */
}
