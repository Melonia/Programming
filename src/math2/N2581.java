package math2;

import java.util.ArrayList;
import java.util.Scanner;

public class N2581 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> array = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		int start = scan.nextInt();
		int end = scan.nextInt();
		for (int i = start; i < end + 1; i++) {
			array.add(i);
		}

		for (int i = 0; i < end + 1; i++) {
			for (int j = 0; j < array.size(); j++) {
				if (array.get(j) % (i + 2) == 0 && array.get(j) != (i + 2) || array.get(j) == 1)
					array.remove(j);

			}
		}
		if(array.size() == 0) {
			System.out.println(-1);
			return;
		}
		int sum = 0;
		for(int i = 0 ; i < array.size(); i++)
			sum += array.get(i);
		System.out.println(sum);
		int min = end;
		for(int i = 0; i <array.size();i++) {
			if(min > array.get(i))
				min = array.get(i);
		}
		System.out.println(min);

	}

}

/*
문제
자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.

예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 이들 소수의 합은 620이고, 최솟값은 61이 된다.

입력
입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.

M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.

출력
M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다. 

단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.
*/