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
����
N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� ���� N(1 �� N �� 1,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ���ڰ� �־�����. �� ���� ������ 1,000���� �۰ų� ���� �����̴�. ���� �ߺ����� �ʴ´�.

���
ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.
*/