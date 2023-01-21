package junohheo.week5;

class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for(int i = 3; i<=total/3; i++) {
            int sero = i;
            int garo = total/sero;
            if((garo-2)*(sero-2)==yellow){
                answer[0] = garo;
                answer[1] = sero;
                break;
            }
        }

        return answer;
    }
}