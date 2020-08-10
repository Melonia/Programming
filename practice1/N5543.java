package practice1;

import java.util.Scanner;

public class N5543 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = 5;
		int index = 2;
		int[] price = new int[num];
		
		for(int i=0;i<num;i++) {
			price[i]=scan.nextInt();
		}
		
		Cal cal = new Cal(price,index);
		System.out.println(cal.iter());
	}
}
class Cal{
	int[] price;
	int index;
	int min=3950;
	
	Cal(int[] price,int index){
		this.index=index;
		this.price=price;
	}
	
	int iter() {
		for(int i=0;i<=index;i++) {
			for(int j=index+1;j<price.length;j++) {
				if(min>price[i]+price[j]-50)
					min=price[i]+price[j]-50;	
			}
		}
		return min;
	}
}
/*
����
��ٳ��忡�� ���� �� �ȸ��� �޴��� ��Ʈ �޴��̴�. �ֹ��� ��, �ڽ��� ���ϴ� �ܹ��ſ� ���Ḧ �ϳ��� ���, ��Ʈ�� �����ϸ�, ������ �հ迡�� 50���� �� ������ ��Ʈ �޴��� ������ �ȴ�.

�ܹ��Ŵ� �� 3���� �������, �ߴ�����, �ϴ����Ű� �ְ�, ����� �ݶ�� ���̴� �� ������ �ִ�.

�ܹ��ſ� ������ ������ �־����� ��, ���� �� ��Ʈ �޴��� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
�Է��� �� �ټ� ���̴�. ù° �ٿ��� �������, ��° �ٿ��� �ߴ�����, ��° �ٿ��� �ϴ������� ������ �־�����. ��° �ٿ��� �ݶ��� ����, �ټ�° �ٿ��� ���̴��� ������ �־�����. ��� ������ 100�� �̻�, 2000�� �����̴�.

���
ù° �ٿ� ���� �� ��Ʈ �޴��� ������ ����Ѵ�.
*/