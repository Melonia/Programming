package backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class N2580 {
	static ArrayList<Cell> emptyCells = new ArrayList<>();
	static int[][] A = new int[9][9];
	static boolean flag = false;
	static ArrayList<Integer>[][] avail = new ArrayList[9][9];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				avail[i][j] = new ArrayList<Integer>();
				A[i][j] = sc.nextInt();
				if (A[i][j] == 0) {
					emptyCells.add(new Cell(j, i));
				}
			}
		}

		dfs(0, 0);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void dfs(int emptyIdx, int availableIdx) {
		if (emptyIdx == emptyCells.size()) {
			flag = true;
			return;
		}
		Cell now = emptyCells.get(emptyIdx);
		int x = now.x;
		int y = now.y;
		getAvailable(x, y);

		for (int i = availableIdx; i < avail[y][x].size(); i++) {
			A[y][x] = avail[y][x].get(i);

			if (isSudoku(x, y)) {
				dfs(emptyIdx + 1, 0);
				if (flag)
					return;
			}
			A[y][x] = 0;
		}
	}

	static boolean isSudoku(int x, int y) {
		int dx[] = { 0, 0, 0, 1, 1, 1, 2, 2, 2 };
		int dy[] = { 0, 1, 2, 0, 1, 2, 0, 1, 2 };

		int sx = x / 3;
		int sy = y / 3;
		sx *= 3;
		sy *= 3;
		for (int i = 0; i < 9; i++) {
			if (A[i][x] == A[y][x] && i != y)
				return false;
			if (A[y][i] == A[y][x] && i != x)
				return false;
			int nx = sx + dx[i];
			int ny = sy + dy[i];
			if (A[ny][nx] == A[y][x] && !(ny == y && nx == x))
				return false;
		}
		return true;
	}

	static void getAvailable(int x, int y) {
		avail[y][x].clear();
		int[] cnt = new int[10];

		for (int i = 0; i < 9; i++) {
			cnt[A[i][x]]++;

		}

		for (int i = 0; i < 9; i++) {
			cnt[A[y][i]]++;
		}
		int sx = x / 3;
		int sy = y / 3;
		sx *= 3;
		sy *= 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cnt[A[sy + i][sx + j]]++;
			}
		}

		for (int i = 1; i < 10; i++) {
			if (cnt[i] == 0)
				avail[y][x].add(i);
		}
	}

}

class Cell {
	int x;
	int y;

	Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
/*
����
������� 18���� ������ �����ڰ� ���� '��ƾ �簢��'�̶� ���񿡼� ������ ������ ���� ���� �α⸦ ������ �ִ�. �� ������ �Ʒ� �׸��� ���� ����, ���� ���� 9���� �� 81���� ���� ĭ���� �̷���� ���簢�� �� ������ �̷����µ�, ���� ���� �� �� �� ĭ���� 1���� 9������ ���� �� �ϳ��� ���� �ִ�.

������ �� ĭ�� ä��� ����� ������ ����.

������ �����ٰ� �����ٿ��� 1���� 9������ ���ڰ� �� ������ ��Ÿ���� �Ѵ�.
���� ������ ���еǾ� �ִ� 3x3 ���簢�� �ȿ��� 1���� 9������ ���ڰ� �� ������ ��Ÿ���� �Ѵ�.
���� ���� ���, ù° �ٿ��� 1�� ������ ������ 2���� 9������ ���ڵ��� �̹� ��Ÿ�� �����Ƿ� ù° �� ��ĭ���� 1�� ���� �Ѵ�.

���� ���� ��� ��ġ�� 3x3 ���簢���� ��쿡�� 3�� ������ ������ ���ڵ��� �̹� ���������Ƿ� ��� �� ĭ���� 3�� ���� �Ѵ�.

�̿� ���� �� ĭ�� ���ʷ� ä�� ���� ������ ���� ���� ����� ���� �� �ִ�.

���� ���� �� ������ �ǿ� ���� �ִ� ���ڵ��� ������ �־��� �� ��� �� ĭ�� ä���� ���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
��ȩ �ٿ� ���� �� �ٿ� 9���� ���� ���� �� �������� �� �ٿ� ���� �ִ� ���ڰ� �� ĭ�� ����� ���ʷ� �־�����. ������ ���� �� ĭ�� ��쿡�� 0�� �־�����. ������ ���� ��Ģ��� ä�� �� ���� ����� �Է��� �־����� �ʴ´�.

���
��� �� ĭ�� ä���� ������ ���� ���� ����� ��ȩ�ٿ� ���� �� �ٿ� 9���� �� ĭ�� ����� ����Ѵ�.

������ ���� ä��� ����� ������ ���� �� �� �ϳ����� ����Ѵ�.
*/