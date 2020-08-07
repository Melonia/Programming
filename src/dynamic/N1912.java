package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//1. testCase �Է�
		int testCase = Integer.parseInt(bf.readLine());
		
		//2. sequence �Է�
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int[] seq = new int[testCase];
		for(int i = 0; i < testCase; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		//3. dp ���� �� �ʱ�ȭ
		int[] dp = new int[testCase];
		dp[0] = seq[0];
		
		//4. dp ���� �� �ִ� ���ϱ�
		int result = seq[0];
		for(int i = 1; i < seq.length; i++) {
			dp[i] = Math.max(dp[i-1] + seq[i],seq[i]);
			result = Math.max(result, dp[i]);
		}
		
		System.out.println(result);
	}
}

/*
����
n���� ������ �̷���� ������ ������ �־�����. �츮�� �� �� ���ӵ� �� ���� ���� �����ؼ� ���� �� �ִ� �� �� ���� ū ���� ���Ϸ��� �Ѵ�. ��, ���� �� �� �̻� �����ؾ� �Ѵ�.

���� �� 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 �̶�� ������ �־����ٰ� ����. ���⼭ ������ 12+21�� 33�� ������ �ȴ�.

�Է�
ù° �ٿ� ���� n(1 �� n �� 100,000)�� �־����� ��° �ٿ��� n���� ������ �̷���� ������ �־�����. ���� -1,000���� ũ�ų� ����, 1,000���� �۰ų� ���� �����̴�.

���
ù° �ٿ� ���� ����Ѵ�.
*/