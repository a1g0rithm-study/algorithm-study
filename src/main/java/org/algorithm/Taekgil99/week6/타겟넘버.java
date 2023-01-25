package org.algorithm.Taekgil99.week6;

public class 타겟넘버 {
	/*
		프로그래머스
		입력 :
		numbers[] : 2 <= numbers.length <= 20, 1 <= numbers[i] <= 50
		target : 1 <= target <= 1000

		출력 :
		numbers의 원소를 더하거나 빼서 target을 만들 수 있는 경우의 수

		DFS를 이용하여 모든 경우의 수를 탐색한다.
		 */
	private static int answer = 0;

	public static void main(String[] args) throws Exception {
		System.out.println(solution(new int[] {1, 1, 1, 1, 1}, 3));
	}

	public static int solution(int[] numbers, int target) {
		dfs(0, 0, numbers, target);
		return answer;
	}

	public static void dfs(int depth, int sum, int[] numbers, int target) {

		if (depth == numbers.length) { // 모든 경우의 수를 탐색하므로 점화식 종료 조건
			if (sum == target)
				answer++; // 탐색한 경우의 수가 target과 같은 경우
			return;
		}

		dfs(depth + 1, sum + numbers[depth], numbers, target); // 다음 원소를 더한 경우
		dfs(depth + 1, sum - numbers[depth], numbers, target); // 다음 원소를 뺀 경우

	}
}
