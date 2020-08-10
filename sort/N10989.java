package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N10989 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(bf.readLine());
		int[] x = new int[num];
		for (int i = 0; i < num; i++)
			try {
				x[i] = Integer.parseInt(bf.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		fsort(x, num, max(x));
		for (int i = 0; i < num; i++) {
			try {
				bw.write(x[i] + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static int max(int... values) {
		int max = 1;
		for (int value : values) {
			if (max < value)
				max = value;
		}
		return max;
	}

	static void fsort(int[] x, int num, int max) {
		int[] f = new int[max + 1];
		int[] b = new int[num];

		for (int i = 0; i < num; i++)
			f[x[i]]++;
		for (int i = 1; i <= max; i++)
			f[i] += f[i - 1];
		for (int i = num - 1; i >= 0; i--)
			b[--f[x[i]]] = x[i];
		for (int i = 0; i < num; i++)
			x[i] = b[i];
	}

}

/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
*/