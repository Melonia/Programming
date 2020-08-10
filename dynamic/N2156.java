package dynamic;

import java.util.Scanner;

public class N2156 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] wine = new int[N+2];
		for(int i = 1; i < N+1; i++) {
			wine[i] = scan.nextInt();
		}
		
		int[][] dp = new int[N+2][2];
		
		dp[0][0] = dp[0][1] =wine[0];
		dp[1][0] = dp[1][1] = wine[1];
        int max=wine[0];
		for(int i = 2; i < N+2; i++) {
		
			dp[i][0] = dp[i-1][1] + wine[i];
			dp[i][1] = max + wine[i];
            if(max<max(dp[i-1][0],dp[i-1][1]))
              max=max(dp[i-1][0],dp[i-1][1]);
			
		}
	
		System.out.println(max(max(dp[N][0],dp[N][1]),dp[N+1][1]));
	}
	static int max(int a, int b) {
		return a>b?a:b;
	}
}

/*
����
ȿ�ִ� ������ �ý�ȸ�� ����. �� ���� ������, ���̺� ���� �پ��� �����ְ� ����ִ� ������ ���� �Ϸķ� ���� �־���. ȿ�ִ� ������ �ý��� �Ϸ��� �ϴµ�, ���⿡�� ������ ���� �� ���� ��Ģ�� �ִ�.

������ ���� �����ϸ� �� �ܿ� ����ִ� �����ִ� ��� ���ž� �ϰ�, ���� �Ŀ��� ���� ��ġ�� �ٽ� ���ƾ� �Ѵ�.
�������� ���� �ִ� 3���� ��� ���� ���� ����.
ȿ�ִ� �� �� �ִ� ��� ���� ���� �����ָ� ������ ���ؼ� � ������ ���� �����ؾ� ���� �����ϰ� �ִ�. 1���� n������ ��ȣ�� �پ� �ִ� n���� ������ ���� ������� ���̺� ���� ���� �ְ�, �� ������ �ܿ� ����ִ� �������� ���� �־����� ��, ȿ�ָ� ���� ���� ���� ���� �����ָ� ���� �� �ֵ��� �ϴ� ���α׷��� �ۼ��Ͻÿ�. 

���� ��� 6���� ������ ���� �ְ�, ������ �ܿ� ������� 6, 10, 13, 9, 8, 1 ��ŭ�� �����ְ� ��� ���� ��, ù ��°, �� ��°, �� ��°, �ټ� ��° ������ ���� �����ϸ� �� ������ ���� 33���� �ִ�� ���� �� �ִ�.

�Է�
ù° �ٿ� ������ ���� ���� n�� �־�����. (1��n��10,000) ��° �ٺ��� n+1��° �ٱ��� ������ �ܿ� ����ִ� �������� ���� ������� �־�����. �������� ���� 1,000 ������ ���� �ƴ� �����̴�.

���
ù° �ٿ� �ִ�� ���� �� �ִ� �������� ���� ����Ѵ�.
*/