package math1;

import java.util.Scanner;

public class N2775 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();
		
		for(int i = 0; i < testCase; i++) {
			int k = scanner.nextInt();
			int n = scanner.nextInt();
			
			int[][] arr = new int[k+1][n];
			for(int j = 0; j < n; j++)
				arr[0][j] = j + 1;
			
			for(int j = 1; j < k+1; j++) {
				for(int r = 0; r < n; r++) {
					if(r == 0) arr[j][r] = 1;
					else arr[j][r] = arr[j-1][r] + arr[j][r-1];
				}
			}
			
			System.out.println(arr[k][n-1]);
		}
	}

}

/*
����
��� �ݻ�ȸ�� �����ϴ� ���� �����ϴ� ����� �̹� ��ȸ�� �γ�ȸ���� �ǰ� �;� �� ���� ������� �ҷ� ��� �ݻ�ȸ�� �����Ϸ��� �Ѵ�.

�� ����Ʈ�� ���ָ� �Ϸ��� ������ �ִµ�, ��a���� bȣ�� ����� �ڽ��� �Ʒ�(a-1)���� 1ȣ���� bȣ���� ������� ���� �ո�ŭ ������� ������ ��ƾ� �Ѵ١� �� ��� ������ �� ��Ű�� ���;� �Ѵ�.

����Ʈ�� ����ִ� ���� ���� ��� ���ֹε��� �� ��� ������ ��Ű�� �Դٰ� �������� ��, �־����� ���� ���� k�� n�� ���� k���� nȣ���� �� ���� ��� �ִ��� ����϶�. ��, ����Ʈ���� 0������ �ְ� �������� 1ȣ���� ������, 0���� iȣ���� i���� ���.

�Է�
ù ��° �ٿ� Test case�� �� T�� �־�����. �׸��� ������ ���̽����� �Է����� ù ��° �ٿ� ���� k, �� ��° �ٿ� ���� n�� �־�����. (1 <= k <= 14, 1 <= n <= 14)

���
������ Test case�� ���ؼ� �ش� ���� ���ֹ� ���� ����϶�.
*/