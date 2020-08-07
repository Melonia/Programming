package math2;

import java.util.Scanner;

public class N1929 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean [] A = new boolean[m+1];
		for(int i=1;i<=m;i++) {
			if(i==1) {
				A[i]=true;
			} else if(A[i]==false){
				for(int j=2;i*j<=m;j++) {
					A[i*j]=true;	
				}
			}
		}
		for(int i=n;i<=m;i++) {
			if(A[i]==false) {
				System.out.println(i);
			}
		}
	}
}
/*
문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
*/