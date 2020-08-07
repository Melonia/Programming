package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9251 {

	public static void main(String[] args) throws IOException {
		//1. ���� �Է�
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String seq_1 = bf.readLine();
		String seq_2 = bf.readLine();
		
		String add_seq_1 = "0"+seq_1;
		String add_seq_2 = "0"+seq_2;
		
		int s1 = add_seq_1.length();
		int s2 = add_seq_2.length();
		
		//2. DP ����
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
����
LCS(Longest Common Subsequence, ���� ���� �κ� ����)������ �� ������ �־����� ��, ����� �κ� ������ �Ǵ� ���� �� ���� �� ���� ã�� �����̴�.

���� ���, ACAYKP�� CAPCAK�� LCS�� ACAK�� �ȴ�.

�Է�
ù° �ٰ� ��° �ٿ� �� ���ڿ��� �־�����. ���ڿ��� ���ĺ� �빮�ڷθ� �̷���� ������, �ִ� 1000���ڷ� �̷���� �ִ�.

���
ù° �ٿ� �Է����� �־��� �� ���ڿ��� LCS�� ���̸� ����Ѵ�.
*/