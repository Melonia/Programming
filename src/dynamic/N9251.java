package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9251 {

	public static void main(String[] args) throws IOException {
		//1. 예제 입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String seq_1 = bf.readLine();
		String seq_2 = bf.readLine();
		
		String add_seq_1 = "0"+seq_1;
		String add_seq_2 = "0"+seq_2;
		
		int s1 = add_seq_1.length();
		int s2 = add_seq_2.length();
		
		//2. DP 선언
		int[][] array = new int[s1][s2];
		
		
		for(int i = 0; i < s1; i++) {
			for(int j = 0; j < s2; j++) {
				if(i == 0 || j == 0) {
					array[i][j] = 0;
				}
				else {
					if(add_seq_1.charAt(i) == add_seq_2.charAt(j)) {
						array[i][j] = array[i-1][j-1] + 1;
					}
					else {
						array[i][j] = Math.max(array[i-1][j],array[i][j-1]);
					}
				}
			}
		}
		System.out.println(array[s1-1][s2-1]);
	}
}

/*
문제
LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

입력
첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.

출력
첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.
*/