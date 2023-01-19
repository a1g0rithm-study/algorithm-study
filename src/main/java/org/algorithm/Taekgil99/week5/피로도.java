package org.algorithm.Taekgil99.week5;

public class 피로도 {
	/*
	프로그래머스
	입력 :
	k : 유저의 현재 피로도, 1 <= k <= 5000
	dungeons[][] : [입장에 필요한 최소 피로도, 소모 피로도], 1 <= 던전 수 <= 8

	출력 :
	유저가 탐험할 수 있는 최대 던전 수

	BFS는 최단거리를 구할때 유리한 방법이기 때문에 해당 문제와 어울리지 않는다.
	따라서 DFS를 이용한다.
	 */
	private static int answer = 0; // 유저가 탐험할 수 있는 최대 던전 수
	private static boolean[] visited; // dfs() 인자 줄이기

	public static void main(String[] args) throws Exception {
		System.out.println(solution(80, new int[][] {{80, 20}, {50, 40}, {30, 10}}));
	}

	public static int solution(int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];
		dfs(0, k, dungeons);
		return answer;
	}

	public static void dfs(int depth, int k, int[][] dungeons) {
		// 모든 경우의 수를 탐색하므로 점화식 종료 조건 X ex) if(depth == dungeons.length) return;

		for (int i = 0; i < dungeons.length; i++) {
			// System.out.println("탐험한 던전 수 : " + depth);
			// System.out.println("탐험한 던전 : " + visited[i]);
			// System.out.println("현재 피로도 : " + k);
			// System.out.println("다음 던전 필요 피로도 : " + dungeons[i][0] + '\n' + "          소모 피로도 : " + dungeons[i][1]);
			// System.out.println("       탐험 후 피로도 : " + (k - dungeons[i][1]));

			if (visited[i] || k < dungeons[i][0]) { // 이미 방문한 던전이거나, 피로도가 부족한 경우
				// System.out.println("SKIP!");
				// System.out.println("==========================");
				continue;
			}
			// System.out.println("==========================");
			visited[i] = true; // 방문 체크

			dfs(depth + 1, k - dungeons[i][1], dungeons); // 다음 던전 탐색

			visited[i] = false; // 다음 던전을 탐색하기 위해 false로 초기화
		}
		answer = Math.max(answer, depth); // 현재까지의 최대 던전 수와 현재 던전 수를 비교하여 최대 던전 수 갱신
	}
}
