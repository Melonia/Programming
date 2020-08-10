package recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N11729 {
	public static BufferedReader br;
	public static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int disk = Integer.parseInt(br.readLine());
		int count = (int) Math.pow(2, disk) - 1;

		System.out.println(count);
		hanoi(disk, 1, 3);

		bw.flush();
		br.close();
		bw.close();
	}

	public static void hanoi(int disk, int from, int to) throws IOException {
		int middle = 6 - from - to;
		if (disk == 1) {
			bw.write(from + " " + to + "\n");
		} else {
			hanoi(disk - 1, from, middle);
			hanoi(1, from, to);
			hanoi(disk - 1, middle, to);
		}
	}
}
/*
����
�� ���� ��밡 �ְ� ù ��° ��뿡�� �ݰ��� ���� �ٸ� n���� ������ �׿� �ִ�. �� ������ �ݰ��� ū ������� �׿��ִ�. ���� �����µ��� ���� ��Ģ�� ���� ù ��° ��뿡�� �� ��° ���� �ű�� �Ѵ�.

�� ���� �� ���� ���Ǹ��� �ٸ� ž���� �ű� �� �ִ�.
�׾� ���� ������ �׻� ���� ���� �Ʒ��� �ͺ��� �۾ƾ� �Ѵ�.
�� �۾��� �����ϴµ� �ʿ��� �̵� ������ ����ϴ� ���α׷��� �ۼ��϶�. ��, �̵� Ƚ���� �ּҰ� �Ǿ�� �Ѵ�.

�Ʒ� �׸��� ������ 5���� ����� �����̴�.(���� ����)

�Է�
ù° �ٿ� ù ��° ��뿡 ���� ������ ���� N (1 �� N �� 20)�� �־�����.

 

���
ù° �ٿ� �ű� Ƚ�� K�� ����Ѵ�.

�� ��° �ٺ��� ���� ������ ����Ѵ�. �� ��° �ٺ��� K���� �ٿ� ���� �� ���� A B�� ��ĭ�� ���̿� �ΰ� ����ϴµ�, �̴� A��° ž�� ���� ���� �ִ� ������ B��° ž�� ���� ���� �ű�ٴ� ���̴�.
*/