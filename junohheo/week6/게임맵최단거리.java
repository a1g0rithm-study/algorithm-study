package junohheo.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    // 상 하 좌 우 로 움직이기 윈한 배열 선언
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};


    public  int solution(int[][] maps) {

        int answer = 0;
        //n * m 의 맵
        int n = maps.length;
        int m = maps[0].length;
        //방문 표시의 배열 선언
        int[][] visited = new int[n][m];
        bfs(maps, visited);
        //visit 배열의 n*m번째 출력 = 몇번째 방문한것인지
        answer = visited[maps.length - 1][maps[0].length - 1];
        //
        if (answer == 0) {
            answer = -1;
        }

        return answer;
    }
        public void bfs(int[][] maps, int[][] visited) {
            int x = 0;
            int y = 0;
            visited[y][x] = 1;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{y, x});

            while (!queue.isEmpty()) {
                int[] current = queue.remove();
                int cY = current[0];
                int cX = current[1];

                for (int i = 0; i < 4; i++) {
                    int nY = cY + dy[i];
                    int nX = cX + dx[i];

                    if (nY < 0 || nY > maps.length - 1 || nX < 0 || nX > maps[0].length - 1)
                        continue;

                    if (visited[nY][nX] == 0 && maps[nY][nX] == 1) {
                        visited[nY][nX] = visited[cY][cX] + 1;
                        queue.add(new int[]{nY, nX});
                    }
                }

            }

        }
}
