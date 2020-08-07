package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class N1181 {
	static String[] buff;

	static void mergeSort(String[] x, int left, int right) {
		if (left < right) {
			int i;
			int center = (left + right) / 2;
			int p = 0;
			int j = 0;
			int k = left;

			mergeSort(x, left, center);
			mergeSort(x, center + 1, right);
			for (i = left; i <= center; i++)
				buff[p++] = x[i];
			while (i <= right && j < p)
				x[k++] = (buff[j].length() <= x[i].length()) ? buff[j++] : x[i++];
			while (j < p)
				x[k++] = buff[j++];

		}
	}

	static void mergesort(String[] x, int n) {
		buff = new String[n];
		mergeSort(x, 0, n - 1);
		buff = null;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(bf.readLine());
		String[] s = new String[testCase];
		for (int i = 0; i < testCase; i++) {
			s[i] = bf.readLine();
		}

		Arrays.sort(s);
		mergesort(s, testCase);

		String s2 = "";
		for (int i = 0; i < testCase; i++) {
			if (!s2.equals(s[i])) {
				bw.write(s[i] + "\n");
				s2 = s[i];
			}
		}
		bw.flush();
	}

}

/*
문제
알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

길이가 짧은 것부터
길이가 같으면 사전 순으로
입력
첫째 줄에 단어의 개수 N이 주어진다. (1≤N≤20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.

출력
조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
*/