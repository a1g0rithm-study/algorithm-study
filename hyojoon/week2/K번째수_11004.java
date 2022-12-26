import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
    퀵 정렬 - 기준값을 선정해 해당 값보다 작은 데이터와 큰 데이터로 분류하는 것을 반복해
    정렬 하는 알고리즘. 기준값이 어떻게 선정되는지가 시간 복잡도에 많은 영향을 미침
    평균 시간 복잡도는 O(nlogn)
 */
public class K번째수_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(A, 0, N - 1,  K - 1);
        System.out.println(A[K - 1]);
    }
    public static void quickSort(int[] A, int S, int E, int K) {
        if(S<E){
            int pivot = partition(A, S, E); // 피벗 구하기 함수
            if (pivot == K) { //K번째 수가 pivot이면 더이상 구할 필요 없음
                return;
            }
            else if(K < pivot) {  //K가 pivot보다 작으면 왼쪽만 정렬
                quickSort(A, S, pivot - 1, K);
            }
            else if(K > pivot){  //K가 pivot보다 크면 왼쪽만 정렬
                quickSort(A, pivot+1, E, K);
            }
        }
    }

    private static int partition(int[] A, int S, int E){
        if(S+1==E) {
            if(A[S]>A[E])swap(A,S,E);
            return E;
        }
        int M = (S + E) / 2;
        swap(A, S, M); // 중앙값을 1번째 요소로 이동하기

        int pivot = A[S];
        int i = S+1, j = E;     // i를 왼쪽 끝으로 ,j를 오른쪽 끝으로

        while (i <= j) {
            while (pivot < A[j] && j > 0 ){   //피벗보다 작은 수가 나올때까지 j--
                j--;
            }
            while (pivot > A[i]  && i <A.length-1){  //피벗보다 큰 수가 나올 떄까지 i++
                i ++;
            }
            if (i <= j) {
                swap (A, i++, j--);  // 찾은 i와 j를 교환하기
            }
        }
        // i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
        A[S] = A[j];
        A[j] = pivot;
        return j;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
