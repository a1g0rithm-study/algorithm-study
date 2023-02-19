package org.algorithm.Taekgil99.week7;

import java.util.*;

public class 아이템줍기 {
	/*
	프로그래머스 - 아이템줍기

	부분이 겹치는 다각형의 테두리 위에 시작 좌표와 타겟 좌표를 지정받아 타겟 좌표까지 이동하는 최단 경로를 구하는 문제

	입력 :
	int[][] rectangle :
		각 직사각형의 [좌측 하단 x, 좌측 하단 y, 우측 상단 x, 우측 상단 y]
	int characterX : 시작 좌표 x
	int characterY : 시작 좌표 y
	int itemX : 타겟 좌표 x
	int itemY : 타겟 좌표 y

	출력 :
	시작 좌표에서 타겟 좌표까지 이동하는 최단 경로의 길이
	 */

	public static void main(String[] args) {

		int[][] rectangle = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
		int characterX = 1;
		int characterY = 3;
		int itemX = 7;
		int itemY = 8;

		System.out.println(solution(rectangle, characterX, characterY, itemX, itemY));

	}

	private static int[][] map;
	private static int answer;

	public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		answer = 0;
		map = new int[100][100];

		for (int[] ints : rectangle) {
			fill(2 * ints[0], 2 * ints[1], 2 * ints[2], 2 * ints[3]);
		}

		// map 출력 (확인용)
		for (int i = 1; i < 18; i++) {
			for (int j = 1; j < 20; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);

		return answer / 2;
	}

	// 직사각형의 테두리를 1로 채우고 내부를 2로 채움
	public static void fill(int x1, int y1, int x2, int y2) {
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
				if (i == x1 || i == x2 || j == y1 || j == y2) {
					map[i][j] = 1;
				}
			}
		}
	}

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void bfs(int startx, int starty, int itemx, int itemy) {
		boolean[][] visited = new boolean[101][101];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startx);
		queue.add(starty);

		while (!queue.isEmpty()) {
			int x = queue.poll();
			int y = queue.poll();

			// 상하좌우 탐색
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (!check(nx, ny) || map[nx][ny] != 1 || visited[nx][ny])
					continue; //범위 아웃 or 벽이 아님 or 방문한적있음
				map[nx][ny] = map[x][y] + 1;
				if (nx == itemx && ny == itemy) {
					answer = (answer == 0) ? map[nx][ny] : Math.min(answer, map[nx][ny]);
					continue;
				}
				visited[nx][ny] = true;
				queue.add(nx);
				queue.add(ny);
			}
		}
	}

	// 범위 체크
	public static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x <= 100 && y <= 100;
	}
}
