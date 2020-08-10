package recursion;

import java.io.*;
import java.util.*;

public class N2447 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(s.nextToken());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
				boolean check = true;
				int n = i;
				int m = j;

				while (true) {
					if (n == 0 || m == 0)
						break;

					if (n % 3 == 1 && m % 3 == 1) {
						sb.append(" ");
						check = false;
						break;
					}

					n /= 3;
					m /= 3;

				}
				if (check)
					sb.append("*");
			}

			sb.append("\n");

		}

		System.out.println(sb);
	}
}
/*
����
������� �������� ���� ��� ����. N�� 3�� �ŵ�����(3, 9, 27, ...)�̶�� �� ��, ũ�� N�� ������ N��N ���簢�� ����̴�.

ũ�� 3�� ������ ����� ������ �ְ�, ����� ������ ��� ĭ�� ���� �ϳ��� �ִ� �����̴�.

***
* *
***
N�� 3���� Ŭ ���, ũ�� N�� ������ �������� ä���� ����� (N/3)��(N/3) ���簢���� ũ�� N/3�� �������� �ѷ��� �����̴�. ���� ��� ũ�� 27�� ������ ���� ��� 1�� ����.

�Է�
ù° �ٿ� N�� �־�����. N�� 3�� �ŵ������̴�. �� � ���� k�� ���� N=3k�̸�, �̶� 1 �� k < 8�̴�.

���
ù° �ٺ��� N��° �ٱ��� ���� ����Ѵ�.
*/