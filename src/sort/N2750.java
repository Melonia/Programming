package sort;

import java.util.Scanner;

public class N2750 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int nx = scan.nextInt();
		int[] x = new int[nx];
		for (int i = 0; i < nx; i++) {
			x[i] = scan.nextInt();
		}
        
        int left = 0;
		int right = nx - 1;
		int shift = 0;
        
		while (left < right) {
			for (int i = left; i < right; i++) {
				if (x[i] > x[i + 1]) {
					Swap.swap(x, i, i + 1);
					shift = i;
				}
			}
			right = shift;

			for (int i = right; i > left; i--) {
				if (x[i] < x[i - 1]) {
					Swap.swap(x, i - 1, i);
					shift = i;
				}
			}
			left = shift;
		}
		//BubbleSort bs = new BubbleSort(x, number);
		//BubbleSort_02 bs2 = new BubbleSort_02(x, number);
		//SelectionSort ss = new SelectionSort(x, number);
		//InsertionSort is = new InsertionSort(x, number);
		//CocktailSort cs = new CocktailSort(x,number);
		
		for (int i = 0; i < nx; i++) {
			System.out.println(x[i]);
		}
	}

}
class Swap {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
}

/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
*/