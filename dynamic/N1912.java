package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//1. testCase 입력
		int testCase = Integer.parseInt(bf.readLine());
		
		//2. sequence 입력
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int[] seq = new int[testCase];
		for(int i = 0; i < testCase; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		//3. dp 선언 및 초기화
		int[] dp = new int[testCase];
		dp[0] = seq[0];
		
		//4. dp 삽입 및 최댓값 구하기
		int result = seq[0];
		for(int i = 1; i < seq.length; i++) {
			dp[i] = Math.max(dp[i-1] + seq[i],seq[i]);
			result = Math.max(result, dp[i]);
		}
		
		System.out.println(result);
	}
}

/*
문제
n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 단, 수는 한 개 이상 선택해야 한다.

예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인 33이 정답이 된다.

입력
첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다. 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.

출력
첫째 줄에 답을 출력한다.
*/