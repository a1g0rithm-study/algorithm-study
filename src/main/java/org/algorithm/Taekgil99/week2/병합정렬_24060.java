package org.algorithm.Taekgil99.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 병합정렬_24060 {
	/*
	입력 :
	첫째 줄에 배열의 크기 N, 저장횟수 K
	둘째 줄에 N개의 정수

	출력 :
	배열을 병합정렬할 때 K번째로 저장되는 배열의 원소 출력
	저장 횟수 < K 라면 -1 출력
	 */

	private static int[] temp;
	private static int cnt;
	private static int K;
	private static int result = -1; // 저장 횟수 K 번째 정수가 없을 경우 -1 출력

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr;

		// N, K 입력 받기
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		K = Integer.parseInt(NK[1]);

		// N개의 정수 입력 받기
		String[] strArr = br.readLine().split(" ");

		// 입력받은 정수 배열을 int 배열로 변환
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}

		temp = new int[N];

		mergeSort(arr, 0, N - 1);
		System.out.println(result);
	}

	// 병합정렬
	private static void mergeSort(int[] arr, int start, int end) {
		// 재귀 종료 조건
		if (start == end) {
			return;
		}
		// 중간값
		int mid = (start + end) / 2;

		mergeSort(arr, start, mid); // 왼쪽
		mergeSort(arr, mid + 1, end); // 오른쪽

		int left = start;
		int right = mid + 1;
		int idx = left;

		while (left <= mid && right <= end) {
			/*
			 배열의 왼쪽부분의 left 인덱스의 값과 배열 오른쪽 부분의 right 인덱스 값을 비교
			 왼쪽이 더 작거나 같으면 temp 배열의 idx 인덱스에 왼쪽 값을 넣고 left 인덱스를 증가
			 */
			if (arr[left] <= arr[right]) {
				temp[idx++] = arr[left++];
			}
			/*
			반대의 경우 오른쪽 값을 temp 배열의 idx 인덱스에 넣고 right 인덱스를 증가
			 */
			else {
				temp[idx++] = arr[right++];
			}
		}
		/*
		배열의 왼쪽 부분이 먼저 끝나는 경우
		배열의 오른쪽 부분의 남은 값들을 temp 배열에 넣어준다.
		 */
		if (left > mid) {
			while (right <= end) {
				temp[idx++] = arr[right++];
			}
		}
		/*
		배열의 오른쪽 부분이 먼저 끝나는 경우
		배열의 왼쪽 부분의 남은 값들을 temp 배열에 넣어준다.
		 */
		else {
			while (left <= mid) {
				temp[idx++] = arr[left++];
			}
		}

		// temp 배열의 값을 arr 배열에 복사하면서 K 번째 저장되는 배열의 원소를 찾는다.
		for (int i = start; i <= end; i++) {
			cnt++;
			if (cnt == K) {
				result = temp[i];
				return; // K 번째 저장되는 배열의 원소를 찾았으므로 종료
			}
			arr[i] = temp[i];
		}
	}
}
