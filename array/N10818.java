package array;

import java.util.Scanner;

public class N10818 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int score[];
		int number = scan.nextInt();
		score = new int[number];
		
		for(int i = 0; i< number; i++) {
			score[i] = scan.nextInt();
		}
		
		System.out.println(Min.min(score) + " " + Max.max(score));
	}
}
class Max {
	
	static int max(int ... values) {
		int max = -1000000;
	
		for(int i : values) {
			if(max<i) max =i;
		}
		
		return max;
	}
	
}

class Min {
	
		static int min(int ... values) {
			int min = 1000000;
		
			for(int i : values) {
				if(min > i) min = i;
			}
			
			return min;
		}

}
/*
문제
N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.

출력
첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
*/