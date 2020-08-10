package sort;

import java.util.Scanner;

public class N2751 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		int[] x = new int[number];
		for (int i = 0; i < number; i++) {
			x[i] = scan.nextInt();
		}
		// BubbleSort bs = new BubbleSort(x, number);
		// BubbleSort_02 bs2 = new BubbleSort_02(x, number);
		// SelectionSort ss = new SelectionSort(x, number);
		// InsertionSort is = new InsertionSort(x, number);
		// CocktailSort cs = new CocktailSort(x,number);
		ShellSort ss = new ShellSort(x, number);
		for (int i = 0; i < number; i++) {
			System.out.println(x[i]);
		}
	}

}

class ShellSort {
	ShellSort(int[] x, int nx){
		for(int h = nx/2; h > 0; h/=2) {
			for(int i = h; i < nx; i++) {
				int j;
				int tmp=x[i];
				for(j=i-h;j>=0&&x[j]>tmp;j-=h)
					x[j+h]=x[j];
				x[j+h]=tmp;
			}
		}
	}
}

/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
*/