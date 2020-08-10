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
����
N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� ���� N(1 �� N �� 1,000,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ���ڰ� �־�����. �� ���� ������ 1,000,000���� �۰ų� ���� �����̴�. ���� �ߺ����� �ʴ´�.

���
ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.
*/