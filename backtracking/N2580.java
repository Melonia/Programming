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
문제
스도쿠는 18세기 스위스 수학자가 만든 '라틴 사각형'이랑 퍼즐에서 유래한 것으로 현재 많은 인기를 누리고 있다. 이 게임은 아래 그림과 같이 가로, 세로 각각 9개씩 총 81개의 작은 칸으로 이루어진 정사각형 판 위에서 이뤄지는데, 게임 시작 전 몇 몇 칸에는 1부터 9까지의 숫자 중 하나가 쓰여 있다.

나머지 빈 칸을 채우는 방식은 다음과 같다.

각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
위의 예의 경우, 첫째 줄에는 1을 제외한 나머지 2부터 9까지의 숫자들이 이미 나타나 있으므로 첫째 줄 빈칸에는 1이 들어가야 한다.

또한 위쪽 가운데 위치한 3x3 정사각형의 경우에는 3을 제외한 나머지 숫자들이 이미 쓰여있으므로 가운데 빈 칸에는 3이 들어가야 한다.

이와 같이 빈 칸을 차례로 채워 가면 다음과 같은 최종 결과를 얻을 수 있다.

게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램을 작성하시오.

입력
아홉 줄에 걸쳐 한 줄에 9개씩 게임 시작 전 스도쿠판 각 줄에 쓰여 있는 숫자가 한 칸씩 띄워서 차례로 주어진다. 스도쿠 판의 빈 칸의 경우에는 0이 주어진다. 스도쿠 판을 규칙대로 채울 수 없는 경우의 입력은 주어지지 않는다.

출력
모든 빈 칸이 채워진 스도쿠 판의 최종 모습을 아홉줄에 걸쳐 한 줄에 9개씩 한 칸씩 띄워서 출력한다.

스도쿠 판을 채우는 방법이 여럿인 경우는 그 중 하나만을 출력한다.
*/