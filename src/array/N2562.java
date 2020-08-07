package array;

import java.util.Scanner;

public class N2562 {
	static final int number = 9; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int[] values = new int[number];
		
		for(int i = 0; i < number; i++) {
			values[i] = scan.nextInt();
		}
		
		System.out.println(Max1.max(values));
		System.out.println(Index_Find.find(values,Max.max(values)));
	}
}
class Index_Find {
	static int find(int[] values,int num) {
		int i;
		
		for(i = 0; i < values.length; i++) {
			if(values[i] == num) break;
		}
		
		return (i + 1);
	}
}

class Max1 {
	
	static int max(int ... values) {
		int max = -1000000;
	
		for(int i : values) {
			if(max < i) max =i;
		}
		
		return max;
	}

}

/*
문제
9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.

예를 들어, 서로 다른 9개의 자연수

3, 29, 38, 12, 57, 74, 40, 85, 61

이 주어지면, 이들 중 최댓값은 85이고, 이 값은 8번째 수이다.

입력
첫 째 줄부터 아홉 번째 줄까지 한 줄에 하나의 자연수가 주어진다. 주어지는 자연수는 100 보다 작다.

출력
첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 몇 번째 수인지를 출력한다.
*/