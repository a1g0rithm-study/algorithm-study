import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 큐_1966 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());	// 테스트 케이스

        while (T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LinkedList<int[]> q = new LinkedList<>();	// Q int 배열로 선언
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                // 초기 위치와 중요도 저장
                // 제네릭을 사용해 int 배열로 큐에 저장
                q.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
            }

            int count = 0;	// 카운팅 선언

            while (!q.isEmpty()) {	// 큐가 비어있을때 까지 반복

                int[] front = q.poll();	// 첫번째 원소 front배열에 저장
                boolean isMax = true;	// 중요도가 높은 원소인지 판단하기 위해 boolean 선언

                // 큐에 남아 있는 원소들 중 중요도 비교
                for(int i = 0; i < q.size(); i++) {

                    // 처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 클 경우
                    if(front[1] < q.get(i)[1]) {

                        // 뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다.
                        q.offer(front);
                        for(int j = 0; j < i; j++) {
                            q.offer(q.poll());
                        }

                        // front원소가 가장 큰 원소가 아니였으므로 false를 하고 탐색을 마침
                        isMax = false;
                        break;
                    }
                }

                // front 원소가 가장 큰 원소가 아니였으므로 다음 반복문으로 넘어감
                if(isMax == false) {
                    continue;
                }

                // front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야하는 문서다.
                count++;
                if(front[0] == M) {	// 찾고자 하는 문서라면 해당 테스트케이스 종료
                    break;
                }

            }

            sb.append(count).append('\n');

        }
        System.out.println(sb);
    }

}
