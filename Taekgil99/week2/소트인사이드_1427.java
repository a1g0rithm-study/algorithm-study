package Taekgil99.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class 소트인사이드_1427 {
	/*
	단순 정수 내림차순 정렬 문제
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		Integer[] arr = IntStream.range(0, str.length())
			.mapToObj(i -> Integer.valueOf(str.charAt(i)))
			.toArray(Integer[]::new);

		Arrays.sort(arr, Comparator.reverseOrder());

		for (Integer n : arr)
			bw.write(n);

		bw.flush();
		bw.close();
	}
}
