package practice1;

import java.util.Scanner;

public class N10817 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		I_D input = new I_D(); //�� ���� �Է� �޴� ��ü
		C_D cal = new C_D(input); //2��° ū ������ ����ϴ� ��ü�� �� ���� �Էµ� ��ü�� ����.
		cal.secNumber(); //�� ��° ������ �����ϴ� �޼ҵ� ȣ��	
	}
}

//data�� �ִ� Ŭ����
class I_D{
	Scanner scan = new Scanner(System.in);
	
	int a,b,c;
	
	I_D(){
		this.a = scan.nextInt();
		this.b = scan.nextInt();
		this.c = scan.nextInt();
	}
}

//
class C_D{
	I_D input;
	int second_number;
	
	C_D(I_D input){
		this.input = input;
		this.second_number = this.calculation(input.a, input.b, input.c);
	}
	
	int calculation(int a,int b,int c) {
		if((a<=b&&b<=c)||(c<=b&&b<=a)) return b;
		else if((b<=a&&a<=c)||(c<=a&&a<=b)) return a;
		else return c;
	}
	
	void secNumber() {
		System.out.println(this.second_number);
	}
}
/*
����
�� ���� A, B, C�� �־�����. �̶�, �� ��°�� ū ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 

�Է�
ù° �ٿ� �� ���� A, B, C�� �������� ���еǾ� �־�����. (1 �� A, B, C �� 100)

���
�� ��°�� ū ������ ����Ѵ�.
*/