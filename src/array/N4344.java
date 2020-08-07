package array;

import java.util.Scanner;

public class N4344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase;
		int count;
		Scanner scan = new Scanner(System.in);
		testCase = scan.nextInt();
		
		for(int i =0;i<testCase;i++) {
			int testCase2 = scan.nextInt();
			int[] student = new int[testCase2];
			
			for(int k = 0; k < testCase2; k++) {
				student[k] = scan.nextInt();
			}
			
			double average = Operation1.average(student);
			count = 0;
			
			for(int j = 0; j < student.length; j++) {
				if(student[j] > average) {
					count++;
				}
			}
			
			System.out.printf("%.3f",(double)count/student.length*100);
			System.out.println("%");
		}
	
	}

}


class Operation1{

	static double average(int ...values) {
		
		return (double)sum(values)/values.length;
		
	}
	
	static int sum(int ...values) {
		
		int sum = 0;
		
		for(int value : values) {
			sum += value;
		}
		
		return sum;
		
	}

	
}



/*
문제
대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.

입력
첫째 줄에는 테스트 케이스의 개수 C가 주어진다.

둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.

출력
각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
*/