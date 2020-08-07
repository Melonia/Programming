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
����
���ĺ� �ҹ��ڷ� �̷���� N���� �ܾ ������ �Ʒ��� ���� ���ǿ� ���� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

���̰� ª�� �ͺ���
���̰� ������ ���� ������
�Է�
ù° �ٿ� �ܾ��� ���� N�� �־�����. (1��N��20,000) ��° �ٺ��� N���� �ٿ� ���� ���ĺ� �ҹ��ڷ� �̷���� �ܾ �� �ٿ� �ϳ��� �־�����. �־����� ���ڿ��� ���̴� 50�� ���� �ʴ´�.

���
���ǿ� ���� �����Ͽ� �ܾ���� ����Ѵ�. ��, ���� �ܾ ���� �� �Էµ� ��쿡�� �� ������ ����Ѵ�.
*/