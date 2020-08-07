package math2;

import java.util.Scanner;

public class N3009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int[][] point = new int[3][2];
		
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 2; j++)
				point[i][j] = scanner.nextInt();
		
		System.out.print(((point[0][0]==point[1][0])? 
				point[2][0] : (point[0][0]==point[2][0]?
						point[1][0]:point[0][0])) + " ");
		System.out.println((point[0][1]==point[1][1])? 
				point[2][1] : (point[0][1]==point[2][1]?
						point[1][1]:point[0][1]));
	}
}

/*
문제
세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.

입력
세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.

출력
직사각형의 네 번째 점의 좌표를 출력한다.
*/