package org.algorithm.Taekgil99.week8;

import java.util.Arrays;

public class 구명보트 {
    /*
    입력:
    people[]: 무인도에 갇힌 사람들의 몸무게
    limit: 구명보트의 무게 제한

    출력: 최소 필요한 구명보트 수

    - 구명보트 당 최대 2명
    - 구명보트에 못타는 경우는 없음 (limit 100, weight 110 => X)
     */

    public static void main(String[] args) {
        int[] people = new int[]{70, 50, 80, 50};
        int limit = 100;

        System.out.println(new Solution().solution(people, limit));
    }

    private static class Solution {

        public int solution(int[] people, int limit) {
            int answer = 0;

            Arrays.sort(people); // people 정렬

            int min = 0;
            int max = people.length - 1;
            while (max >= min) { // max : 최댓값 index
                // 두명이 탈 수 있는 조건
                // if 최소+최대 무게 <= 무게 제한
                if (people[min] + people[max] <= limit) {
                    // 두명이 탈 수 있다면 min++, max--
                    min++;
                }
                // 탈 수 없다면 max--
                max--;

                //구명보트 count++
                answer++;
            }
            return answer;
        }

    }

}
